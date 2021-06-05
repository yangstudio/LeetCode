package yang.huawei;

import java.util.Scanner;

/**
 * @Description: 游乐场游玩时间
 *
 * 参考 剑指 Offer 47. 礼物的最大价值
 * https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * @Author: yangchao
 * @Date: 2021/04/13/22:38
 */
public class Test_4_7_3 {
    static int n, m, t;
    static int mt = -1;
    static int[][] mat;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数据：");
        while (sc.hasNext()) {
            n = sc.nextInt();
            m = sc.nextInt();
            t = sc.nextInt();

            //初始化矩阵
            mat = new int[n][m];
            for (int i= 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            dfs(0,0,mat[0][0]);
            System.out.println(mt);
        }
    }

    static void dfs(int x, int y, int cur) {
        if (cur > t) return;
        if (x == n-1 && y == m-1) {
            mt = Math.max(cur,mt);
            return;
        }
        if (x+1 < n) {
            dfs(x+1,y,cur+mat[x+1][y]);
        }
        if (y+1 < m) {
            dfs(x,y+1,cur+mat[x][y+1]);
        }
    }
}
