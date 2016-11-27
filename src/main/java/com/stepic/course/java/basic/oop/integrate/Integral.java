package com.stepic.course.java.basic.oop.integrate;

import java.util.function.DoubleUnaryOperator;


public interface Integral {
    double integrate(DoubleUnaryOperator function, double a, double b);
}
