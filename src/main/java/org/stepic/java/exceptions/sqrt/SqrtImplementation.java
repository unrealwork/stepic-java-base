package org.stepic.java.exceptions.sqrt;


public class SqrtImplementation {
    public static double sqrt(double x) {
        if (x < 0) {
            String failMessage = String.format("Expected non-negative number, got %f", x);
            throw new IllegalArgumentException(failMessage);
        } else {
            return Math.sqrt(x);
        }
    }
}
