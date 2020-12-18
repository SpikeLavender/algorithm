package com.natsumes.tree;

/**
 * 树堆（Treap）
 *
 * 树堆（Treap）是二叉排序树（Binary Sort Tree）与堆（Heap）结合产生的一种拥有堆性质的二叉排序树。
 *
 * 但是这里要注意两点，第一点是Treap和二叉堆有一点不同，就是二叉堆必须是完全二叉树，而Treap并不一定是；
 * 第二点是Treap并不严格满足平衡二叉排序树（AVL树）的要求，即树堆中每个节点的左右子树高度之差的绝对值可能会超过1，
 * 只是近似满足平衡二叉排序树的性质。
 *
 * Treap每个节点记录两个数据，一个是键值，一个是随机附加的优先级，Treap在以关键码构成二叉排序树的同时，
 * 又以结点优先级形成最大堆和最小堆。所以Treap必须满足这两个性质，一是二叉排序树的性质，二是堆的性质。
 *
 * @author hetengjiao
 */
public class Treap<V> {


    static class Node<V> {

        private V value;

        private int num;

        private Node<V> left;

        private Node<V> right;

        private Node<V> parent;
    }
}
