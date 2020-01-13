package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class UniqueNumberTest {

    @Test
    public void testUniqueNumber() {
        Assert.assertEquals(1, UniqueNumber.find(new int[] {6, 1, 3, 3, 3, 6, 6}));
        Assert.assertEquals(19, UniqueNumber.find(new int[] {13, 19, 13, 13}));
    }
}
