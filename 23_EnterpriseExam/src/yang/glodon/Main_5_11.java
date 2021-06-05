package yang.glodon;

import java.util.Scanner;

/**
 * @Description: 大数阶乘
 * https://blog.csdn.net/lisp1995/article/details/52403507
 *
 * 思路2 ： https://blog.csdn.net/qq_40564464/article/details/81708066
 * @Author: yangchao
 * @Date: 2021/05/11/19:17
 */
public class Main_5_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数n：");
        int n = sc.nextInt();
        //存储每一位得到的数
        int[] store = new int[100000];
        store[0] = 1;
        int digit = 1; // 位数从第一位开始
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            int num = 0;
            for (int j = 0; j < digit; j++) {
                temp = store[j]*i + num;   //将一个数的每一位数都分别乘以i，
                store[j] = temp%10;       //将一个数的每一位数利用数组进行储存
                num = temp/10;
            }
            while(num > 0) { // 判断退出循环后，num的值是否为0
                store[digit] = num%10;
                num = num/10;
                digit++;
            }
        }
        for (int i = digit-1; i > 0; i--) {
            System.out.print(store[i]);
        }
        System.out.println();
    }
}