package com.natsumes.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图
 *
 * 图最直观的一种存储方法就是，邻接矩阵（Adjacency Matrix）。
 * @author hetengjiao
 */
public class MatrixGraph<E> {

    /**
     * 存储点的链表
     */
    private List<E> vertexList;

    /**
     * 邻接矩阵，用来存储边
     */
    private int[][] edges;

    /**
     * 边的数目
     */
    private int numOfEdges;

    public MatrixGraph(int n) {
        //初始化矩阵，一维数组，和边的数目
        this.edges = new int[n][n];
        this.vertexList = new ArrayList<>(n);
        this.numOfEdges = 0;
    }

    /**
     * 得到结点的个数
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 得到边的数目
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回结点i的数据
     */
    public E getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回v1,v2的权值
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 插入结点
     */
    public void insertVertex(E vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        numOfEdges++;
    }

}
