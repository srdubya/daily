package com.swiley.practice.daily;

/*
Given an array of integers where every integer occurs three times except for one integer, which only occurs once,
find and return the non-duplicated integer.
For example:
 Given [6, 1, 3, 3, 3, 6, 6], return 1.
 Given [13, 19, 13, 13], return 19.

Do this in O(N) time and O(1) space.
*/

public class UniqueNumber {

    public static int find(int[] numbers) {
        int[] bits = new int[32];

        for (var number : numbers) {
            for (int i = 0; i < 32; i++) {
                bits[i] += number & 1;
                number = number >> 1;
            }
        }

        int ret = 0;
        for (int i = 0; i < 32; i++) {
            if ((bits[i] % 3) != 0) {
                ret += 1 << i;
            }
        }
        return ret;
    }
}
