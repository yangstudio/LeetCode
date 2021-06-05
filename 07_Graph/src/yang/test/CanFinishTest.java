package yang.test;

import org.junit.Test;
import yang.CanFinish;

import static org.junit.Assert.*;

/**
 * @Description: 207. 课程表 测试用例
 * @Author: yangchao
 * @Date: 2020/12/24/9:12
 */
public class CanFinishTest {

    @Test
    public void canFinish() {
        int numCourses = 6;
        int[][] prerequisites = new int[][]{{3,0},{3,1},{4,1},{4,2},{5,3},{5,4}};
        CanFinish cf = new CanFinish();
        boolean result = cf.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }
}