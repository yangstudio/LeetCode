package yang;

/**
 * @Description: 200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 * @Author: yangchao
 * @Date: 2020/12/18/9:10
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    res++;
                    dfs(grid,r,c);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, int r, int c) {
        //坐标不合法，直接返回
        if (!(r >= 0 && r <grid.length && c >= 0 && c < grid[0].length)) {
            return;
        }
        //若方格不是岛屿，直接返回
        if (grid[r][c] != '1') {
            return;
        }
        //将方格标记为已遍历
        grid[r][c] = '2';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
