package com.natsumes.common;

/**
 * 幂运算
 *
 * @author hetengjiao
 */
public class PowOperate {

    /**
     * 快速幂等法
     * @param x 底数
     * @param n 幂指数
     * @return
     */
    public static int pPow(int x, int n) {
        int res = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }

    /**
     * 递归高效求幂指数
     * @param x 底数
     * @param n 幂指数
     * @return
     */
    public static int myPow(int x, int n) {
        int mod = 2;
        if (n == 0) {
            return 1;
        }
        if (n % mod == 1) {
            return x * myPow(x, n - 1);
        } else {
            int sub = myPow(x, n / 2);
            return sub * sub;
        }
    }
}
