package com.natsumes.tree;

/**
 * SBT - Size Balanced Tree
 *
 * 相比红黑树、AVL树等自平衡二叉查找树，SBT更易于实现。据陈启峰在论文中称，SBT是“目前为止速度最快的高级二叉搜索树”。
 * SBT能在O(log n)的时间内完成所有二叉搜索树（BST）的相关操作，而与普通二叉搜索树相比，SBT仅仅加入了简洁的核心操作Maintain。
 *
 * 在本数据结构的实现中，用 size 来表示以当前节点为根节点的子树大小
 *
 * 如果数据分布不均匀，是否会退化？
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
        maintain(node);
    }

    /**
     * balance
     * @param node node need balance
     */
    private void maintain(Node node) {
        if (node == null || node == root || node.parent == root) {
            return;
        }

        doMaintain(node, node.data.compareTo(node.parent.data) < 0);
    }

    /**
     * balance
     * @param node node
     * @param flag true -> left, false -> right
     */
    private void doMaintain(Node node, boolean flag) {
        if (node != null) {
            if (flag && node.left != null) {
                int right = node.right == null ? -1 : node.right.size;
                if (node.left.left != null && node.left.left.size > right) {
                    llRotate(node);
                } else if (node.left.right != null && node.left.right.size > right) {
                    lrRotate(node);
                } else{
                    return;
                }
                doMaintain(node.left, true);
                doMaintain(node.right, false);
                doMaintain(node, true);
                doMaintain(node, false);
            } else if (!flag && node.right != null) {
                int left = node.left == null ? -1 : node.left.size;
                if (node.right.left != null && node.right.left.size > left) {
                    rlRotate(node);
                } else if (node.right.right != null && node.right.right.size > left) {
                    rrRotate(node);
                } else {
                    return;
                }

                doMaintain(node.left, true);
                doMaintain(node.right, false);
                doMaintain(node, true);
                doMaintain(node, false);
            }
            if (node.parent == null) {
                root = node;
            }
        }
    }



    @Override
    protected void updateSize(Node node) {
        if (node == null) {
            return;
        }
        int leftSize = node.left == null ? 0 : node.left.size;
        int rightSize = node.right == null ? 0 : node.right.size;
        node.size = leftSize + rightSize + 1;
    }
}
