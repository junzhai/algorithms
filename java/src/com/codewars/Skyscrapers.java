package com.codewars;

public class Skyscrapers {
    public static int[][] solvePuzzle(int[] clues) {
        int[][] ret = new int[6][6];
        backtrack(6, 0, 63, ret, clues);
        return ret;
    }

    private static boolean backtrack(int v, int row, int mask, int[][] ret, int[] clues) {
        if (v == 0) {
            return true;
        }

        int leftRowClue = clues[23 - row];
        int rightRowClue = clues[6 + row];
        for (int col = 0, m = 1; col < 6; col++, m <<= 1) {
            if (ret[row][col] != 0) {
                continue;
            }
            if ((mask & m) == 0) {
                continue;
            }

            int topColClue = clues[col];
            int bottomColClue = clues[17 - col];
            if (checkAndUpdateClues(row, col, ret, clues)) {
                ret[row][col] = v;
                if (row == 5) {
                    if (backtrack(v - 1, 0, 63, ret, clues)) {
                        return true;
                    }
                } else {
                    if (backtrack(v, row + 1, mask ^ m, ret, clues)) {
                        return true;
                    }
                }
                ret[row][col] = 0;
                clues[23 - row] = leftRowClue;
                clues[6 + row] = rightRowClue;
                clues[col] = topColClue;
                clues[17 - col] = bottomColClue;
            }
        }
        return false;
    }

    private static boolean checkAndUpdateClues(int row, int col, int[][] ret, int[] clues) {
        boolean updateLeftClue = false;
        if (clues[23 - row] > 0) {
            boolean checkClue = true;
            for (int c = col - 1; c >= 0; c--) {
                if (ret[row][c] != 0) {
                    checkClue = false;
                    break;
                }
            }
            if (checkClue) {
                if (clues[23 - row] == 1) {
                    if (col > 0) {
                        return false;
                    }
                } else {
                    if (col + 1 < clues[23 - row]) {
                        return false;
                    }
                }
                updateLeftClue = true;
            }
        }

        boolean updateRightClue = false;
        if (clues[6 + row] > 0) {
            boolean checkClue = true;
            for (int c = col + 1; c < 6; c++) {
                if (ret[row][c] != 0) {
                    checkClue = false;
                    break;
                }
            }
            if (checkClue) {
                if (clues[6 + row] == 1) {
                    if (col < 5) {
                        return false;
                    }
                } else {
                    if (6 - col < clues[6 + row]) {
                        return false;
                    }
                }
                updateRightClue = true;
            }
        }

        boolean updateTopClue = false;
        if (clues[col] > 0) {
            boolean checkClue = true;
            for (int r = row - 1; r >= 0; r--) {
                if (ret[r][col] != 0) {
                    checkClue = false;
                    break;
                }
            }
            if (checkClue) {
                if (clues[col] == 1) {
                    if (row > 0) {
                        return false;
                    }
                } else {
                    if (row + 1 < clues[col]) {
                        return false;
                    }
                }
                updateTopClue = true;
            }
        }

        boolean updateBottomClue = false;
        if (clues[17 - col] > 0) {
            boolean checkClue = true;
            for (int r = row + 1; r < 6; r++) {
                if (ret[r][col] != 0) {
                    checkClue = false;
                    break;
                }
            }
            if (checkClue) {
                if (clues[17 - col] == 1) {
                    if (row < 5) {
                        return false;
                    }
                } else {
                    if (6 - row < clues[17 - col]) {
                        return false;
                    }
                }
                updateBottomClue = true;
            }
        }

        if (updateLeftClue) {
            clues[23 - row] -= 1;
        }
        if (updateRightClue) {
            clues[6 + row] -= 1;
        }
        if (updateTopClue) {
            clues[col] -= 1;
        }
        if (updateBottomClue) {
            clues[17 - col] -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] clues = new int[]{3, 2, 2, 3, 2, 1,
                1, 2, 3, 3, 2, 2,
                5, 1, 2, 2, 4, 3,
                3, 2, 1, 2, 2, 4};

        int[][] expected = new int[][]{
                new int[]{2, 1, 4, 3, 5, 6},
                new int[]{1, 6, 3, 2, 4, 5},
                new int[]{4, 3, 6, 5, 1, 2},
                new int[]{6, 5, 2, 1, 3, 4},
                new int[]{5, 4, 1, 6, 2, 3},
                new int[]{3, 2, 5, 4, 6, 1}};

        int[][] actual = Skyscrapers.solvePuzzle(clues);
        int i = 0;
    }
}
