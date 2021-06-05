package yang.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/14/19:01
 */
public class Test_4_14_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<String> stack = new Stack<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < str.length();i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(stb.toString());
                stb = new StringBuilder();
            } else if (ch == ')') {
                String s1 = stack.pop();
                StringBuilder temp = new StringBuilder();
                for (int j = s1.length()-1;j >= 0; j--) {
                    temp.append(s1.charAt(j));
                }
                stb.append(temp);
                stack.push(stb.toString());
            } else {
                stb.append(str.charAt(i));
            }
        }
        String res = stack.pop();
        System.out.println(res);
    }

    @org.junit.Test
    public void test() {
        String str = "(u(love)i)";
        Stack<String> stack = new Stack<>();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < str.length();i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(stb.toString());
                stb = new StringBuilder();
            } else if (ch == ')') {
                String s1 = stb.toString();
                StringBuilder temp = new StringBuilder();
                for (int j = s1.length()-1;j >= 0; j--) {
                    temp.append(s1.charAt(j));
                }
                stb = new StringBuilder();
                String s2 = stack.pop();
                stb.append(s2);
                stb.append(temp);
                //if (i == str.length()-1) stack.push(stb.toString());
                //stack.push(stb.toString());
            } else {
                stb.append(str.charAt(i));
            }
        }
        String res = stb.toString();
        System.out.println(res);
        System.out.println("iloveu");
    }

}
