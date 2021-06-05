package com.yc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: convert
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author: yangchao
 * @Date: 2020/12/31/8:38
 */

public class Convert {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            if (i == 0 || i == numRows-1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
