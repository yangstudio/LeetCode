package yang;

/**
 * @Description: 查找模式串在文本串中的索引位置
 * 参考小码哥的ppt
 * @Author: yangchao
 * @Date: 2020/12/28/15:30
 */
public class KMP {
    public static int kmpSearch(String text, String pattern) {
        if (text == null || pattern == null) return -1;
        int tlen = text.length(), plen = pattern.length();
        if (tlen == 0 || plen == 0 || tlen < plen) return -1;
        int[] next = next(pattern);
        int ti = 0, pi = 0;
        int tmax = tlen - plen;

        //ti – pi 是指每一轮比较中 text 首个比较字符的位置
        while(pi < plen && ti - pi <= tmax) {
            if (pi < 0 || text.charAt(ti) == pattern.charAt(pi)) {
                ti++;
                pi++;
            } else {
                pi = next[pi];
            }
        }
        return pi == plen ? ti - pi : -1;
    }
    //构建KMP的next表,存储的是索引index前面子串的最大“真前缀后缀公共子串长度”
    private static int[] next(String pattern) {
        int len = pattern.length();
        int[] next = new int[len];
        int i = 0;
        //相当于在 -1 位置有一个假想的统配字符(哨兵)
        // 设定的前提条件：n == next[i]
        int n = next[i] = -1;
        while (i < len - 1) {
            if (n < 0 || pattern.charAt(i) == pattern.charAt(n)) {
                next[++i] = ++n;
            } else {
                //失配不相等时，进入下一个循环，比较charAt(i)和charAt(k), k == next[n];
                n = next[n];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String text = "DABCCDABCDABEA";
        String pattern = "ABCDABE";
        int[] next = next(pattern);
        for (int i : next) {
            System.out.println(i);
        }

        int res = kmpSearch(text,pattern);
        System.out.println(res);
    }
}
