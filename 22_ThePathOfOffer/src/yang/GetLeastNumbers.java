package yang;

import java.util.PriorityQueue;

/**
 * @Description: 剑指 Offer 40. 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/05/15/22:01
 */

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1,v2) -> v2 > v1 ? 1 : -1);
        for (int val : arr) {
            if (pq.size() < k) {
                pq.offer(val);
            } else {
                if (pq.peek() > val) {
                    pq.poll();
                    pq.offer(val);
                }
            }
        }
        int[] res = new int[k];
        while ( k > 0) {
            k--;
            res[k] = pq.poll();
        }
        return res;
    }
}
