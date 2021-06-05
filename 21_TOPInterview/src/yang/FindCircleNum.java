package yang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 * @Author: yangchao
 * @Date: 2021/03/18/15:18
 */
public class FindCircleNum {
    public int findCircleNUm(int[][] isConnected) {
        // int[][] isConnected 是无向图的邻接矩阵
        int res = 0;
        boolean [] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            //若当前节点i未被访问，说明又是一个新的连通域，则遍历新的连通域且res+1
            if (!visited[i]) {
                dfs(isConnected,visited,i);
                res++;
            }
        }
        return res;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int i) {
        // 对当前顶点 i 进行访问标记
        visited[i] = true;
        // 继续遍历与顶点 i 相邻的顶点（使用 visited 数组防止重复访问
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs(isConnected,visited,j);
            }
        }
    }

    /**
     * 广度优先搜索
     */
    public int findCircleNUMII(int[][] isConnected) {
        int res = 0;
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            //若当前节点未被访问，则又是一个新的连通区域，res+1，且bfs新的区域
            if (!visited[i]) {
                res++;
                queue.offer(i);
                visited[i] = true;
                while(!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w = 0; w < len; w++) {
                        if (isConnected[v][w] == 1 && !visited[w]) {
                            visited[w] = true;
                            queue.offer(w);
                        }
                    }
                }
            }
        }
        return res;
    }
}
