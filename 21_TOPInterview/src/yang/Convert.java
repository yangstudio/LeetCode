package yang;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 6. Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author: yangchao
 * @Date: 2021/03/31/15:13
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> list = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char ch : s.toCharArray()) {
            list.get(i).append(ch);
            if (i == 0 || i == numRows-1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder ele : list) {
             res.append(ele);
        }
        return res.toString();
    }
}
