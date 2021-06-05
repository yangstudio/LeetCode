package yang;

/**
 * @Description: 剑指 Offer 29. 顺时针打印矩阵
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * @Author: yangchao
 * @Date: 2021/05/06/8:46
 */

public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int l = 0, r = matrix[0].length-1;
        int t = 0, b = matrix.length-1;
        int[] res = new int[(r+1)*(b+1)];
        int index = 0;
        while (true) {
            // left -> right
            for (int i = l; i <= r; i++) res[index++] = matrix[t][i];
            if (++t > b) break;
            // top -> bottom
            for (int i = t; i <= b; i++) res[index++] = matrix[i][r];
            if (l > --r) break;
            // right -> left
            for (int i = r; i >= l; i--) res[index++] = matrix[b][i];
            if (t > --b) break;
            // bottom -> top
            for (int i = b; i >= t; i--) res[index++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }
}
