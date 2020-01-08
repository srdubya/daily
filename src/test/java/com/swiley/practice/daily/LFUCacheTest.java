package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class LFUCacheTest {

    @Test
    public void testLFUCacheOne() {
        var cache = new LFUCache<String, String>(1);

        cache.set("1", "10");
        Assert.assertEquals("10", cache.get("1"));
        cache.set("1", "20");
        Assert.assertEquals("20", cache.get("1"));

        cache.set("2", "30");
        Assert.assertEquals("30", cache.get("2"));
        Assert.assertNull(cache.get("1"));
    }

    @Test
    public void testLFUCacheTwo() {
        var cache = new LFUCache<String, String>(2);

        cache.set("1", "10");
        Assert.assertEquals("10", cache.get("1"));
        cache.set("1", "20");
        Assert.assertEquals("20", cache.get("1"));

        cache.set("2", "30");
        Assert.assertEquals("30", cache.get("2"));
        Assert.assertEquals("20", cache.get("1"));

        cache.set("3", "40");
        Assert.assertNull(cache.get("2"));
        Assert.assertEquals("20", cache.get("1"));
        Assert.assertEquals("40", cache.get("3"));
    }
}
