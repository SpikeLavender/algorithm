package com.natsumes.alth.greedy;

/**
 * @author hetengjiao
 */
public class Goods implements Comparable<Goods> {
    /**
     * 名称
     */
    String name;

    /**
     * 重量
     */
    double weight;

    /**
     * 价格
     */
    double price;

    /**
     * 价值
     */
    double value;

    public Goods(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.value = price / weight;
    }

    @Override
    public int compareTo(Goods o) {
        if (value - o.value < 0) {
            return 1;
        } else if (value - o.value > 0) {
            return -1;
        }
        return 0;
    }
}
