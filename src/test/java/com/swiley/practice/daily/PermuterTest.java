package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class PermuterTest {

    @Test
    public void testIntegerPermutation() {
        var results = Permuter.getPermutations(new Integer[] {1, 2, 3});
        Assert.assertEquals(6, results.size());
    }

    @Test
    public void testIntPermutation() {
        var results = Permuter.getPermutations(123, 10);
        Assert.assertEquals(6, results.size());
        Assert.assertTrue(results.contains(123));
        Assert.assertTrue(results.contains(132));
        Assert.assertTrue(results.contains(213));
        Assert.assertTrue(results.contains(231));
        Assert.assertTrue(results.contains(312));
        Assert.assertTrue(results.contains(321));

        results = Permuter.getPermutations(1234, 10);
        Assert.assertEquals(24, results.size());
        Assert.assertTrue(results.contains(1234));
        Assert.assertTrue(results.contains(1324));
        Assert.assertTrue(results.contains(2134));
        Assert.assertTrue(results.contains(2314));
        Assert.assertTrue(results.contains(3124));
        Assert.assertTrue(results.contains(3214));

        Assert.assertTrue(results.contains(1243));
        Assert.assertTrue(results.contains(1342));
        Assert.assertTrue(results.contains(2143));
        Assert.assertTrue(results.contains(2341));
        Assert.assertTrue(results.contains(3142));
        Assert.assertTrue(results.contains(3241));

        Assert.assertTrue(results.contains(1423));
        Assert.assertTrue(results.contains(1432));
        Assert.assertTrue(results.contains(2413));
        Assert.assertTrue(results.contains(2431));
        Assert.assertTrue(results.contains(3412));
        Assert.assertTrue(results.contains(3421));

        Assert.assertTrue(results.contains(4123));
        Assert.assertTrue(results.contains(4132));
        Assert.assertTrue(results.contains(4213));
        Assert.assertTrue(results.contains(4231));
        Assert.assertTrue(results.contains(4312));
        Assert.assertTrue(results.contains(4321));

        results = Permuter.getPermutations(12345, 10);
        Assert.assertEquals(5 * 24, results.size());
    }
}
