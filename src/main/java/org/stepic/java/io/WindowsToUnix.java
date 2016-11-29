package org.stepic.java.io;


import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class WindowsToUnix {
    public static void main(String[] args) throws java.io.IOException {
        final byte lf = 10;
        final byte caret = 13;
        int current;
        int previous = -1;
        while ((current = System.in.read()) != -1) {
            if (current != caret) {
                if (current == lf && previous == caret) {
                    System.out.write(lf);
                } else {
                    if (previous == caret) {
                        System.out.write(caret);
                    }
                    System.out.write(current);
                }
            } else {
                if (previous == caret) {
                    System.out.write(caret);
                }
            }
            previous = current;
        }
        if (previous == caret) {
            System.out.write(caret);
        }
        System.out.flush();
    }

    public static void windowsToUnixLF(InputStream inputStream, OutputStream outputStream) throws java.io.IOException {
        final byte lf = 10;
        final byte caret = 13;
        int current;
        int previous = -1;
        while ((current = inputStream.read()) != -1) {
            if (current != caret) {
                if (current == lf && previous == caret) {
                    outputStream.write(lf);
                } else {
                    if (previous == caret) {
                        outputStream.write(caret);
                    }
                    outputStream.write(current);
                }
            } else {
                if (previous == caret) {
                    outputStream.write(caret);
                }
            }
            previous = current;
        }
        if (previous == caret) {
            outputStream.write(caret);
        }
        inputStream.close();
        outputStream.close();
    }
}
