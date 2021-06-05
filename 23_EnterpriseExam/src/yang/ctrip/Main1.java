package yang.ctrip;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Description:
 * @Author: yangchao
 * @Date: 2021/05/13/23:17
 */
public class Main1 {

    static int procee(int[] scores, int[] cards) {
        //开始用了不安全的数据结构HashSet，交早了。交完，距结算前10分钟做出来了
        Set<int[]> set=new CopyOnWriteArraySet<>();
        set.add(cards);
        for(int i=0;i<cards.length-1;i++){
            for(int[] a:set){
                int[] tmp=a.clone();
                int mid=tmp[i];
                tmp[i]=tmp[i+1];
                tmp[i+1]=mid;
                set.add(tmp);
            }
        }

        int sum=0;
        for(int[] a:set){
            int sum1=scores[0];
            int pre=0;
            for(int i:a){
               if(pre+i<scores.length) {
                   sum1+=scores[pre+i];
                   pre+=i;
               }else {
                   break;
               }
            }
            sum=Math.max(sum,sum1);
        }
        return sum;
    }
/******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _scores_size = 0;
        _scores_size = Integer.parseInt(in.nextLine().trim());
        int[] _scores = new int[_scores_size];
        int _scores_item;
        for(int _scores_i = 0; _scores_i < _scores_size; _scores_i++) {
            _scores_item = Integer.parseInt(in.nextLine().trim());
            _scores[_scores_i] = _scores_item;
        }

        int _cards_size = 0;
        _cards_size = Integer.parseInt(in.nextLine().trim());
        int[] _cards = new int[_cards_size];
        int _cards_item;
        for(int _cards_i = 0; _cards_i < _cards_size; _cards_i++) {
            _cards_item = Integer.parseInt(in.nextLine().trim());
            _cards[_cards_i] = _cards_item;
        }

        res = procee(_scores, _cards);
        System.out.println(String.valueOf(res));

    }

}
