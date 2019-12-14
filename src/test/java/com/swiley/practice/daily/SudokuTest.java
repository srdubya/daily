package com.swiley.practice.daily;

import org.junit.Assert;
import org.junit.Test;

public class SudokuTest {

    @Test
    public void sudokuTest() {
        Assert.assertTrue(Sudoku.computeSolution(new String[] {
                "0,0,1",
                "5,0,5",
                "0,1,7",
                "1,1,5",
                "4,1,6",
                "7,1,4",
                "2,2,3",
                "3,2,4",
                "5,2,1",
                "6,2,6",
                "4,3,2",
                "4,3,2",
                "6,3,4",
                "8,3,9",
                "1,4,9",
                "3,4,5",
                "5,4,7",
                "7,4,2",
                "0,5,2",
                "2,5,7",
                "4,5,9",
                "2,6,2",
                "3,6,7",
                "5,6,6",
                "6,6,8",
                "1,7,6",
                "4,7,3",
                "7,7,5",
                "8,7,4",
                "3,8,9",
                "8,8,2"
        }));
    }
}
