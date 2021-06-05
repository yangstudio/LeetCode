package yang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 8. 四数之和
 * https://leetcode-cn.com/problems/4sum/
 * @Author: yangchao
 * @Date: 2021/01/12/8:55
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length <  4) return  lists;
        int minVal = nums[0] + nums[1] + nums[2] + nums[3];
        int maxVal = nums[len-1] + nums[len-2] + nums[len-3] + nums[len-4];
        if (minVal > target || maxVal < target) return lists;

        //定义4个指针: i,j,le,ri  i从0开始遍历，j从i+1开始遍历，留下le和ri，le指向j+1，ri指向数组最大值
        for (int i = 0; i < len -3; i++) {
            //当前与前一个相等时忽略，本轮与上一轮重复
            if (i > 0 && nums[i] == nums[i-1]) continue;

            //第二层遍历i，初始化指向k+1
            for (int j = i+1; j < len - 2; j++) {
                if (j > i+1 && nums[j] == nums[j-1]) continue;
                //定义指针le指向j+1
                int le = j+1;
                //定义指针执行数组尾端
                int ri = len-1;
                //获取当前最小值，如果当前值比taget大，则后面的都比target大，退出循环
                int min = nums[i] + nums[j] + nums[le] + nums[le+1];
                if (min > target) break;
                //获取当前最大值，如果最大值比target小，则后面的都比target小，退出循环
                int max = nums[i] + nums[j] + nums[ri-1] +nums[ri];
                if (max < target) continue;

                //开始移动 j 和 h 指针，计算当前和
                while(le < ri) {
                    int sum = nums[i] + nums[j] +nums[le] +nums[ri];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i],nums[j],nums[le],nums[ri]));
                        //去重
                        while(le < ri && nums[le] == nums[le+1]) le++;
                        while (le < ri && j < ri && nums[ri] == nums[ri-1]) ri--;
                        le++;
                        ri--;
                    } else if (sum < target) {
                        le++;
                    } else {
                        ri--;
                    }
                }
            }
        }
        return lists;
    }
}
