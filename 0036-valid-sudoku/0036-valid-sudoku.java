class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }
                // Check column
                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
                // Check sub-box
                int rowIndex = 3 * (i / 3) + j / 3;
                int colIndex = 3 * (i % 3) + j % 3;
                if (board[rowIndex][colIndex] != '.' && !boxSet.add(board[rowIndex][colIndex])) {
                    return false;
                }
            }
        }
        return true;
    }
}