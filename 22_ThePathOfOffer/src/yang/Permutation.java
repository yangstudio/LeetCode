package yang;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @Author: yangchao
 * @Date: 2021/05/13/15:03
 */
public class Permutation {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        if (s.length() == 1) return new String[]{s};
        boolean[] visited = new boolean[s.length()];
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        List<String> list = new LinkedList<>();
        dfs(0,visited,list,new StringBuilder(),chs);
        String[] res = new String[list.size()];
       return list.toArray(new String[list.size()]);
    }

    private void dfs(int index,boolean[] visited, List<String> list, StringBuilder sb, char[] chs) {
        if (index == chs.length) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chs.length;i++) {
            if (!visited[i]) {
                if ( i > 0 && chs[i-1] == chs[i] && !visited[i-1]) continue;
                visited[i] = true;
                sb.append(chs[i]);
                dfs(index+1,visited,list,sb,chs);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    @Test
    public void test() {
        Permutation pt = new Permutation();
        String s = "abca";
        String[] res = pt.permutation(s);
        for (String str : res) {
            System.out.print(str+ " ");
        }
    }
}
