package com.natsumes.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class TreapTest {

    private Treap<Integer> treap;

    @Before
    public void setUp() throws Exception {
        treap = new Treap<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
        treap.add(3);
        treap.add(1);
        treap.add(5);
        treap.add(2);
        treap.add(4);
        treap.add(10);
        treap.add(7);
        treap.add(9);
        System.out.println("finished");
    }

    @Test
    public void remove() {
    }
}