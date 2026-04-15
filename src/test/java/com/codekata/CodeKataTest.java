package com.codekata;

import com.codekata.curiousity.tricks.LargerNumber;
import org.junit.*;

import static org.junit.Assert.assertTrue;

public class CodeKataTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class");
    }

    @Before
    public void before() {
        System.out.println("Before Test Case");
    }

    @Test
    public void isGreaterTest() {
        LargerNumber largerNumber = new LargerNumber();
        int num1 = 4, num2 = 3;
        assertTrue(num1 + " is greater than " + num2, largerNumber.isGreater(num1, num2));
        System.out.println(num1 + " is greater than " + num2 + " = " + largerNumber.isGreater(num1, num2));
    }

    @Test
    public void testPositiveNumbers() {
        LargerNumber largerNumber = new LargerNumber();
        assertTrue("10 should be greater than 5", largerNumber.isGreater(10, 5));
    }

    @Test
    public void testNegativeNumbers() {
        LargerNumber largerNumber = new LargerNumber();
        assertTrue("-1 should be greater than -5", largerNumber.isGreater(-1, -5));
    }

    @Test
    public void testEqualNumbers() {
        LargerNumber largerNumber = new LargerNumber();
        Assert.assertFalse("5 should not be greater than 5", largerNumber.isGreater(5, 5));
    }

    @Test
    public void testLargeNumbers() {
        LargerNumber largerNumber = new LargerNumber();
        assertTrue("1000000 should be greater than 999999", largerNumber.isGreater(1000000, 999999));
    }


/*
    @Test
    public void testFailingCase1() {
        LargerNumber largerNumber = new LargerNumber();
        assertTrue("This should fail: 3 is not greater than 5", largerNumber.isGreater(3, 5));
    }

    @Test
    public void testFailingCase2() {
        LargerNumber largerNumber = new LargerNumber();
        Assert.assertEquals("Expected 10 but got different", 10, 5);
    }
    */

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
