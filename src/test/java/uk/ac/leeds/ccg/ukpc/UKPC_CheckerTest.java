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
package uk.ac.leeds.ccg.ukpc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_AANN;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_AANA;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_ANN;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_AAA;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_AAN;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_ANA;
import static uk.ac.leeds.ccg.ukpc.UKPC_Checker.TYPE_AN;

/**
 * Test for {@link uk.ac.leeds.ccg.ukpc.UKPC_Checker}.
 * 
 * @author Andy Turner
 * @version 1.0.0
 */
public class UKPC_CheckerTest {

    public UKPC_CheckerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of isValidPostcodeForm method, of class UKPC_Checker.
     */
    @Test
    public void testIsValidPostcodeUnit() {
        System.out.println("isValidPostcodeForm");
        UKPC_Checker instance = new UKPC_Checker();
        String postcode;
        boolean expResult;
        boolean result;
        // Test 1
        postcode = "LS29JT";
        expResult = true;
        result = instance.isValidPostcodeUnit(postcode);
        assertEquals(expResult, result);
        // Test 2
        postcode = "NW1A1AA";
        expResult = true;
        result = instance.isValidPostcodeUnit(postcode);
        assertEquals(expResult, result);
        // Test 3
        postcode = "N1P1AA";
        expResult = true;
        result = instance.isValidPostcodeUnit(postcode);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstPartPostcodeType method, of class UKPC_Checker.
     */
    @Test
    public void testGetFirstPartPostcodeType() {
        System.out.println("getFirstPartPostcodeType");
        UKPC_Checker instance = new UKPC_Checker();
        char[] fpp;
        int expResult;
        int result;
        // Tests
        // 1 AANN; 2 AANA; 3 ANN; 4 ANA; 5 AAN; 6 ANA; 7 AN.       
        // Test 1
        fpp = "LS11".toCharArray();
        expResult = TYPE_AANN;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 2
        fpp = "NW2A".toCharArray();
        expResult = TYPE_AANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 3
        fpp = "N11".toCharArray();
        expResult = TYPE_ANN;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 4
        fpp = "N1A".toCharArray();
        expResult = TYPE_ANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 5
        fpp = "LS2".toCharArray();
        expResult = 5;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 6
        fpp = "AAA".toCharArray();
        expResult = 0;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 6
        fpp = "GIR".toCharArray();
        expResult = TYPE_AAA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 7
        fpp = "NPT".toCharArray();
        expResult = TYPE_AAA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 8
        fpp = "CRO".toCharArray();
        expResult = TYPE_AAA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 9
        fpp = "W1M".toCharArray();
        expResult = TYPE_ANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 10
        fpp = "W1N".toCharArray();
        expResult = TYPE_ANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 11
        fpp = "W1R".toCharArray();
        expResult = TYPE_ANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 12
        fpp = "W1V".toCharArray();
        expResult = TYPE_ANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 13
        fpp = "W1X".toCharArray();
        expResult = TYPE_ANA;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 13
        fpp = "N2".toCharArray();
        expResult = TYPE_AN;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of contains method, of class UKPC_Checker.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        char c;
        char[] array = "ABCDE".toCharArray();
        UKPC_Checker instance = new UKPC_Checker();
        boolean expResult;
        boolean result;
        // Test 1
        c = 'F';
        expResult = false;
        result = instance.contains(c, array);
        assertEquals(expResult, result);
        // Test 2
        c = 'E';
        expResult = true;
        result = instance.contains(c, array);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidPostcodeArea method, of class UKPC_Checker.
     */
    @Test
    public void testIsValidPostcodeArea() {
        System.out.println("isValidPostcodeArea");
        UKPC_Checker instance = new UKPC_Checker();
        String s;
        boolean expResult;
        boolean result;
        // Test
        s = "LS";
        expResult = true;
        result = instance.isValidPostcodeArea(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidPostcodeDistrict method, of class UKPC_Checker.
     */
    @Test
    public void testIsValidPostcodeDistrict() {
        System.out.println("isValidPostcodeDistrict");
        UKPC_Checker instance = new UKPC_Checker();
        String s;
        boolean expResult;
        boolean result;
        // Test
        s = "LS2";
        expResult = true;
        result = instance.isValidPostcodeDistrict(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidPostcodeSector method, of class UKPC_Checker.
     */
    @Test
    public void testIsValidPostcodeSector() {
        System.out.println("isValidPostcodeSector");
        UKPC_Checker instance = new UKPC_Checker();
        String s;
        boolean expResult;
        boolean result;
        // Test
        s = "LS29";
        expResult = true;
        result = instance.isValidPostcodeSector(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnitPostcodeType method, of class UKPC_Checker.
     *
     */
    @Test
    public void testGetUnitPostcodeType_String() {
        System.out.println("getUnitPostcodeType");
        UKPC_Checker instance = new UKPC_Checker();
        String s;
        int expResult;
        int result;
        // Test 1 AANN 
        s = "LS129JT";
        expResult = TYPE_AANN;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 2 AANA
        s = "AA2A9JT";
        expResult = TYPE_AANA;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 3 ANN
        s = "L129JT";
        expResult = TYPE_ANN;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 4 ANA
        s = "A1A9JT";
        expResult = TYPE_ANA;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 5 AAN
        s = "LS29JT";
        expResult = TYPE_AAN;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 6 AAA
        s = "AAA9JT";
        expResult = 0;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 7 AN        
        s = "L29JT";
        expResult = TYPE_AN;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSecondPartPostcodeType method, of class UKPC_Checker.
     */
    @Test
    public void testIsValidSecondPartPostcodeType() {
        System.out.println("isValidSecondPartPostcodeType");
        UKPC_Checker instance = new UKPC_Checker();
        char[] spp;
        boolean expResult;
        boolean result;
        // Test1
        spp = "9JT".toCharArray();
        expResult = true;
        result = instance.isValidSecondPartUnitPostcode(spp);
        assertEquals(expResult, result);
    }
}
