package com.natsumes;


import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashSet<Integer> integers = new HashSet<>();

            int i = 0;
            while (i < n) {
                //nums[i] = sc.nextInt();
                integers.add(sc.nextInt());
                i++;
            }
            int[] nums = new int[integers.size()];
            int k = 0;
            for (Integer integer : integers) {
                nums[k] = integer;
                k++;
            }

            int coinChange = coinChange(nums, m);
            if (coinChange <= 0) {
                System.out.println("No solution");
            } else {
                System.out.println(coinChange);
            }
        }
    }

    /**
     * f[i][j] = f[i-1][j-1],
     * @param coins
     * @param amount
     * @return
     */
    private static int coinChange(int[] coins, int amount) {
        int[] f = new int[amount + 1];
        int inf = Integer.MAX_VALUE - 1;
        for (int i = 1; i <= amount; i++) {
            f[i] = inf;   //防止后续整数溢出
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = amount; j >= coins[i]; j--) {

                f[j] = Math.min(f[j], f[j - coins[i]] + 1);
            }
        }
        return f[amount] == inf ? -1 : f[amount];
    }
}
