class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        boolean[] usedCols = new boolean[n];
        boolean[] usedDiag1 = new boolean[2*n-1];
        boolean[] usedDiag2 = new boolean[2*n-1];
        char[][] board = new char[n][n];
        
        // initialize board
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backtrack(res, board, usedCols, usedDiag1, usedDiag2, 0, n);
        
        return res;
    }
    private void backtrack(List<List<String>> res, char[][] board, boolean[] usedCols, boolean[] usedDiag1, boolean[] usedDiag2, int row, int n) {
        // base case
        if (row == n) {
            res.add(constructBoard(board));
            return;
        }
        
        // recursive case
        for (int col = 0; col < n; col++) {
            int diag1 = row + col;
            int diag2 = n - 1 - row + col;
            if (!usedCols[col] && !usedDiag1[diag1] && !usedDiag2[diag2]) {
                board[row][col] = 'Q';
                usedCols[col] = true;
                usedDiag1[diag1] = true;
                usedDiag2[diag2] = true;
                backtrack(res, board, usedCols, usedDiag1, usedDiag2, row+1, n);
                board[row][col] = '.';
                usedCols[col] = false;
                usedDiag1[diag1] = false;
                usedDiag2[diag2] = false;
            }
        }
    }
    
    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}