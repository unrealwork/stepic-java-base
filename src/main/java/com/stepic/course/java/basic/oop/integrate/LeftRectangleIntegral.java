package com.stepic.course.java.basic.oop.integrate;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.function.DoubleUnaryOperator;

import static org.testng.Assert.assertEquals;


public class LeftRectangleIntegral implements Integral {
    public double integrate(DoubleUnaryOperator function, double a, double b) {
        final double EPS = 10e-5d;
        Double result = null;
        double h = b - a;
        if (h == 0) {
            return 0d;
        }
        Double nextResult = function.applyAsDouble(a) * h;
        int i = 5;
        do {
            h /= 2;
            double upLimit = b - h;
            result = nextResult;
            nextResult = 0d;
            double point;
            for (point = a; point <= upLimit; point += h) {
                nextResult += h * function.applyAsDouble(point);
            }
            nextResult += (b - point) * function.applyAsDouble(point);
        } while (Math.abs(nextResult - result) >= EPS);
        return nextResult;
    }

    @DataProvider(name = "integralDataProvider")
    public Object[][] provideIntegralData() {
        return new Object[][]{
                {(DoubleUnaryOperator) Math::sin, 0d, 10d, Math.cos(0) - Math.cos(10)},
                {(DoubleUnaryOperator) Math::sin, 10d, 10d, 0d}
        };
    }

    @Test(dataProvider = "integralDataProvider")
    public void testIntegrate(DoubleUnaryOperator function, double a, double b, double result) {
        assertEquals(integrate(function, a, b), result, 10e-5);
    }
}
