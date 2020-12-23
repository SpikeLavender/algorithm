package com.natsumes.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 替罪羊树 -- Scapegoat Tree
 *
 * 非常暴力的二叉搜索树，除了在 子树不平衡的时候会暴力重构以外和BTS没有任何区别
 *
 * @author hetengjiao
 */
public class ScapegoatTree<T extends Comparable<T>> extends AbstractTree<T> {

    /**
     * 阈值
     */
    private static final double THRESHOLD = 0.75;

    /**
     * 上次修改的节点数
     */
    private int lastModifyNodeCount = 0;

    @Override
    protected Node initNode(T data) {
        return new Node(data);
    }

    @Override
    protected void afterAdd(Node node) {
        reBuild(node);
    }

    private void reBuild(Node node) {
        Node sgNode = findBuild(node);
        if (sgNode == null) {
            return;
        }
        List<T> elements = new ArrayList<>(sgNode.size);
        inOrderTraversal(sgNode, elements);
        Node newNode = doReBuild(elements, 0, elements.size() - 1);
        Node parent = sgNode.parent;

        if (parent == null) {
            root = newNode;
        } else if (sgNode.data.compareTo(parent.data) < 0) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }

    }

    private Node doReBuild(List<T> elements, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node node = new Node(elements.get(mid));
        node.size = end - start + 1;
        node.left = doReBuild(elements, start, mid - 1);
        node.right = doReBuild(elements, mid + 1, end);
        updateNodeNum(node);
        return node;
    }

    private Node findBuild(Node node) {
        Node current = root;
        while (current != null && current != node) {
            if (!isBalance(current)) {
                break;
            }
            if (current.data.compareTo(node.data) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    }

    /**
     * 中序遍历
     */
    private void inOrderTraversal(Node node, List<T> elements) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, elements);
        elements.add(node.data);
        inOrderTraversal(node.right, elements);
    }


    private boolean isBalance(Node node) {
        int left = node.left == null ? 0 : node.left.size;
        int right = node.right == null ? 0 : node.right.size;
        return left <= THRESHOLD * node.size && right <= THRESHOLD * node.size;
    }
}
