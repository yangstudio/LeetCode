package yang.huawei;

import java.util.*;

/**
 * @Description: 小孩分组
 * 与题【547. 省份数量】对比 https://leetcode-cn.com/problems/number-of-provinces/
 * @Author: yangchao
 * @Date: 2021/04/13/15:09
 */
public class Test_4_7_1 {
    /*
    * 方法1：dfs
    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //获取邻接矩阵
        int len = sc.nextInt();
        Map<String,Boolean> visit = new HashMap<>();   //表示当前孩子String是否遍历过
        Map<String, List<String>> connectMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            visit.put(s1,false);
            visit.put(s2,false);
            if (!connectMap.containsKey(s1)) {
                List<String> temp = new ArrayList<>();
                temp.add(s2);
                connectMap.put(s1,temp);
            } else {
                connectMap.get(s1).add(s2);
            }

            if (!connectMap.containsKey(s2)) {
                List<String> temp = new ArrayList<>();
                temp.add(s1);
                connectMap.put(s2,temp);
            } else {
                connectMap.get(s2).add(s1);
            }
        }
        //遍历邻接矩阵，dfs
        int res = 0;
        for (String s : connectMap.keySet()) {
            if (!visit.get(s)) {
                dfs(s,connectMap,visit);
                res++;
            }
        }
        System.out.println(res);
    }

    public static void dfs(String person, Map<String,List<String>> connectMap,Map<String,Boolean> visit) {
        visit.put(person,true);
        if (connectMap.get(person) != null) {
            for (String str : connectMap.get(person)) {
                if (!visit.get(str)) {
                    dfs(str,connectMap,visit);
                }
            }
        }
    }

    /*
    * 方法2：并查集
    * */

/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnionFind uf = new UnionFind();
        int len = sc.nextInt();
        for (int i = 0; i < len; i++) {
            String s1 = sc.next();
            String s2 = sc.next();
            uf.union(s1,s2);
        }
        int res = uf.getSizes();
        System.out.println(res);
    }*/

    private static class UnionFind {
        private Map<String,String> parents;
        private int sizes;

        public UnionFind() {
            this.parents = new HashMap<>();
            this.sizes = 0;
        }

        public void union(String s1, String s2) {
            String p1 = find(s1);
            String p2 = find(s2);
            if (p1 == p2) return;
            parents.put(p1,p2);
            sizes--;
        }

        public String find(String v) {
            if (!parents.containsKey(v)) {
                parents.put(v,v);
                sizes++;
            }
            //路径压缩：让每个节点的父节点都指向根节点
            if (v != parents.get(v)) {
                parents.put(v,find(parents.get(v)));
            }
            return parents.get(v);
        }
        public int getSizes(){
            return sizes;
        }
    }

}
