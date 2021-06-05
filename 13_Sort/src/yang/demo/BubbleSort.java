package yang.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:冒泡排序
 * 冒泡排序 的时间复杂度 O(n^2), 自己写出
 * @Author: yangchao
 * @Date: 2020/11/25/15:54
 */
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        int temp = 0; //临时变量
        boolean flag = false; //标识变量，表示是否进行过交换
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                //如果前面的数比后面的数大，则交换
                if (array[j] > array[j+1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if (!flag) break; // 在一趟排序中，一次交换都没有发生过
            flag = false;     // 重置flag!!!, 进行下次判断
        }
    }


    public static void main(String[] args) {
        /*int[] array = {3,9,20,10,-1};
        int[] array1 = {3,9,10,-1,20};
        bubbleSort(array);*/

        int[] arr = new int[80000];
        for(int i =0; i < 80000;i++) {
            arr[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);
    }


}
