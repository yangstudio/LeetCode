package yang.glodon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/28/20:26
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);

        String[] temp = sc.nextLine().split(" ");
        int[] happy = new int[n];
        for (int i = 0; i < n;i++) {
            happy[i] = Integer.parseInt(temp[i]);
        }
        int[] dp = new int[n];
        dp[0] = happy[0];
        int res = 0;
        Arrays.sort(happy);
        if (n < 4) {
            for (int i = n-1; i >= 0; i--) {
                res += happy[i];
            }
        }
        System.out.println(res);
    }
}
