package yang;


import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description: 973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @Author: yangchao
 * @Date: 2020/12/01/14:31
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((m,n)->(n[0]*n[0] + n[1]*n[1]) - (m[0]*m[0] + m[1]*m[1]));
        for (int[] point : points) {

            if (queue.size() == K) {
                System.out.println(Arrays.toString(queue.peek()));
                System.out.println("-------------");
                //if ((Math.pow(queue.peek()[0],2) + Math.pow(queue.peek()[1],2)) > (Math.pow(point[0],2) + Math.pow(point[1],2) ))
                //这种写法更简洁！！！
                if (queue.comparator().compare(queue.peek(),point) < 0 ){
                    queue.poll();
                    queue.offer(point);
                }
            } else {
                queue.offer(point);
            }
        }
        int[][] result = new int[K][2];
        for (int i = K-1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return result;
    }
}
