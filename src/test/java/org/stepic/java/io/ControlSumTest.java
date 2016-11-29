package org.stepic.java.io;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by shmagrinskiy on 11/29/16.
 */
public class ControlSumTest {
    @DataProvider(name = "controlSumProvider")
    private Object[][] provideControlSum() {
        return new Object[][]{
                {new byte[]{0x33, 0x45, 0x01}, 71},
                {new byte[]{}, 0},
                {null, 0}
        };
    }

    @Test(dataProvider = "controlSumProvider")
    public void testCheckSum(byte[] bytes, int expectedSum) throws IOException {
        InputStream is = new ByteArrayInputStream(bytes);
        Assert.assertEquals(ControlSum.checkSumOfStream(is), expectedSum);
    }
}