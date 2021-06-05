package yang;

/**
 * @Description: 547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 * @Author: yangchao
 * @Date: 2020/12/23/8:40
 */
public class FindCircleNum {
    public int findCircleNum(int[][] M) {
        int res = 0;
        int[] visited = new int[M.length];
        for (int r = 0; r < M.length; r++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则遍历新的连通域且cnt+=1.
            if (visited[r] == 0) {
                dfs(M,visited,r);
                res++;
            }
        }
        return res;
    }
    //深度优先遍历
    private void dfs(int[][] M, int[] visited, int r) {
        for (int c = 0; c < M.length; c++) {
            if (M[r][c] == 1 && visited[c] == 0) {
                visited[c] = 1;
                dfs(M, visited, c);
            }
        }
    }
}

