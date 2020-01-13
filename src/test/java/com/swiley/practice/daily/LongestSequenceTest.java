package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LongestSequenceTest {

    @Test
    public void testLongestSequence() {
        int[] array = new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        var longest = LongestSequence.findLongest(array);
        Assert.assertEquals(6, longest.size());
    }

}
