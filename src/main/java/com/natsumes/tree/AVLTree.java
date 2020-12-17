package com.natsumes.tree;

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
public class AVLTree {

    private AVLNode root;

    /**
     * LR型
     * 先左旋再右旋
     * @param node 旧节点
     * @return 新的父节点
     */
    AVLNode lrRotate(AVLNode node) {
        rrRotate(node.left);
        return llRotate(node);
    }

    /**
     * LL型调整函数
     * 右旋
     * @param node 离操作结点最近的失衡的结点
     * @return 新父节点
     */
    AVLNode llRotate(AVLNode node) {
        // 获取失衡结点的父节点
        AVLNode parent = node.parent;

        //获取失衡结点的左孩子
        AVLNode son = node.left;

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

    private void updateDepth(AVLNode node) {
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
    AVLNode rrRotate(AVLNode node) {
        // 获取失衡结点的父节点
        AVLNode parent = node.parent;

        //获取失衡结点的右孩子
        AVLNode son = node.right;

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
    AVLNode rlRotate(AVLNode node) {
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
    public AVLNode insert(AVLNode root, int value) {
        AVLNode temp;
        AVLNode node = new AVLNode(value);
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
    private AVLNode insertValue(AVLNode root, AVLNode node, AVLNode parent) {
        if (root == null) {
            root = node;
            node.parent = parent;
            return root;
        }
        if (node.value < root.value) {
            return insertValue(root.left, node, root);
        }
        if (node.value > root.value) {
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
    private int getDepth(AVLNode node) {
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
    private int getBalance(AVLNode node) {
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
    private AVLNode balanceInsert(AVLNode root, AVLNode node) {
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
    public AVLNode remove(AVLNode root, int value) {
        if (root == null) {
            return null;
        }
        AVLNode temp = null;
        if (root.value < value) {
            remove(root.right, value);
        } else if (root.value > value) {
            remove(root.left, value);
        } else {
            temp = root;
        }
        if (temp != null) {
            //如果已经返回到最后一次（也就是root是真正的树根）
            if (root.parent != null) {
                AVLNode tmp = removeValue(temp);
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
    private AVLNode removeValue(AVLNode node) {
        AVLNode parent = node.parent;
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

        AVLNode temp;
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
            AVLNode tmp = getMin(node.right);
            node.value = tmp.value;
            parent = tmp.parent;
            updateDepth(parent);
        }
        return parent;
    }

    public AVLNode getMin(AVLNode node) {
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return getMin(node.left);
        }
        return node;
    }

}
