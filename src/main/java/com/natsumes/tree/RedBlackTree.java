package com.natsumes.tree;


/**
 * @author hetengjiao
 */
public class RedBlackTree <T extends Comparable<T>> extends AbstractTree<T> {

    public RedBlackTree() {
        root = null;
    }

    public RedBlackTree(T data) {
        root = new Node(data);
        root.isBlack = true;
    }

    public Node build() {
        return root;
    }

    @Override
    protected Node initNode(T data) {
        if (root == null) {
            return new Node(data, true);
        }
        return new Node(data);
    }

    @Override
    protected void afterAdd(Node node) {
        balanceInsert(node);
    }

    /**
     * 自平衡
     */
    private void balanceInsert(Node node) {
        Node father, grandFather;
        // 如果是根节点 setBlack
        // 如果不是根节点，父节点为黑，则不需要平衡
        // 如果不是根节点，而且父节点为红，进入平衡过程
        while ((father = node.parent) != null && !father.isBlack) {
            grandFather = father.parent;
            // 如果父节点为祖父节点的左节点
            if (grandFather.left == father) {
                // 如果叔叔节点存在且为红
                Node uncle = grandFather.right;
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
                    Node tmp = node;
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
                Node uncle = grandFather.left;
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
                    Node tmp = node;
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
    private void leftRotate(Node node) {
        Node parent = node.parent;
        Node right = node.right;

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
        updateNodeNum(node);
        updateNodeNum(right);
    }

    /**
     * 右旋: 顺时针旋转红黑树的两个结点，使得父结点被自己的左孩子取代，而自己成为自己的右孩子
     */
    private void rightRotate(Node node) {
        Node parent = node.parent;
        Node left = node.left;
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
        updateNodeNum(node);
        updateNodeNum(left);
    }

    private void handleRotate(Node parent, Node newParent, Node node) {
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



    private void setBlack(Node node) {
        node.isBlack = true;
    }

    private void setRed(Node node) {
        node.isBlack = false;
    }

    public void list() {
        System.out.print("[");
        list(root);
        System.out.println("]");
    }

    public void list(Node node) {
        if (node == null) {
            return;
        }

        list(node.left);
        System.out.print(node.data + " : " + node.num + ", ");
        list(node.right);
    }


//    class TreeNode extends AbstractTree.TreeNode {
//
//        transient boolean isBlack;
//
//        TreeNode left;
//
//        TreeNode right;
//
//        transient TreeNode parent;
//
//        TreeNode(T data) {
//            super(data);
//            this.isBlack = false;
//        }
//
//        @Override
//        public String toString() {
//            return "TreeNode{" + "data=" + data + ", nodeNum = " + nodeNum
//                    + ", color=" + (isBlack ? "BLACK" : "RED") + '}';
//        }
//    }
}
