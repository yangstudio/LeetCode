package yang;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: 139. 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 * @Author: yangchao
 * @Date: 2021/03/24/8:50
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();
        //dp[i] 表示字符串s前 i个字符组成的字符串 s[0..i-1]是否能被空格拆分成若干个字典中出现的单词
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        for (int i = 1; i < len;i++) {
            for (int j = 0; j < i; j++) {
                //判断s[0,j-1]组成的字符串s1和s[j,i-1]组成的字符串s2是否都包含在wordSet中，若都合法，
                //则按照定义，s1和s2组成的字符串s也是合法的
                if (dp[j] && wordSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }
}
