package yang;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description: 239. 滑动窗口最大值
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * @Author: yangchao
 * @Date: 2021/03/28/21:38
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return nums;
        //双向队列，保存当前窗口最大值的数组位置，保证队列中数组位置的数值按从大到小排列
        Deque<Integer> queue = new LinkedList<>();
        int[] res = new int[len-k+1];
        for (int i = 0; i < len; i++) {
            //保证从大到小，如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            //添加当前值对应的数组下标
            queue.addLast(i);
            //判断当前队列中队首的值是否有效,为什么是 < i-k+1? 当滑动窗口形成后，滑动窗口的范围是【i-k+1，i】
            //i-k+1:左边界范围，比如 k = 3, i= 4时，滑动窗口的范围应该是[2,4] ,
            // 队列中索引小于2的都不在窗口内，应该剔除
            if (queue.peek() < i-k+1) {  // i-k :
                queue.poll();
            }
            //当前窗口长度为k时，保存当前窗口的最大值
            if (i-k+1 >= 0) {
                res[i-k+1] = nums[queue.peek()];
            }
        }
        return res;
    }
}
