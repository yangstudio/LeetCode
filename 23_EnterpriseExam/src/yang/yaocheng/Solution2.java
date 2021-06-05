package yang.yaocheng;

import java.util.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/05/19/19:06
 */
public class Solution2 {
        /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 出现次数最多的词组
     * @param content string字符串 英文文本
     * @return string字符串ArrayList<ArrayList<>>
     */
/*    public ArrayList<ArrayList<String>> frequentWords (String content) {
        // write code here
        String[] arr = content.substring(0,content.length()-1).split(" ");
        List<String> list1 = new ArrayList<>();
        Map<String,Integer> map1 = new TreeMap<>();
        for (String str : arr) {
            if (!Character.isLowerCase(str.charAt(str.length()-1))){
                str = str.substring(0,str.length()-1);
            }
            if (!map1.containsKey(str)) {
                map1.put(str,1);
            } else {
                map1.put(str,map1.get(str)+1);
            }
        }
    }*/
}
