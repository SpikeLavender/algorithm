package com.natsumes.work;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * @author hetengjiao
 */
public class MedianFinderTest {

    private static MedianFinder finder = new MedianFinder();

    @Test
    public void findMedian() {

        finder.findMedian();

    }

    @Test
    public void addNum() {
        finder.addNum(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int in = sc.nextInt();
            finder.addNum(in);
            double median = finder.findMedian();
            System.out.println("median number is: " + median);
        }
    }
}