package yang;

import org.junit.Test;

import java.util.Stack;

/**
 * @Description: 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 * @Author: yangchao
 * @Date: 2021/04/09/14:57
 */
public class DecodeString {
    public String decodeString(String s) {
       StringBuilder res = new StringBuilder();
       int multi = 0;
       Stack<Integer> stackMulti = new Stack<>();
       Stack<String> stackRes = new Stack<>();
       for (char ch : s.toCharArray()) {
           if (ch == '[') {
               stackMulti.push(multi);
               stackRes.push(res.toString());
               multi = 0;
               res = new StringBuilder();
           } else if (ch == ']') {
               StringBuilder temp = new StringBuilder();
               int curMulti = stackMulti.pop();
               for (int i = 0; i < curMulti; i++) {
                   temp.append(res);
               }
               res = new StringBuilder(stackRes.pop()+temp);
           } else if (Character.isDigit(ch)) {
               multi = multi*10 + ch - '0';
           } else {
               res.append(ch);
           }
       }
       return res.toString();
    }

    @Test
    public void decodeStringTest(){
        String s = "3[a2[c]]";
        DecodeString ds = new DecodeString();
        String str = ds.decodeString(s);
        System.out.println(str);
    }
}
