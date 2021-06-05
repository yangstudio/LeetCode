package yang;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * @Author: yangchao
 * @Date: 2021/04/01/20:14
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 1) {
            res.add("()");
            return res;
        }
        char[] packets = new char[]{'(',')'};
        //sizes[0]代表当前可以使用的左括号数量；
        //sizes[0]代表当前可以使用的右括号数量；
        int[] sizes = new int[]{n,n};
        dfs(0,res,new StringBuilder(),packets,sizes,2*n);
        return res;
    }
    private void dfs(int index, List<String> res, StringBuilder path, char[] packets, int[] sizes, int depth) {
        if (index == depth) {
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < 2; i++) {
            //若当前要选择右括号且右括号的数量小于左括号，则是非法的
            //剪枝
            if (i == 1 && sizes[1]-1 < sizes[0]) break;
            if (sizes[i] <= 0) continue;
            sizes[i]--;
            path.append(packets[i]);
            dfs(index+1,res,path,packets,sizes,depth);
            //回溯
            sizes[i]++;
            path.deleteCharAt(index);
        }
    }

    @Test
    public void generateParenthesisTest(){
        GenerateParenthesis gp = new GenerateParenthesis();
        List<String> list = gp.generateParenthesis(3);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
