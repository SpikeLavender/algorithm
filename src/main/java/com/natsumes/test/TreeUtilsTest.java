package com.natsumes.test;

import com.natsumes.tree.BinaryTree;
import com.natsumes.tree.TreeNode;
import com.natsumes.tree.TreeUtils;

/**
 * @author hetengjiao
 */
public class TreeUtilsTest {
    public static void main(String[] args) {
        BinaryTree<Integer> btt = new BinaryTree<>(Integer::compareTo);
        TreeNode<Integer> node = btt.insert(10).insert(8).insert(11).insert(7).insert(9).insert(12)
                .build();

        TreeUtils.preOrderTraversal(node);
        System.out.println("========================");
        TreeUtils.inOrderTraversal(node);
        System.out.println("========================");
        TreeUtils.postOrderTraversal(node);
    }
}
