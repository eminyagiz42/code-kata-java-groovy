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

    @After
    public void after() {
        System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After Class");
    }
}
