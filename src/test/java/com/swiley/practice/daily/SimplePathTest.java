package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class SimplePathTest {

    @Test
    public void testSimplePath() {
        Assert.assertEquals(2, SimplePath.calculatePath(2, 2));
        Assert.assertEquals(6, SimplePath.calculatePath(3, 3));
        Assert.assertEquals(20, SimplePath.calculatePath(4, 4));
        Assert.assertEquals(70, SimplePath.calculatePath(5, 5));
        Assert.assertEquals(252, SimplePath.calculatePath(6, 6));
        Assert.assertEquals(924, SimplePath.calculatePath(7, 7));
    }
}
