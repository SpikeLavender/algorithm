package com.natsumes.company;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author hetengjiao
 */
public class ByteDanceTest {

    private ByteDance bd = new ByteDance();

    @Test
    public void longestPalindrome() {
        Assert.assertEquals("aba", bd.longestPalindrome("babad"));
        Assert.assertEquals("bb", bd.longestPalindrome("cbbd"));
        Assert.assertEquals("a", bd.longestPalindrome("a"));
        Assert.assertEquals("a", bd.longestPalindrome("ac"));
    }

    @Test
    public void findLastRightNode() {
        Node node = new Node(1,
                new Node(2, new Node(4, new Node(7), new Node(8)), new Node(5)),
                new Node(3, new Node(6), new Node(9))
        );
        Assert.assertEquals(8, bd.findLastRightNode(node).val);

        node = new Node(1,
                new Node(2,
                        new Node(4, new Node(7), new Node(8)),
                        new Node(5, new Node(10), new Node(11))
                ),
                new Node(3,
                        new Node(6, new Node(12), null),
                        new Node(9)
                )
        );
        Assert.assertEquals(12, bd.findLastRightNode(node).val);
    }
}