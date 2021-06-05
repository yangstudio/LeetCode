package yang;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/04/25/11:46
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < str.length();i++) {
            if (str.charAt(i) == '1') {
                res++;
            }
        }
        return res;
    }
}
