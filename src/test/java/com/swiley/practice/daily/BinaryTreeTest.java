package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBinaryTree() {
        Assert.assertArrayEquals(
                new String[]{"a", "b", "c", "d", "e"},
                new BinaryTree<String>().insertAll(new String[]{"c", "b", "d", "a", "e"}).getList().toArray()
        );
    }
}
