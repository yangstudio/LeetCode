package yang;

import org.junit.Test;

/**
 * @Description: 剑指 Offer 46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @Author: yangchao
 * @Date: 2021/05/18/8:35
 */

public class TranslateNum {
    int[] res;
    public int translateNum(int num) {
        if (num < 10) return 1;
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        res = new int[1];
        dfs(0,arr,res);
        return res[0];
    }
    private void dfs(int index, char[] arr, int[] res) {
        if (index >= arr.length) {
            res[0]++;
            return;
        }
        for (int i = index; i < index+2; i++) {
            if (i < arr.length) {
                if (i == index+1 ){  // 取两位
                    int temp = (arr[index]-'0')*10 + (arr[i]-'0');
                    // 26 06 就不满足条件
                    if (temp > 25 || temp < 10) break;
                    dfs(i+1,arr,res);
                } else {   // 取一位
                    dfs(i+1,arr,res);
                }
            }
        }
    }

    @Test
    public void test() {
        TranslateNum ts = new TranslateNum();
        int res = ts.translateNum(506);
        System.out.println(res);

    }
}
