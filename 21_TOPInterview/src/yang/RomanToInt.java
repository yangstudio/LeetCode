package yang;

/**
 * @Description: 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 * @Author: yangchao
 * @Date: 2021/03/30/9:40
 */
public class RomanToInt {
    public int romanToInt(String s) {
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += getNUm(s.charAt(i));
        }
        return res;
    }
    private int getNUm(Character chr) {
        switch (chr){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            case 'a': return 4;
            case 'b': return 9;
            case 'c': return 40;
            case 'd': return 90;
            case 'e': return 400;
            case 'f': return 900;
            default:
                return 0;
        }
    }
}
