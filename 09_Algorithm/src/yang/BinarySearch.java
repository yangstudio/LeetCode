package yang;

/**
 * @Description: 二分查找，前提是数组有序
 * 非递归与递归方式都要掌握
 * @Author: yangchao
 * @Date: 2020/11/29/16:16
 */
public class BinarySearch {
    /**
     * 二分查找的非递归实现
     * @param arr 待查找的数组, arr是升序排序
     * @param target 需要查找的数
     * @return 返回对应下标，-1表示没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) { //说明继续查找
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if ( arr[mid] > target) {
                right = mid - 1;//需要向左边查找
            } else {
                left = mid + 1; //需要向右边查找
            }
        }
        return -1;
    }

   //二分查找递归实现
    public static int binarySearch1(int[] arr, int left, int right, int target) {
        // 当 left > right 时，说明递归完整个数组，但是没有找到
        if (left > right) return -1;

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (target > midVal) { // 向 右递归
            return binarySearch1(arr, mid + 1, right, target);
        } else if (target < midVal) { // 向左递归
            return binarySearch1(arr, left, mid - 1, target);
        } else {
            return mid;
        }
    }
}
