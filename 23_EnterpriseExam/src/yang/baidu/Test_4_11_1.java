package yang.baidu;

import java.util.Scanner;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/11/19:48
 */
public class Test_4_11_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int len = sc.nextInt();
            for (int i = 0; i < len; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int root  = getParent(1,a,b);
                int path = getPath(root,a) + getPath(root,b);
                System.out.println(path);
            }
    }
    public static int getParent(int root, int a, int b) {
        //获取最近公共祖先节点
        if (root > a && root > b) return -1;
        if (root == a || root == b) return root;
        int left = getParent(root*2,a,b);
        int right = getParent(root*2+1,a,b);
        if (left == -1) return right;
        if (right == -1) return left;
        return root;
    }
    public static int getPath(int root, int val) {
        if (root == val) return 0;
        int path = 0;
        while (val > root) {
            val = val / 2;
            path++;
        }
        return path;
    }
}
