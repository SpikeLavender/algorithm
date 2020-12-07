package com.natsumes.binary;

import java.util.Scanner;

/**
 * 二分查找框架
 * @author hetengjiao
 */
public class BinarySearch {

    /**
     * 基本的二分搜索
     *
     * 如果存在，返回下标
     * 如果不存在，返回-1
     */
    public static int binarySearch(int[] nums, int target) {
        // [left, right]
        int left = 0;
        int right = nums.length - 1;


        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 寻找左侧边界的二分搜索
     */
    public static int leftBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // [left, right) [2, 3, 5, 7] [0, 4), [1, 2, 2, 3, 5, 7] 2
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == nums.length) {
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 寻找右侧边界的二分搜索
     */
    public static int rightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        // [left, right) [2, 3, 5, 7] [0, 4), [1, 2, 2, 3, 5, 7] 2
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? left - 1 : -1;
    }

    enum CMD {
        /**
         * binarySearch
         */
        BS("bs"),

        /**
         * leftBound
         */
        LB("lb"),

        /**
         * rightBound
         */
        RB("rb"),

        /**
         * exit
         */
        EX("exit");
        ;

        private final String name;

        CMD(String name) {
            this.name = name;
        }

        public static CMD getCmd(String name) {
            for (CMD value : values()) {
                if (value.name.equals(name)) {
                    return value;
                }
            }
            throw new IllegalArgumentException("un support type");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String next = sc.next();
            CMD cmd = CMD.getCmd(next);
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m; i++) {
                nums[i] = sc.nextInt();
            }
            int target = sc.nextInt();

            switch (cmd) {
                case BS:
                    System.out.println(binarySearch(nums, target));
                    break;
                case LB:
                    System.out.println(leftBound(nums, target));
                    break;
                case RB:
                    System.out.println(rightBound(nums, target));
                    break;
                default:
                    break;
            }

        }
    }

}
