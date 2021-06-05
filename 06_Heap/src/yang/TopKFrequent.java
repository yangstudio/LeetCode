package yang;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Description: 47. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @Author: yangchao
 * @Date: 2020/12/01/8:39
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> occurMap = new HashMap<>();
        for (int num : nums) {
            //Map.getOrDefault():
            //当Map集合中有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            occurMap.put(num,occurMap.getOrDefault(num,0) +  1);
        }
        //int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((m,n) -> m[1] - n[1]);
        for (Map.Entry<Integer, Integer> entry : occurMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            } else {
                queue.offer(new int[]{num,count});
            }
        }
        int[] result = new int[k];
        for (int i = k-1; i >= 0; i--) {
            result[i] = queue.poll()[0];
        }
        return result;
    }
}
