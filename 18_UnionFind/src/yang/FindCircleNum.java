package yang;

/**
 * @Description: 547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 *
 * @Author: yangchao
 * @Date: 2021/04/13/15:40
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (isConnected[i][j] == 1) {
                    if (!uf.isSame(i,j)) {
                        uf.union(i,j);
                    }
                }
            }
        }
        return uf.getSizes();
    }
    public class UnionFind{
        private int[] parents;
        private int[] ranks;
        private int sizes;

        public UnionFind(int capacity) {
            this.parents = new int[capacity];
            this.ranks = new int[capacity];
            this.sizes = capacity;
            for (int i = 0; i < capacity; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        public void union(int v1, int v2) {
            int p1 = find(v1);
            int p2 = find(v2);
            if (p1 == p2) return;
            sizes--;
            if (ranks[p1] < ranks[p2]) {
                parents[p1] = p2;
            } else if (ranks[p1] > ranks[p2]) {
                parents[p2] = p1;
            } else {
                parents[p1] = p2;
                ranks[p2] += 1;
            }
        }

        public int find(int v) {
            if (v != parents[v]) {
                parents[v] = find(parents[v]);
            }
            return parents[v];
        }

        public boolean isSame(int v1, int v2) {
            return find(v1) == find(v2);
        }

        public int getSizes() {
            return this.sizes;
        }
    }
}
