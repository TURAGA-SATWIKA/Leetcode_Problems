class Solution {
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();
        Set<Integer> antiDiagonals = new HashSet<>();
        return backtrack(0, n, cols, diagonals, antiDiagonals);
    
    }
    private int backtrack(int row, int n, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        if (row == n) {
            return 1;
        }
        int count = 0;
        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;
            if (!cols.contains(col) && !diagonals.contains(diagonal) && !antiDiagonals.contains(antiDiagonal)) {
                cols.add(col);
                diagonals.add(diagonal);
                antiDiagonals.add(antiDiagonal);
                count += backtrack(row + 1, n, cols, diagonals, antiDiagonals);
                cols.remove(col);
                diagonals.remove(diagonal);
                antiDiagonals.remove(antiDiagonal);
            }
        }
        return count;
    }
}