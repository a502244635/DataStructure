package com.wenwen.learn.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
    private ArrayList<String> vertexList;//存储顶点集合
    private int[][] edges;//存储图对应的邻接节点
    private int numOfEdges;//表示边的数目
    //定义给数组 boolean[], 记录某个结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexs = {"A","B","C","D","E"};
        //创建图对象
        Graph graph = new Graph(n);
        //循环地添加顶点
        for (String vertex : vertexs){
            graph.insertVertex(vertex);
        }
        //添加边
        //A-B A-C B-C B-D B-E
         graph.insertEdge(0, 1, 1); // A-B
         graph.insertEdge(0, 2, 1); //
         graph.insertEdge(1, 2, 1); //
         graph.insertEdge(1, 3, 1); //
         graph.insertEdge(1, 4, 1); //
        graph.dfs();
//        graph.showGraph();

    }

    public Graph(int n){
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
    }

    //得到第一个邻接结点
    public int getFirstNeighbor(int index){
        for (int j = 0;j<vertexList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标获取下一个邻接结点的下标
    public int getNextNeighbor(int v1, int v2){
        for (int j = v2 + 1;j < vertexList.size();j++){
            if (edges[v1][v2] > 0){
                return j;
            }
        }
        return -1;
    }
    //深度优先遍历算法
    public void dfs(boolean[] isVisited, int i){
        //首先我们访问该结点
        System.out.print(getValueByIndex(i) + "->");
        //将结点设置为已经访问
        isVisited[i] = true;
        //查找结点i的第一个邻接结点
        int w = getFirstNeighbor(i);
        while (w != -1){
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i,w);
        }
    }

    //对dfs进行一个重载，遍历我们所有的结点，并进行dfs
    public void dfs(){
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行 dfs[回溯]
        for (int i = 0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }
    //对一个结点进行广度优先遍历的方法
    public void bfs(boolean[] isVisited,int i){
        int u ;//表示队列的头结点对应下标
        int w; //邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        //访问结点，输出结点信息
        System.out.print(getValueByIndex(i)+"=>");
        //标记为已访问
        isVisited[i] = true;
        //将结点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头结点下标
            u = (Integer)queue.removeFirst();
            //得到第一个邻接结点的下标
            w = getFirstNeighbor(u);
            while (w != -1){
                //是否访问过
                if (!isVisited[w]){
                    System.out.print(getValueByIndex(w)+"=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱结点，找w后面的下一个邻结点
                w = getNextNeighbor(u,w);
            }

        }
    }

    //遍历所有的结点，进行bfs
    public void bfs(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }

    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }
    //返回结点i(下标)对应的数据0-》A 1 -》B
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }
    //返回v1 v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //添加边
    /**
     *
     * @param v1 第一个顶点对应的下标
     * @param v2 第二个顶点对应的下标
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
