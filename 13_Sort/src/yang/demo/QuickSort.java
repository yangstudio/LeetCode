package yang.demo;

import java.util.Arrays;

/**
 * @Description: 快速排序
 * https://blog.csdn.net/nrsc272420199/article/details/82587933
 * @Author: yangchao
 * @Date: 2020/11/27/16:13
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        if(arr != null && arr.length > 0) {
            quickSort(arr, 0 , arr.length-1);
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        //1,找到递归算法的出口
        if( low >= high) return;
        //2, 存
        int i = low;
        int j = high;
        //3,key,以最左边为基准位
        int key = arr[low];
        //4，完成一趟排序
        while( i < j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i < j && arr[j] > key){
                //如果扫描到的值大于基准数据，就让 j-1
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i < j && arr[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 4.4，调整key的位置
        int temp = arr[i];
        arr[i] = arr[low];
        arr[low] = temp;
        //5, 对key左边的数快排
        quickSort(arr, low, i-1 );
        //6, 对key右边的数快排
        quickSort(arr, i+1, high);
    }

    public static void main(String[] args) {
        //int[] arr = {9, 2, 14, 5, 17, 4, 5 ,6, 3, 9, 10, 14, 18,20};
        int[] array = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            array[i] = (int) (Math.random() * 100000000); // 生成一个[0, 100000000) 数
        }
        long start = System.currentTimeMillis();
        quickSort(array);
        //System.out.println(Arrays.toString(arr));
        long end = System.currentTimeMillis();
        System.out.println("quickSort排序的运行时间："+(end-start));
    }

}
