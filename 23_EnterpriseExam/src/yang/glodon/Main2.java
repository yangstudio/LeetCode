package yang.glodon;

import java.util.Scanner;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/28/20:00
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int w = Integer.parseInt(strs[1]);
        int k = Integer.parseInt(strs[2]);

        String[] heighs = sc.nextLine().split(" ");
        int[] keys = new int[n];
        int money = 0;
        for (int i = 0; i < n; i++) {
            keys[i] = Integer.parseInt(heighs[i]);
        }
        for (int i = 0; i < n;i++) {
            if (keys[i] > w) {
                money += keys[i] - w;
                for (int j = i+1; j < n; j++) {
                    keys[j] += k;
                }
            }
        }
        System.out.println(money);
    }
}
