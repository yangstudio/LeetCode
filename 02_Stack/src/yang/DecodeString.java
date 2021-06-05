package yang;

import java.util.Collections;
import java.util.LinkedList;


/**
 * 394. 字符串解码
 * https://leetcode-cn.com/problems/decode-string/
 */

public class DecodeString {

    public static void main(String[] args) {
        String s = "3[ab2[cd]ef]";
        String str = decodeString1(s);
        System.out.println(str);

    }

    // 1. digit - 保存为multi
    // 2. abc - 添加到res
    // 3. [ - 将 multi ，res 压栈，并置0
    // 4. ] - 将之前的res,multi出栈--出一次
    public static String decodeString1(String s) {
        //两个栈，一个放倍数，一个放字符结果
        LinkedList<StringBuilder> stack_res = new LinkedList<>();
        LinkedList<Integer> stack_multi = new LinkedList<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                multi = multi*10 + (c - '0');
            }else if(c == '['){
                stack_multi.addLast(multi);
                stack_res.addLast(res);
                res = new StringBuilder();
                multi = 0;
            }else if(c == ']'){
                StringBuilder lastRes = stack_res.removeLast();
                int lastMulti = stack_multi.removeLast();
                StringBuilder tmp = new StringBuilder();
                for(int j = 0; j < lastMulti; j++) {
                    tmp.append(res);
                }
                res = lastRes.append(tmp);
            }else if (Character.isLetter(c)){
                res.append(c);
            }
        }

        return res.toString();
    }

    int ptr;
    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<>();
        ptr = 0;
        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前sub对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    private  String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    private  String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}



