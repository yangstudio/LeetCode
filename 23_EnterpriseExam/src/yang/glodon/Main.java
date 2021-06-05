package yang.glodon;

import java.util.Scanner;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/28/19:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int res = 0;
        while (x <= y) {
            x *= 2;
            res++;
        }
        System.out.println(res);
    }
}
