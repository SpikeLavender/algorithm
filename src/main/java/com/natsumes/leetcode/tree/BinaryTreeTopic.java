package com.natsumes.leetcode.tree;

import java.util.*;

/**
 * 二叉树专题
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-right-side-view/">199.二叉树的右视图</a>
 * {@link BinaryTreeTopic#rightSideView(com.natsumes.leetcode.tree.TreeNode)
 * {@link BinaryTreeTopic#rightSideView01(com.natsumes.leetcode.tree.TreeNode)
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/">103.二叉树的锯齿形层序遍历</a>
 * {@link BinaryTreeTopic#zigzagLevelOrder(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">257.二叉树的所有路径</a>
 * {@link BinaryTreeTopic#binaryTreePaths(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/path-sum/">112.路径总和</a>
 * {@link BinaryTreeTopic#hasPathSum(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/path-sum-ii/">113.路径总和 II</a>
 * {@link BinaryTreeTopic#pathSum(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * <a href="https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/">124.二叉树中的最大路径和</a>
 * {@link BinaryTreeTopic#maxPathSum(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/">129.求根到叶子节点数字之和</a>
 * {@link BinaryTreeTopic#sumNumbers(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/path-sum-iii/">437.路径总和 III</a>
 * {@link BinaryTreeTopic#pathSumIII(com.natsumes.leetcode.tree.TreeNode, int)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/path-sum-iv/">666.路径总和 IV</a>
 * {@link BinaryTreeTopic#pathSum(int[])}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/count-univalue-subtrees/">250.统计同值子树</a>
 * {@link BinaryTreeTopic#countUnivalSubtrees(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/longest-univalue-path/">687.最长同值路径</a>
 * {@link BinaryTreeTopic#longestUnivaluePath(com.natsumes.leetcode.tree.TreeNode)}
 *
 * TODO: <a href="https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/">988.从叶结点开始的最小字符串</a>
 * {@link BinaryTreeTopic#smallestFromLeaf(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a>查找完全二叉树的最后一层最右边的节点</a>
 * {@link BinaryTreeTopic#findLastRightNode(com.natsumes.leetcode.tree.TreeNode)}
 *
 * <a href="https://leetcode-cn.com/problems/trim-a-binary-search-tree/submissions/">669.修剪二叉搜索树</a>
 * {@link BinaryTreeTopic#trimBST(com.natsumes.leetcode.tree.TreeNode, int, int)}
 *
 * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">236.二叉树的最近公共祖先</a>
 * {@link BinaryTreeTopic#lowestCommonAncestor(TreeNode, TreeNode, TreeNode)}
 * {@link BinaryTreeTopic#lowestCommonAncestorA(TreeNode, TreeNode, TreeNode)}
 *
 * @author hetengjiao
 */
public class BinaryTreeTopic {

    /**
     * 199. 二叉树的右视图
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * 示例:
     *
     * 输入: [1,2,3,null,5,null,4]
     * 输出: [1, 3, 4]
     * 解释:
     *
     *    1            {@literal <---}
     *  /   \
     * 2     3         {@literal <---}
     *  \     \
     *   5     4       {@literal <---}
     *
     * @param root root  @Nullable
     * @return List
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doRightSideView(root, res, 1);
        return res;
    }

    private void doRightSideView(TreeNode node, List<Integer> res, int num) {
        if (node == null) {
            return;
        }
        if (num > res.size()) {
            res.add(node.val);
        }
        res.set(num - 1, node.val);
        doRightSideView(node.left, res, num + 1);
        doRightSideView(node.right, res, num + 1);
    }

    /**
     * 199. 二叉树的右视图
     * 迭代法
     *
     * @param root root
     * @return list
     */
    public List<Integer> rightSideView01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int levelValue = root.val;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValue = Objects.requireNonNull(node).val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(levelValue);
        }
        return res;
    }

    /**
     * 103. 二叉树的锯齿形层序遍历
     * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回锯齿形层序遍历如下：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @param root root
     * @return list
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<LinkedList<Integer>> ans = new ArrayList<>();
        doZigzagLevelOrder(root, ans, 1);
        return new ArrayList<>(ans);
    }

    private void doZigzagLevelOrder(TreeNode node, List<LinkedList<Integer>> ans, int num) {
        if (node == null) {
            return;
        }
        if (num > ans.size()) {
            ans.add(new LinkedList<>());
        }
        if (num % 2 == 1) {
            ans.get(num - 1).add(node.val);
        } else {
            ans.get(num - 1).addFirst(node.val);
        }
        doZigzagLevelOrder(node.left, ans, num + 1);
        doZigzagLevelOrder(node.right, ans, num + 1);
    }

    /**
     * LC 二叉树的前序遍历 || 144. 二叉树的前序遍历
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,2,3]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     *
     * 输入：root = [1,2]
     * 输出：[1,2]
     * 示例 5：
     *
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= TreeNode.val <= 100
     *  
     *
     * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
     * <p>
     * 作者：力扣 (LeetCode) 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xeywh5/ 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        //return doPreorderTraversal(root);
        return doPreorderTraversal02(root);
    }

    /**
     * 递归
     */
    private List<Integer> doPreorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doPreorderTraversal(root, res);
        return res;
    }

    private void doPreorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        doPreorderTraversal(root.left, res);
        doPreorderTraversal(root.right, res);
    }

    /**
     * 非递归 -- 迭代
     */
    private List<Integer> doPreorderTraversal02(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            res.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return res;
    }

    /**
     * LC 二叉树的中序遍历 || 94. 二叉树的中序遍历
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     *
     *  
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,null,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     *
     * 输入：root = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：root = [1]
     * 输出：[1]
     * 示例 4：
     *
     *
     * 输入：root = [1,2]
     * 输出：[2,1]
     * 示例 5：
     *
     *
     * 输入：root = [1,null,2]
     * 输出：[1,2]
     *  
     *
     * 提示：
     *
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= TreeNode.val <= 100
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xecaj6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        //return doInorderTraversal(root);
        return doInorderTraversal02(root);
    }

    /**
     * 递归
     */
    private List<Integer> doInorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doInorderTraversal(root, res);
        return res;
    }

    private void doInorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        doInorderTraversal(root.left, res);
        res.add(root.val);
        doInorderTraversal(root.right, res);
    }

    /**
     * 非递归 -- 迭代
     */
    private List<Integer> doInorderTraversal02(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        TreeNode tmp;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            tmp = stack.pop();
            res.add(tmp.val);
            node = tmp.right;
        }
        return res;
    }

    /**
     * LC 二叉树的后序遍历  || 145 二叉树的后序遍历
     *
     * 给定一个二叉树，返回它的 后序 遍历。
     * <p>
     * 示例:
     *
     * 输入: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * 输出: [3,2,1]
     * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xebrb2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        //return doPostorderTraversal(root);
        //return doPostorderTraversal02(root);
        return doPostorderTraversal03(root);
    }

    /**
     * 递归写法
     */
    private List<Integer> doPostorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        doPostorderTraversal(root, res);
        return res;
    }

    private void doPostorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        doPostorderTraversal(root.left, res);
        doPostorderTraversal(root.right, res);
        res.add(root.val);
    }

    /**
     * 非递归写法 -- 技巧1：逆序输出
     */
    private List<Integer> doPostorderTraversal02(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmp;
        while (!stack.isEmpty()) {
            tmp = stack.pop();
            // 逆序输出
            res.addFirst(tmp.val);
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
        }
        return res;
    }

    /**
     * 非递归写法 -- 正常写法
     */
    private List<Integer> doPostorderTraversal03(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode node = root;
        TreeNode tmp, last = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            tmp = stack.peek();
            if (tmp.right == null || tmp.right == last) {
                stack.pop();
                res.add(tmp.val);
                last = tmp;
            } else {
                node = tmp.right;
            }
        }
        return res;
    }

    /**
     * LC 二叉树的层序遍历 || 102 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     *
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xefh1i/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //return doLevelOrder(root);
        return doLevelOrder02(root);
    }

    /**
     * 非递归实现
     */
    private List<List<Integer>> doLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currSize = q.size();
            for (int i = 0; i < currSize; i++) {
                TreeNode node = q.poll();
                level.add(Objects.requireNonNull(node).val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }

    /**
     * 递归实现
     */
    private List<List<Integer>> doLevelOrder02(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        doLevelOrder02(root, res, 1);
        return res;
    }

    private void doLevelOrder02(TreeNode root, List<List<Integer>> res, int num) {
        if (root == null) {
            return;
        }
        if (num > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(num - 1).add(root.val);
        doLevelOrder02(root.left, res, num + 1);
        doLevelOrder02(root.right, res, num + 1);
    }


    private int answer = 0;

    /**
     * LC 二叉树的最大深度 || 104. 二叉树的最大深度 || 剑指 Offer 55 - I. 二叉树的深度
     * <p>
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoh1zg/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int maxDepth(TreeNode root) {
        //maxDepthTop(root, 1);
        //return answer;
        answer = 0;
        return maxDepthBottom(root);
    }

    private void maxDepthTop(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maxDepthTop(root.left, depth + 1);
        maxDepthTop(root.right, depth + 1);
    }

    private int maxDepthBottom(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepthBottom(root.left);
        int right = maxDepthBottom(root.right);
        return Math.max(left, right) + 1;
    }

    /**
     * LC 对称二叉树 || 剑指 Offer 28. 对称的二叉树
     * <p>
     * 给定一个二叉树，检查它是否是镜像对称的。
     * <p>
     * <p>
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *  
     *
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *  
     *
     * 进阶：
     * <p>
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xoxzgv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean isSymmetric(TreeNode root) {
        //return isSymmetric4Recursion(root);
        return isSymmetric4Iteration(root);
    }

    /**
     * 递归
     */
    private boolean isSymmetric4Recursion(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recursion(root.left, root.right);
    }

    private boolean recursion(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }

    /**
     * 迭代
     */
    private boolean isSymmetric4Iteration(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }

        return true;
    }

    /**
     * 257. 二叉树的所有路径
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     *
     * 输入:
     *
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * 输出: ["1->2->5", "1->3"]
     *
     * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
     *
     * @param root root
     * @return paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        doBinaryTreePaths(root, res, new ArrayList<>());
        return res;
    }

    private void doBinaryTreePaths(TreeNode node, List<String> res, List<Integer> trace) {
        if (node == null) {
            return;
        }
        trace.add(node.val);
        if (node.left == null && node.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < trace.size(); i++) {
                sb.append(trace.get(i));
                if (i < trace.size() - 1) {
                    sb.append("->");
                }
            }
            res.add(sb.toString());
        }
        doBinaryTreePaths(node.left, res, trace);
        doBinaryTreePaths(node.right, res, trace);
        trace.remove(trace.size() - 1);
    }

    /**
     * LC 路径总和  || 112. 路径总和
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xo566j/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // 如果已经有满足条件的，就不需要再遍历了
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null ) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    /**
     * 113. 路径总和 II
     * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例:
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \    / \
     *         7    2  5   1
     * 返回:
     *
     * [
     *    [5,4,11,2],
     *    [5,8,4,5]
     * ]
     *
     * @param root root
     * @param targetSum targetSum
     * @return list
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new LinkedList<>();
        doPathSum(root, res, track, targetSum);
        return res;
    }

    private void doPathSum(TreeNode node, List<List<Integer>> res, List<Integer> track, int sum) {
        if (node == null) {
            return;
        }
        track.add(node.val);
        sum -= node.val;
        if (sum == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(track));
        }
        doPathSum(node.left, res, track, sum);
        doPathSum(node.right, res, track, sum);
        track.remove(track.size() - 1);
    }

    /**
     * 437. 路径总和 III
     * 给定一个二叉树，它的每个结点都存放着一个整数值。
     *
     * 找出路径和等于给定数值的路径总数。
     *
     * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     *
     * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
     *
     * 示例：
     *
     * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
     *
     *       10
     *      /  \
     *     5   -3
     *    / \    \
     *   3   2   11
     *  / \   \
     * 3  -2   1
     *
     * 返回 3。和等于 8 的路径有:
     *
     * 1.  5 -> 3
     * 2.  5 -> 2 -> 1
     * 3.  -3 -> 11
     *
     * @param root root
     * @param sum sum
     * @return ans
     */
    public int pathSumIII(TreeNode root, int sum) {

        return 0;
    }

    /**
     * 666. 路径总和 IV
     * 对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。
     *
     * 对于每个整数：
     *
     * 百位上的数字表示这个节点的深度 D，1 <= D <= 4。
     * 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= P <= 8。位置编号与一棵满二叉树的位置编号相同。
     * 个位上的数字表示这个节点的权值 V，0 <= V <= 9。
     * 给定一个包含三位整数的升序数组，表示一棵深度小于 5 的二叉树，请你返回从根到所有叶子结点的路径之和。
     *
     *
     *
     * 示例 1：
     *
     * 输入: [113, 215, 221]
     * 输出: 12
     * 解释:
     * 这棵树形状如下:
     *     3
     *    / \
     *   5   1
     *
     * 路径和 = (3 + 5) + (3 + 1) = 12.
     * 示例 2：
     *
     * 输入: [113, 221]
     * 输出: 4
     * 解释:
     * 这棵树形状如下:
     *     3
     *      \
     *       1
     *
     * 路径和 = (3 + 1) = 4.
     *
     * @param nums nums
     * @return ans
     */
    public int pathSum(int[] nums) {
        return 0;
    }

    /**
     * 250. 统计同值子树
     * 给定一个二叉树，统计该二叉树数值相同的子树个数。
     *
     * 同值子树是指该子树的所有节点都拥有相同的数值。
     *
     * 示例：
     *
     * 输入: root = [5,1,5,5,5,null,5]
     *
     *               5
     *              / \
     *             1   5
     *            / \   \
     *           5   5   5
     *
     * 输出: 4
     *
     * @param root root
     * @return ans
     */
    public int countUnivalSubtrees(TreeNode root) {
        return 0;
    }

    /**
     * 687. 最长同值路径
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     *
     * 注意：两个节点之间的路径长度由它们之间的边数表示。
     *
     * 示例 1:
     *
     * 输入:
     *
     *               5
     *              / \
     *             4   5
     *            / \   \
     *           1   1   5
     * 输出:
     *
     * 2
     * 示例 2:
     *
     * 输入:
     *
     *               1
     *              / \
     *             4   5
     *            / \   \
     *           4   4   5
     * 输出:
     *
     * 2
     * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
     *
     * @param root root
     * @return ans
     */
    public int longestUnivaluePath(TreeNode root) {
        return 0;
    }

    /**
     * 988. 从叶结点开始的最小字符串
     * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个从 0 到 25 的值，
     * 分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
     *
     * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
     *
     * （小贴士：字符串中任何较短的前缀在字典序上都是较小的：例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。）
     *
     * 示例 1：
     *
     * 输入：[0,1,2,3,4,3,4]
     * 输出："dba"
     *
     * 示例 2：
     *
     * 输入：[25,1,3,1,3,0,2]
     * 输出："adz"
     *
     * 示例 3：
     *
     * 输入：[2,2,1,null,1,0,null,0]
     * 输出："abc"
     *
     *
     * 提示：
     *
     * 给定树的结点数介于 1 和 8500 之间。
     * 树中的每个结点都有一个介于 0 和 25 之间的值。
     *
     * @param root root
     * @return leaf string
     */
    public String smallestFromLeaf(TreeNode root) {
        return "";
    }


    /**
     * LC 填充每个节点的下一个右侧节点指针 || 116. 填充每个节点的下一个右侧节点指针
     * <p>
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct TreeNode {
     *   int val;
     *   TreeNode *left;
     *   TreeNode *right;
     *   TreeNode *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     *
     * 进阶：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *
     * 输入：root = [1,2,3,4,5,6,7]
     * 输出：[1,#,2,3,#,4,5,6,7,#]
     *
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     * 序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
     *  
     *
     * 提示：
     *
     * 树中节点的数量少于 4096
     * -1000 <= node.val <= 1000
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connect(root.left, root.right);
        return root;
    }

    /**
     * 递归
     */
    private void connect(Node left, Node right) {

        if (left == null || right == null) {
            return;
        }
        left.next = right;
        connect(left.left, left.right);
        connect(right.left, right.right);
        connect(left.right, right.left);
    }

    /**
     * LC 填充每个节点的下一个右侧节点指针II || 117. 填充每个节点的下一个右侧节点指针II
     *
     * 给定一个二叉树
     *
     * struct TreeNode {
     *   int val;
     *   TreeNode *left;
     *   TreeNode *right;
     *   TreeNode *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     *
     * 初始状态下，所有 next 指针都被设置为 NULL。
     *
     *  
     *
     * 进阶：
     *
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *  
     *
     * 示例：
     *
     *
     *
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
     *  
     *
     * 提示：
     *
     * 树中的节点数小于 6000
     * -100 <= node.val <= 100
     *  
     *
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/data-structure-binary-tree/xorvud/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public Node connect2(Node root) {
        //return connect4Iteration(root);
        return connect4INext(root);
    }

    /**
     * 方法一：层序遍历，然后将每一层连起来成一个链表
     */
    private Node connect4Iteration(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node last = null;
            for (int i = 0; i < n; i++) {
                Node f = queue.poll();
                if (Objects.requireNonNull(f).left != null) {
                    queue.offer(f.left);
                }
                if (f.right != null) {
                    queue.offer(f.right);
                }
                if (i != 0) {
                    last.next = f;
                }
                last = f;
            }
        }
        return node;
    }

    /**
     * 方法二：使用已建立的  next 指针
     *
     * 因为必须处理树上的所有节点，所以无法降低时间复杂度，但是可以尝试降低空间复杂度。
     *
     * 在方法一中，因为对树的结构一无所知，所以使用队列保证有序访问同一层的所有节点，并建立它们之间的连接。
     * 然而不难发现：一旦在某层的节点之间建立了 next 指针，那这层节点实际上形成了一个链表。
     * 因此，如果先去建立某一层的 next 指针，再去遍历这一层，就无需再使用队列了。
     *
     * 基于该想法，提出降低空间复杂度的思路：如果第 i 层节点之间已经建立 next 指针，就可以通过 next 指针访问该层的所有节点，
     * 同时对于每个第 i 层的节点，我们又可以通过它的 left 和 right 指针知道其第 i+1 层的孩子节点是什么，
     * 所以遍历过程中就能够按顺序为第 i+1 层节点建立 next 指针。
     *
     * 具体来说：
     *
     * 从根节点开始。因为第 00 层只有一个节点，不需要处理。可以在上一层为下一层建立 next 指针。该方法最重要的一点是：
     * 位于第 xx 层时为第 x + 1层建立 next 指针。一旦完成这些连接操作，移至第 x + 1层为第 x + 2层建立next 指针。
     * 当遍历到某层节点时，该层节点的 next 指针已经建立。这样就不需要队列从而节省空间。每次只要知道下一层的最左边的节点，
     * 就可以从该节点开始，像遍历链表一样遍历该层的所有节点。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private Node connect4INext(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }

                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    private Node last = null, nextStart = null;

    private void handle(Node node) {
        if (last != null) {
            last.next = node;
        }
        if (nextStart ==  null) {
            nextStart = node;
        }
        last = node;
    }

    /**
     * LC 二叉树的最近公共祖先 || 236. 二叉树的最近公共祖先 || 剑指 Offer 68 - II. 二叉树的最近公共祖先
     *
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     * 示例 1:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * 输出: 3
     * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
     * 示例 2:
     *
     * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * 输出: 5
     * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
     *  
     *
     * 说明:
     *
     * 所有节点的值都是唯一的。
     * p、q 为不同节点且均存在于给定的二叉树中
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return lowestCommonAncestor4R(root, p, q);
        return lowestCommonAncestor4I(root, p, q);
    }

    /**
     * 递归
     */
    private TreeNode lowestCommonAncestor4R(TreeNode root, TreeNode p, TreeNode q) {
        dfs4Low(root, p, q);
        return ans4Lc;
    }

    private TreeNode ans4Lc;

    private boolean dfs4Low(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lSon = dfs4Low(root.left, p, q);
        boolean rSon = dfs4Low(root.right, p, q);
        if ((lSon && rSon) ||
                ((root.val == p.val || root.val == q.val) && (lSon || rSon))) {
            ans4Lc = root;
        }
        return lSon || rSon || (root.val == p.val || root.val == q.val);
    }

    /**
     * 存储父节点
     *
     * 1. 从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
     * 2. 从 p 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
     *
     * 3. 同样，我们再从 q 节点开始不断往它的祖先移动，如果有祖先已经被访问过，
     * 即意味着这是 p 和 q 的深度最深的公共祖先，即 LCA 节点。
     */
    private TreeNode lowestCommonAncestor4I(TreeNode root, TreeNode p, TreeNode q) {
        dfs4LCI(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private Map<Integer, TreeNode> parent = new HashMap<>();

    private Set<Integer> visited = new HashSet<>();

    private void dfs4LCI(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs4LCI(root.left);
        }

        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs4LCI(root.right);
        }
    }

    public TreeNode lowestCommonAncestorA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorA(root.left, p, q);
        TreeNode right = lowestCommonAncestorA(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null && right == null) {
            return null;
        }
        return left == null ? right : left;
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     *
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 例如，给出
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode buildTree02(int[] inorder, int[] postorder) {
        return build02(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build02(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int index = 0;
        int rootVal = postorder[postEnd];
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int leftSize = index - inStart;
        root.left = build02(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = build02(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * <p>
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意: 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     *
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param preorder pre
     * @param inorder  in
     *
     * @return root
     */
    public TreeNode buildTree01(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart > pEnd) {
            return null;
        }
        int rootVal = preorder[pStart];
        int index = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index - iStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,pStart + 1, pStart + leftSize, inorder, iStart, index - 1);
        root.right = build(preorder, pStart + leftSize + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }

    /**
     * 114. 二叉树展开为链表
     * 给定一个二叉树，原地将它展开为一个单链表。
     * 
     *
     * 例如，给定二叉树
     *
     *     1
     *    / \
     *   2   5
     *  / \   \
     * 3   4   6
     * 将其展开为：
     *
     * 1
     *  \
     *   2
     *    \
     *     3
     *      \
     *       4
     *        \
     *         5
     *          \
     *           6
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        root.right = left;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    /**
     * 124. 二叉树中的最大路径和
     * 给定一个非空二叉树，返回其最大路径和。
     * <p>
     * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。 该路径至少包含一个节点，且不一定经过根节点。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * 输出：6
     * 示例 2：
     *
     * 输入：[-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * 输出：42
     * <p>
     * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[]{Integer.MIN_VALUE};
        onSideMax(root, ans);
        return ans[0];
    }

    /**
     * 计算二叉树中的一个节点的最大贡献值
     * @param node node
     * @param ans 记录结果
     * @return 节点的最大贡献值
     */
    private int onSideMax(TreeNode node, int[] ans) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, onSideMax(node.left, ans));
        int right = Math.max(0, onSideMax(node.right, ans));
        ans[0] = Math.max(left + right + node.val, ans[0]);
        return Math.max(left, right) + node.val;
    }

    /**
     * 129. 求根到叶子节点数字之和
     * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
     *
     * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
     *
     * 计算从根到叶子节点生成的所有数字之和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例 1:
     *
     * 输入: [1,2,3]
     *     1
     *    / \
     *   2   3
     * 输出: 25
     * 解释:
     * 从根到叶子节点路径 1->2 代表数字 12.
     * 从根到叶子节点路径 1->3 代表数字 13.
     * 因此，数字总和 = 12 + 13 = 25.
     * 示例 2:
     *
     * 输入: [4,9,0,5,1]
     *     4
     *    / \
     *   9   0
     *  / \
     * 5   1
     * 输出: 1026
     * 解释:
     * 从根到叶子节点路径 4->9->5 代表数字 495.
     * 从根到叶子节点路径 4->9->1 代表数字 491.
     * 从根到叶子节点路径 4->0 代表数字 40.
     * 因此，数字总和 = 495 + 491 + 40 = 1026
     *
     * @param root root
     * @return res
     */
    public int sumNumbers(TreeNode root) {
        return 0;
    }

    /**
     * 297. 二叉树的序列化与反序列化
     *
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
     * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
     * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，
     * 你也可以采用其他的方法解决这个问题。
     *
     * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 剑指 Offer 37. 序列化二叉树
     * 请实现两个函数，分别用来序列化和反序列化二叉树。
     *
     * 示例: 
     *
     * 你可以将以下二叉树：
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * 序列化为 "[1,2,3,null,null,4,5]"
     * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Codec {

        private final static String NULL_CHAR = "null";

        private final static String SPE_CHAR = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder str = new StringBuilder();
            serialize(root, str);
            return str.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            //List<String>
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(SPE_CHAR)));
            return deserialize(nodes);
        }

        /**
         * 前序和后序都可以
         * 中序无法反序列化
         */
        private void serialize(TreeNode p, StringBuilder str) {
            if (p == null) {
                str.append(NULL_CHAR).append(SPE_CHAR);
                return;
            }
            // 前序
            str.append(p.val).append(SPE_CHAR);
            serialize(p.left, str);
            // 中序
            serialize(p.right, str);
            // 后序
        }

        /**
         * 前序
         */
        private TreeNode deserialize(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            String first = nodes.removeFirst();
            if (NULL_CHAR.equals(first)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.left = deserialize(nodes);
            root.right = deserialize(nodes);
            return root;
        }

        /**
         * 后序
         */
        private void serialize02(TreeNode p, StringBuilder str) {
            if (p == null) {
                str.append(NULL_CHAR).append(SPE_CHAR);
                return;
            }
            serialize(p.left, str);
            serialize(p.right, str);
            // 后序
            str.append(p.val).append(SPE_CHAR);
        }

        /**
         * 后序
         */
        private TreeNode deserialize02(LinkedList<String> nodes) {
            if (nodes.isEmpty()) {
                return null;
            }
            String first = nodes.removeLast();
            if (NULL_CHAR.equals(first)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(first));
            root.right = deserialize(nodes);
            root.left = deserialize(nodes);
            return root;
        }

        /**
         * 层级遍历
         */
        public void serialize03(TreeNode root, StringBuilder str) {
            if (root == null) {
                return;
            }

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                TreeNode cur = q.poll();
                if (cur == null) {
                    str.append(NULL_CHAR).append(SPE_CHAR);
                    continue;
                }
                str.append(cur.val).append(SPE_CHAR);
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }

        /**
         * 层级遍历
         */
        public TreeNode deserialize03(String data) {
            if (data.isEmpty()) {
                return null;
            }

            String[] nodes = data.split(SPE_CHAR);
            if (NULL_CHAR.equals(nodes[0])) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            for (int i = 1; i < nodes.length; ) {
                TreeNode parent = q.poll();
                assert parent != null;
                String left = nodes[i++];
                if (!NULL_CHAR.equals(left)) {
                    parent.left = new TreeNode(Integer.parseInt(left));
                    q.offer(parent.left);
                } else {
                    parent.left = null;
                }
                String right = nodes[i++];
                if (!NULL_CHAR.equals(right)) {
                    parent.right = new TreeNode(Integer.parseInt(right));
                    q.offer(parent.right);
                } else {
                    parent.right = null;
                }
            }

            return root;
        }
    }

    public Codec codec() {
        return new Codec();
    }

    /**
     * 226. 翻转二叉树
     * 翻转一棵二叉树。
     *
     * 示例：
     *
     * 输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * 备注:
     * 这个问题是受到 Max Howell 的 原问题 启发的 ：
     *
     * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/invert-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    /**
     * 剑指 Offer 27. 二叉树的镜像
     *
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     *
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     *
     * 限制：
     *
     * 0 <= 节点个数 <= 1000
     * 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
     * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * 543. 二叉树的直径
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
     * 这条路径可能穿过也可能不穿过根结点。
     *
     *
     *
     * 示例 :
     * 给定二叉树
     *
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
     *
     *
     *
     * 注意：两结点之间的路径长度是以它们之间边的数目表示。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        //DFS
        // left + right
        distance = 1;
        getDepth(root);
        return distance - 1;
    }

    private int distance;

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左儿子深度
        int left = getDepth(root.left);
        // 右儿子深度
        int right = getDepth(root.right);
        distance = Math.max(distance, left + right + 1);
        return Math.max(left, right) + 1;
    }

    /**
     * 965. 单值二叉树
     * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
     *
     * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     *
     *
     * 输入：[1,1,1,1,1,null,1]
     * 输出：true
     * 示例 2：
     *
     *
     *
     * 输入：[2,2,2,5,2]
     * 输出：false
     *
     *
     * 提示：
     *
     * 给定树的节点数范围是 [1, 100]。
     * 每个节点的值都是整数，范围为 [0, 99] 。
     *
     * https://leetcode-cn.com/problems/univalued-binary-tree/
     */
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }


    /**
     * 617. 合并二叉树
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     *
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
     * 否则不为 NULL 的节点将直接作为新二叉树的节点。
     *
     * 示例 1:
     *
     * 输入:
     * 	Tree 1                     Tree 2
     *           1                         2
     *          / \                       / \
     *         3   2                     1   3
     *        /                           \   \
     *       5                             4   7
     * 输出:
     * 合并后的树:
     * 	     3
     * 	    / \
     * 	   4   5
     * 	  / \   \
     * 	 5   4   7
     * 注意: 合并必须从两个树的根节点开始。
     * https://leetcode-cn.com/problems/merge-two-binary-trees/
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // DFS
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merge = new TreeNode(t1.val + t2.val);
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        return merge;
    }

    /**
     * BFS
     */
    public TreeNode mergeTrees0(TreeNode t1, TreeNode t2) {
        // DFS 或者 BFS
        //if ()
        return null;
    }

    /**
     * 669. 修剪二叉搜索树
     *
     * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，
     * 使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，
     * 原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
     *
     * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：root = [1,0,2], low = 1, high = 2
     * 输出：[1,null,2]
     * 示例 2：
     *
     *
     * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
     * 输出：[3,2,null,1]
     * 示例 3：
     *
     * 输入：root = [1], low = 1, high = 2
     * 输出：[1]
     * 示例 4：
     *
     * 输入：root = [1,null,2], low = 1, high = 3
     * 输出：[1,null,2]
     * 示例 5：
     *
     * 输入：root = [1,null,2], low = 2, high = 4
     * 输出：[2]
     *
     *
     * 提示：
     *
     * 树中节点数在范围 [1, 104] 内
     * 0 <= TreeNode.val <= 104
     * 树中每个节点的值都是唯一的
     * 题目数据保证输入是一棵有效的二叉搜索树
     * 0 <= low <= high <= 104
     *
     * https://leetcode-cn.com/problems/trim-a-binary-search-tree/
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * 查找完全二叉树的最后一层最右边的节点
     *
     * 对每个子树的根节点，先从它的右子树开始，沿着左分支一直走到最后一层，如果深度等于树的深度
     * 且该最后节点右边没有节点，则为所求；
     * 否则，右侧右节点，则遍历右子树，深度小于树的深度，则遍历左子树
     *
     *            1
     *          /  \
     *         2    2
     *        / \  / \
     *       3  4 4   3
     *
     * @param treeNode treeNode
     * @return treeNode
     */
    public TreeNode findLastRightNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return treeNode;
        }
        TreeNode curTreeNode = treeNode;
        int depth = 0;
        while (curTreeNode != null) {
            depth++;
            curTreeNode = curTreeNode.left;
        }

        int level = 0;
        while (treeNode != null) {
            level++;
            if (level == depth) {
                break;
            }
            if (treeNode.right != null) {
                int tmpDepth = level + 1;
                curTreeNode = treeNode.right;
                TreeNode preTreeNode = curTreeNode;
                while (curTreeNode.left != null) {
                    tmpDepth++;
                    preTreeNode = curTreeNode;
                    curTreeNode = curTreeNode.left;
                }
                if (tmpDepth < depth) {
                    treeNode = treeNode.left;
                } else if (preTreeNode.right == null || preTreeNode.right == curTreeNode) {
                    return curTreeNode;
                } else {
                    treeNode = treeNode.right;
                }
            } else {
                treeNode = treeNode.left;
            }
        }
        return treeNode;
    }
}
