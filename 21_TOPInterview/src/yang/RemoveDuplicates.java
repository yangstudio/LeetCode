package yang;

/**
 * @Description: 26. 删除有序数组中的重复项
 * @Author: yangchao
 * @Date: 2021/03/21/22:50
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int index = 0, p = 0;
        while(p < len) {
            nums[index] = nums[p];
            while (p < len-1 && nums[p] == nums[p-1]) {
                p++;
            }
            index++;
            p++;
        }
        return index;
    }
}
