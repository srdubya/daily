package com.swiley.practice.daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permuter {

    public static List<Integer> getPermutations(int src, int base) {
        var tmp = new LinkedList<Integer>();
        var digit = src % base;
        var divisor = base;
        do {
            tmp.add(digit);
            digit = (src / divisor) % base;
            divisor = divisor * base;
        } while (divisor / base < src);

        var results = getPermutations(tmp);

        tmp.clear();
        for (var result : results) {
            var multiplier = (int) Math.pow(base, result.size() - 1);
            int val = 0;
            for (var res : result) {
                val += res * multiplier;
                multiplier /= base;
            }
            tmp.add(val);
        }
        return tmp;
    }

    public static <T> List<List<T>> getPermutations(T[] src) {
        var tmp = new LinkedList<T>();
        Collections.addAll(tmp, src);
        return getPermutations(tmp);
    }

    public static <T> List<List<T>> getPermutations(List<T> src) {
        var ret = new LinkedList<List<T>>();

        if (src.size() == 2) {
            var toAdd = new ArrayList<T>(2);
            toAdd.add(src.get(0));
            toAdd.add(src.get(1));
            ret.add(toAdd);
            toAdd = new ArrayList<>(2);
            toAdd.add(src.get(1));
            toAdd.add(src.get(0));
            ret.add(toAdd);
            return ret;
        }

        for (int i = 0; i < src.size(); i++) {
            var first = src.get(i);
            var others = getOthersExcept(i, src);
            for (var perm : getPermutations(others)) {
                ret.add(buildList(first, perm));
            }
        }
        return ret;
    }

    private static <T> List<T> buildList(T first, List<T> perm) {
        perm.add(0, first);
        return perm;
    }

    private static <T> List<T> getOthersExcept(int target, List<T> src) {
        var ret = new LinkedList<T>();
        for (int i = 0; i < src.size(); i++) {
            if (i != target) {
                ret.add(src.get(i));
            }
        }
        return ret;
    }
}
