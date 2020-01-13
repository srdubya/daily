package com.swiley.practice.daily;

//Given an array of numbers, find the length of the longest increasing subsequence in the array. The subsequence does not
//necessarily have to be contiguous.

//For example, given the array [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15], the longest increasing
//subsequence has length 6: it is 0, 2, 6, 9, 11, 15.


import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class LongestSequence {

    private static class SequenceNode {

        private final List<SequenceNode> children;
        private int value;

        private SequenceNode() {
            children = new LinkedList<>();
        }

        SequenceNode(int first) {
            this();
            value = first;
        }

        boolean append(int val) {
            if (val <= value) {
                return false;
            }
            boolean added = false;
            for (var child : children) {
                if (child.append(val)) {
                    added = true;
                }
            }
            if (!added) {
                children.add(new SequenceNode(val));
            }
            return true;
        }

        public void forEach(Consumer<List<Integer>> consumer) {
            for (var child : children) {
                var tmp = new LinkedList<Integer>();
                tmp.add(value);
                child.forEach(tmp, consumer);
            }
        }

        public void forEach(List<Integer> values, Consumer<List<Integer>> onLeafNode) {
            if (children.size() == 0) {
                values.add(value);
                onLeafNode.accept(values);
                return;
            }

            for (var child : children) {
                var tmp = new LinkedList<>(values);
                tmp.add(value);
                child.forEach(tmp, onLeafNode);
            }
        }

    }

    public static List<Integer> findLongest(int[] array) {
        return getLongestBranch(buildSequenceNodes(array));
    }

    private static List<Integer> getLongestBranch(List<SequenceNode> roots) {
        List<Integer> longest = null;
        for (var root : roots) {
            var lists = new LinkedList<List<Integer>>();
            root.forEach(lists::add);
            for (var list : lists) {
                if (longest == null || list.size() > longest.size()) {
                    longest = list;
                }
            }
        }
        return longest;
    }

    private static List<SequenceNode> buildSequenceNodes(int[] array) {
        List<SequenceNode> roots = null;
        for (var val : array) {
            if (roots == null) {
                roots = new LinkedList<>();
                roots.add(new SequenceNode(val));
                continue;
            }
            var added = false;
            for (var root : roots) {
                if (root.append(val)) {
                    added = true;
                }
            }
            if (!added) {
                roots.add(new SequenceNode(val));
            }
        }
        return roots;
    }
}
