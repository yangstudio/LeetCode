package yang;

/**
 * @Description:
 * 605. 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 * @Author: yangchao
 * @Date: 2020/11/25/14:33
 */

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int i = 0;
        while( i < flowerbed.length && count <= n) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] ==0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                count++;
                i += 2;
            }  else{
                i++;
            }
        }
        return count >= n;
    }
}
