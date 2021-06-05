package yang;

import org.junit.Test;

/**
 * @Description: 剑指 Offer 12. 矩阵中的路径
 * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 * @Author: yangchao
 * @Date: 2021/04/21/9:01
 */
public class Exist {
    String word;
    char[][] board;
    boolean[][] visited;
    public static final int[][] DIRECTIONS = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length;i++) {
            for (int j = 0; j < board[0].length;j++) {
                if (dfs(0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int index, int i, int j) {
        if (index == word.length()-1) return board[i][j] == word.charAt(index);
        if (board[i][j] == word.charAt(index)) {
            visited[i][j] = true;
            for (int[] direction : DIRECTIONS) {
                int x = i + direction[0];
                int y = j + direction[1];
                if (inArea(x,y) && !visited[x][y]) {
                    if (dfs(index+1,x,y)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public boolean inArea(int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    @Test
    public void existTest() {
        char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Exist es = new Exist();
        boolean exist = es.exist(board, word);
        System.out.println(exist);

    }
}
