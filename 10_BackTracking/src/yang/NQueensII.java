package yang;

/**
 * 52. N皇后 II
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class NQueensII {
    int totals = 0;
    int[] cols;

    public int totalNQueens(int n) {
        if (n < 1) return 0;
        cols = new int[n];
        place(0);
        return totals;
    }
    private void place(int row) {
        if (row == cols.length) {
            totals++;
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row,col)) {
                cols[row] = col;
                place(row + 1);
            }
        }
    }
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (cols[i] == col) return false;
            if (row - i == Math.abs(col - cols[i])) return false;
        }
        return true;
    }
}
