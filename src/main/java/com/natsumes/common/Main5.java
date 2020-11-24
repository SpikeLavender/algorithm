package com.natsumes.common;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int i = 0;
            while (i < n) {
                nums[i] = sc.nextInt();
                i++;
            }
            int ofLIS = lengthOfLIS(nums);
            System.out.println(n - ofLIS);
        }
    }

    private static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j =  i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    tmp = Math.max(tmp, f[j] + 1);
                }
            }
            f[i] = tmp;
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
