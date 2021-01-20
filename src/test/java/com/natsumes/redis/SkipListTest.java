package com.natsumes.redis;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class SkipListTest {

    @Test
    public void add() {
        SkipList<Integer> list = new SkipList<>();
        list.add(50);
        list.add(15);
        list.add(13);
        list.add(20);
        list.add(100);
        list.add(75);
        list.add(99);
        list.add(76);
        list.add(83);
        list.add(65);
        list.print();

        list.search(50);
        list.remove(50);
        list.search(50);
    }

    @Test
    public void search() {
    }

    @Test
    public void remove() {
    }
}