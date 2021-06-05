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
    private int size;

    public UnionFind(int capacity){
        this.parents = new int[capacity];
        this.ranks = new int[capacity];
        this.size = capacity;
        for (int i = 0; i < capacity; i++) {
            this.parents[i] = i;
            this.ranks[i] = 1;
        }
    }

    /**
     * 基于rank的优化：矮的树 嫁接到 高的树,当 ranks[v1] ！= ranks[v2]时，树的总高度不变
     * @param v1
     * @param v2
     */
    public void union(int v1, int v2){
        //找出v1.v2的根节点
        int r1 = find(v1);
        int r2 = find(v2);
        if (r1 == r2) return;
        //集合数量-1
        size--;
        if (ranks[r1] < ranks[r2]) {
            parents[r1] = r2;
        } else if (ranks[r1] > ranks[r2]) {
            parents[r2] = r1;
        } else {
            parents[r1] = r2;
            //此时以 r2 为根结点的树的高度仅加了 1
            ranks[r2] += 1;
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
}
