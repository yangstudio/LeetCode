package yang.huawei;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/14/19:56
 */
public class Test_4_14_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] miles = new int[len];
        for (int i = 0; i < len; i++) {
            miles[i] = sc.nextInt();
        }
        int res = getTheLeastTime(miles);
        System.out.println(res);

    }

    public static int getTheLeastTime(int[] miles) {
        int len = miles.length;
        if (len == 1) return 1;
        int[] dp = new int[len];
        Arrays.fill(dp,len+1);
        dp[0] = 0;
        if (miles[0] == 0) return 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (miles[j] >= i-j) {
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[len-1] >= len ? 0 : dp[len-1];
    }

    @Test
    public void test3() {
        int[] miles = new int[] {2,5,1,1,1,1};
        int len = miles.length;
        int[] dp = new int[len];
        Arrays.fill(dp,len+1);
        dp[0] = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (miles[j] >= i-j) {
                    dp[i] = Math.min(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(dp[len-1]);
    }
}
