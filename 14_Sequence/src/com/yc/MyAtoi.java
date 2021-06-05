package com.yc;

/**
 * @Description: 8. 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @Author: yangchao
 * @Date: 2020/12/31/15:32
 */
public class MyAtoi {
    public int myAtoi(String str) {
       int len = str.length();
       char[] chars = str.toCharArray();

       //1. 去除前导空格
       int index = 0;
       while (index < len && chars[index] == ' ') {
           index++;
       }
       //2. 判断str 是否为 " "
       if(index == len) return 0;
       //3. 如果出现符号字符，仅第一个有效
       int sign = 1;
       char firstChar = chars[index];
       if (firstChar == '+') {
           index++;
       } else if (firstChar == '-') {
           index++;
           sign = -1;
       }
       //4. 将后续出现的数字字符进行转换
       int res = 0;
       while (index < len) {
           char curr = chars[index];
           //判断不合法的情况
           if (curr > '9' || curr < '0') {
               break;
           }
           // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
           if( res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (curr - '0') > Integer.MAX_VALUE % 10)) {
               return Integer.MAX_VALUE;
           }
           if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (curr - '0') > -(Integer.MIN_VALUE % 10))) {
               return Integer.MIN_VALUE;
           }
           res = res*10 + sign * (curr - '0');
           index++;
       }
       return res;
    }
}
