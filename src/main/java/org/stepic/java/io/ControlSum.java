package org.stepic.java.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class ControlSum {
    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        // your implementation here
        int current;
        int sum = 0;
        while ((current = inputStream.read()) != -1) {
            byte currentByte = (byte) current;
            sum = Integer.rotateLeft(sum, 1) ^ (currentByte & 0xFF);
        }
        return sum;
    }
}
