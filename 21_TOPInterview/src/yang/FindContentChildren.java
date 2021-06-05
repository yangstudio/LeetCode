package yang;

import java.util.Arrays;

/**
 * @Description: 455. 分发饼干
 * https://leetcode-cn.com/problems/assign-cookies/
 * @Author: yangchao
 * @Date: 2021/04/04/15:23
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        if (s.length == 0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (s[si] < g[gi]) {
                si++;
            } else {
                res++;
                si++;
                gi++;
            }
        }

        /*
        int index = 0;
        for (int i = 0; i < s.length; i++) {
            for (int j = index; j < g.length; j++) {
                if (s[i] >= g[j]) {
                    res++;
                    index = j+1;
                    break;
                }
            }
        }*/
        return res;
    }
}
