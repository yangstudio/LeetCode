package yang.demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 对于字符串或者不连续的整数类型可以使用传统并查集的变形
 * @Author: yangchao
 * @Date: 2021/04/14/11:48
 */
public class UnionFindII {
    private Map<Integer,Integer> parents;
    private int sizes;

    public UnionFindII() {
        this.parents = new HashMap<>();
        this.sizes = 0;
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        parents.put(px,py);
        sizes--;
    }

    public int find(int v) {
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
