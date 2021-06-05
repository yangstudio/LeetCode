package yang;

import com.sun.jmx.snmp.SnmpUnknownMsgProcModelException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 210. 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * @Author: yangchao
 * @Date: 2020/12/25/8:29
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        Queue<Integer> queue = new LinkedList<>();
        //初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        //拓扑排序
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            res[i] = queue.poll();
            numCourses--;
            for (Integer cur : adjacency.get(res[i])) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) {
                    queue.add(cur);
                }
            }
            i++;
        }

        return numCourses == 0 ? res : new int[0];
    }
}
