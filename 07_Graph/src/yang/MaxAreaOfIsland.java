package yang;

/**
 * @Description: 695. 岛屿的最大面积
 * https://leetcode-cn.com/problems/max-area-of-island/
 * @Author: yangchao
 * @Date: 2020/12/21/8:42
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    res = Math.max(res,dfs(grid,r,c));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        //坐标不合法，直接返回
        if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) {
            return 0;
        }
        //若方格不是岛屿，或者已经遍历过，直接返回
        if (grid[r][c] != 1) {
            return 0;
        }
        //将当前方格标记为已遍历
        grid[r][c] = 2;
        //递归遍历四个相邻方格
        return  1+ dfs(grid,r - 1, c) +
                   dfs(grid,r + 1, c) +
                   dfs(grid,r, c + 1) +
                   dfs(grid,r, c - 1);
    }
}
