package com.swiley.practice.daily;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList<T> {

    public static class Element<V> {
        private Element<V> predecessor = null;
        private Element<V> successor = null;
        private final V value;

        public Element(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        private boolean isEqual(Element<V> other) {
            return other != null && this.value.equals(other.value);
        }
    }

    private Element<T> head = null;
    private Element<T> tail = null;

    public Element<T> add(T item) {
        var ret = new Element<>(item);
        add(ret);
        return ret;
    }

    public void add(Element<T> item) {
        item.successor = head;
        if (head != null) {
            head.predecessor = item;
        }
        head = item;

        if (tail == null) {
            tail = item;
        }
    }

    public T removeTail() {
        if (tail == null) {
            return null;
        }

        var ret = tail.value;
        tail = tail.predecessor;
        if (tail != null) {
            tail.successor = null;
        } else {
            head = null;
        }

        return ret;
    }

    public void moveToHead(Element<T> element) {
        if (element.isEqual(head)) {
            return;
        }
        if (element.isEqual(tail)) {
            tail = element.predecessor;
        }
        element.predecessor.successor = element.successor;
        element.successor = head;
        element.predecessor = null;
        head.predecessor = element;
        head = element;
    }

    public List<T> getAll() {
        var ptr = head;
        var ret = new LinkedList<T>();
        while (ptr != null) {
            ret.add(ptr.value);
            ptr = ptr.successor;
        }
        return ret;
    }
}
