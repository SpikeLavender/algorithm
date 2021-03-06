package com.natsumes.graph;

/**
 * 深度优先搜索
 *
 * 从起点出发，从规定的方向中选择其中一个不断地向前走，直到无法继续为止，然后尝
 * 试另外一种方向，直到最后走到终点。就像走迷宫一样，尽量往深处走。
 *
 * DFS 解决的是连通性的问题，即，给定两个点，一个是起始点，一个是终点，判断是不是有一条路径能
 * 从起点连接到终点。起点和终点，也可以指的是某种起始状态和最终的状态。问题的要求并不在乎路径
 * 是长还是短，只在乎有还是没有。
 *
 * 时间复杂度
 * 邻接表
 * 访问所有顶点的时间为 O(V)，而查找所有顶点的邻居一共需要 O(E) 的时间，所以总的时间复杂度是
 * O(V + E)。
 * 邻接矩阵
 * 查找每个顶点的邻居需要 O(V) 的时间，所以查找整个矩阵的时候需要 O(V^2) 的时间
 *
 * @author hetengjiao
 */
public class DepthFirstSearch {
}
