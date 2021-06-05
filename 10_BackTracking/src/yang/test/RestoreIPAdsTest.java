package yang.test;

import org.junit.Test;
import yang.RestoreIPAds;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2020/11/20/10:15
 */
public class RestoreIPAdsTest {

    @Test
    public void restoreIpAddresses() {
        String s = "25525511135";
        RestoreIPAds rIp = new RestoreIPAds();
        List<String> list = rIp.restoreIpAddresses(s);
        System.out.println(list);
    }
}