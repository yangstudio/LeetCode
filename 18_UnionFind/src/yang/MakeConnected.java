package yang;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 1319. 连通网络的操作次数
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 * @Author: yangchao
 * @Date: 2021/01/13/15:23
 */
public class MakeConnected {
    public int makeConnected(int n, int[][] connections) {
        //线缆数量不足：连通n台电脑，至少需要n-1条网线
        if (connections.length < n-1) return -1;
        UnionFind uf = new UnionFind(n);
        //redus：没有连通的电脑的个数，初始化时n台电脑都没有连通
        int redus = n;
        for (int[] connection : connections) {
            if (!uf.isSame(connection[0],connection[1])) {
                uf.union(connection[0],connection[1]);
                //未连通的电脑集合-1
                redus--;
            }
        }
        //剩余redus个电脑集合，至少需要redus-1条网线将他们连接起来
        return redus-1;
    }

    private class UnionFind{
        private int[] parents;
        private int[] ranks;

        public UnionFind(int capacity) {
            this.parents = new int[capacity];
            this.ranks = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        public void union(int v1, int v2) {
            //找出v1和v2的根节点
            int r1 = find(v1);
            int r2 = find(v2);
            if (r1 == r2) return;

            if (ranks[r1] < ranks[r2]) {
                parents[r1] = r2;
            } else if(ranks[r1] > ranks[r2]) {
                parents[r2] = r1;
            } else {
                parents[r1] = r2;
                ranks[r2] += 1;
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
    }
}
