package yang;

/**
 * @Description: 剑指 Offer 17. 打印从1到最大的n位数
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @Author: yangchao
 * @Date: 2021/04/26/10:46
 */
public class PrintNumbers {
    //大数越界问题： 当 nn 较大时，endend 会超出 int32int32 整型的取值范围，超出取值范围的数字无法正常存储。
    // 但由于本题要求返回 int 类型数组，相当于默认所有数字都在 int32 整型取值范围内，因此不考虑大数越界问题。

    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10,n)-1;
        int[] res = new int[len];
        for (int i = 1; i <= len; i++) {
            res[i-1] = i;
        }
        return res;
    }
}
