package com.swiley.practice.daily;

public class Palindromic {

    private static class APalindromic {

        private String value;

        public APalindromic(String src, int center) {
            int first = center;
            int last = center + 1;
            value = src.substring(first, last);

            first--;
            last++;
            while (first >= 0 && last <= src.length()) {
                String attempt = src.substring(first, last);
                if (isPalindromic(attempt)) {
                    value = attempt;
                } else {
                    break;
                }
                first--;
                last++;
            }
        }

        private boolean isPalindromic(String attempt) {
            for (int i = 0; i <= attempt.length() / 2; i++) {
                if (attempt.charAt(i) != attempt.charAt(attempt.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

        public int length() {
            return value.length();
        }
    }

    public static String solve(String string) {
        APalindromic longest = null;
        for (int i = 0; i < string.length(); i++) {
            if (longest == null) {
                longest = new APalindromic(string, i);
            } else {
                var attempt = new APalindromic(string, i);
                if (attempt.length() > longest.length()) {
                    longest = attempt;
                }
            }
        }

        return longest == null ? null : longest.value;
    }
}
