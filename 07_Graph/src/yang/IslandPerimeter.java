package yang;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/17/08:42
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    return dfs(grid,row,col);
                }
            }
        }
        return 0;
    }
    private int dfs(int[][] grid, int row, int col) {
        //从一个岛屿方格走向网格边界，周长加1
        if (!(row >= 0 && row <+ grid.length && col >= 0 && col <grid[0].length)) {
            return 1;
        }
        //从一个岛屿方格走向水域方格，周长加1
        if (grid[row][col] == 0) {
            return 1;
        }
        //已遍历过的(值为2)在这里会直接返回，不会重复遍历
        if (grid[row][col] != 1) {
            return 0;
        }
        //将方格标记为"已遍历"
        grid[row][col] = 2;
        return dfs(grid,row -1, col) +
                dfs(grid,row + 1, col) +
                dfs(grid, row, col - 1) +
                dfs(grid, row, col + 1);
    }
}
