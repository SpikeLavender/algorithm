package com.natsumes.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉搜索树专题
 * @author hetengjiao
 */
public class BinarySearchTreeTopic {

    /**
     * LC 验证二叉搜索树 || 98. 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 示例 1:
     *
     * 输入:
     *     2
     *    / \
     *   1   3
     * 输出: true
     * 示例 2:
     *
     * 输入:
     *     5
     *    / \
     *   1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 方法一：递归
     */
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val>= upper) {
            return false;
        }
        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    /**
     * 方法二：中序遍历
     */
    public boolean isValidBST2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    /**
     * LC 二叉搜索树迭代器 || 173. 二叉搜索树迭代器
     * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
     *
     * 调用 next() 将返回二叉搜索树中的下一个最小的数。
     *
     * 示例：
     *
     *
     * BSTIterator iterator = new BSTIterator(root);
     * iterator.next();    // 返回 3
     * iterator.next();    // 返回 7
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 9
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 15
     * iterator.hasNext(); // 返回 true
     * iterator.next();    // 返回 20
     * iterator.hasNext(); // 返回 false
     *  
     *
     * 提示：
     *
     * next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
     * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/introduction-to-data-structure-binary-search-tree/xpg4qe/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class BSTIterator {

        private TreeNode root;

        public BSTIterator(TreeNode root) {
            this.root = root;
        }

        public int next() {
            return -1;
        }

        public boolean hasNext() {
            return true;
        }
    }

    /**
     * 99. 恢复二叉搜索树
     * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
     *
     * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,3,null,null,2]
     * 输出：[3,1,null,null,2]
     * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
     * 示例 2：
     *
     *
     * 输入：root = [3,1,4,null,null,2]
     * 输出：[2,1,4,null,null,3]
     * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
     *  
     *
     * 提示：
     *
     * 树上节点的数目在范围 [2, 1000] 内
     * -231 <= Node.val <= 231 - 1
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void recoverTree(TreeNode root) {

    }
}
