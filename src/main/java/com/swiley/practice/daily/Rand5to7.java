package com.swiley.practice.daily;

public class Rand5to7 {

    public static int rand5() {
        return (int) (Math.random() * 5) + 1;
    }

    static int lastRet = 0;
    public static int rand7(int index5) {
        lastRet = lastRet + (index5 - 1);
        if (lastRet >= 7) {
            lastRet = lastRet % 7;
        }
        return lastRet + 1;
    }
}
