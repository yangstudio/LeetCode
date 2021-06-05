package yang;

/**
 * @Description: 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @Author: yangchao
 * @Date: 2021/03/01/9:33
 */
public class MyAtoi {
    public int myAtoi(String str) {
        char[] chrs = str.toCharArray();
        int len = chrs.length;
        if (len == 0) return 0;
        long res = 0;
        boolean negative = false;
        int index = 0;
        while (index < len && chrs[index] == ' ') {
            index++;
        }
        if (index == len) return 0;
        if (chrs[index] == '-') {
            negative = true;
            index++;
        } else if (chrs[index] == '+') {
            index++;
        } else if (!Character.isDigit(chrs[index])) {
            return 0;
        }
        while (index < len) {
            if (chrs[index] >= '0' && chrs[index] <= '9') {
                res = res*10 + chrs[index] - '0';
                index++;
                if (!negative && res >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (negative && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            } else {
                break;
            }
        }
        if (negative) res = -res;
        return (int)res;
    }
}
