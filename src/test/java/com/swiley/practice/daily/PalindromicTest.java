package com.swiley.practice.daily;


import org.junit.Assert;
import org.junit.Test;

public class PalindromicTest {

    @Test
    public void testPalindromic() {
        Assert.assertEquals(
                "bcdcb",
                Palindromic.solve("aabcdcb")
        );
        Assert.assertEquals(
                "anana",
                Palindromic.solve("bananas")
        );
    }
}
