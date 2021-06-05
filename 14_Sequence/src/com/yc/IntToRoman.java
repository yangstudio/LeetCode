package com.yc;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/12/30/8:24
 */
public class IntToRoman {
    public String intToRoman(int num) {
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        StringBuilder res = new StringBuilder();
        int index = 0;
        //13 为数组的长度
        while (index < 13) {
            while (num >= nums[index]) {
                res.append(roman[index]);
                num -= nums[index];
            }
            index++;
        }
        return res.toString();
    }
}
