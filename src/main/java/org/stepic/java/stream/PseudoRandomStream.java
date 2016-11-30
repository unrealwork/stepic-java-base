package org.stepic.java.stream;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by shmagrinskiy on 11/30/16.
 */
public class PseudoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> ((n * n) / 10) % 1000);
    }

    public static void main(String[] args) {
        pseudoRandomStream(13).limit(10).forEach(System.out::println);
    }
}
