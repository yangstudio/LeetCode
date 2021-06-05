package yang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 207. 课程表
 * https://leetcode-cn.com/problems/course-schedule/
 * @Author: yangchao
 * @Date: 2020/12/24/8:26
 */
public class CanFinish {
    /**
     * 方法1：广度优先搜索
      * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //统计课程安排图中每个节点的入度
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            //初始化零接表，因为课程代号为0 ~ numCourses-1,adjacency的索引也是这个范围
            //所以adjacency.get(index)方法即可得到对应的课程所对应的链表
            adjacency.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            //统计课程安排图中每个节点的入度
            indegrees[prerequisite[0]]++;
            //为邻接表赋值：索引[1]对应的节点为有向边的起点，[0]为终点
            //邻接表中的链表记录的是终点信息
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        //将所有入度为0的节点入列
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()) {
            //当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre
            int pre = queue.poll();
            numCourses--;
            //遍历pre节点的邻接节点【有向边的终止节点】
            for (Integer cur : adjacency.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) {
                    //cur的所有前驱节点已删除，入度为0，将其重新入队列
                    queue.add(cur);
                }
            }
        }
        //若课程表中有环，一定有节点的入度始终不为0
        return numCourses == 0;
    }

    /**
     * 方法2：深度优先所搜
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishII(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>(numCourses);
        //初始化邻接矩阵
        for (int i = 0; i < numCourses; i++) {
            //添加numCourses个数组
            adjacency.add(new ArrayList<>());
        }
        int[] flags = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            //prerequisite[1]是前导课程，她是DAG中有向边的起点，
            // 然后添加prerequisite[0]，她是边的终点
            adjacency.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            //依次遍历adj每个位置，判断当前位置是否有环
            if (!dfs(adjacency,flags,i)) return false;
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> adjacency,int[] flags, int i){
        //当前节点处陷入了循环，有环
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i)) {
            //遍历i的每个邻接节点
            if (!dfs(adjacency,flags,j)) return false;
        }
        //完成该轮遍历时，flag置位-1
        flags[i] = -1;
        return true;
    }
}
