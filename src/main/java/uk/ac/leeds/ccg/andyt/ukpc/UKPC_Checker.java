/*
 * Copyright 2019 Andy Turner, CCG, University of Leeds.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.ac.leeds.ccg.andyt.ukpc;

/**
 * For checking Strings to see if they might be viable UK unit, sector, district
 * or area postcodes and for returning the type of unit, sector and district
 * postcodes.
 *
 * Postcodes take various forms comprised of alphanumeric characters. This class
 * contains methods for efficiently check if Strings are of the right length and
 * have the digits 0 to 9 and restricted sets of alphabetic characters in viable
 * places.
 *
 * The general format of a postcode is given in:
 * https://en.wikipedia.org/wiki/Postcodes_in_the_United_Kingdom
 *
 * @author Andy Turner
 * @version 1.0.0
 */
public class UKPC_Checker {

    public static final int TYPE_AANN = 1;
    public static final int TYPE_AANA = 2;
    public static final int TYPE_ANN = 3;
    public static final int TYPE_ANA = 4;
    public static final int TYPE_AAN = 5;
    public static final int TYPE_AAA = 6;
    public static final int TYPE_AN = 7;

    public static final char[] AtoZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    public static final char[] AtoZ_not_CIKMOV = "ABDEFGHJKLNPQRSTUWXYZ".toCharArray();
    public static final char[] AtoZ_not_QVX = "ABCDEFGHIJKLMNOPRSTUWYZ".toCharArray();
    public static final char[] AtoZ_not_IJZ = "ABCDEFGHKLMNOPQRSTUVWXY".toCharArray();
    public static final char[] ABCDEFGHJKSTUW = "ABCDEFGHJKSTUW".toCharArray();
    public static final char[] ABEHMNPRVWXY = "ABEHMNPRVWXY".toCharArray();
    public static final char[] digits = "0123456789".toCharArray();

    /**
     * Creates a new UKPC_Checker.
     */
    public UKPC_Checker() {
    }

    /**
     * L and LS are valid postcode areas.
     *
     * @param s The string to test if it is in a valid postcode area form.
     * @return True iff s has a valid postcode area form.
     */
    public boolean isValidPostcodeArea(String s) {
        if (s == null) {
            return false;
        }
        String s0 = s.trim().replaceAll("\\s+", "");
        int length = s0.length();
        if (length < 2) {
            return false;
        }
        if (length > 3) {
            return false;
        }
        char[] chars = s0.toCharArray();
        if (contains(chars[0], AtoZ_not_QVX)) {
            if (length == 1) {
                return true;
            } else {
                if (contains(chars[1], AtoZ_not_IJZ)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * LS2 is a valid postcode district.
     *
     * @param s The string to test if it is in a valid postcode area form.
     * @return True iff s has a valid postcode area form.
     */
    public boolean isValidPostcodeDistrict(String s) {
        if (s == null) {
            return false;
        }
        String s0 = s.trim().replaceAll("\\s+", "");
        int length = s0.length();
        if (length < 2) {
            return false;
        }
        int fppt = getFirstPartPostcodeType(s.toCharArray());
        return fppt != 0;
    }

    /**
     * LS2 9 is a valid postcode sector.
     *
     * @param s The string to test if it is in a valid postcode sector form.
     * @return True iff s has a valid postcode sector form.
     */
    public boolean isValidPostcodeSector(String s) {
        if (s == null) {
            return false;
        }
        String s0 = s.trim().replaceAll("\\s+", "");
        int length = s0.length();
        if (length < 3) {
            return false;
        }
        if (contains(s0.substring(length - 1, length).toCharArray()[0], digits)) {
            char[] fpp = s0.substring(0, length - 1).toCharArray();
            int fppt = getFirstPartPostcodeType(fpp);
            return fppt != 0;
        }
        return false;
    }

    /**
     * LS2 9JT is a valid unit postcode.
     *
     * @param s The string to test if it is in a valid unit postcode form.
     * @return True iff s has a valid unit postcode form.
     */
    public boolean isValidPostcodeUnit(String s) {
        if (s == null) {
            return false;
        }
        String s0 = s.trim().replaceAll("\\s+", "");
        int length = s0.length();
        if (length < 5) {
            return false;
        }
        if (isValidSecondPartUnitPostcode(s0.substring(length - 3, length).toCharArray())) {
            char[] fpp = s0.substring(0, length - 3).toCharArray();
            int fppt = getFirstPartPostcodeType(fpp);
            return fppt != 0;
        } else {
            if (isValidSecondPartUnitPostcodeOld(s0.substring(length - 3, length).toCharArray())) {
                char[] fpp = s0.substring(0, length - 3).toCharArray();
                int fppt = getFirstPartPostcodeType(fpp);
                return fppt != 0;
            }
        }
        return false;
    }

    /**
     * @param s The postcode for which the form is returned. This may contain
     * white-space.
     * @return an int which is: 0 if s is not a valid unit postcode and 1 to 7
     * inclusive if s is a valid unit postcode of the following forms: AANA NAA;
     * ANN NAA; ANA NAA; AAN NAA; AN NAA.
     */
    public int getUnitPostcodeType(String s) {
        if (isValidPostcodeUnit(s)) {
            String s0 = s.trim().replaceAll("\\s+", "");
            return getUnitPostcodeType(s0, s0.length());
        }
        return 0;
    }

    /**
     * @param s A full unit postcode for which the form is returned. This is
     * expected to have been stripped of all white-space.
     * @param length The length of postcode.
     * @return an int which is: 0 if the length is less than 5 or both the first
     * and second parts of the the postcode are invalid; Completely valid
     * postcodes return 2 to 7 inclusive. These are respectively of the form
     * AANN NAA; AANA NAA; ANN NAA; ANA NAA; AAN NAA; AN NAA.
     */
    public int getUnitPostcodeType(String s, int length) {
        if (length < 5) {
            return 0;  // Invalid
        }
        String spp = s.substring(length - 3, length);
        if (isValidSecondPartUnitPostcode(spp.toCharArray())) {
            return getFirstPartPostcodeType(s.substring(0, length - 3).toCharArray());
        }
        return 0; // Invalid
    }

    /**
     * @param s A postcode sector s for which the form is returned. This is
     * expected to have been stripped of all whitespace.
     * @param length The length of postcode.
     * @return an int which is: 0 if the length is less than 4 or both the first
     * and second parts of the the postcode are invalid; Completely valid
     * postcode sectors return 2 to 7 inclusive. These are respectively of the
     * form AANN N; AANA N; ANN N; ANA N; AAN N; AN N.
     */
    public int getPostcodeSectorType(String s, int length) {
        if (length < 4) {
            return 0;  // Invalid
        }
        String spp = s.substring(length - 1, length);
        if (contains(spp.toCharArray()[0], digits)) {
            return getFirstPartPostcodeType(s.substring(0, length - 1).toCharArray());
        }
        return 0; // Invalid
    }

    /**
     * @param spp the second part of the postcode to test if it is a valid
     * second part of a postcode for a unit postcode.
     * @return true if spp is of length 3 and where: spp[0] is in
     * {@link #digits}; spp[1] is in {@link #AtoZ_not_CIKMOV}; and, spp[1] is in
     * {@link #AtoZ_not_CIKMOV}.
     */
    public boolean isValidSecondPartUnitPostcode(char[] spp) {
        if (spp.length == 3) {
            if (contains(spp[0], digits)
                    && contains(spp[1], AtoZ_not_CIKMOV)
                    && contains(spp[2], AtoZ_not_CIKMOV)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param spp the second part of the postcode to test if it is a valid
     * second part of a postcode for a unit postcode.
     * @return true if spp is of length 3 and where: spp[0] is in
     * {@link #digits}; spp[1] is in {@link #AtoZ_not_CIKMOV}; and, spp[1] is in
     * {@link #AtoZ_not_CIKMOV}.
     */
    public boolean isValidSecondPartUnitPostcodeOld(char[] spp) {
        if (spp.length == 3) {
            if (contains(spp[0], digits)
                    && contains(spp[1], AtoZ)
                    && contains(spp[2], AtoZ)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param fpp First Part of a Postcode.
     * @return Where A stands for an alphabetical character and N stands for
     * digit: 0 if fpp is not a valid first part for a postcode; 1 if it is of
     * the form AANN; 2 if it is of the form AANA; 3 if it is of the form ANN; 4
     * if it is of the form ANA; 5 if it is of the form AAN; 6 if it is of the
     * form AAA; 7 if it is of the form AN.
     */
    public int getFirstPartPostcodeType(char[] fpp) {
        if (fpp.length > 4 || fpp.length < 2) {
            return 0;
        }
        if (fpp.length == 4) {
            if (contains(fpp[0], AtoZ_not_QVX)
                    && contains(fpp[1], AtoZ_not_IJZ)
                    && contains(fpp[2], digits)
                    && contains(fpp[3], digits)) {
                return TYPE_AANN;
            } else if (contains(fpp[0], AtoZ_not_QVX)
                    && contains(fpp[1], AtoZ_not_IJZ)
                    && contains(fpp[2], digits)
                    && contains(fpp[3], ABEHMNPRVWXY)) {
                return TYPE_AANA;
            } else {
                return 0;
            }
        }
        if (fpp.length == 3) {
            if (contains(fpp[0], AtoZ_not_QVX)) {
                if (contains(fpp[1], digits)) {
                    if (contains(fpp[2], digits)) {
                        return TYPE_ANN;
                    } else if (contains(fpp[2], ABCDEFGHJKSTUW)) {
                        return TYPE_ANA;
                    } else if (fpp[2] == 'P') {
                        // Special case N1P
                        return TYPE_ANA;
                    } else if (fpp[0] == 'W') {
                        if (contains(fpp[2], AtoZ)) {
                            // Special case W1N
                            // Special case W1R
                            // Special case W1V
                            // Special case W1X
                            // Special case W1Y
                            //System.out.println(String.valueOf(fpp));
                            return TYPE_ANA;
                        } else {
                            return 0;
                        }
                    } else if (fpp[2] == 'N') {
                        return TYPE_ANA;
                    } else {
                        return 0;
                    }
                } else if (contains(fpp[1], AtoZ_not_IJZ)) {
                    if (contains(fpp[2], digits)) {
                        return TYPE_AAN;
                    } else if (fpp[1] == 'P' && fpp[2] == 'T') {
                        // NPT.
                        return TYPE_AAA;
                    } else if (fpp[1] == 'R' && fpp[2] == 'O') {
                        // CRO.
                        return TYPE_AAA;
                    } else {
                        return 0;
                    }
                } else {
                    if (fpp[1] == 'I' && fpp[2] == 'R') {
                        // GIR.
                        return TYPE_AAA;
                    } else {
                        return 0;
                    }
                }
            } else {
                return 0;
            }
        }
        if (fpp.length == 2) {
            if (contains(fpp[0], AtoZ_not_QVX)) {
                if (contains(fpp[1], digits)) {
                    return TYPE_AN;
                }
            }
        }
        return 0;
    }

    /**
     * @param c The char to test to see if it is in array
     * @param a The array to test to see if it contains c.
     * @return true if c is in a and false otherwise.
     */
    public boolean contains(char c, char[] a) {
        for (char x : a) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }
}
