package yang.demo;

import java.util.Arrays;

/**
 * @Description: 选择排序
 *最好、最坏、平均时间复杂度：O(n^2)，性能优于冒泡排序
 * @Author: yangchao
 * @Date: 2020/11/26/09:49
 */

public class SelectSort {
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            int min = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (min > arr[j]) {  //说明假定的最小值并不是最小
                    min = arr[j];    //重置min
                    minIndex = j;    //重置minIndex
                }
            }
            //将最小值放在arr[i]，即交换
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println("第"+(i+1)+"轮后~~");
            System.out.println(Arrays.toString(arr));
            System.out.println("------------------");
        }
    }

    public static void main(String[] args) {
        int [] arr = {101, 34, 119, 1, -1, 90, 123};
        selectSort(arr);
    }
}
