package com.com.isildur;

import com.isildur.RpnCalculator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class TestClass {

    private static Logger log = LoggerFactory.getLogger(TestClass.class);

    @Test
    public void testCalculatorInteger() {

        RpnCalculator calc = new RpnCalculator();

        String expression = "1 2 -";

        String result = calc.execute(expression);

        assertEquals("-1.0", result);
    }

    @Test
    public void testCalculatorDouble() {

        RpnCalculator calc = new RpnCalculator();

        String expression = "15 7 1 1 + - / 3 * 2 1 1 + + - -";

        String result = calc.execute(expression);

        assertEquals("5.0", result);
    }
}
