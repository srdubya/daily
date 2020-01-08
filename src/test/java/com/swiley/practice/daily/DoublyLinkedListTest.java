package com.swiley.practice.daily;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;


public class DoublyLinkedListTest {

    @Test
    public void testAdd() {
        var list = new DoublyLinkedList<String>();
        list.add("0");
        list.add("1");
        list.add("2");
        var items = list.getAll();
        assertEquals("2", items.get(0));
        assertEquals("1", items.get(1));
        assertEquals("0", items.get(2));
    }

    @Test
    public void testMoveToHead() {
        var list = new DoublyLinkedList<String>();
        var zero = list.add("0");
        var one = list.add("1");
        var two = list.add("2");    // 2,1,0

        list.moveToHead(zero);      // 0,2,1
        var items = String.join(",", list.getAll());
        Assert.assertEquals("0,2,1", items);

        list.moveToHead(two);       // 2,0,1
        items = String.join(",", list.getAll());
        Assert.assertEquals("2,0,1", items);

        list.moveToHead(two);       // 2,0,1
        items = String.join(",", list.getAll());
        Assert.assertEquals("2,0,1", items);
    }

    @Test
    public void testRemoveTail() {
        var list = new DoublyLinkedList<String>();
        Assert.assertNull(list.removeTail());
        var zero = list.add("0");
        var one = list.add("1");
        var two = list.add("2");

        Assert.assertEquals(zero.getValue(), list.removeTail());

        var items = String.join(",", list.getAll());
        Assert.assertEquals("2,1", items);

        Assert.assertEquals(one.getValue(), list.removeTail());

        items = String.join(",", list.getAll());
        Assert.assertEquals("2", items);

        Assert.assertEquals(two.getValue(), list.removeTail());
        Assert.assertEquals(0, list.getAll().size());
    }
}
