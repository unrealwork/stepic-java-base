package org.stepic.java.oop.integrate;

import java.util.function.DoubleUnaryOperator;


public interface Integral {
    double integrate(DoubleUnaryOperator function, double a, double b);
}
