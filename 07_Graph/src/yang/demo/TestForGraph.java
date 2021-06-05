package yang.demo;

/**
 * @Description: 图
 * https://blog.csdn.net/weixin_40953222/article/details/80544928
 * @Author: yangchao
 * @Date: 2020/12/15/19:13
 */
public class TestForGraph {
    public static void main(String[] args) {
        //测试一把图是否创建ok
        int n = 8;  //结点的个数
        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for(String vertex: Vertexs) {
            graph.insertVertex(vertex);
        }

        //更新边的关系
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);


        //显示一把邻结矩阵
        graph.showGraph();

        //测试一把，我们的dfs遍历是否ok
        System.out.println("深度遍历");
        graph.dfs(); // [1->2->4->8->5->3->6->7]
		System.out.println();
        //System.out.println("广度优先!");
        //graph.bfs(); // [1->2->3->4->5->6->7->8]

    }

}
