package com.natsumes.alth.greedy;

import com.natsumes.sort.SortUtils;

/**
 * 贪婪算法
 *
 * 贪婪算法（Greedy）的定义：是一种在每一步选中都采取在当前状态下最好或最优的选择，从而希望
 * 导致结果是全局最好或最优的算法。
 * 贪婪算法：当下做局部最优判断，不能回退
 * （能回退的是回溯，最优+回退是动态规划）
 * 由于贪心算法的高效性以及所求得答案比较接近最优结果，贪心算法可以作为辅助算法或解决一些要求
 * 结果不特别精确的问题
 * 注意：当下是最优的，并不一定全局是最优的。
 *
 * 假设一共有N件物品，第 i 件物品的价值为 Vi ，重量为Wi，一个小偷有一个最多只能装下重量为W的背
 * 包，他希望带走的物品越有价值越好，可以带走某件物品的一部分，请问：他应该选择哪些物品？
 *
 * @author hetengjiao
 */
public class GreedyBag {
    /**
     * 最大承重
     */
    private double max = 0;

    public void getMaxValue(Goods[] goods) {
        Goods[] gList = sort(goods);
        double sumWt = 0;

        for (Goods value : gList) {
            sumWt += value.weight;
            if (sumWt <= max) {
                System.out.println(value.name + "取" + value.weight + "kg");
            } else {
                System.out.println(value.name + "取" + (max - (sumWt - value.weight)) + "kg");
                return;
            }
        }
    }

    /**
     * 按价值排序
     */
    private Goods[] sort(Goods[] goods) {
        return SortUtils.quickSort(goods);
    }

    public void setMax(double max) {
        this.max = max;
    }
}
