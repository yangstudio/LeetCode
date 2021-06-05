package yang;

/**
 * @Description: 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 * @Author: yangchao
 * @Date: 2020/12/22/14:30
 */
public class Solve {
    public void solve(char[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        /*对于每一个边界上的 O，我们以它为起点，标记所有与它直接或间接相连的字母 O*/
        //遍历第一列和最后一列
        for (int r = 0; r < m; r++) {
            dfs(board,r,0);
            dfs(board,r,n-1);
        }
        //遍历第一行和最后一行
        for (int c = 1; c < n - 1; c++) {
            dfs(board,0,c);
            dfs(board,m-1,c);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                // if 和 else if 的判断条件顺序不能颠倒，先判断'#'情况
                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }
    private void dfs(char[][] board, int r, int c) {
        //坐标不合法，直接返回
        if (!(r >= 0 && r < board.length && c >= 0 && c < board[0].length)) {
            return;
        }
        //若方格不是岛屿，或者已经遍历过，直接返回
        if (board[r][c] != 'O') {
            return;
        }
        //将当前方格标记为已遍历
        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
