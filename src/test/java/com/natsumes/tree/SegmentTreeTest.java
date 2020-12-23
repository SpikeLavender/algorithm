package com.natsumes.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author hetengjiao
 */
public class SegmentTreeTest {

    private SegmentTree<Integer> st;

    @Before
    public void setUp() throws Exception {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        st = new SegmentTree<>(nums, (a, b)-> {
            a = a == null ? 0 : a;
            b = b == null ? 0 : b;
            return a + b;
        });
    }

    @Test
    public void query() {
        Assert.assertEquals(0, st.query(1, 4).intValue());
        Assert.assertEquals(-3, st.query(0, 5).intValue());
        Assert.assertEquals(-2, st.query(0, 0).intValue());
        Assert.assertEquals(-1, st.query(5, 5).intValue());
    }

    @Test
    public void update() {
        st.update(1, 2);
        Assert.assertEquals(2, st.get(1).intValue());
    }

    @Test
    public void get() {
        Assert.assertEquals(-1, st.get(5).intValue());
        Assert.assertEquals(0, st.get(1).intValue());
    }

    @Test
    public void size() {
        int size = st.size();
        System.out.println(size);
        Assert.assertEquals(6, st.size());
    }
}