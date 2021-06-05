package yang.demo;

import java.util.Arrays;

/**
 * @Description: 基数排序
 *看尚硅谷的思路图解即可看懂代码
 * @Author: yangchao
 * @Date: 2020/11/28/16:31
 */
public class RadixSort {
    public static void radixSort(int[] array) {
        //找出最大值
        int max = array[0];
        int len = array.length;
        for (int i = 1; i < len; i++) {
            if (array[i] > max) max = array[i];
        }
        // 最大数组元素有多少位就进行多少次循环
        // divider:1,10,100,1000...
        for (int divider = 1; divider <= max; divider *= 10) {
            //开辟新空间，存储次数,每一位的元素只能是0~9之间
            int[] counts = new int[10];
            // 统计每个整数出现的次数
            for (int i = 0; i < len; i++ ) {
                counts[array[i] / divider % 10]++;
            }
            //累加次数，可以知道前面有多少个数组元素,既是按照array[i] / divider % 10的大小排序
            //例如748，在第一次div时， 比如counts[8]=1,累加后counts[8]=6，
            // 则说明当前位是0~7的有5个，那么748在数组中他在tempArr[6-1]这个位置存储
            for (int i = 1; i < counts.length; i++) {
                counts[i] += counts[i-1];
            }
            //从后往前遍历元素，将它放到有序数组中的合适位置
            int[] tempArr = new int[len];
            for (int i = len-1; i >= 0; i--){
                tempArr[--counts[array[i] / divider % 10]] = array[i];
            }
            //将有序数组赋值到array
            System.arraycopy(tempArr,0,array,0,len);

            System.out.println("--------每一轮排序后的数组------------");
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] array = {53,3,542,748,14,214};
        radixSort(array);
        System.out.println(Arrays.toString(array));
    }
}
