package yang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 947. 移除最多的同行或同列石头
 * https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column/
 * @Author: yangchao
 * @Date: 2021/01/15/8:47
 */
public class RemoveStones {
    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();
        for (int[] stone : stones) {
            uf.union(stone[0]+10000,stone[1]);
        }
        return stones.length - uf.getCount();
    }

    private class UnionFind{
        private Map<Integer,Integer> parent;
        private int count;

        public UnionFind(){
            this.parent = new HashMap<>();
            this.count = 0;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;
            parent.put(rootX,rootY);
            count--;
        }

        public int find(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x,x);
                count++;
            }
            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public int getCount(){
            return count;
        }
    }
}
