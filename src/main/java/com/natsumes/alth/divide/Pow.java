package com.natsumes.alth.divide;

/**
 *
 * 计算n次幂
 *
 * @author hetengjiao
 */
public class Pow {

    /**
     * 时间复杂度O(n)
     * @param x x
     * @param n n
     */
    public static long commomPow(int x, int n) {
        long s = 1;
        while (n >= 1) {
            s *= x;
            n--;
        }
        return s;
    }

    /**
     * 时间复杂度O(logn)
     * @param x x
     * @param n n
     * @return
     */
    public static long pow(int x, int n) {
        //递归结束
        if (n == 1) {
            return x;
        }

        long half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
