package yang;

/**
 * @Description: 79. 单词搜索
 * https://leetcode-cn.com/problems/word-search/
 * @Author: yangchao
 * @Date: 2021/04/02/20:29
 */
public class Exist {

    private static final int[][] DIRECTIONS = {{-1,0},{0,-1},{0,1},{1,0}};
    private int rows;
    private int cols;
    private int len;
    private boolean[][] visited;
    private char[] charArray;
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        if(rows == 0) return false;
        visited = new boolean[rows][cols];
        len = word.length();
        charArray = word.toCharArray();
        this.board = board;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(i,j,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int index) {
        if(index == len-1) return board[i][j] == charArray[index];
        if(board[i][j] == charArray[index]) {
            visited[i][j] = true;
            for(int[] direction : DIRECTIONS) {
                int x = i + direction[0];
                int y = j + direction[1];
                if(inArea(x,y) && !visited[x][y]) {
                    if(dfs(x,y,index+1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
    }
    private boolean inArea(int x,int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
