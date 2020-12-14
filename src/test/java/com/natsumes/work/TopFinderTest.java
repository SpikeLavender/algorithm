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
            int num = finder.addNum(in);
            //double median = finder.addNum();
            System.out.println("median number is: " + num);
        }
    }
}