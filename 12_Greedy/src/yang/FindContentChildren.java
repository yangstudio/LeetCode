package yang;

import java.util.Arrays;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/24/15:44
 */
public class FindContentChildren {
    public int findContentChildren(int[] grid, int[] size) {
        Arrays.sort(grid);
        Arrays.sort(size);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < grid.length && sIndex < size.length) {
            if (grid[gIndex] <= size[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }
}
