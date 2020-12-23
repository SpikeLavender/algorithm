package com.natsumes.tree;

/**
 * Segment Tree
 * 线段树(Segment Tree)也是一棵树，只不过元素的值代表一个区间。
 * 常用区间的统计操作，比如一个区间的最大值(max)，最小值(min)，和(sum)等等
 *
 * @author hetengjiao
 */
public class SegmentTree<T extends Comparable<T>> {

    private Object[] tree;

    private Object[] data;

    private Merger<T> merger;

    public interface Merger<T> {
        T merge(T a, T b);
    }

    public SegmentTree(T[] arr, Merger<T> merger) {
        this.data = arr;
        this.merger = merger;
        this.tree = new Object[(data.length << 2)];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 构建线段树
     *
     * @param treeIndex 当前需要添加节点的索引
     * @param treeLeft  treeIndex左边界
     * @param treeRight treeIndex右边界
     */
    @SuppressWarnings("unchecked")
    private void buildSegmentTree(int treeIndex, int treeLeft, int treeRight) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = data[treeLeft];
            return;
        }

        int leftIndex = (treeIndex << 1) + 1;
        //当前节点右子树索引
        int rightIndex = (treeIndex << 1) + 2;

        //int mid = (left+right)/2; 如果left和right很大，可能会导致整型溢出
        int mid = treeLeft + (treeRight - treeLeft) / 2;
        //构建左子树
        buildSegmentTree(leftIndex, treeLeft, mid);
        //构建右子树
        buildSegmentTree(rightIndex, mid + 1, treeRight);
        //当前节点存放的值
        tree[treeIndex] = merger.merge((T)tree[leftIndex], (T)tree[rightIndex]);
    }

    /**
     * 线段树的查询
     * 对于线段树的查询，主要有以下几种情况：
     *
     * 要查询的区间在刚好就是当前节点的区间
     * 要查找的区间在当前节点的左子树区间
     * 要查找的区间在当前节点的右子树区间
     * 要查找的区间一部分在当前节点的左子树区间，一部分在右子树区间
     */
    public T query(int start, int end) {
        return query(0, 0, data.length - 1, start, end);
    }

    /**
     * @param treeIndex 当前查找的节点
     * @param treeLeft  treeIndex的左边界
     * @param treeRight treeIndex的右边界
     * @param queryL    用户需要查找的左边界
     * @param queryR    用户需要查找的右边界
     * @return t
     */
    @SuppressWarnings("unchecked")
    private T query(int treeIndex, int treeLeft, int treeRight, int queryL, int queryR) {
        //1. 需要查找的范围完刚好在这个treeIndex节点的区间
        if (treeLeft == queryL && treeRight == queryR) {
            return (T) tree[treeIndex];
        }
        //当前节点左子树索引
        int leftIndex = (treeIndex << 1) + 1;
        //当前节点右子树索引
        int rightIndex = (treeIndex << 1) + 2;
        //int mid = (left+right)/2; 如果left和right很大，可能会导致整型溢出
        int mid = treeLeft + (treeRight - treeLeft) / 2;
        //2. 需要查找的范围完全在左子树的区间里
        if (queryR <= mid) {
            return query(leftIndex, treeLeft, mid, queryL, queryR);
        }

        //3. 需要查找的范围完全在左子树的区间里
        if (queryL >= mid + 1) {
            return query(rightIndex, mid + 1, treeRight, queryL, queryR);
        }

        //4. 需要查找的范围一部分在左子树里，一部分在右子树中
        T left = query(leftIndex, treeLeft, mid, queryL, mid);
        T right = query(rightIndex, mid + 1, treeRight, mid + 1, queryR);
        return merger.merge(left, right);
    }

    public void update(int index, T e) {
        data[index] = e;
        update(0, 0, data.length - 1, index, e);
    }

    @SuppressWarnings("unchecked")
    private void update(int treeIndex, int treeLeft, int treeRight, int index, T e) {
        if (treeLeft == treeRight) {
            tree[treeIndex] = e;
            return;
        }

        int mid = treeLeft + (treeRight - treeLeft) / 2;
        int leftChildIndex = (treeIndex << 1) + 1;
        int rightChildIndex = (treeIndex << 1) + 2;

        if (index <= mid) {
            update(leftChildIndex, treeLeft, mid, index, e);
        } else if (index >= mid + 1) {
            update(rightChildIndex, mid + 1, treeRight, index, e);
        }

        //更改完叶子节点后，还需要对他的所有祖辈节点更新
        tree[treeIndex] = merger.merge((T)tree[leftChildIndex], (T)tree[rightChildIndex]);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) data[index];
    }

    public int size() {
        return data.length;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (Object o : tree) {
            if (o == null) {
                continue;
            }
            builder.append(o).append(',');
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append(']');
        return builder.toString();
    }
}
