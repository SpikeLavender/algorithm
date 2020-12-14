package com.natsumes.tree;

import java.util.Comparator;

/**
 * @author hetengjiao
 */
public class RedBlackTree<V> {

    private RedBlackTreeNode<V> root;

    private final Comparator<? super V> comparator;

    public RedBlackTree(Comparator<? super V> comparator) {
        this.comparator = comparator;
    }

    public RedBlackTreeNode<V> build() {
        return root;
    }

    public RedBlackTree<V> insert(V value) {
        RedBlackTreeNode<V> node = new RedBlackTreeNode<>(value);
        // 如果根节点为空，直接设为为根节点，并设置为黑色
        if (root == null) {
            node.isBlack = true;
            root = node;
            return this;
        }

        // 如果根节点不为空，查找插入的位置
        RedBlackTreeNode<V> parent = root;
        RedBlackTreeNode<V> son;
        if (comparator.compare(value, parent.value) < 0) {
            son = parent.left;
        } else if (comparator.compare(value, parent.value) == 0) {
            parent.num++;
            return this;
        } else {
            son = parent.right;
        }

        // 递归查找插入的位置
        while (son != null) {
            parent = son;
            if (comparator.compare(value, parent.value) < 0) {
                son = parent.left;
            }else if (comparator.compare(value, parent.value) == 0) {
                parent.num++;
                return this;
            } else {
                son = parent.right;
            }
        }

        if (comparator.compare(value, parent.value) <= 0) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        node.parent = parent;
        balanceInsert(node);
        return this;
    }

    /**
     * 自平衡
     */
    private void balanceInsert(RedBlackTreeNode<V> node) {
        RedBlackTreeNode<V> father, grandFather;
        // 如果是根节点 setBlack
        // 如果不是根节点，父节点为黑，则不需要平衡
        // 如果不是根节点，而且父节点为红，进入平衡过程
        while ((father = node.parent) != null && !father.isBlack) {
            grandFather = father.parent;
            // 如果父节点为祖父节点的左节点
            if (grandFather.left == father) {
                // 如果叔叔节点存在且为红
                RedBlackTreeNode<V> uncle = grandFather.right;
                if (uncle != null && !uncle.isBlack) {
                    // 将父节点和叔叔节点调整为黑，祖父节点调整为红
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                // 如果叔叔节点不存在，或者为黑，且新增节点为父节点的右孩子
                if (node == father.right) {
                    // 以父节点为轴左旋，使新节点成为父节点
                    leftRotate(father);
                    // 交换父节点和子节点位置
                    RedBlackTreeNode<V> tmp = node;
                    node = father;
                    father = tmp;
                    // 进入下一种情况 00
                }
                // 00: 如果叔叔节点不存在，或者为黑，且新增节点为父节点的左孩子
                // 以祖父节点为轴右旋一次
                rightRotate(grandFather);
                setBlack(father);
                setRed(grandFather);
            } else { // 如果父节点为祖父节点的右节点
                // 如果叔叔节点存在且为红
                RedBlackTreeNode<V> uncle = grandFather.left;
                if (uncle != null && !uncle.isBlack) {
                    // 将父节点和叔叔节点调整为黑，祖父节点调整为红
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                // 如果叔叔节点不存在，或者为黑，且新增节点为父节点的左孩子
                if (node == father.left) {
                    // 以父节点为轴右旋，使新节点成为父节点
                    rightRotate(father);
                    // 交换父节点和子节点位置
                    RedBlackTreeNode<V> tmp = node;
                    node = father;
                    father = tmp;
                    // 进入下一种情况 00
                }
                // 00: 如果叔叔节点不存在，或者为黑，且新增节点为父节点的右孩子
                // 以祖父节点为轴左旋一次
                leftRotate(grandFather);
                setBlack(father);
                setRed(grandFather);
            }
        }
        setBlack(root);
    }

    /**
     * 左旋: 逆时针旋转红黑树的两个结点，使得父结点被自己的右孩子取代，而自己成为自己的左孩子
     */
    private void leftRotate(RedBlackTreeNode<V> node) {
        RedBlackTreeNode<V> parent = node.parent;
        RedBlackTreeNode<V> right = node.right;

        // 如果为根节点，直接交换位置
        handleRotate(parent, right, node);
        // 将自己挂到交换后的节点下
        // 将自己的父节点设置为原来的父节点的右孩子
        node.parent = right;
        // 将原来右节点的左节点挂到自己的右节点
        node.right = right.left;
        if (right.left != null) {
            right.left.parent = node;
        }
        // 将自己挂到交换后的节点下
        right.left = node;
    }

    /**
     * 右旋: 顺时针旋转红黑树的两个结点，使得父结点被自己的左孩子取代，而自己成为自己的右孩子
     */
    private void rightRotate(RedBlackTreeNode<V> node) {
        RedBlackTreeNode<V> parent = node.parent;
        RedBlackTreeNode<V> left = node.left;
        // 如果为根节点，直接交换位置
        handleRotate(parent, left, node);
        // 将自己挂到交换后的节点下
        // 将自己的父节点设置为原来的父节点的左孩子
        node.parent = left;
        // 将原来左节点的右节点挂到自己的左节点
        node.left = left.right;
        if (left.right != null) {
            left.right.parent = node;
        }
        // 将自己挂到交换后的节点下
        left.right = node;
    }

    private void handleRotate(RedBlackTreeNode<V> parent, RedBlackTreeNode<V> newParent ,RedBlackTreeNode<V> node) {
        // 如果为根节点，直接交换位置
        if (parent == null) {
            root = newParent;
            newParent.parent = null;
        } else { // 进入旋转
            // 将要交换的节点挂到父节点下
            if (parent.left != null && parent.left == node){
                parent.left = newParent;
            } else {
                parent.right = newParent;
            }
            newParent.parent = parent;
        }
    }

    private void setBlack(RedBlackTreeNode<V> node) {
        node.isBlack = true;
    }

    private void setRed(RedBlackTreeNode<V> node) {
        node.isBlack = false;
    }

    public void list(RedBlackTreeNode<V> node) {
        if (node == null) {
            return;
        }

        list(node.left);
        System.out.println(node);
        list(node.right);
    }
}
