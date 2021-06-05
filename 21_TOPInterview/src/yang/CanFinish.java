package yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 207. 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 * @Author: yangchao
 * @Date: 2021/04/13/21:26
 */

public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //统计课程安排图中每个节点的入度
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            //初始化邻接表，因为课程代号为0~numCourses-1，adjacency的索引也是这个范围
            //所以adjacency.get(index)方法既可以得到对应的课程所对应的链表
            adjacency.add(new ArrayList<>());   //邻接矩阵存储的是有向边的终点
        }
        for (int[] pq : prerequisites) {
            //统计课程安排图中每个节点的入度
            indegrees[pq[0]]++;
            //为邻接表赋值：索引[1]对应的节点为有向边的起点，[0]为终点
            //邻接表中的链表记录的是终点信息
            adjacency.get(pq[1]).add(pq[0]);
        }

        //将所有入度为0的节点入列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            //当queue非空时，依次将队首节点出队，在课程表安排图中删除此节点pre
            int pre = queue.poll();
            numCourses--;
            //遍历pre的邻接节点【有向边的终点】
            for (Integer cur : adjacency.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) {
                    //cur的所有前驱节点已经删除，入度为0，将其重新入队列
                    queue.add(cur);
                }
            }
        }
        //若课程表有环，一定有节点的入度始终不为0
        return numCourses == 0;
    }
}
