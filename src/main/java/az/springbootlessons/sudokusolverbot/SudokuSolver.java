package az.springbootlessons.sudokusolverbot;

public class SudokuSolver {
    private static final int SIZE = 9;
    private  int[][] board = new int[SIZE][SIZE];

    public SudokuSolver(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        // 00 01 02 03 04 05 06 07 08
        // 10 11 12 13 14 15 16 17 18
        // 20 21 22 23 24 25 26 27 28
        // 30 31 32 33 34 35 36 37 38
        // 40 41 42 43 44 45 46 47 48
        // 50 51 52 53 54 55 56 57 58
        // 60 61 62 63 64 65 66 67 68
        // 70 71 72 73 74 75 76 77 78
        // 80 81 82 83 84 85 86 87 88
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
//                    System.out.println("row: " + row + " col: " + col);
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(row, col, num)) {
                            board[row][col] = num;
                            if (solve()) {
                                return true;
                            } else {
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int row, int col, int num) {
        return isValidForBox(row, col, num) && isValidForColumn(col, num) && isValidForRow(row, num);
    }

    public boolean isValidForRow(int row, int num) {
        for (int col = 0; col < SIZE; col++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidForColumn(int col, int num) {
        for (int row = 0; row < SIZE; row++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidForBox(int row, int col, int num) {
        int boxColStart = col - col % 3; // 07 - 07 % 3 = 06 + 03 = 09  r < 09 r++
        int boxRowStart = row - row % 3;
        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
