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
package uk.ac.leeds.ccg.andyt.postcode;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author geoagdt
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
        postcode = "LS2 9JT";
        expResult = true;
        result = instance.isValidPostcodeUnit(postcode);
        assertEquals(expResult, result);
        // Test 2
        postcode = "NW1A 1AA";
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
        expResult = 1;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 2
        fpp = "NW2A".toCharArray();
        expResult = 2;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 3
        fpp = "N11".toCharArray();
        expResult = 3;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 4
        fpp = "N1A".toCharArray();
        expResult = 4;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 5
        fpp = "LS2".toCharArray();
        expResult = 5;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 6
        fpp = "AAA".toCharArray();
        expResult = 6;
        result = instance.getFirstPartPostcodeType(fpp);
        assertEquals(expResult, result);
        // Test 7
        fpp = "N2".toCharArray();
        expResult = 7;
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
        s = "LS2 9";
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
        s = "LS12 9JT";
        expResult = 1;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 2 AANA
        s = "AA2A 9JT";
        expResult = 2;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 3 ANN
        s = "L12 9JT";
        expResult = 3;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 4 ANA
        s = "A1A 9JT";
        expResult = 4;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 5 AAN
        s = "LS2 9JT";
        expResult = 5;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 6 AAA
        s = "AAA 9JT";
        expResult = 6;
        result = instance.getUnitPostcodeType(s);
        assertEquals(expResult, result);
        // Test 7 AN        
        s = "L2 9JT";
        expResult = 7;
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
