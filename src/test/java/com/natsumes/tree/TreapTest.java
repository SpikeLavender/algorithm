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
        treap.insert(3);
        treap.insert(1);
        treap.insert(5);
        treap.insert(2);
        treap.insert(4);
        treap.insert(10);
        treap.insert(7);
        treap.insert(9);
        System.out.println("finished");
    }

    @Test
    public void remove() {
    }
}