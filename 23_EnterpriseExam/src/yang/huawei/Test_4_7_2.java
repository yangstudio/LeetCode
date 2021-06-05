package yang.huawei;

import java.util.*;

/**
 * @Description: 第二题：输出任务执行时间
 * 拓扑排序
 * 对比题【207. 课程表】 https://leetcode-cn.com/problems/course-schedule/
 * @Author: yangchao
 * @Date: 2021/04/13/20:40
 */
public class Test_4_7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] missions = sc.nextLine().split(",");
        int n = missions.length;
        int[] missionTime = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        List<List<Integer>> adjacency = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            //初始化邻接表，因为任务代号为0~n-1，adjacency的索引也是这个范围
            //所以adjacency.get(index)方法既可以得到对应的任务所对应的链表
            adjacency.add(new ArrayList<>());
            //初始化每个任务的执行时间
            missionTime[i] = Integer.parseInt(missions[i]);
        }
        //任务间的依赖关系
        String[] depends = sc.nextLine().split(",");
        //统计每个任务的前置任务【有向图中节点的入度】
        int[] indegrees = new int[n];
        for (String depend : depends) {
            String[] edge = depend.split("->");
            indegrees[Integer.parseInt(edge[0])]++;
            //邻接表存储的是有向图中有向边的终点
            adjacency.get(Integer.parseInt(edge[1])).add(Integer.parseInt(edge[0]));
        }
        //将所有入度为0的节点入列
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                deque.offer(i);
            }
        }

        int pretime = 0;
        int[] time = new int[n];
        while (!deque.isEmpty()) {
            //当deque非空时，依次将队首节点出队，在任务安排图中删除此节点
            int pre = deque.poll();
            time[pre] = missionTime[pre] + pretime;
            pretime = time[pre];
            for (Integer cur : adjacency.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) {
                    deque.offer(cur);
                }
            }
        }
        //打印
        for (int i = 0; i < n-1; i++) {
            System.out.print(time[i] + ",");
        }
        System.out.println(time[n-1]);

    }
}
