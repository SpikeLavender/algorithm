package com.natsumes.tree;

/**
 * SBT - Size Balanced Tree
 *
 * 相比红黑树、AVL树等自平衡二叉查找树，SBT更易于实现。据陈启峰在论文中称，SBT是“目前为止速度最快的高级二叉搜索树”。
 * SBT能在O(log n)的时间内完成所有二叉搜索树（BST）的相关操作，而与普通二叉搜索树相比，SBT仅仅加入了简洁的核心操作Maintain。
 *
 * 在本数据结构的实现中，用 size = nodeNum - num 来表示以当前节点为根节点的子树大小
 *
 * @author hetengjiao
 */
public class SizeBalancedTree<T extends Comparable<T>> extends AbstractTree<T> implements Tree<T> {

    public SizeBalancedTree() {
        root = null;
    }

    public SizeBalancedTree(T data) {
        root = new Node(data);
    }

    @Override
    protected Node initNode(T data) {
        return new Node(data);
    }

    @Override
    protected void afterAdd(Node node) {

    }
}
