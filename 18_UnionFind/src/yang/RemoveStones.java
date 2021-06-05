package yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 947. 移除最多的同行或同列石头
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * @Author: yangchao
 * @Date: 2021/04/14/11:02
 */
public class RemoveStones {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            uf.union(stone[0]+10001,stone[1]);
        }
        return stones.length - uf.getSizes();
    }

    private class UnionFind {
        private Map<Integer,Integer> parents;
        private int sizes;

        public UnionFind() {
            this.parents = new HashMap<>();
            this.sizes = 0;
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) return;
            parents.put(px,py);
            sizes--;
        }

        public int find(int v) {
            if (!parents.containsKey(v)) {
                parents.put(v,v);
                sizes++;
            }
            //路径压缩：让每个节点的父节点都指向根节点
            if (v != parents.get(v)) {
                parents.put(v,find(parents.get(v)));
            }
            return parents.get(v);
        }
        public int getSizes(){
            return sizes;
        }
    }
}
