package com.natsumes.leetcode;

import java.util.*;

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
        return helper(node.left, lower, val) && helper(node.right, val, upper);
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
     *
     * 方法1：中序遍历，拍平二叉树, 时间复杂度符合，但是用了O(n)的内存，不符合要求
     */
    static class BSTIterator1 {

        List<Integer> nodeSorted;

        int index;

        public BSTIterator1(TreeNode root) {
            this.nodeSorted = new ArrayList<>();
            this.index = -1;
            this.inorder(root);
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            this.inorder(root.left);
            this.nodeSorted.add(root.val);
            this.inorder(root.right);
        }

        public int next() {

            return this.nodeSorted.get(++this.index);
        }

        public boolean hasNext() {
            return this.index + 1 < this.nodeSorted.size();
        }
    }

    /**
     * 173. 二叉搜索树迭代器
     * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
     *
     * 调用 next() 将返回二叉搜索树中的下一个最小的数。
     *
     * 示例：
     * BSTIterator iterator = new BSTIterator(root);
     *
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
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-search-tree-iterator
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static class BSTIterator {

        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.leftInorder(root);
        }

        /**
         *  For a given node, add all the elements in the leftmost branch of the tree under it to the stack.
         */
        private void leftInorder(TreeNode root) {
            while (root != null) {
                this.stack.push(root);
                root = root.left;
            }
        }

        public int next() {
            TreeNode node = this.stack.pop();
            if (node != null) {
                this.leftInorder(node.right);
            } else {
                throw new IndexOutOfBoundsException("node is null");
            }
            return node.val;
        }

        public boolean hasNext() {
            return this.stack.size() > 0;
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
     *
     * 方法一：显式中序遍历，但是空间为 O(N)
     */
    public void recoverTree(TreeNode root) {
        doRecoverTree(root);
    }

    public void doRecoverTree1(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                } else {
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    /**
     * 隐式中序遍历
     * O(H)
     */
    public void doRecoverTree2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        swap(x, y);
    }

    private void swap(TreeNode x, TreeNode y) {
        if (x == null || y == null) {
            return;
        }
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }

    /**
     * Morris 中序遍历
     *
     * 方法二中我们不再显示的用数组存储中序遍历的值序列，但是我们会发现我们仍需要 O(H)O(H) 的栈空间，无法满足题目的进阶要求，
     * 那么该怎么办呢？这里向大家介绍一种不同于平常递归或迭代的遍历二叉树的方法：Morris 遍历算法，
     * 该算法能将非递归的中序遍历空间复杂度降为 O(1)O(1)。
     *
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 xx）：
     *
     * 如果 xx 无左孩子，则访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
     * 如果 xx 有左孩子，则找到 xx 左子树上最右的节点（即左子树中序遍历的最后一个节点，xx 在中序遍历中的前驱节点），
     * 我们记为 \textit{predecessor}predecessor。根据 \textit{predecessor}predecessor 的右孩子是否为空，进行如下操作。
     * 如果 \textit{predecessor}predecessor 的右孩子为空，则将其右孩子指向 xx，然后访问 xx 的左孩子，
     * 即 x = x.\textit{left}x=x.left。
     * 如果 \textit{predecessor}predecessor 的右孩子不为空，则此时其右孩子指向 xx，说明我们已经遍历完 xx 的左子树，
     * 我们将 \textit{predecessor}predecessor 的右孩子置空，然后访问 xx 的右孩子，即 x = x.\textit{right}x=x.right。
     * 重复上述操作，直至访问完整棵树。
     * 其实整个过程我们就多做一步：将当前节点左子树中最右边的节点指向它，这样在左子树遍历完成后我们通过这个指向走回了 xx，
     * 且能再通过这个知晓我们已经遍历完成了左子树，而不用再通过栈来维护，省去了栈的空间复杂度。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree/solution/huci-fu-er-cha-sou-suo-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void doRecoverTree(TreeNode root) {
        morrisInorder(root);
    }

    private void morrisInorder(TreeNode root) {
        TreeNode x = null, y = null, pred = null, predecessor;

        while (root != null) {
            if (root.left != null) {
                // 找root的前驱
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                    continue;
                }
                if (pred != null && pred.val > root.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                predecessor.right = null;
                root = root.right;

            } else {
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        swap(x, y);
    }

    /**
     * 二叉搜索树中的搜索
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     *
     * 例如，
     *
     * 给定二叉搜索树:
     *
     *         4
     *        / \
     *       2   7
     *      / \
     *     1   3
     *
     * 和值: 2
     * 你应该返回如下子树:
     *
     *       2
     *      / \
     *     1   3
     * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/introduction-to-data-structure-binary-search-tree/xpsqtv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    /**
     * 二叉搜索树中的插入操作
     * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
     * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     *
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [4,2,7,1,3], val = 5
     * 输出：[4,2,7,1,3,5]
     * 解释：另一个满足题目要求可以通过的树是：
     *
     * 示例 2：
     *
     * 输入：root = [40,20,60,10,30,50,70], val = 25
     * 输出：[40,20,60,10,30,50,70,null,null,25]
     * 示例 3：
     *
     * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
     * 输出：[4,2,7,1,3,5]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/introduction-to-data-structure-binary-search-tree/xp1llt/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        if (root == null) {
            root = node;
            return root;
        }
        if (val == root.val) {
            return root;
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
