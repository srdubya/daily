package com.swiley.practice.daily;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListMerger<T extends Comparable<T>> {

    private ListIterator<T>[] iterators;

    @SafeVarargs
    public static <T extends Comparable<T>> LinkedList<T> merge(List<T> ...lists) {
        if (lists.length == 0) {
            return null;
        }
        return new ListMerger<>(lists).mergeLists(lists);
    }

    private ListMerger(List<T>[] lists) {
        iterators = new ListIterator[lists.length];
    }

    private T getNext(ListIterator<T>[] iterators) {
        var min = -1;
        T minValue = null;
        for (int i = 0; i < iterators.length; i++) {
            if (min == -1 && peek(iterators[i]) != null) {
                min = i;
                minValue = peek(iterators[min]);
                continue;
            }
            //noinspection ConstantConditions
            if (minValue != null && peek(iterators[i]) != null && peek(iterators[i]).compareTo(minValue) <= 0) {
                min = i;
                minValue = peek(iterators[min]);
            }
        }
        return iterators[min].next();
    }

    private T peek(ListIterator<T> iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        var ret = iterator.next();
        iterator.previous();
        return ret;
    }

    private boolean hasMore(ListIterator<?>[] iterators) {
        for (var iterator : iterators) {
            if (iterator.hasNext()) {
                return true;
            }
        }
        return false;
    }

    private LinkedList<T> mergeLists(List<T>[] lists) {
        var ret = new LinkedList<T>();

        for (int i = 0; i < iterators.length; i++) {
            iterators[i] = lists[i].listIterator();
        }

        while (hasMore(iterators)) {
            ret.add(getNext(iterators));
        }

        return ret;
    }
}