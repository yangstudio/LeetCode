package yang;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 1018. 可被 5 整除的二进制前缀
 * @Url: https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * @Author: yangchao
 * @Date: 2021/01/14/8:58
 */

public class PrefixesDivBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int remainder = 0;
        for (int i = 0; i < A.length; i++) {
            remainder = (remainder*2 + A[i]) % 5;
            if (remainder == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }
}
