import java.util.*;
class Solution {
    List<List<String>> ans = new ArrayList<>();
    char[][] board;
    int n;
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0);
        return ans;
    }
    private void backtrack(int row) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            ans.add(temp);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }
    private boolean isSafe(int r, int c) {
        for (int i = 0; i < r; i++)
            if (board[i][c] == 'Q') return false;
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q') return false;
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q') return false;
        return true;
    }
}
