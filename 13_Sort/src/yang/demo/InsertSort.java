package yang.demo;

import java.util.Arrays;

/**
 * @Description: 插入排序
 * 平均时间复杂度：O(n^2)
 * @Author: yangchao
 * @Date: 2020/11/26/10:05
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //定义待插入的数
            int insertVal = arr[i];
            int insertIndex = i -1; //即arr[i]前面那个数的下标
            /*
            * 给insertVal 找到插入的位置
		    *    说明
			        1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
			        2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
			        3. 就需要将 arr[insertIndex] 后移
			 */
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            //这里我们判断是否需要赋值
            if (insertIndex + 1 != i) {
                arr[insertIndex+1] = insertVal;
            }

            System.out.println("第"+i+"轮插入");
            System.out.println(Arrays.toString(arr));
            System.out.println("-------------");
        }
    }

    public static void main(String[] args) {
        int[] arr = {101,34,120,1,-1,89};
        insertSort(arr);
    }
}

