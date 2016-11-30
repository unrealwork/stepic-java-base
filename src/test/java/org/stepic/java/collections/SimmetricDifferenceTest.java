package org.stepic.java.collections;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;


public class SimmetricDifferenceTest {
    @DataProvider(name = "symmetricDifferenceProvider")
    private Object[][] provideSymmetricDifference() {
        return new Object[][]{
                {new Integer[]{1, 2, 3}, new Integer[]{0, 1, 2}, new Integer[]{0, 3}}
        };
    }

    @Test(dataProvider = "symmetricDifferenceProvider")
    public void testSymmetricDifference(Object[] first, Object[] second, Object[] result) throws Exception {
        Set<Object> firstSet = new HashSet<>(Arrays.asList(first));
        Set<Object> secondSet = new HashSet<>(Arrays.asList(second));
        Set<Object> resultSet = new HashSet<>(Arrays.asList(result));
        assertEquals(SimmetricDifference.symmetricDifference(firstSet, secondSet), resultSet);
    }

}