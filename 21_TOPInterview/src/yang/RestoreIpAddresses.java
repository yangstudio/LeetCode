package yang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 93. 复原 IP 地址
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * @Author: yangchao
 * @Date: 2021/04/01/14:18
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        //IP 只有4段，每一段的范围在 [0~255]
        if (s.length() < 4 || s.length() > 12) return res;
        List<String> path = new ArrayList<>(4);
        dfs(s,0,4, path, res);
        return res;
    }

    private void dfs(String s, int begin, int residue,
                     List<String> path, List<String> res) {
        if (begin == s.length()) {
            if (residue == 0) {
                res.add(String.join(".",path));
            }
            return;
        }
        //取begin-1字符后，判断剩余的字符个数不能构成有效的IP地址：
        //例如，取s[0] = 2后，剩余的len-1 = 10 个字符【5525511135】不能构成有效的IP
        if (residue * 3 < s.length() - begin) return;
        for (int i = begin; i < begin + 3; i++) {
            if (i >= s.length()) return;
            //判断s在闭区间[left,right]内能否构成有效的IP地址
            if (judgeIPSegment(s,begin,i)) {
                String currentIPSegment = s.substring(begin,i+1);
                path.add(currentIPSegment);
                dfs(s,i+1,residue-1,path,res);
                path.remove(path.size()-1);
            }
        }
    }

    //判断s在闭区间[left,right]内能否构成有效的IP地址
    private boolean judgeIPSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') return false;
        int res = 0;
        while(left <= right) {
            res = res*10 + s.charAt(left)-'0';
            left++;
        }
        return res >= 0 && res <= 255;
    }

    @Test
    public void restoreIpAddressesTest() {
        String s = "25525511135";
        RestoreIpAddresses restIP = new RestoreIpAddresses();
        List<String> list = restIP.restoreIpAddresses(s);
        for (String str :list) {
            System.out.println(str);
        }
    }
}
