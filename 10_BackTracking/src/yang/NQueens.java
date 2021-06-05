package yang;

import java.util.LinkedList;
import java.util.List;

/**
 * 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {
    List<List<String>> lists = new LinkedList<>();
    int[] cols;

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return null;
        cols = new int[n];
        place(0);
        return lists;
    }

    private void place(int row) {
        if (row == cols.length) {
            show();
            return;
        }
        for (int col = 0; col < cols.length; col++) {
            if (isValid(row,col)) {
                cols[row] = col;
                place(row+1);
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
    private void show() {
        List<String> list = new LinkedList<>();
        for (int row = 0; row < cols.length; row++) {
            StringBuilder str = new StringBuilder();
            for (int col = 0; col < cols.length; col++) {
                if (cols[row] == col) {
                    str.append("Q");
                } else {
                    str.append(".");
                }
            }
            list.add(str.toString());
        }
        lists.add(list);
    }
}
