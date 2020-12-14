package com.natsumes.work;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author hetengjiao
 */
public class TopFinderTest {
    private static TopFinder finder = new TopFinder();

    @Test
    public void addNum() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int in = sc.nextInt();
            finder.addNum(in);
            finder.list();
            System.out.println("top number is: [" + finder.getTop(0.5) + ", "
                    + finder.getTop(0.9) + ", "
                    + finder.getTop(0.99) + "]");
        }
    }
}