package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class ListMergerTest {

    @Test
    public void testListMerger() {
        Assert.assertEquals(
                new LinkedList<>(Arrays.asList(1, 2, 3)),
                ListMerger.merge(Collections.singletonList(1), Arrays.asList(2, 3))
        );
        Assert.assertEquals(
                new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                ListMerger.merge(Arrays.asList(6, 8), Arrays.asList(2, 3), Arrays.asList(1,4,5,7,9))
        );
        Assert.assertEquals(
                new LinkedList<>(Arrays.asList("a", "b", "c", "d", "e", "f")),
                ListMerger.merge(Arrays.asList("a", "f"), Arrays.asList("b", "d"), Arrays.asList("c", "e"))
        );
    }
}
