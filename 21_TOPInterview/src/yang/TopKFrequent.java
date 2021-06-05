package yang;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Description: 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * @Author: yangchao
 * @Date: 2021/04/07/15:11
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //使用HashMap统计每个元素出现的次数
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            //当map集合有这个key时，就使用这个key值，如果没有就使用默认值defaultValue
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //遍历map，用最小堆保存频率最大的k个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
            } else if (map.get(key) > map.get(queue.peek())){
                //每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
                // 如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
                queue.poll();
                queue.offer(key);
            }
        }
        //去除最小堆中的元素
        int[] res = new int[k];
        int index = k-1;
        while (!queue.isEmpty()) {
            res[index--] = queue.poll();
        }
        return res;
    }
}
