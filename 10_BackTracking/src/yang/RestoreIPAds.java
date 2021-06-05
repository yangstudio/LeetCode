package yang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:93. 复原IP地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * @Author: yangchao
 * @Date: 2020/11/19/15:26
 */
public class RestoreIPAds {
    ArrayDeque<String> path;
    int len;
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        len = s.length();
        path = new ArrayDeque<>(4);
        if (len < 4 || len > 12) return list;
        getIPSubaet(s,0,4,list);
        return list;
    }
    // residue:记录剩余多少段还没被分割,ip段最多就4个段
    private void getIPSubaet(String s, int begin, int residue,List<String> list){
        if (begin == len) {
            if (residue == 0) {
                list.add(String.join(".", path));
                System.out.println("list的元素为:"+list.get(list.size()-1));
                System.out.println("------------------------------------");
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len || residue == 0) break;
            //每个Ip段最多三位数，如果此时剩余的IP位数大于 IP段数*3(每个Ip段最多三位数)，则证明剩下的字符不能构成合法的IP段
            //即后面的ip段即使全部是3位，s还是会有剩下的，因此剪枝。
            if ((residue - 1) * 3 < len - i -1) continue;
            if (isValidSegment(s, begin, i)) {
                String currIPSegment = s.substring(begin,i+1);
                path.addLast(currIPSegment);
                System.out.println("  递归之前 => " + path);
                getIPSubaet(s,i+1,residue-1,list);
                path.removeLast();
                System.out.println("  递归之后 => " + path);
            }
        }
    }

    private boolean isValidSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') return false;
        int res = 0;
        while(left <= right) {
            res = res*10 + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }
}
