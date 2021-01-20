package com.natsumes.redis;

import org.junit.Test;

/**
 * @author hetengjiao
 */
public class BitmapTest {

    @Test
    public void set() {

        Bitmap bitmap = new Bitmap();
        bitmap.set(3);
        bitmap.set(65);
    }

    @Test
    public void get() {
        Bitmap bitmap = new Bitmap();
        System.out.println(bitmap.get(3));
        bitmap.set(3);
        System.out.println(bitmap.get(3));
        System.out.println(bitmap.get(65));
    }

    @Test
    public void clear() {
        Bitmap bitmap = new Bitmap(64);
        bitmap.set(3);
        bitmap.set(65);
        System.out.println(bitmap.get(3));
        System.out.println(bitmap.get(65));
        bitmap.clear(3);
        System.out.println(bitmap.get(3));
        System.out.println(bitmap.get(65));
    }

    public static void main(String[] args) {
        System.out.println(Long.toBinaryString(((1L << 6) - 1) >> 6));
        System.out.println(Long.toBinaryString(1L << 63));
        System.out.println(Long.toBinaryString(1L << 31));
    }
}