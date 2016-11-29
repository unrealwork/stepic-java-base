package org.stepic.java.io.streams;


/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class DoubleParser {
    public static void main(String[] args) throws java.io.IOException {
        StringBuilder result = new StringBuilder();
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String string;
        double sum = 0d;
        while ((string = reader.readLine()) != null) {
            String[] splitted = string.split("\\s");
            for (String s : splitted) {
                try {
                    double d = Double.parseDouble(s);
                    sum += d;
                } catch (NumberFormatException e) {

                }
            }
        }
        System.out.printf("%.6f", sum);
        System.out.flush();
    }
}
