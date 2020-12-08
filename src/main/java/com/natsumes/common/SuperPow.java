package com.natsumes.common;

import java.util.Scanner;

/**
 *
 * a ^ b
 *
 * @author hetengjiao
 */
public class SuperPow {

    /**
     * 递归高效求幂指数
     * @param x 底数
     * @param n 幂指数
     * @param base 取模基础值
     * @return
     */
    public static int myPow(int x, int n, int base) {
        int mod = 2;
        if (n == 0) {
            return 1;
        }
        x %= base;
        if (n % mod == 1) {
            return x * myPow(x, n - 1, base) % base;
        } else {
            int sub = myPow(x, n / 2, base);
            return (sub * sub) % base;
        }
    }

    public static int superPow(int a, int[] b, int base) {
        return superPow(a, b, b.length, base);
    }

    /**
     * 横幂算法
     * 对 1337 取模
     * @param a 底数
     * @param b 指数数组
     * @param len
     * @return
     */
    private static int superPow(int a, int[] b, int len, int base) {
        if (len == 0) {
            return 1;
        }
        int k = b[len - 1];
        int part1 = myPow(a, k, base);
        int part2 = myPow(superPow(a, b, len - 1, base), 10, base);
        return part1 * part2;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
            }
            int a = sc.nextInt();

            System.out.println(superPow(a, b, base));
        }
    }
}
