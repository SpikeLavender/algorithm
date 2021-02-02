package com.natsumes.tree;

/**
 * 不同场景使用不同的方法
 *     - 数据离散 -> 使用计数排序
 *     - 数据集中在某个小区间内，使用平衡树  O(log n)
 *
 * 由于AVL树种类较少所以比红黑树实际上更容易实现.而且ALV树在旋转插入所需要的复杂度为0(1),而红
 * 黑树则需要的复杂度为0(lgn).
 *
 * 实际上插入AVL树和红黑树的速度取决于你所插入的数据.如果你的数据分布较好,则比较宜于采用AVL树(例如随机产生系列数),
 * 但是如果你想处理比较杂乱的情况,则红黑树是比较快的,因为红黑树对已经处理好的数据重新平衡减少了不心要的操作.
 *
 * 另外一方面,如果是一种非寻常的插入系列比较常见(比如,插入密钥系列),则AVL树比较快,因为它的严格的平衡规则将会减少树的高度.
 * Splay树可能比红黑树和AVL树还要快这也取决于你所访问的数据分布,如果你用哈希表来代替一棵树,则将所以的树还要快.
 *
 * @author hetengjiao
 */
public abstract class AbstractTree<T extends Comparable<T>> implements Tree<T> {

    protected Node root;

    @Override
    public void add(T data) {
        if (root == null) {
            root = initNode(data);
            return;
        }
        Node node = initNode(data);
        if (doAdd(data, node) != null) {
            afterAdd(node);
        }
    }

    /**
     * add之前构造新节点
     * @param data 插入数据
     * @return 新节点
     */
    protected abstract Node initNode(T data);

    /**
     * 执行插入
     * @param data 插入的数据
     * @param node 需要插入的节点
     * @return 返回需要调整的节点
     */
    protected Node doAdd(T data, Node node) {
        Node temp = root;
        Node parent = temp;

        int res = 0;
        while (temp != null) {
            parent = temp;
            parent.nodeNum++;
            parent.size++;
            res = data.compareTo(temp.data);
            if (res > 0) {
                temp = temp.right;
            } else if (res < 0) {
                temp = temp.left;
            } else {
                temp.num++;
                return null;
            }
        }
        if (res > 0) {
            parent.right = node;
        } else {
            parent.left = node;
        }
        node.parent = parent;
        return node;
    }

    /**
     * 插入之后进行平衡操作
     * @param node 需要处理的节点
     */
    protected abstract void afterAdd(Node node);

    /**
     * LL型调整函数
     * 右旋
     * @param node 离操作结点最近的失衡的结点
     * @return 新父节点
     */
    protected Node llRotate(Node node) {
        // 获取失衡结点的父节点
        Node parent = node.parent;

        //获取失衡结点的左孩子
        Node son = node.left;

        //设置son结点右孩子的父指针
        if (son.right != null) {
            son.right.parent = node;
        }

        //失衡结点的左孩子变更为son的右孩子
        node.left = son.right;

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
        updateFields(node, son);
        return son;
    }

    /**
     * RR型调整函数
     * @param node 离操作结点最近的失衡的结点
     * @return 新父节点
     */
    protected Node rrRotate(Node node) {
        // 获取失衡结点的父节点
        Node parent = node.parent;

        //获取失衡结点的右孩子
        Node son = node.right;

        // 设置son节点的左孩子的父指针
        if (son.left != null) {
            son.left.parent = node;
        }
        // son的左孩子成为失衡节点的右孩子
        node.right = son.left;

        // 失衡节点成为son的左孩子
        son.left = node;

        son.parent = parent;

        if (parent != null && parent.left == node) {
            parent.left = son;
        } else if (parent != null) {
            parent.right = son;
        }
        //设置失衡结点的父亲
        node.parent = son;
        updateFields(node, son);
        return son;
    }

    private void updateFields(Node node, Node son) {
        //更新失衡结点的高度信息
        updateDepth(node);
        //更新son结点的高度信息
        updateDepth(son);
        updateNodeNum(node);
        updateNodeNum(son);
        updateSize(node);
        updateSize(son);
    }

    /**
     * LR型
     * 先左旋再右旋
     * @param node 旧节点
     * @return 新的父节点
     */
    protected Node lrRotate(Node node) {
        node.left = rrRotate(node.left);
        return llRotate(node);
    }

    /**
     * RL型
     * 先右旋再左旋
     * @param node 旧节点
     * @return 新的父节点
     */
    protected Node rlRotate(Node node) {
        node.right = llRotate(node.right);
        return rrRotate(node);
    }

    @Override
    public boolean remove(T data) {
        return false;
    }

    protected void updateDepth(Node node) {

    }

    protected void updateNodeNum(Node node) {
        if (node == null) {
            return;
        }
        int leftSize = node.left == null ? 0 : node.left.nodeNum;
        int rightSize = node.right == null ? 0 : node.right.nodeNum;
        node.nodeNum = leftSize + rightSize + node.num;
    }

    protected void updateSize(Node node) {
    }

    public T getMinData() {
        Node node = root;
        Node minNode = node;
        while (node != null) {
            minNode = node;
            node = node.left;
        }
        if (minNode != null) {
            return minNode.data;
        }
        return null;
    }

    public T getMaxData() {
        Node node = root;
        Node maxNode = node;
        while (node != null) {
            maxNode = node;
            node = node.right;
        }
        if (maxNode != null) {
            return maxNode.data;
        }
        return null;
    }

    public T getTopN(long n) {
        if (root == null || n > root.nodeNum || n < 0) {
            return null;
        }
        Node node = root;
        while (node != null) {
            int left = node.left == null ? 0 : node.left.nodeNum;
            if (n <= left) {
                node = node.left;
            } else if (n > left + node.num){
                n = n - left - node.num;
                node = node.right;
            } else {
                return node.data;
            }
        }
        return null;
    }

    public int getTotalSize() {
        if (root == null) {
            return 0;
        }
        return root.nodeNum;
    }

    class Node {
        T data;

        /**
         * used by Red-Black
         */
        transient boolean isBlack;

        /**
         * used by Treap
         */
        transient int priority;

        /**
         * 深度，这里计算每个节点的深度，通过深度的比较可得出是否平衡
         * used by AVL tree
         */
        int depth = 1;

        int num = 1;

        /**
         * 节点的个数，用来实现top值的查找
         */
        int nodeNum;

        /**
         * 子节点的个数，用来实现SBT的平衡
         */
        int size = 1;

        Node left;

        Node right;

        transient Node parent;

        Node() {
        }

        Node(T data) {
            this.data = data;
            this.nodeNum = 1;
            this.isBlack = false;
        }

        Node(T data, int priority) {
            this.data = data;
            this.nodeNum = 1;
            this.priority = priority;
        }

        Node(T data, boolean isBlack) {
            this.data = data;
            this.isBlack = isBlack;
            this.nodeNum = 1;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "data=" + data + ", nodeNum = " + nodeNum
                    + ", depth = " + depth
                    + ", priority = " + priority
                    + ", color=" + (isBlack ? "BLACK" : "RED")
                    + '}';
        }

    }
}
