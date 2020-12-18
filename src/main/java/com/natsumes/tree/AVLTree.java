package com.natsumes.tree;

import java.util.Comparator;

/**
 * AVL树
 *
 * 平衡二叉树（Balanced BinaryTree）又被称为AVL树。它具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树。
 *
 *
 * 平衡二叉树一般是一个有序树，它具有二叉树的所有性质，其遍历操作和二叉树的遍历操作相同。
 * 但是由于其对二叉树施加了额外限制，因而其添加、删除操作都必须保证平衡二叉树的因子被保持。
 *
 * 平衡二叉树中引入了一个概念：平衡二叉树节点的平衡因子，它指的是该节点的两个子树，
 * 即左子树和右子树的高度差，即用左子树的高度减去右子树的高度，如果该节点的某个子树不存在，则该子树的高度为0,
 * 如果高度差的绝对值超过1就要根据情况进行调整。
 *
 * @author hetengjiao
 */
public class AVLTree<V> implements Tree<V> {

    private Node<V> root;

    private final Comparator<? super V> comparator;

    public AVLTree(Comparator<? super V> comparator) {
        this.comparator = comparator;
    }

    @Override
    public void insert(V value) {
        insert(root, value);
    }

    @Override
    public boolean remove(V value) {
        return delete(value);
    }

    /**
     * LR型
     * 先左旋再右旋
     * @param node 旧节点
     * @return 新的父节点
     */
    private Node<V> lrRotate(Node<V> node) {
        rrRotate(node.left);
        return llRotate(node);
    }

    /**
     * LL型调整函数
     * 右旋
     * @param node 离操作结点最近的失衡的结点
     * @return 新父节点
     */
    private Node<V> llRotate(Node<V> node) {
        // 获取失衡结点的父节点
        Node<V> parent = node.parent;

        //获取失衡结点的左孩子
        Node<V> son = node.left;

        //设置son结点右孩子的父指针
        if (son.right != null) {
            son.right.parent = node;
        }

        //失衡结点的左孩子变更为son的右孩子
        node.left = son.right;

        //更新失衡结点的高度信息
        updateDepth(node);

        //失衡结点变成son的右孩子
        son.right = node;
        //设置son的父结点为原失衡结点的父结点
        son.parent = parent;
        //如果失衡结点不是根结点，则开始更新父节点
        if (parent != null) {
            //如果父节点的左孩子是失衡结点，指向现在更新后的新孩子son
            if (parent.left == node) {
                parent.left = son;
            } else {
                //父节点的右孩子是失衡结点
                parent.right = son;
            }
        }
        //设置失衡结点的父亲
        node.parent = son;
        //更新son结点的高度信息
        updateDepth(son);
        return son;
    }

    private void updateDepth(Node<V> node) {
        if (node == null) {
            return;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        node.depth = Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * RR型调整函数
     * @param node 离操作结点最近的失衡的结点
     * @return 新父节点
     */
    private Node<V> rrRotate(Node<V> node) {
        // 获取失衡结点的父节点
        Node<V> parent = node.parent;

        //获取失衡结点的右孩子
        Node<V> son = node.right;

        // 设置son节点的左孩子的父指针
        if (son.left != null) {
            son.left.parent = node;
        }
        // son的左孩子成为失衡节点的右孩子
        node.right = son.left;
        updateDepth(node);

        // 失衡节点成为son的左孩子
        son.left = node;

        son.parent = parent;

        if (parent != null && parent.left == node) {
            parent.left = son;
        } else if (parent != null) {
            parent.right = son;
        }
        node.parent = son;
        updateDepth(son);
        return son;
    }

    /**
     * LR型
     * 先右旋再左旋
     * @param node 旧节点
     * @return 新的父节点
     */
    private Node<V> rlRotate(Node<V> node) {
        llRotate(node.left);
        return rrRotate(node);
    }

    /**
     * 插入节点
     *
     * @param root 根节点
     * @param value 值
     * @return 插入后的根节点
     */
    public Node<V> insert(Node<V> root, V value) {
        Node<V> temp;
        Node<V> node = new Node<>(value);
        temp = insertValue(root, node, null);
        if (temp != null) {
            updateDepth(temp);
            root = balanceInsert(root, temp);
        }
        return root;
    }

    /**
     * 插入节点
     */
    private Node<V> insertValue(Node<V> root, Node<V> node, Node<V> parent) {
        if (root == null) {
            root = node;
            node.parent = parent;
            return root;
        }
        if (comparator.compare(node.value, root.value) < 0) {
            return insertValue(root.left, node, root);
        }
        if (comparator.compare(node.value, root.value) > 0) {
            return insertValue(root.right, node, root);
        }
        root.num++;
        return root;
    }

    /**
     * 获取节点深度
     * @param node 节点
     * @return 当前节点深度
     */
    private int getDepth(Node<V> node) {
        if (node == null) {
            return 0;
        }
        return node.depth;
    }

    /**
     * 返回当前平衡因子
     * @param node 节点
     * @return 当前平衡因子
     */
    private int getBalance(Node<V> node) {
        if (node == null) {
            return 0;
        }
        return getDepth(node.left) - getDepth(node.right);
    }

    /**
     * 自平衡
     * @param root 根节点
     * @param node 插入节点
     * @return 调整后的根节点
     */
    private Node<V> balanceInsert(Node<V> root, Node<V> node) {
        int balance;
        while (node != null) {
            updateDepth(node);
            balance = getBalance(node);
            if (balance >= -1 && balance <= 1) {
                node = node.parent;
                continue;
            }

            if (balance > 1) {
                // 左子树高
                if (getBalance(node.left) > 0) {
                    // LL
                   node = llRotate(node);
                } else {
                    // LR
                    node = lrRotate(node);
                }
            } else {
                // 右子树高
                if (getBalance(node.right) < 0) {
                    // RR
                    node = rrRotate(node);
                } else {
                    // RL
                    node = rlRotate(node);
                }
            }

            if (node.parent == null) {
                root = node;
                break;
            }

            node = node.parent;
        }
        return root;
    }

    /**
     * 找到删除的结点，执行删除操作，并根据情况调整AVL树
     * @param root 根
     * @param value 需要删除的val
     * @return 找到删除结点的情况则返回新根，否则返回NULL
     */
    private Node<V> remove(Node<V> root, V value) {
        if (root == null) {
            return null;
        }
        Node<V> temp = null;
        if (comparator.compare(root.value, value) < 0) {
            remove(root.right, value);
        } else if (comparator.compare(root.value, value) > 0) {
            remove(root.left, value);
        } else {
            temp = root;
        }
        if (temp != null) {
            //如果已经返回到最后一次（也就是root是真正的树根）
            if (root.parent != null) {
                Node<V> tmp = removeValue(temp);
                return balanceInsert(root, tmp);
            }
            return temp;
        }
        return null;
    }

    /**
     * 删除操作
     *
     * @param node 需要删除的节点
     * @return 删除节点的父节点
     */
    private Node<V> removeValue(Node<V> node) {
        Node<V> parent = node.parent;
        if (parent == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            updateDepth(parent);
            node.parent = null;
            return parent;
        }

        Node<V> temp;
        if (node.right == null) {
            // 只有左孩子
            temp = node;
            node = node.left;
            node.parent = temp.parent;
            updateDepth(node);
        } else if (node.left == null) {
            temp = node;
            node = node.right;
            node.parent = temp.parent;
            updateDepth(node);
        } else {
            //既有左孩子也有右孩子，化繁为简
            Node<V> tmp = getMin(node.right);
            node.value = tmp.value;
            parent = tmp.parent;
            updateDepth(parent);
        }
        return parent;
    }

    public Node<V> getMin(Node<V> node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return getMin(node.left);
        }
        return node;
    }

    private boolean delete(V value) {
        Node<V> node = getNode(value);
        if (node == null) {
            return false;
        }
        Node<V> parent = node.parent;
        Node<V> left = node.left;
        Node<V> right = node.right;

        if (left == null && right == null) {
            if (parent != null) {
                if (parent.left == node) {
                    parent.left = null;
                } else if (parent.right == node) {
                    parent.right = null;
                }
            } else {
                root = null;
            }
            node = null;
            return true;
        } else if (left == null) {
            setParent(parent, right, value);
            node = null;
            return true;
        } else if (right == null) {
            setParent(parent, left, value);
            node = null;
            return true;
        } else {
            Node<V> successor = getSuccessor(node);
            V temp = successor.value;
            boolean delete = delete(temp);
            if (delete) {
                node.value = temp;
            }
            successor = null;
            return true;
        }
    }

    /**
     * 一个节点在整棵树中的后继节点必满足，大于该节点值得所有节点集合中值最小的那个节点，即为后继节点，
     * 当然，也有可能不存在后继节点。
     * 一个节点在整棵树中的先驱节点必满足，小于该节点值得所有节点集合中值最大的那个节点，即为先驱节点
     */
    private Node<V> getSuccessor(Node<V> node) {
        if (node.right != null) {
            //存在右子树，右子树的左节点为后继节点
            Node<V> right = node.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        // 如果没有右子树，则去父节点找
        Node<V> parent = node.parent;
        while (parent != null && (node == parent.right)) {
            // 如果该节点是父节点的右节点，继续，直到找到第一个子节点为父节点的左节点
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private void setParent(Node<V> parent, Node<V> node, V value) {
        if (parent != null && comparator.compare(parent.value, value) > 0) {
            parent.left = node;
        } else if (parent != null && comparator.compare(parent.value, value) < 0) {
            parent.right = node;
        } else {
            root = node;
        }
    }

    /**
     *                  15
     *                /    \
     *              (5)     16
     *            /   \      \
     *           3    12     20
     *               /  \   /  \
     *             10   13 18   23
     *            /
     *           6 - successor
     *            \
     *             7
     *
     * 算法导论中实现
     */
    public boolean remove02(V value) {
        Node<V> node = getNode(value);
        if (node == null) {
            return false;
        }
        // 左节点为空，则可能两个节点都不存在或者只存在右节点
        if (node.left == null) {
            transplant(node, node.right);
        } else if (node.right == null) {
            transplant(node, node.left);
        } else {
            Node<V> successor = getSuccessor(node);
            if (successor.parent != node) {
                // 如果在右子树中
                transplant(successor, successor.right);
                successor.right = node.right;
                successor.right.parent = successor;
            }
            transplant(node, successor);
            successor.left = node.left;
            successor.left.parent = successor;
        }
        // 最后将node设置为null，交给垃圾回收器处理
        node = null;
        return true;
    }

    /**
     * 将child节点替换node节点
     *
     *  1、先判断 node是否存在父节点
     *     1、不存在，则child替换为根节点
     *     2、存在，则继续下一步
     *  2、判断node节点是父节点的那个孩子(即判断出 node是右节点还是左节点)，
     *     得出结果后，将child节点替换node节点 ，即若node节点是左节点 则child替换后 也为左节点，否则为右节点
     *  3、将node节点的父节点置为child节点的父节点
     *
     * @param node    要删除的节点
     * @param child   node节点的子节点
     */
    private void transplant(Node<V> node, Node<V> child){
        if (node.parent == null) {
            this.root = child;
        } else if (node.parent.left == node) {
            node.parent.left = child;
        } else if (node.parent.right == node) {
            node.parent.right = child;
        }

        if (child != null) {
            child.parent = node.parent;
        }
    }

    public Node<V> getNode(V value) {
        if (root == null) {
            return null;
        }
        return getNode(root, value);
    }

    private Node<V> getNode(Node<V> node, V value) {
        if (node == null) {
            return null;
        }

        if (comparator.compare(value, node.value) == 0){
            return node;
        } else if (comparator.compare(value, node.value) < 0) {
            return getNode(node.left, value);
        } else {
            return getNode(node.right, value);
        }
    }

    static class Node<V> {

        /**
         * 深度，这里计算每个节点的深度，通过深度的比较可得出是否平衡
         */
        int depth = 0;

        Node<V> parent;

        Node<V> left;

        Node<V> right;

        V value;

        int num;

        Node(V value) {
            this.value = value;
            this.num = 1;
        }
    }
}
