package yang;
import yang.demo.UnionFind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/***
* @Description: 1202. 交换字符串中的元素
 * https://leetcode-cn.com/problems/smallest-string-with-swaps/
* @Author: yangchao
* @Date: 2021/1/13
*/
public class SwapString {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) return s;

        //1. 构建并查集，将任意交换的节点对输入并查集
        int len = s.length();
        UnionFind uf = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            uf.union(pair.get(0),pair.get(1));
        }
        //2. 构建映射关系
        char[] charArray = s.toCharArray();
        //key: 连通分量的代宝元， value：同一个连通分量的字符集合(保存在一个优先级序列中)
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = uf.find(i);
            map.computeIfAbsent(root,key->new PriorityQueue<>()).offer(charArray[i]);
        }
        //3. 重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = uf.find(i);
            stringBuilder.append(map.get(root).poll());
        }
        return stringBuilder.toString();
    }
}
