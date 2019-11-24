package com.swiley.practice.daily;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class MissingIntegerTest
{
    @Test
    public void missingIntegerTest()
    {
        assertEquals(2, MissingInteger.computeOf(new int[] {3, 4, -1, 1}));
        assertEquals(4, MissingInteger.computeOf(new int [] {0, 1, 2, 3, 5}));
        assertEquals(1, MissingInteger.computeOf(new int [] {0, -1, 2, 3, 5}));
        assertEquals(5, MissingInteger.computeOf(new int [] {0, 1, 2, 3, 4}));
        assertEquals(6, MissingInteger.computeOf(new int [] {5, 4, 3, 2, 1}));
        assertEquals(6, MissingInteger.computeOf(new int [] {5, 4, 3, 2, 1}));
        assertEquals(1, MissingInteger.computeOf(new int [] {0}));
        assertEquals(1, MissingInteger.computeOf(new int [] {0, 0}));
        assertEquals(1, MissingInteger.computeOf(new int [] {0, 2}));
        assertEquals(1, MissingInteger.computeOf(new int [] {0, 2, 0}));
    }
}
