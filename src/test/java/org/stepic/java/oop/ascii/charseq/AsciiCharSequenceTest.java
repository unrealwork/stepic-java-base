package org.stepic.java.oop.ascii.charseq;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class AsciiCharSequenceTest {
    @DataProvider(name = "byteArrayLengthProvider")
    public Object[][] provideByteArrayLength() {
        return new Object[][]{
                {new byte[]{104, 101, 108, 108, 111}, 5}
        };
    }

    @Test(dataProvider = "byteArrayLengthProvider")
    public void testLength(byte[] bytes, int expectedLength) throws Exception {
        CharSequence charSequence = new AsciiCharSequence(bytes);
        assertEquals(charSequence.length(), expectedLength);
    }

    @Test(dataProvider = "byteArrayProvider")
    public void testCharAt() throws Exception {

    }

    @Test
    public void testSubSequence() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

    }

}