package yang;

/**
 * @Description: 684. 冗余连接
 * https://leetcode-cn.com/problems/redundant-connection/
 * @Author: yangchao
 * @Date: 2021/01/13/14:20
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] res = new int[2];
        int len = edges.length;
        UnionFind uf = new UnionFind(len);
        for (int[] edge : edges) {
            if (!uf.isSame(edge[0],edge[1])) {
                uf.union(edge[0],edge[1]);
            } else {
                res = edge;
            }
        }
        return res;
    }

    private  class UnionFind {
        private int[] parents;
        private int[] ranks;

        public UnionFind(int capacity) {
            this.parents = new int[capacity];
            this.ranks = new int[capacity];
            //这里做了一点小改变，因为节点是从1开始的，因此我们这里的i也是从1开始，cpacity为 len+1【与数组下标匹配，防止越界】
            for (int i = 1; i < capacity; i++){
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        //基于rank的优化：矮的树 嫁接到 高的树,当 ranks[v1] ！= ranks[v2]时，树的总高度不变
        public void union(int v1, int v2) {
            //找出v1和v2的根节点
            int r1 = find(v1);
            int r2 = find(v2);
            if (r1 == r2) return;

            if (ranks[r1] < ranks[r2]) {
                parents[r1] = r2;
            } else if (ranks[r1] > ranks[r2]) {
                parents[r2] = r1;
            } else {
                parents[r1] = r2;
                //此时以r2为根节点的数的高度增加了1
                ranks[r2] += 1;
            }
        }

        //基于路径压缩的优化：在find时使路径上的所有节点都指向根节点，从而降低数的高度
        public int find(int v){
            if (v != parents[v]) {
                parents[v] = find(parents[v]);
            }
            return parents[v];
        }

        public boolean isSame(int v1, int v2) {
            return find(v1) == find(v2);
        }
    }
}
