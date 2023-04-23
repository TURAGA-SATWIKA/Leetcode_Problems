class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    private boolean solve(char[][] board, int row, int col) {
        // Base case: if we have filled all the cells in the board, we have found a solution
        if (row == board.length) {
            return true;
        }
        
        // Compute the next row and column indices
        int nextRow = col == board.length - 1 ? row + 1 : row;
        int nextCol = (col + 1) % board.length;
        
        // If the current cell is not empty, move to the next cell
        if (board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }
        
        // Try to fill in a valid digit in the current cell
        for (char digit = '1'; digit <= '9'; digit++) {
            if (isValid(board, row, col, digit)) {
                board[row][col] = digit;
                if (solve(board, nextRow, nextCol)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        
        // Backtrack if we could not find a valid digit for the current cell
        return false;
    }
    
    private boolean isValid(char[][] board, int row, int col, char digit) {
        // Check if the digit is already present in the same row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == digit) {
                return false;
            }
        }
        
        // Check if the digit is already present in the same column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == digit) {
                return false;
            }
        }
        
        // Check if the digit is already present in the same 3x3 sub-box
        int subBoxRow = (row / 3) * 3;
        int subBoxCol = (col / 3) * 3;
        for (int i = subBoxRow; i < subBoxRow + 3; i++) {
            for (int j = subBoxCol; j < subBoxCol + 3; j++) {
                if (board[i][j] == digit) {
                    return false;
                }
            }
        }
        
        // If the digit is not present in the same row, column, or sub-box, it is valid
        return true;
    }
}