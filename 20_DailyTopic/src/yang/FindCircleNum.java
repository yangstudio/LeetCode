package yang;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 每日一题： 547. 省份数量
 *https://leetcode-cn.com/problems/number-of-provinces/
 * @Author: yangchao
 * @Date: 2021/01/07/14:27
 */
public class FindCircleNum {
    /**
     * 广度优先搜索
     * @param isConnected
     * @return
     */
    public int findCircleNumII(int[][] isConnected) {
        int len = isConnected.length;   //，len 为无向图的顶点数量
        int res = 0;
        //表示图中哪些节点被访问过【被访问过得城市】
        boolean[] visited = new boolean[len];
        //队列，存放的是同一省份的城市
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;        //如果当前城市被访问过则跳过
            res++;                           //否则遇到了一个新的城市，res+1
            queue.offer(i);                  //把当前城市加入到队列中
            //这个队列中所有的城市都是统一省份的，需要把他们都标记为已访问过，
            // 然后继续查找和他们相连的，若他们也是同一省份的，=也需要加入到队列中
            while (!queue.isEmpty()) {
                int j = queue.poll();    //出队,找出j未被遍历的邻接节点k
                for (int k =0; k < len; k++) {
                    if (isConnected[j][k] == 1 && !visited[k]) {
                        visited[k] = true;
                        queue.offer(k);
                    }
                }
            }
        }
        return res;
    }

    /**
     * 深度优先搜索
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int res = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则遍历新的连通域且res+=1.
            if (!visited[i]) {
                dfs(isConnected,visited,i);
                res++;
            }
        }
        return res;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int row) {
        for (int col = 0; col < isConnected.length; col++) {
            if (isConnected[row][col] == 1 && !visited[col]) {
                visited[col] = true;
                dfs(isConnected,visited,col);
            }
        }
    }
}
