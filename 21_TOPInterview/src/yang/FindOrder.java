package yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 210. 课程表 II
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * @Author: yangchao
 * @Date: 2021/03/19/14:40
 */

public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        int[] res = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite: prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            res[i] = queue.poll();
            numCourses--;
            for (Integer curr: adjacency.get(res[i])) {
                indegrees[curr]--;
                if (indegrees[curr] == 0) {
                    queue.offer(curr);
                }
            }
            i++;
        }
        return numCourses == 0 ? res : new int[0];
    }
}
