package yang;

import org.junit.Test;

import java.util.*;

/**
 * @Description: 51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 * @Author: yangchao
 * @Date: 2021/04/02/16:04
 */
public class NQueens {
    private Set<Integer> col;
    private Set<Integer> main;
    private Set<Integer> sub;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new LinkedList<>();
        if (n == 0) return res;

        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        List<Integer> path = new LinkedList<>();

        dfs(0,path);
        return res;

    }
    private void dfs(int row, List<Integer> path){
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }
        //行数依次递增，针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            //主对角线：(横坐标-纵坐标)的值固定
            //副对角线：横、纵坐标之和固定
            if (!col.contains(i) && !main.contains(row-i) && !sub.contains(row+i)){
                path.add(i);
                col.add(i);
                main.add(row-i);
                sub.add(row+i);

                dfs(row+1,path);

                sub.remove(row+i);
                main.remove(row-i);
                col.remove(i);
                path.remove(path.size()-1);
            }
        }
    }
    private List<String> convert2board(List<Integer> path) {
        List<String> board = new LinkedList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }

    @Test
    public void solveNQueensTest(){
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println("=======");
            for (String str: list) {
                System.out.println(str);
            }
        }
    }
}
