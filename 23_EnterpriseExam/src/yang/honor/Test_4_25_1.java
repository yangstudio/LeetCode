package yang.honor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test_4_25_1 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        if (strs.length != 4) return;
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int weekth = Integer.parseInt(strs[2]);
        int weekday = Integer.parseInt(strs[3]);

        //找出该月第一天对应是星期几
        StringBuilder st = new StringBuilder();
        st.append(year).append("-").append(month).append("-").append(1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(st.toString());
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(date.getTime()));
        //
        int week = cal.get(Calendar.DAY_OF_WEEK)-1;
        if (week == 0) week = 7;

        //key:为第几周，value: map类型，为星期数与具体日期的映射
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        int j = 1; //日期
        int maxdate;
        if (month == 2) {
            if ((year%4 == 0 && year%100 != 0)) maxdate = 29;
            else if (year%400 == 0) maxdate = 29;
            else maxdate = 28;
        }
        else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            maxdate = 31;
        } else maxdate = 30;

        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = week; i <= 7; i++) {
            map1.put(week,j);
            j++;
        }
        map.put(1,map1);
        for (int n = 2; n <= 6;n++) {
            if (j > maxdate) break;
            Map<Integer,Integer> mapk = new HashMap<>();
            for (int i = 1; i <= 7; i++) {
                mapk.put(i,j);
                j++;
                if (j > maxdate) break;
            }
            map.put(n,mapk);
        }
        if (!map.containsKey(weekth)) {
            System.out.println(0);
        } else {
            Map<Integer, Integer> resMap = map.get(weekth);
            if (resMap.containsKey(weekday)) {
                Integer day = resMap.get(weekday);
                StringBuilder res = new StringBuilder();
                res.append(year).append("-");
                if (month < 10) {
                    res.append(0);
                }
                res.append(month).append("-");
                if (day < 10) {
                    res.append(0);
                }
                res.append(day);
                System.out.println(res.toString());
            } else {
                System.out.println(0);
            }
        }
    }
}
