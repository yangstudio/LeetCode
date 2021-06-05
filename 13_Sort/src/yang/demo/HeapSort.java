package yang.demo;

/**
 * @Description: 堆排序，面试必会
 * https://blog.csdn.net/u013384984/article/details/79496052
 * @Author: yangchao
 * @Date: 2020/11/28/22:05
 */

public class HeapSort {
    public static void heapSort(int[] array) {
        int temp = 0;
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array,i,array.length);
        }
        //将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
        //重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for (int j = array.length-1; j > 0; j--) {
            temp = array[j];
            //按照大顶堆的性质，array[0]为最大值
            array[j] = array[0];
            array[0] = temp;
            adjustHeap(array,0,j);
        }
    }

    /**
     * @Description:  将一个数组(二叉树), 调整成一个大顶堆, 完成将以i对应的非叶子结点的树调整成大顶堆
     * 举例  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => 得到 {4, 9, 8, 5, 6}
     * 如果我们再次调用  adjustHeap 传入的是 i = 0 => 得到 {4, 9, 8, 5, 6} => {9,6,8,5, 4}
     * @param array 待调整的数组
     * @param i 表示非叶子结点在数组中索引
     * @param length 表示对多少个元素继续调整， length是在逐渐的减少
     */
    private static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i]; // 先把当前元素取出来，因为当前元素可能要一直移动
        //k = i * 2 + 1  k是i结点的左子结点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明左子结点的值小于右子结点的值
            if (k + 1 < length && array[k] < array[k+1]) {
                k++; // k 指向右子结点
            }
            if (array[k] > temp) { //如果子结点大于父结点
                array[i] = array[k];
                i = k;  //!!! i 指向 k,继续循环比较
            } else {
                break;
            }
        }
        //当for 循环结束后，我们已经将以i 为父结点的树的最大值，放在了堆顶(局部)
        array[i] = temp;//将temp值放到调整后的位置,最好自己画一个堆试一下
    }

    public static void main(String[] args) {
        /*int[] array = {9, 2, 14, 5, 17, 4, 5 ,6, 3, 9, 10, 14, 18,20};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));*/
        int[] array = new int[100000000];
        for (int i = 0; i < 100000000; i++) {
            array[i] = (int) (Math.random() * 100000000); // 生成一个[0, 100000000) 数
        }
        long start = System.currentTimeMillis();
        heapSort(array);
        //System.out.println(Arrays.toString(arr));
        long end = System.currentTimeMillis();
        System.out.println("heapSort排序的运行时间："+(end-start));
    }
}
