package com.natsumes.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class StrUtilsTest {

    @Test
    public void print() {
        Assert.assertEquals(4, StrUtils.print("abcadac"));
        Assert.assertEquals(1, StrUtils.print("aaaaaaa"));
    }
}