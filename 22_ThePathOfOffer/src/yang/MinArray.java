package yang;

/**
 * @Description: 剑指 Offer 11. 旋转数组的最小数字
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @Author: yangchao
 * @Date: 2021/04/20/8:37
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;
        //归根结底，找出最小元素所在的区间，并不断缩小该区间的范围
        while(left < right) {
            int mid = (left + right)/2;
            //【mid+1，right】
            if (numbers[mid] > numbers[right]) {
                left = mid+1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }
}
