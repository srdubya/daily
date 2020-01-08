package com.swiley.practice.daily;

import java.util.Stack;

public class SubsetOfNumbers {

    static Stack<Integer> stack = new Stack<>();

    public static Integer[] solve(int[] values, int goal) {
        if (solve(values, goal, 0)) {
            return toArray(stack);
        }
        return null;
    }

    private static Integer[] toArray(Stack<Integer> stack) {
        Integer[] ret = new Integer[stack.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.pop();
        }
        return ret;
    }

    private static boolean solve(int[] values, int goal, int start) {
        if (values[start] < goal) {
            stack.push(values[start]);
            if (start < values.length -1 && solve(values, goal - values[start], start + 1)) {
                return true;
            }
            stack.pop();
            if (start < values.length - 1) {
                return solve(values, goal, start + 1);
            }
            return false;
        } else if (values[start] == goal) {
            stack.push(values[start]);
            return true;
        } else {
            if (start < values.length - 1) {
                return solve(values, goal, start + 1);
            }
            return false;
        }
    }
}
