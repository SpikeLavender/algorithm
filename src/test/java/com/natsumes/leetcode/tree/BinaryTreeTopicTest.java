package com.natsumes.leetcode.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author hetengjiao
 */
public class BinaryTreeTopicTest {

    private final BinaryTreeTopic bt = new BinaryTreeTopic();

    private final BinaryTreeTopic.Codec codec = new BinaryTreeTopic().codec();

    public TreeNode buildNode(String data) {
        return codec.deserialize03(data);
    }

    @Test
    public void codec() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        BinaryTreeTopic.Codec codec = bt.codec();
        String serialize = codec.serialize(root);
        System.out.println(serialize);

        TreeNode deserialize = codec.deserialize(serialize);
        System.out.println(deserialize);
    }


    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    @Test
    public void buildTree() {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = bt.buildTree01(preorder, inorder);

        System.out.println(treeNode.toString());
    }

    /**
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    @Test
    public void buildTree02() {
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode treeNode = bt.buildTree02(inorder, postorder);

        System.out.println(treeNode.toString());
    }

    /**
     * 1 / \ 2   5 / \   \ 3   4   6
     */
    @Test
    public void flatten() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        bt.flatten(root);
        System.out.println(root);
    }

    @Test
    public void maxPathSum() {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = bt.maxPathSum(root);
        System.out.println(i);
    }

    @Test
    public void preorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = bt.preorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void inorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = bt.inorderTraversal(root);
        System.out.println(list);
    }

    @Test
    public void postorderTraversal() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Integer> list = bt.postorderTraversal(root);
        System.out.println(list);
    }


    @Test
    public void levelOrder() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = bt.levelOrder(root);
        System.out.println(lists);
    }

    @Test
    public void maxDepth() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int i = bt.maxDepth(root);
        System.out.println(i);
        Assert.assertEquals(3, i);
    }

    @Test
    public void isSymmetric() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean i = bt.isSymmetric(root);
        System.out.println(i);
        Assert.assertTrue(i);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        i = bt.isSymmetric(root);
        System.out.println(i);
        Assert.assertFalse(i);
    }

    /**
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
     */
    @Test
    public void hasPathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4, null, new TreeNode(1));
        boolean i = bt.hasPathSum(root, 22);
        System.out.println(i);
        Assert.assertTrue(i);


        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);
        i = bt.hasPathSum(root, 22);
        System.out.println(i);
        Assert.assertFalse(i);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        i = bt.hasPathSum(root, 1);
        System.out.println(i);
        Assert.assertTrue(i);

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        i = bt.hasPathSum(root, 0);
        System.out.println(i);
        Assert.assertFalse(i);
    }

    @Test
    public void connect() {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, new Node(6), new Node(7), null);
        Node node = bt.connect(root);
        System.out.println(node);
    }

    @Test
    public void connect2() {
        Node root = new Node(1);
        root.left = new Node(2, new Node(4), new Node(5), null);
        root.right = new Node(3, null, new Node(7), null);
        Node node = bt.connect2(root);
        System.out.println(node);
    }

    @Test
    public void lowestCommonAncestor() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        root.right = new TreeNode(1, new TreeNode(0), new TreeNode(8));

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode node = bt.lowestCommonAncestor(root, p, q);
        int res = node == null ? -1 : node.val;
        System.out.println(res);
        Assert.assertEquals(3, res);
    }

    /**
     *          4
     *        /   \
     *       2     7
     *      / \   / \
     *     1   3 6   9
     */
    @Test
    public void invertTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode treeNode = bt.invertTree(root);
        System.out.println(treeNode);
    }


    @Test
    public void mirrorTree() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        TreeNode treeNode = bt.mirrorTree(root);
        System.out.println(treeNode);
    }

    @Test
    public void diameterOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        Assert.assertEquals(3, bt.diameterOfBinaryTree(root));
    }

    @Test
    public void isUnivalTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        Assert.assertTrue(bt.isUnivalTree(root));

        Assert.assertTrue(bt.isUnivalTree(null));
        root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        Assert.assertFalse(bt.isUnivalTree(root));
    }

    @Test
    public void mergeTrees() {
        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(7)));
        TreeNode node = bt.mergeTrees(t1, t2);
        System.out.println(node);
        Assert.assertEquals(3, node.val);
    }

    @Test
    public void mergeTrees0() {
//        TreeNode t1 = new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2));
//        TreeNode t2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)),
//                new TreeNode(3, null, new TreeNode(7)));
//        TreeNode node = bt.mergeTrees0(t1, t2);
//        System.out.println(node);
//        Assert.assertEquals(3, node.val);
    }

    @Test
    public void zigzagLevelOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> lists = bt.zigzagLevelOrder(root);
        System.out.println(lists);
    }

    @Test
    public void rightSideView() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(4)
                )
        );
        List<Integer> list = bt.rightSideView(treeNode);
        System.out.println(list);

        treeNode = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        null
                )
        );
        list = bt.rightSideView(treeNode);
        System.out.println(list);
    }

    @Test
    public void rightSideView01() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(4)
                )
        );
        List<Integer> list = bt.rightSideView01(treeNode);
        System.out.println(list);
    }

    @Test
    public void findLastRightNode() {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(7), new TreeNode(8)), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(9))
        );
        Assert.assertEquals(8, bt.findLastRightNode(treeNode).val);

        treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(7), new TreeNode(8)),
                        new TreeNode(5, new TreeNode(10), new TreeNode(11))
                ),
                new TreeNode(3,
                        new TreeNode(6, new TreeNode(12), null),
                        new TreeNode(9)
                )
        );
        Assert.assertEquals(12, bt.findLastRightNode(treeNode).val);
    }

    @Test
    public void trimBST() {
    }

    @Test
    public void pathSum() {
        TreeNode root = new TreeNode(5,
                new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null),
                new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1)))
        );
        List<List<Integer>> lists = bt.pathSum(root, 22);
        System.out.println(lists);
    }

    @Test
    public void sumNumbers() {
        TreeNode root = new TreeNode(2,
                new TreeNode(2),
                new TreeNode(3)
        );
        Assert.assertEquals(25, bt.sumNumbers(root));

        root = new TreeNode(4,
                new TreeNode(9, new TreeNode(5), new TreeNode(1)),
                new TreeNode(0)
        );
        Assert.assertEquals(1026, bt.sumNumbers(root));
    }

    @Test
    public void binaryTreePaths() {
        List<String> lists = bt.binaryTreePaths(buildNode("1,2,3,null,5"));
        System.out.println(lists);
    }

    @Test
    public void pathSumIII() {
        TreeNode node = buildNode("[10,5,-3,3,2,null,11,3,-2,null,1]");
        Assert.assertEquals(3, bt.pathSumIII(node, 8));
    }

    @Test
    public void smallestFromLeaf() {
        Assert.assertEquals("dba", bt.smallestFromLeaf(buildNode("[0,1,2,3,4,3,4]")));
        Assert.assertEquals("adz", bt.smallestFromLeaf(buildNode("[25,1,3,1,3,0,2]")));
        Assert.assertEquals("abc", bt.smallestFromLeaf(buildNode("[2,2,1,null,1,0,null,0]")));
    }
}