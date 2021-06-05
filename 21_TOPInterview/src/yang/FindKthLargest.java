package yang;

/**
 * @Description: 215. 数组中的第K个最大元素
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Author: yangchao
 * @Date: 2021/04/07/8:51
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        heapSort(nums);
        return nums[nums.length-k];
    }
    //堆排序
    private void heapSort(int[] array) {
        //将无序序列构建成一个大顶堆
        for (int i = array.length/2 - 1; i >= 0; i--) {
            adjuxtHeap(array,i,array.length);
        }
        int temp = 0;
        for (int j = array.length-1; j > 0; j--) {
            temp = array[j];
            array[j] = array[0];
            array[0] = temp;
            adjuxtHeap(array,0,j);
        }
    }
    private void adjuxtHeap(int[] array, int i, int length) {
        int temp = array[i];
        for (int k = i*2+1; k < length; k = 2*k+1) {
            if (k+1 < length && array[k] < array[k+1]) {
                k++;
            }
            if (array[k] > temp) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;
    }
}
