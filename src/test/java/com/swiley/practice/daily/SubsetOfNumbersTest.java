package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class SubsetOfNumbersTest {

    @Test
    public void testSubsetOfNumbers() {
        Assert.assertArrayEquals(
                new Integer[] {2, 9, 1, 12},
                SubsetOfNumbers.solve(new int[] {12, 1, 61, 5, 9, 2}, 24)
        );
        Assert.assertArrayEquals(
                new Integer[] {2, 9, 1, 12},
                SubsetOfNumbers.solve(new int[] {25, 12, 1, 61, 5, 9, 2, 1, 1}, 24)
        );
    }
}
