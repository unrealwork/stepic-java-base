package org.stepic.java.io;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class WindowsToUnixTest {
    @DataProvider(name = "bytesProvider")
    private Object[][] provideBytes() {
        return new Object[][]{
                {new byte[]{65, 13, 10, 10, 13}, new byte[]{65, 10, 10, 13}},
                {new byte[]{65, 13, 10, 10, 66, 13}, new byte[]{65, 10, 10, 66, 13}},
                {new byte[]{65, 13, 10, 10, 13, 13}, new byte[]{65, 10, 10, 13, 13}},
                {new byte[]{13}, new byte[]{13}},
                {new byte[]{13, 10}, new byte[]{10}},
                {new byte[]{13, 10, 13}, new byte[]{10, 13}},
                {new byte[]{10, 13, 10}, new byte[]{10, 10}}

        };
    }

    @Test(dataProvider = "bytesProvider")
    public void testWindowsToUnixLF(byte[] inputBytes, byte[] outputBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(0);
        WindowsToUnix.windowsToUnixLF(inputStream, outputStream);
        assertEquals(outputStream.toByteArray(), outputBytes);
    }
}