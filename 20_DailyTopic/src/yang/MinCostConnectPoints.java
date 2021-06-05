package yang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: 1584. 连接所有点的最小费用
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/submissions/
 * @Author: yangchao
 * @Date: 2021/01/19/8:33
 */

public class MinCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        UnionFind uf = new UnionFind(length);
        List<Edge> edges = new ArrayList<>();
        //算出任意两个节点之间的曼哈顿距离
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                edges.add(new Edge(distance(points,i,j),i,j));
            }
        }
        //lambda表达式
        Collections.sort(edges,(e1, e2) -> e1.len - e2.len);
        int res = 0;
        int num = 1;
        for (Edge edge : edges){
            int len = edge.len;
            int v1 = edge.v1, v2 = edge.v2;
            //判断是否属于同一个连通量
            if (!uf.isSame(v1,v2)) {
                uf.union(v1,v2);
                res += len;
                num++;
                if (num == length) break;
            }
        }
        return res;
    }
    //计算两个点v1和v2之间的曼哈顿距离
    private int distance(int[][] points, int v1, int v2) {
        return Math.abs(points[v1][0] - points[v2][0]) +
                Math.abs(points[v1][1] - points[v2][1]);
    }

    private class UnionFind{
        int[] parents;
        int[] ranks;
        int size;

        public UnionFind(int capaticy){
            this.parents = new int[capaticy];
            this.ranks = new int[capaticy];
            this.size = capaticy;
            for (int i = 0; i < capaticy; i++){
                this.parents[i] = i;
                this.ranks[i] = 1;
            }
        }

        public int find(int v) {
            if (v != parents[v]) {
                parents[v] = find(parents[v]);
            }
            return parents[v];
        }

        public void union(int v1, int v2) {
            int r1 = find(v1);
            int r2 = find(v2);
            if (r1 == r2) return;

            size--;

            if (ranks[r1] < ranks[r2]) {
                parents[r1] = r2;
            } else if (ranks[r1] > ranks[r2]) {
                parents[r2] = r1;
            } else {
                parents[r1] = r2;
                ranks[r2] += 1;
            }
        }

        public boolean isSame(int v1, int v2) {
            return find(v1) == find(v2);
        }
    }

    class Edge{
        int len, v1, v2;
        public Edge(int len, int v1, int v2) {
            this.len = len;
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
