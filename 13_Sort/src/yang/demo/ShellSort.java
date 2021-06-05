package yang.demo;

import java.util.Arrays;

/**
 * @Description: 希尔排序: 对插入排序的改进，会写
 * @Author: yangchao
 * @Date: 2020/11/26/11:18
 */

public class ShellSort {
    //移位法: 对交换法的改进
    public static void shellSort(int[] arr) {
        //增量gap，并逐步缩小gap
        for (int gap = arr.length / 2; gap > 0; gap /= 2 ) {
            //从第gap个元素开始，逐个对其所在的组进行直接插入
            for (int i = gap; i < arr.length; i++) {
                //定义待插入的数
                int insertVal = arr[i];
                int insertIndex = i -gap; //即同一组中，arr[i]前面那个数的下标
                if (insertVal < arr[insertIndex]) {
                    while(insertIndex >= 0 && insertVal < arr[insertIndex]) {
                        //移动
                        arr[insertIndex+gap] = arr[insertIndex];
                        insertIndex -= gap;
                    }
                    //当退出while循环后，就给insertVal找到了位置
                    arr[insertIndex+gap] = insertVal;
                }
            }
            //System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    //交换法
    public static void shellSort1(int[] arr) {
        int temp = 0;
        int count =0;
        for (int gap = arr.length/2; gap > 0; gap /= 2) {
            for (  int i  = gap; i < arr.length; i++) {
                //遍历个组中所有的元素，步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上补偿后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println("希尔排序第" + (++count) + "轮 =" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        //int[] array = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        int[] array = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            array[i] = (int) (Math.random() * 100000000); // 生成一个[0, 100000000) 数
        }
        long start = System.currentTimeMillis();
        shellSort(array);
        //System.out.println(Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println("shellSort排序的运行时间："+(end-start));

    }
}
