package com.swiley.practice.daily;

/**
 * Hello world!
 *
 */
public class MissingInteger
{
    private int[] input;

    private MissingInteger(int[] input) {
        this.input = input;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    static int computeOf(int[] input) {
        var self = new MissingInteger(input);
        self.clean();
        for (int index : input) {
            self.doIndex(index);
        }

        var max = 0;
        for (int i = 0; i < input.length; i++) {
            if (self.input[i] >= 0) {
                return i + 1;
            } else {
                max = Math.max(max, 0 - self.input[i]);
            }
        }

        return max + 1;
    }

    private void clean() {
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                input[i] = 0;
            }
        }
    }

    private void doIndex(int value) {
        if (value != 0) {
            var absValue = Math.abs(value);
            var index =  absValue - 1;
            if (input[index] == 0) {
                input[index] = 0 - absValue;
            } else {
                input[index] = 0 - Math.abs(input[index]);
            }
        }
    }
}
