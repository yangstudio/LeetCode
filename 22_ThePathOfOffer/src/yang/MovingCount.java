package yang;

/**
 * @Description: 剑指 Offer 13. 机器人的运动范围
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * @Author: yangchao
 * @Date: 2021/04/23/18:47
 */

public class MovingCount {
    int m, n,k;
    int res;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        dfs(0,0);
        return res;
    }

    public void dfs(int x, int y) {
        if (!(x < m && x >= 0 && y < n && y >= 0)) return;
        if (visited[x][y]) return;
        if (x / 10 + x % 10 + y / 10 + y % 10 > k) return;
        visited[x][y] = true;
        res++;
        dfs(x+1,y);
        dfs(x-1,y);
        dfs(x,y+1);
        dfs(x,y-1);
    }
}
