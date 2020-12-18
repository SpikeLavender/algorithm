package com.natsumes.work;


import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hetengjiao
 */
public class IntRedBlackTree {

    private IntRedBlackNode root;

    private AtomicLong totalSize;

    private volatile int[] topNumArr;

    public IntRedBlackTree() {
        totalSize = new AtomicLong(0);
        topNumArr = new int[] {-1, -1, -1};
    }

    public void insert(int value) {
        totalSize.addAndGet(1);
        IntRedBlackNode node = new IntRedBlackNode(value);
        // 如果根节点为空，直接设为为根节点，并设置为黑色
        if (root == null) {
            node.isBlack = true;
            root = node;
            return;
        }

        // 如果根节点不为空，查找插入的位置
        IntRedBlackNode parent = root;
        IntRedBlackNode son;
        if (value < parent.value) {
            son = parent.left;
        } else if (value == parent.value) {
            parent.num++;
            return;
        } else {
            son = parent.right;
        }

        // 递归查找插入的位置
        while (son != null) {
            parent = son;
            if (value < parent.value) {
                son = parent.left;
            }else if (value == parent.value) {
                parent.num++;
                return;
            } else {
                son = parent.right;
            }
        }

        if (value <= parent.value) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        node.parent = parent;
        balanceInsert(node);
    }

    /**
     * 自平衡
     */
    private void balanceInsert(IntRedBlackNode node) {
        IntRedBlackNode father, grandFather;
        // 如果是根节点 setBlack
        // 如果不是根节点，父节点为黑，则不需要平衡
        // 如果不是根节点，而且父节点为红，进入平衡过程
        while ((father = node.parent) != null && !father.isBlack) {
            grandFather = father.parent;
            // 如果父节点为祖父节点的左节点
            if (grandFather.left == father) {
                // 如果叔叔节点存在且为红
                IntRedBlackNode uncle = grandFather.right;
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
                    IntRedBlackNode tmp = node;
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
                IntRedBlackNode uncle = grandFather.left;
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
                    IntRedBlackNode tmp = node;
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
    private void leftRotate(IntRedBlackNode node) {
        IntRedBlackNode parent = node.parent;
        IntRedBlackNode right = node.right;

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
    private void rightRotate(IntRedBlackNode node) {
        IntRedBlackNode parent = node.parent;
        IntRedBlackNode left = node.left;
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

    private void handleRotate(IntRedBlackNode oldParent, IntRedBlackNode newParent, IntRedBlackNode node) {
        // 如果为根节点，直接交换位置
        if (oldParent == null) {
            root = newParent;
            newParent.parent = null;
            return;
        }
        // 进入旋转
        if (oldParent.left != null && oldParent.left == node){
            oldParent.left = newParent;
        } else {
            oldParent.right = newParent;
        }
        newParent.parent = oldParent;

    }

    private void setBlack(IntRedBlackNode node) {
        node.isBlack = true;
    }

    private void setRed(IntRedBlackNode node) {
        node.isBlack = false;
    }

    public void list() {
        System.out.print("[");
        list(root);
        System.out.println("]");
    }

    public void list(IntRedBlackNode node) {
        if (node == null) {
            return;
        }

        list(node.left);
        System.out.print(node.value + " : " + node.num + ", ");
        list(node.right);
    }

    /**
     *  todo: 改造为线程安全的
     */
    void updateNstValue() {
        int size = totalSize.intValue();
        int top50Index = (int)(size * 0.5 + 0.5);
        int top90Index = (int)(size * 0.1 + 0.5);
        int top99Index = (int)(size * 0.01 + 0.5);
        int[] nums = new int[] {top50Index, top90Index, top99Index};
        for (int i = 0; i < topNumArr.length; i++) {
            topNumArr[i] = -1;
        }
        doUpdateNstValue(root, nums);
    }

    private void doUpdateNstValue(IntRedBlackNode node, int[] nums) {
        if (node == null) {
            return;
        }
        if (topNumArr[0] != -1 && topNumArr[1] != -1 && topNumArr[2] != -1) {
            return;
        }
        doUpdateNstValue(node.right, nums);

        // 单例
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - node.num;
        }
        if (nums[2] <= 0 && topNumArr[2] == -1) {
            topNumArr[2] = node.value;
        }
        if (nums[1] <= 0 && topNumArr[1] == -1) {
            topNumArr[1] = node.value;
        }
        if (nums[0] <= 0 && topNumArr[0] == -1) {
            topNumArr[0] = node.value;
            return;
        }
        doUpdateNstValue(node.left, nums);
    }

    int[] getTopNumArr() {
        return topNumArr;
    }
}
