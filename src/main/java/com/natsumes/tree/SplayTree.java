package com.natsumes.tree;

import java.util.Scanner;

/**
 * 伸展树
 *
 * 伸展树的出发点是这样的：考虑到局部性原理（刚被访问的内容下次可能仍会被访问，查找次数多的内容可能下一次会被访问），
 * 为了使整个查找时间更小，被查频率高的那些节点应当经常处于靠近树根的位置。
 * 这样，很容易得想到以下这个方案：每次查找节点之后对树进行重构，把被查找的节点搬移到树根，这种自调整形式的二叉查找树就是伸展树。
 * 每次对伸展树进行操作后，它均会通过旋转的方法把被访问节点旋转到树根的位置。
 *
 * 为了将当前被访问节点旋转到树根，我们通常将节点自底向上旋转，直至该节点成为树根为止。
 * “旋转”的巧妙之处就是在不打乱数列中数据大小关系（指中序遍历结果是全序的）情况下，所有基本操作的平摊复杂度仍为 O(log n)。
 *
 * 特性
 * 和普通的二叉查找树相比，具有任何情况下、任何操作的平摊复杂度为 o(logN)
 * 和一般的平衡二叉树比如 红黑树、AVL树相比，其维护更少的节点额外信息，空间性能更优，同时编程复杂度更低
 * 在很多情况下，对于查找操作，后面的查询和之前的查询有很大的相关性。这样每次查询操作将被查到的节点旋转到树的根节点位置，
 * 这样下次查询操作可以很快的完成
 * 可以完成对区间的查询、修改、删除等操作，可以实现线段树和树状数组的所有功能
 *
 * @author hetengjiao
 */
public class SplayTree<T extends Comparable<T>> extends AbstractTree<T> {

    @Override
    protected Node initNode(T data) {
        return new Node(data);
    }

    @Override
    protected void afterAdd(Node node) {
        splay(node);
    }

    private void splay(Node node) {
        Node parent;
        Node current = node;
        while ((parent = current.parent) != null) {
           Node grandFather = parent.parent;
           if (grandFather == null) {
               if (current == parent.left) {
                   llRotate(parent);
               } else {
                   rrRotate(parent);
               }
               break;
           } else {
               if (current == parent.left) {
                   if (parent == grandFather.left) {
                       llRotate(grandFather);
                   } else {
                       rlRotate(grandFather);
                   }
               } else {
                   if (parent == grandFather.left) {
                       lrRotate(grandFather);
                   } else {
                       rrRotate(grandFather);
                   }
               }
           }
           current = parent;
        }
        root = current;
    }

    public Node find(T t) {
        Node current = root;
        while (current != null) {
            if (t.compareTo(current.data) < 0) {
                current = current.left;
            } else if (t.compareTo(current.data) > 0) {
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) {
            return null;
        }
        splay(current);
        return current;
    }

    @Override
    public T getTopN(long n) {
        if (root == null || n > root.nodeNum || n < 0) {
            return null;
        }
        Node node = root;
        while (node != null) {
            int left = node.left == null ? 0 : node.left.nodeNum;
            if (n <= left) {
                node = node.left;
            } else if (n > left + node.num){
                n = n - left - node.num;
                node = node.right;
            } else {
                splay(node);
                return node.data;
            }
        }
        return null;
    }

    @Override
    public boolean remove(T data) {
        return true;
    }

}
