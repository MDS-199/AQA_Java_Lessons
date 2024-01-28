package org.factorial;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testFactorialWithZero() {
        int result = App.Factorial.calculate(0);
        assertEquals(result, 1, "Factorial of 0 should be 1");
    }

    @DataProvider(name = "positiveNumbers")
    public Object[][] positiveNumbers() {
        return new Object[][] {
                {1, 1},
                {2, 2},
                {3, 6},
                {4, 24},
                {5, 120}
        };
    }

    @Test(dataProvider = "positiveNumbers")
    public void testFactorialWithPositiveNumber(int input, int expected) {
        int result = App.Factorial.calculate(input);
        assertEquals(result, expected, "Factorial of " + input + " should be " + expected);
    }

    @Test
    public void testFactorialWithNegativeNumber() {
        int result = App.Factorial.calculate(-5);
        assertEquals(result, 0, "Factorial of a negative number should be 0");
    }
}
