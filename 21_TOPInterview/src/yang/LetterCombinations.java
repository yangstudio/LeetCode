package yang;

import java.util.*;

/**
 * @Description: 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @Author: yangchao
 * @Date: 2021/03/11/8:33
 */
public class LetterCombinations {

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new LinkedList<>();
        if (digits == "") return combinations;

        Map<Character,String> phoneMap = new HashMap<>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");

        backtrack(combinations,phoneMap,digits,0,new StringBuilder());
        return combinations;

    }
    private void backtrack(List<String> combinations,Map<Character,String> phoneMap,
                           String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations,phoneMap,digits,index+1,combination);
            combination.deleteCharAt(index);
        }
    }

/*    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) return combinations;

        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "gkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(combinations,map,digits,0,new StringBuilder());
        return combinations;

    }
    private void backtrack(List<String> combinations, Map<Character,String> map,
                           String digits,int index, StringBuilder combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int count = letters.length();
            for (int i = 0; i < count; i++ ) {
                combination.append(letters.charAt(i));
                backtrack(combinations,map,digits,index+1,combination);
                //回溯操作：添加之后又删除了,之后再遍历其余的字母
                combination.deleteCharAt(index);
            }
        }
    }*/
}
