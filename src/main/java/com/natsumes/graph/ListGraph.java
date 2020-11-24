package com.natsumes.graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 邻接表
 *
 * 用邻接矩阵来表示一个图，虽然简单、直观，但是比较浪费存储空间
 * 对于无向图来说，如果 A[i][j]等于 1，那 A[j][i]也肯定等于 1。实际上，我们只需要存储一个就可以了。
 * 也就是说，无向图的二维数组中，如果我们将其用对角线划分为上下两部分，那我们只需要利用上面或
 * 者下面这样一半的空间就足够了，另外一半白白浪费掉了
 * 还有，如果我们存储的是稀疏图（Sparse Matrix），也就是说，顶点很多，但每个顶点的边并不多，
 * 那邻接矩阵的存储方法就更加浪费空间了。比如微信有好几亿的用户，对应到图上就是好几亿的顶点。
 * 但是每个用户的好友并不会很多，一般也就三五百个而已。如果我们用邻接矩阵来存储，那绝大部分的
 * 存储空间都被浪费了
 * 针对上面邻接矩阵比较浪费内存空间的问题，我们来看另外一种图的存储方法，邻接表（Adjacency List）。
 *
 * 数组+链表的结构
 *
 * @author hetengjiao
 */
public class ListGraph<E,V> {

    /**
     * 存储所有的顶点
     */
    private Map<String, Vertex> vertexMap;

    public ListGraph() {
        vertexMap = new HashMap<>();
    }

    public void insertVertex(String vertexName) {
        insertVertex(vertexName, null);
    }

    public void insertVertex(String vertexName, V v) {
        Vertex vertex = new Vertex(vertexName, null);
        vertex.setValue(v);
        vertexMap.put(vertexName, vertex);
    }

    public void insertEdge(String begin, String end, int weight) {
        insertEdge(begin, end, weight, null);
    }

    public void insertEdge(String begin, String end, int weight, E e) {
        Vertex vertexBegin = vertexMap.get(hash(begin));
        if (vertexBegin == null) {
            vertexBegin = new Vertex(begin, null);
            vertexMap.put(begin, vertexBegin);
        }
        Edge edge = new Edge(end, weight, null);
        edge.setValue(e);
        if (vertexBegin.next == null) {
            vertexBegin.next = edge;
        } else {
            Edge lastEdge = vertexBegin.next;
            while (lastEdge.next != null) {
                lastEdge = lastEdge.next;
            }
            lastEdge.next = edge;
        }

    }

    public void print() {
        Set<Map.Entry<String, Vertex>> set = vertexMap.entrySet();
        for (Map.Entry<String, Vertex> entry : set) {
            Vertex vertex = entry.getValue();
            Edge edge = vertex.next;
            while (edge != null) {
                System.out.println(vertex.name + " 指向 " + edge.name + " 权值为：" + edge.weight);
                edge = edge.next;
            }
        }
    }

    private String hash(String vertexName) {
        return Integer.toOctalString(vertexName.hashCode()) + System.currentTimeMillis();
    }

    class Vertex {
        //顶点名称
        String name;

        //顶点属性
        V value;

        //从该定点出发的边
        Edge next;

        Vertex(String name, Edge next) {
            this.name = name;
            this.next = next;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    class Edge {
        // 被指向的顶点
        String name;

        // 弧的权值
        int weight;

        // 被指向的下一个边
        Edge next;

        // 边属性
        E value;

        Edge(String name, int weight, Edge next) {
            this.name = name;
            this.weight = weight;
            this.next = next;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }
    }
}
