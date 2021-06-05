package yang.demo;

/**
 * @Description: 并查集：基于【按秩合并】和【路径压缩】的优化
 * @Author: yangchao
 * @Date: 2021/01/12/17:06
 */

public class UnionFind {
    private int[] parents;
    //以 i为根结点的子树的高度（引入了路径压缩以后该定义并不准确）
    private int[] ranks;
    //集合数量
    private int sizes;

    public UnionFind(int capacity){
        this.parents = new int[capacity];
        this.ranks = new int[capacity];
        this.sizes = capacity;
        for (int i = 0; i < capacity; i++) {
            this.parents[i] = i;
            this.ranks[i] = 1;
        }
    }

    /**
     * 基于rank的优化：矮的树嫁接到高的树,当 ranks[v1] ！= ranks[v2]时，树的总高度不变
     * @param v1
     * @param v2
     */
    public void union(int v1, int v2){
        //找出v1.v2的根节点
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        //集合数量-1
        sizes--;
        if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else {
            //相等的话让v1的根节点指向v2的根节点
            parents[p1] = p2;
            //此时以 r2 为根结点的树的高度仅加了 1
            ranks[p2] += 1;
        }
    }

    /**
     * 基于路径压缩优化：在find时使路径上的所有节点都指向根节点，从而降低树的高度
     * @param v
     * @return
     */
    public int find(int v) {
        if (v != parents[v]) {
            parents[v] = find(parents[v]);
        }
        return parents[v];
    }

    /**
     * 检查v1 和 v2 是否属于同一个集合
     * @param v1
     * @param v2
     * @return
     */
    public boolean isSame(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /**
     * 返回并查集的数量
     * @return
     */
    public int getSizes(){
        return sizes;
    }
}
