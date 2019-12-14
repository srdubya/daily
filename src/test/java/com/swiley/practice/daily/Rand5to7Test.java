package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class Rand5to7Test {

    @Test
    public void testRand5to7() {
        int[] five = new int[5];
        int[] seven = new int[7];

        for (int i = 0; i < 1000 * 1000; i++) {
            int index5 = Rand5to7.rand5() - 1;
            five[index5]++;
            int index7 = Rand5to7.rand7(index5 + 1) - 1;
            seven[index7]++;
        }

        for (int i = 0; i < five.length; i++) {
            System.out.println((i + 1) + ": " + five[i]);
        }
        System.out.println();
        for (int i = 0; i < seven.length; i++) {
            System.out.println((i + 1) + ": " + seven[i]);
        }
    }
}
