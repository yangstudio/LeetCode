package yang.demo;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * 最好。最坏、平均时间复杂度：O(nlogn)
 * @Author: yangchao
 * @Date: 2020/11/28/15:01
 */

public class MergeSort {
    public static void mergeSort(int[] array) {
        int[] backArray = new int[array.length >> 1];
        sort(0,array.length,array,backArray);
    }

    // 对 [begin, end) 范围的数据进行归并排序 【)
    private static void sort(int begin, int end, int[] array, int[] backArray) {
        //长度小于2，不需要排序
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        sort(begin,mid,array,backArray);
        sort(mid,end,array,backArray);
        merge(begin,mid,end,array,backArray);
    }
    //将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列【)
    private static void merge(int begin, int mid, int end, int[] array, int[] backArray) {
        //li:备份出来的左侧数组组内的即将进行排序元素的索引，le:数组结束索引 【不包括le】
        int li = 0, le = mid - begin;
        //ri：右侧数组即将进行排序元素的索引，re为结束索引【不包括re】
        int ri = mid, re = end;
        //数组array内正在进行排序的元素的索引
        int ai = begin;
        //备份左边数组
        System.arraycopy(array,begin,backArray,0,le);
        //看左边元素是否完全排到右边数组，因为左边先结束，不需要再做其他操作，右边直接不动就行了
        while( li < le) {
            //ri >= re: 意味着右边数组提前越界了，就没有元素可以取了，可以直接将左边数组的元素直接搬过来
            if (ri < re && array[ri] < backArray[li]) {
                array[ai++] = array[ri++];
            } else {
                array[ai++] = backArray[li++];
            }
        }
    }

    public static void main(String[] args) {
        //int[] array = { 8, 4, 5, 7, 1, 18, 23, 3, 6, 2, 12,17,13,12,24,46,78,43,21,9};
        int[] array = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            array[i] = (int) (Math.random() * 100000000); // 生成一个[0, 100000000) 数
        }
        long start = System.currentTimeMillis();
        mergeSort(array);
        System.out.println(Arrays.toString(array));
        long end = System.currentTimeMillis();
        System.out.println("mergeSort排序的运行时间："+(end-start));
    }
}
