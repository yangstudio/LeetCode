package yang.ctrip;

import java.util.Scanner;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/05/13/23:18
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            endTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = scanner.nextInt();
        }
        System.out.println(maxValue(startTime,endTime,value));

    }
    public static int maxValue(int[] startTime,int[] endTime,int[] value){
        if(startTime.length==1){
            return value[0];
        }
        int max = 0;
        int n = startTime.length;
        int[] time = new int[24];
        for (int i = 0; i < 24; i++) {
            time[i] = i+1;
        }

        while (n>0){
            int temMax = 0;
            int k = 0;

            for (int i = 0; i < startTime.length; i++) {
                if(value[i] > temMax){
                    temMax = value[i];
                    k = i;
                }
            }
            value[k] = 0;
            boolean flag = true;
            for (int j = startTime[k]; j < endTime[k]; j++) {
                if(time[j-1]==0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for (int j = startTime[k]; j < endTime[k]; j++) {
                    time[j-1] = 0;
                }
                max += temMax;
            }
            n--;
        }

        return max;
    }
}
