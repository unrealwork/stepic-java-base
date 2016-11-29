package org.stepic.java.io.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class ByteConverter {


    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charset));
        int r;
        while ((r = reader.read()) != -1) {
            char c = (char) r;
            result.append(c);
        }
        return result.toString();
    }
}
