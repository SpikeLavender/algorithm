package com.natsumes.leetcode;

import java.util.*;

/**
 *
 * LeetCode 全集
 *
 * @author hetengjiao
 */
public class LeetCode {

    /* ==================================== 随机算法专题 ======================================== */


    /* ------------------------------------ 水塘抽样算法 ---------------------------------------- */
    /**
     * 398. 随机数索引
     * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。
     * 您可以假设给定的数字一定存在于数组中。
     *
     * 注意：
     * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
     *
     * 示例:
     *
     * int[] nums = new int[] {1,2,3,3,3};
     * Solution solution = new Solution(nums);
     *
     * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
     * solution.pick(3);
     *
     * // pick(1) 应该返回 0。因为只有nums[0]等于1。
     * solution.pick(1);
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/random-pick-index
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public int pick(int[]nums, int target) {
        Random random = new Random();
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
            if (random.nextInt(i) == 0) {
                res = i;
            }
        }
        return res;
    }

    /**
     * 382. 链表随机节点
     *
     * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
     *
     * 进阶:
     * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
     *
     * 示例:
     *
     * // 初始化一个单链表 [1,2,3].
     * ListNode head = new ListNode(1);
     * head.next = new ListNode(2);
     * head.next.next = new ListNode(3);
     * Solution solution = new Solution(head);
     *
     * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
     * solution.getRandom();
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/linked-list-random-node
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class RandomPick {

        private ListNode head;

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        private RandomPick(ListNode head) {
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            Random random = new Random();
            int res = 0;
            int i = 0;
            ListNode p = head;
            while (p != null) {
                // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
                if (random.nextInt(++i) == 0) {
                    res = p.val;
                }
                p = p.next;
            }
            return res;
        }
    }

    public RandomPick randomPick(ListNode head) {
        return new RandomPick(head);
    }

    /**
     * 实现一个生成器类，构造函数传入一个很长的数组，请你实现randomGet方法，每次调用随机返回数组中的一个元素，
     * 多次调用不能重复返回相同索引的元素。
     * 连续 m 次之内不能出现重复的元素
     * 要求不能对该数组进行任何形式的修改，且操作的时间复杂度是 O(1)。
     */
    class RandomArrPick {

        private int[] nums;

        // 连续3次之内的数据不能重复
        private final static int MAX_SKIP_NUM = 3;

        // todo：定义一个类似于LRU的数据结构, 定长队列
        private Set<Integer> set = new HashSet<>(MAX_SKIP_NUM);

        /** @param nums The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public RandomArrPick(int[] nums) {
            this.nums = nums;
        }

        /** Returns a random node's value. */
        public int randomGet() {
            Random random = new Random();
            int res = 1, i;
            for (i = 0; i < nums.length; i++) {
                // 生成一个[0, i)之间的随机整数，这个证书等于0的概率就是 1 / i
                if (!set.contains(i) && random.nextInt(i + 1) == 0) {
                    res = nums[i];
                    set.add(i);
                }
            }
            set.add(i);
            return res;
        }
    }

    public RandomArrPick randomArrPick(int[] nums) {
        return new RandomArrPick(nums);
    }
    /* ------------------------------------------------------------------------------------- */

    /* ====================================================================================== */

    /* ==================================== 二叉树相关专题 ======================================== */


    /**
     * LC 二叉树的前序遍历
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
     * -100 <= Node.val <= 100
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
     * LC 二叉树的中序遍历
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
     * -100 <= Node.val <= 100
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
     * LC 二叉树的后序遍历 给定一个二叉树，返回它的 后序 遍历。
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
     * LC 二叉树的层序遍历
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
                assert node != null;
                level.add(node.val);
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
     * LC 二叉树的最大深度
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
     * LC 对称二叉树
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
     * 116. 填充每个节点的下一个右侧节点指针
     * <p>
     * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
     *
     * struct Node {
     *   int val;
     *   Node *left;
     *   Node *right;
     *   Node *next;
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
        return null;
    }

    private int ans = Integer.MIN_VALUE;
    /**
     * 124. 二叉树中的最大路径和 给定一个非空二叉树，返回其最大路径和。
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
        oneSideMax(root);
        return ans;
    }

    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, oneSideMax(root.left));
        int right = Math.max(0, oneSideMax(root.right));
        // 后序遍历
        ans = Math.max(ans, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    /**
     * 297. 二叉树的序列化与反序列化
     *
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     *
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
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
        private void serialize03(TreeNode root, StringBuilder str) {
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
        private TreeNode deserialize03(String data) {
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

    /* ======================================================================================= */

    /* ==================================== 回溯算法相关专题 ======================================== */

    /**
     * 表示是否被访问过
     */
    private boolean[] vis;

    /**
     * 46. 全排列
     * 给定一个没有重复数字的序列，返回其所有可能的全排列。
     *
     * 示例:
     *
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     *            O
     *         1     2
     *       O         O
     *     2   3     1   3
     *    O     O   O      O
     *    3     2   3      1
     *    O     O   O      O
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        vis = new boolean[nums.length];
        List<Integer> track = new ArrayList<>();
        backTrack(nums, track, res, 0);
        return res;
    }

    /**
     * 回溯算法
     * @param nums      选择列表
     * @param track     记录路径
     * @param res       符合条件的结果
     */
    private void backTrack(int[] nums, List<Integer> track, List<List<Integer>> res, int idx) {
        // 结束条件：track.size = nums.length
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合理的选择
            if (vis[i]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            vis[i] = true;
            // 进入下一层决策树
            backTrack(nums, track, res, idx + 1);
            // 取消选择
            vis[i] = false;
            track.remove(idx);
        }
    }

    // todo: 1.交换元素达成目的的算法

    /**
     * 47. 全排列 II
     *
     * 给定一个可包含重复数字的序列 nums ，按任意顺序返回所有不重复的全排列。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backTrackUnique(nums, track, res, 0);
        return res;
    }

    /**
     * 回溯算法(按下标回溯)
     * @param nums          数据
     * @param trackIndex    记录路径下标
     * @param res           结果
     */
    private void backTrackUnique(int[] nums, List<Integer> trackIndex, List<List<Integer>> res, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(trackIndex));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            } else if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                // 保证每次访问重复元素的时候，都是按照顺序访问第一个未被访问到的元素
                continue;
            }
            trackIndex.add(nums[i]);
            vis[i] = true;
            backTrackUnique(nums, trackIndex, res, idx + 1);
            vis[i] = false;
            trackIndex.remove(idx);
        }
    }

    /**
     * 784. 字母大小写全排列
     *
     * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
     *
     * 示例：
     * 输入：S = "a1b2"
     * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * 输入：S = "3z4"
     * 输出：["3z4", "3Z4"]
     *
     * 输入：S = "12345"
     * 输出：["12345"]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-case-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> letterCasePermutation(String S) {
        return null;
    }

    /* ======================================================================================= */
}
