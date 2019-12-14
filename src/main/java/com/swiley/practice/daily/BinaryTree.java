package com.swiley.practice.daily;

import java.util.LinkedList;
import java.util.List;
import java.lang.Comparable;

public class BinaryTree<T extends Comparable<T>> {

    private static class Node<E extends Comparable<E>> {

        private Node<E> left;
        private Node<E> right;
        private final E val;

        Node(E value) {
            this.val = value;
        }

        public void insert(Node<E> newNode) {
            var result = newNode.val.compareTo(val);
            if (result == 0 ) {
                return;
            }
            if (result < 0) {
                if (left == null) {
                    left = newNode;
                } else {
                    left.insert(newNode);
                }
            } else {
                if (right == null) {
                    right = newNode;
                } else {
                    right.insert(newNode);
                }
            }
        }

        public void getValues(List<E> ret) {
            if (left != null) {
                left.getValues(ret);
            }

            ret.add(val);

            if (right != null) {
                right.getValues(ret);
            }
        }
    }
    
    private Node<T> root;
    
    public T insert(T value) {
        var newNode = new Node<>(value);
        if (root == null) {
            root = newNode;
        } else {
            root.insert(newNode);
        }
        
        return value;
    }

    public BinaryTree<T> insertAll(List<T> values) {
        for (T value : values) {
            insert(value);
        }
        return this;
    }

    public BinaryTree<T> insertAll(T[] values) {
        insertAll(List.of(values));
        return this;
    }
    
    public List<T> getList() {
        List<T> ret = new LinkedList<>();
        if (root != null) {
            root.getValues(ret);
        }
        return ret;
    }
}
