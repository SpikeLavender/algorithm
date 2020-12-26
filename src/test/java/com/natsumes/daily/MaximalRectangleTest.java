package com.natsumes.daily;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class MaximalRectangleTest {

    private static MaximalRectangle mr = new MaximalRectangle();

    @Test
    public void maximalRectangle() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0' , '0'},
                {'1', '0', '1', '1' , '1'},
                {'1', '1', '1', '1' , '1'},
                {'1', '0', '0', '1' , '0'}
        };

        Assert.assertEquals(6, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {};
        Assert.assertEquals(0, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'0'}};
        Assert.assertEquals(0, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'1'}};
        Assert.assertEquals(1, mr.doMaximalRectangleCommon(matrix));

        matrix = new char[][] {{'0', '0'}};
        Assert.assertEquals(0, mr.doMaximalRectangleCommon(matrix));
    }
}