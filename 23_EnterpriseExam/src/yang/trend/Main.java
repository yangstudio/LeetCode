package yang.trend;

import java.util.*;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/05/08/20:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int x = Integer.parseInt(sc.next());
        int m = str.length();
        int tar = Integer.parseInt(str);
        int num = tar;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            int temp = num % 10;
            map.put(i+1,temp);
            list.add(temp);
        }
        int res = 0;
        if (map.get(m-x) == 0) {
            for (int i = 0; i < m-x-1;i++) {
                res = res*10 + map.get(i+1);
            }
            System.out.println(res);
        } else {
            /*Collections.sort(list);
            for (int i = 0; i < x; i++) {
                int pos =
            }*/
            System.out.println(0);
        }
    }

   /* public static String getkey(Map<Integer,Integer> map, Integer value) {

    }*/

}
