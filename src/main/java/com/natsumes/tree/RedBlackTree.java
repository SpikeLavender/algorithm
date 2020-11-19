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
            node.setBlack(true);
            root = node;
            return this;
        }

        // 如果根节点不为空，查找插入的位置
        RedBlackTreeNode<V> parent = root;
        RedBlackTreeNode<V> son;
        if (comparator.compare(value, parent.getValue()) <= 0) {
            son = parent.getLeft();
        } else {
            son = parent.getRight();
        }

        // 递归查找插入的位置
        while (son != null) {
            parent = son;
            if (comparator.compare(value, parent.getValue()) <= 0) {
                son = parent.getLeft();
            } else {
                son = parent.getRight();
            }
        }

        if (comparator.compare(value, parent.getValue()) <= 0) {
            parent.setLeft(node);
        } else {
            parent.setRight(node);
        }
        node.setParent(parent);
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
        while ((father = node.getParent()) != null && !father.isBlack()) {
            grandFather = father.getParent();
            // 如果父节点为祖父节点的左节点
            if (grandFather.getLeft() == father) {
                // 如果叔叔节点存在且为红
                RedBlackTreeNode<V> uncle = grandFather.getRight();
                if (uncle != null && !uncle.isBlack()) {
                    // 将父节点和叔叔节点调整为黑，祖父节点调整为红
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                // 如果叔叔节点不存在，或者为黑，且新增节点为父节点的右孩子
                if (node == father.getRight()) {
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
                RedBlackTreeNode<V> uncle = grandFather.getLeft();
                if (uncle != null && !uncle.isBlack()) {
                    // 将父节点和叔叔节点调整为黑，祖父节点调整为红
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                // 如果叔叔节点不存在，或者为黑，且新增节点为父节点的左孩子
                if (node == father.getLeft()) {
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
        RedBlackTreeNode<V> parent = node.getParent();
        RedBlackTreeNode<V> right = node.getRight();

        // 如果为根节点，直接交换位置
        handleRotate(parent, right, node);
        // 将自己挂到交换后的节点下
        // 将自己的父节点设置为原来的父节点的右孩子
        node.setParent(right);
        // 将原来右节点的左节点挂到自己的右节点
        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        // 将自己挂到交换后的节点下
        right.setLeft(node);
    }

    /**
     * 右旋: 顺时针旋转红黑树的两个结点，使得父结点被自己的左孩子取代，而自己成为自己的右孩子
     */
    private void rightRotate(RedBlackTreeNode<V> node) {
        RedBlackTreeNode<V> parent = node.getParent();
        RedBlackTreeNode<V> left = node.getLeft();
        // 如果为根节点，直接交换位置
        handleRotate(parent, left, node);
        // 将自己挂到交换后的节点下
        // 将自己的父节点设置为原来的父节点的左孩子
        node.setParent(left);
        // 将原来左节点的右节点挂到自己的左节点
        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        // 将自己挂到交换后的节点下
        left.setRight(node);
    }

    private void handleRotate(RedBlackTreeNode<V> parent, RedBlackTreeNode<V> newParent ,RedBlackTreeNode<V> node) {
        // 如果为根节点，直接交换位置
        if (parent == null) {
            root = newParent;
            newParent.setParent(null);
        } else { // 进入旋转
            // 将要交换的节点挂到父节点下
            if (parent.getLeft() != null && parent.getLeft() == node){
                parent.setLeft(newParent);
            } else {
                parent.setRight(newParent);
            }
            newParent.setParent(parent);
        }
    }

    private void setBlack(RedBlackTreeNode<V> node) {
        node.setBlack(true);
    }

    private void setRed(RedBlackTreeNode<V> node) {
        node.setBlack(false);
    }

    public void list(RedBlackTreeNode<V> node) {
        if (node == null) {
            return;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            System.out.println(node);
            return;
        }

        System.out.println(node);
        list(node.getLeft());
        list(node.getRight());
    }
}
