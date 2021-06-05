package yang;

import yang.demo.UnionFind;

/**
 * @Description: 959. 由斜杠划分区域
 * https://leetcode-cn.com/problems/regions-cut-by-slashes/
 * @Author: yangchao
 * @Date: 2021/01/25/10:09
 */
public class RegionsBySlashes {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        int size = 4*N*N;

        UnionFind uf = new UnionFind(size);
        for (int i = 0; i < N; i++) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < N; j++) {
                //二维网格转换为一维表格
                int index = 4 * (i * N + j);
                char c = row[j];
                //单元格内合并
                if (c == '/') {
                    //合并0、3，合并1、2
                    uf.union(index,index+3);
                    uf.union(index+1,index+2);
                } else if (c == '\\') {
                    //合并0、1，合并2、3
                    uf.union(index,index+1);
                    uf.union(index+2,index+3);
                } else {
                    uf.union(index,index+1);
                    uf.union(index+1,index+2);
                    uf.union(index+2,index+3);
                }

                //单元格间合并
                //向右合并：1(当前)、3(右一列)
                if (j + 1 < N) {
                    uf.union(index + 1, 4 * (i * N + j + 1) + 3);
                }
                //向下合并：2(当前)、0(下一行)
                if ( i + 1 < N) {
                    uf.union(index + 2, 4 * ((i + 1) * N + j));
                }
            }
        }
        return uf.getSizes();
    }
}
