package org.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class factorialCalculateTest {
    @Test
    void checkCorrectCalculation(){
        assertEquals(2*3*4*5, App.Factorial.calculate(5));
    }
    @Test
    void checkZeroInputCalculation(){
        assertEquals(1, App.Factorial.calculate(0));
    }
    @Test
    void checkOutputIsInteger(){
        var result = App.Factorial.calculate(5);
        assertInstanceOf(Integer.class, result);
    }
}
