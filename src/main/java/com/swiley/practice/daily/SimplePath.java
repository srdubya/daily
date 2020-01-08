package com.swiley.practice.daily;

// There is an N by M matrix of zeroes. Given N and M, write a function to count the number of ways of starting at the
// top-left corner and getting to the bottom-right corner. You can only move right or down.  For example, given a 2 by
// 2 matrix, you should return 2, since there are two ways to get to the bottom-right:
//        •	Right, then down
//        •	Down, then right
// Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.

public class SimplePath {

    public static int calculatePath(int width, int height) {
        if (width == 1 && height == 1) {
            return 1;
        }
        if (width == 1) {
            return calculatePath(width, height - 1);
        } else if (height == 1) {
            return calculatePath(width - 1, height);
        } else {
            return calculatePath(width - 1, height) + calculatePath(width, height - 1);
        }
    }
}
