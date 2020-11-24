package com.natsumes.alth.dp;

/**
 * @author hetengjiao
 */
public class Fibonacci {

    /**
     * f(n-1) + f(n-2)
     */
    public static long commonFib(int n) {
        if (n <= 1) {
            return n;
        }
        return commonFib(n - 1) + commonFib(n - 2);
    }


    private static long[] sub = new long[100];

    /**
     * 斐波那契数列： 递归分治+记忆搜索(备忘录)
     */
    public static long fib(int n) {
        if (n <= 1) {
            return n;
        }
        if (sub[n] == 0) {
            sub[n] = fib(n - 1) + fib(n - 2);
        }

        return sub[n];
    }

    /**
     * 斐波那契数列： DP
     * dp(n) = dp(n-1) + dp(n+2)
     *
     * 使用动态规划四个步骤
     * 1. 把当前的复杂问题转化成一个个简单的子问题（分治）
     * 2. 寻找子问题的最优解法（最优子结构）
     * 3. 把子问题的解合并，存储中间状态
     * 4. 递归+记忆搜索或自底而上的形成递推方程(dp方程)
     *
     * 时间复杂度
     * 新的斐波那契数列实现时间复杂度为O(n)
     *
     * 优缺点
     * 优点：时间复杂度和空间复杂度都相当较低
     * 缺点：难，有些场景不适用
     *
     * 适用场景
     * 尽管动态规划比回溯算法高效，但是，并不是所有问题，都可以用动态规划来解决。能用动态规划解决
     * 的问题，需要满足三个特征，最优子结构、无后效性和重复子问题。在重复子问题这一点上，动态规划
     * 和分治算法的区分非常明显。分治算法要求分割成的子问题，不能有重复子问题，而动态规划正好相
     * 反，动态规划之所以高效，就是因为回溯算法实现中存在大量的重复子问题。
     */
    public static long dp4fib(int n) {
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

}
