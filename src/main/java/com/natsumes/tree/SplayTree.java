package com.natsumes.tree;

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
 * @author hetengjiao
 */
public class SplayTree<T extends Comparable<T>> extends AbstractTree<T> implements Tree<T> {

    @Override
    public void add(T data) {

    }

    @Override
    public boolean remove(T data) {
        return true;
    }

}
