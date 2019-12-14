package com.swiley.practice.daily;

public class Sudoku {
    
    @SuppressWarnings("EmptyMethod")
    public static void main(String[] args) {
    }

    public static boolean computeSolution(String[] hints) {
        int[] board = new int[9*9];
        for (var hint : hints) {
            addHint(hint, board);
        }
        print(board);
        
        var solved = solve(board, 0);
        if (solved) {
            print(board);
        }
        
        return solved;
    }

    private static boolean solve(int[] board, int i) {
        if (i == (9 * 9) - 1) {
            System.out.println();
//            print(board);
            if (board[i] != 0) {
                return isCorrect(board);
            }
            for (int attemptedVal = 1; attemptedVal <= 9; ++attemptedVal) {
                board[i] = attemptedVal;
                if (isCorrect(board)) {
                    return true;
                }
            }
            return false;
        }

        if (board[i] != 0) {
            return solve(board, i + 1);
        }
        for (int attemptedVal = 1; attemptedVal <= 9; attemptedVal++) {
            board[i] = attemptedVal;
            if (isCorrect(board) && solve(board, i + 1)) {
                return true;
            }
        }
        board[i] = 0;
        return false;
    }

    private static boolean isCorrect(int[] board) {
        for (int x = 0; x < 9; ++x) {
            int[] column = new int[9];
            for (int y = 0; y < 9; ++y) {
                var val = board[iFromXY(x, y)];
                if (val > 0) {
                    column[val - 1] += 1;
                }
            }
            for (int i = 0; i < 9; ++i) {
                if (column[i] > 1) {
                    return false;
                }
            }
        }

        for (int y = 0; y < 9; ++y) {
            int[] row = new int[9];
            for (int x = 0; x < 9; ++x) {
                var val = board[iFromXY(x, y)];
                if (val > 0) {
                    row[val - 1] += 1;
                }
            }
            for (int i = 0; i < 9; ++i) {
                if (row[i] > 1) {
                    return false;
                }
            }
        }

        for (int X = 0; X < 3; ++X) {
            for (int Y = 0; Y < 3; ++Y) {
                int[] cells = new int[9];
                for (int x = 0; x < 3; ++x) {
                    for (int y = 0; y < 3; ++y) {
                        var val = board[(Y * 27) + (X * 3) + x + (y * 9)];
                        if (val > 0) {
                            cells[val - 1] += 1;
                        }
                    }
                }
                for (int i = 0; i < 9; ++i) {
                    if (cells[i] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void print(int[] board) {
        for (int y = 0; y < 9; ++y) {
            for (int x = 0; x < 9; ++x) {
                System.out.print(" " + toString(board, x, y));
                if ((x + 1) % 3 == 0) {
                    System.out.print(" |");
                }
            }
            System.out.println();
            if ((y + 1) % 3 == 0) {
                System.out.println("------------------------");
            }
        }
    }

    private static String toString(int[] board, int x, int y) {
        var i = iFromXY(x, y);
        if (board[i] == 0) {
            return " ";
        }
        return Integer.toString(board[i]);
    }

    private static void addHint(String hint, int[] board) {
        String[] bits = hint.split(",");
        var x = Integer.parseInt(bits[0].trim());
        var y = Integer.parseInt(bits[1].trim());
        var val = Integer.parseInt(bits[2].trim());

        board[iFromXY(x, y)] = val;
    }

    private static int iFromXY(int x, int y) {
        return x + (y * 9);
    }
}
