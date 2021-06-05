package yang;

/**
 * @Description: 344. 反转字符串
 * https://leetcode-cn.com/problems/reverse-string/
 * @Author: yangchao
 * @Date: 2021/03/21/17:20
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length < 2) return;
        int len = s.length;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
