package yang;

/**
 * @Description: 605. 种花问题
 *https://leetcode-cn.com/problems/can-place-flowers/
 * @Author: yangchao
 * @Date: 2021/04/06/14:33
 */
public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length < n) return false;
        int count = 0;
        int pre = 0;
        for (int i = 0; i < flowerbed.length-1; i++) {
            if (flowerbed[i] == 0 && pre == 0 && flowerbed[i+1] == 0) {
                count++;
                flowerbed[i] = 1;
            }
            pre = flowerbed[i];
        }
        if (pre == 0 && flowerbed[flowerbed.length-1] == 0) {
            count++;
        }
        if (count >= n) return true;
        return false;
    }

    /*
    * 1 0 1 0 0
    * */
}
