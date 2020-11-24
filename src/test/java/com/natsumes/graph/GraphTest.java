package com.natsumes.graph;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class GraphTest {

    @Test
    public void testMatrixGraph() {
        int n = 4;
        //结点的标识
        String[] labels = {"V1", "V1", "V3", "V4"};
        MatrixGraph<String> matrixGraph = new MatrixGraph<>(n);
        for (String label : labels) {
            matrixGraph.insertVertex(label);
        }
        matrixGraph.insertEdge(0, 1, 2);
        matrixGraph.insertEdge(0, 2, 5);
        matrixGraph.insertEdge(2, 3, 8);
        matrixGraph.insertEdge(3, 0, 7);
        System.out.println("结点个数是：" + matrixGraph.getNumOfVertex());
        System.out.println("边的个数是：" + matrixGraph.getNumOfEdges());
        Assert.assertEquals(4, matrixGraph.getNumOfEdges());
        Assert.assertEquals(4, matrixGraph.getNumOfVertex());
    }

    @Test
    public void testListGraph() {

        ListGraph graph = new ListGraph();

        graph.insertVertex("A");
        graph.insertVertex("B");
        graph.insertVertex("C");
        graph.insertVertex("D");
        graph.insertVertex("E");
        graph.insertVertex("F");

        graph.insertEdge("C", "A", 1);
        graph.insertEdge("F", "C", 2);
        graph.insertEdge("A", "B", 4);
        graph.insertEdge("E", "B", 2);
        graph.insertEdge("A", "D", 5);
        graph.insertEdge("D", "F", 4);
        graph.insertEdge("D", "E", 3);

        graph.print();
    }
}
