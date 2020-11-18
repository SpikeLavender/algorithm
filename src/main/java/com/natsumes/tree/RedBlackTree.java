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
        if (root == null) {
            node.setBlack(true);
            root = node;
            return this;
        }
        RedBlackTreeNode<V> parent = root;
        RedBlackTreeNode<V> son;

        if (comparator.compare(value, parent.getValue()) <= 0) {
            son = parent.getLeft();
        } else {
            son = parent.getRight();
        }
        //find the position
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

        while ((father = node.getParent()) != null && !father.isBlack()){
            grandFather = father.getParent();
            if (grandFather.getLeft() == father) {
                RedBlackTreeNode<V> uncle = grandFather.getRight();
                if (uncle != null && !uncle.isBlack()) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getRight()) {
                    leftRotate(father);
                    RedBlackTreeNode<V> tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                rightRotate(grandFather);
            } else {
                RedBlackTreeNode<V> uncle = grandFather.getLeft();
                if (uncle != null && !uncle.isBlack()) {
                    setBlack(father);
                    setBlack(uncle);
                    setRed(grandFather);
                    node = grandFather;
                    continue;
                }
                if (node == father.getLeft()) {
                    rightRotate(father);
                    RedBlackTreeNode<V> tmp = node;
                    node = father;
                    father = tmp;
                }
                setBlack(father);
                setRed(grandFather);
                leftRotate(grandFather);
            }
        }
        setBlack(root);
    }

    /**
     * 左旋
     */
    private void leftRotate(RedBlackTreeNode<V> node) {
        RedBlackTreeNode<V> right = node.getRight();
        RedBlackTreeNode<V> parent = node.getParent();

        handleRotate(parent, right, node);

        node.setRight(right.getLeft());
        if (right.getLeft() != null) {
            right.getLeft().setParent(node);
        }
        right.setLeft(node);
    }

    /**
     * 右旋
     */
    private void rightRotate(RedBlackTreeNode<V> node) {
        RedBlackTreeNode<V> left = node.getLeft();
        RedBlackTreeNode<V> parent = node.getParent();

        handleRotate(parent, left, node);

        node.setLeft(left.getRight());
        if (left.getRight() != null) {
            left.getRight().setParent(node);
        }
        left.setRight(node);
    }

    private void handleRotate(RedBlackTreeNode<V> parent, RedBlackTreeNode<V> input ,RedBlackTreeNode<V> node) {
        if (parent == null) {
            root = input;
            input.setParent(null);
        } else {
            if (parent.getLeft() != null && parent.getLeft() == node) {
                parent.setLeft(input);
            } else {
                parent.setRight(input);
            }
            input.setParent(parent);
        }
        node.setParent(input);
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
