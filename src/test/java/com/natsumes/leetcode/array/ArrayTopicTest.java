package com.natsumes.leetcode.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author hetengjiao
 */
public class ArrayTopicTest {

    private final ArrayTopic at = new ArrayTopic();

    @Test
    public void reverse() {
        Assert.assertEquals(321, at.reverse(123));
        Assert.assertEquals(-321, at.reverse(-123));
        Assert.assertEquals(21, at.reverse(120));
        Assert.assertEquals(0, at.reverse(0));
        Assert.assertEquals(0, at.reverse(2147483647));
        Assert.assertEquals(0, at.reverse(-2147483648));
    }

    @Test
    public void findMedianSortedArrays() {
        Assert.assertEquals(2.0d, at.findMedianSortedArrays(new int[] {1, 3}, new int[] {2}), 0.0);
        Assert.assertEquals(2.5d, at.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}), 0.0);
        Assert.assertEquals(0.0d, at.findMedianSortedArrays(new int[] {0, 0}, new int[] {0, 0}), 0.0);
        Assert.assertEquals(1.0d, at.findMedianSortedArrays(new int[] {}, new int[] {1}), 0.0);
        Assert.assertEquals(2.0d, at.findMedianSortedArrays(new int[] {2}, new int[] {}), 0.0);
    }

    @Test
    public void maxArea() {
        Assert.assertEquals(49, at.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assert.assertEquals(1, at.maxArea(new int[] {1, 1}));
        Assert.assertEquals(16, at.maxArea(new int[] {4, 3, 2, 1, 4}));
        Assert.assertEquals(2, at.maxArea(new int[] {1, 1, 1}));
    }

    @Test
    public void search() {
        Assert.assertEquals(4, at.search(new int[] {4,5,6,7,0,1,2}, 0));
        Assert.assertEquals(-1, at.search(new int[] {4,5,6,7,0,1,2}, 3));
        Assert.assertEquals(-1, at.search(new int[] {1}, 0));
    }

    @Test
    public void findKthLargest() {
        Assert.assertEquals(5, at.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2));
        Assert.assertEquals(4, at.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    @Test
    public void quickSort() {
        int[] nums = new int[] {1, 3, 5, 7, 9, 4, 2, 6};
        at.quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6};
        at.quickSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {3, 2, 3, 1, 2, 5, 2, 5, 6};
        at.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void checkPossibility() {
        Assert.assertTrue(at.checkPossibility(new int[] {1, 4, 2, 5, 6, 7}));
        Assert.assertTrue(at.checkPossibility(new int[] {3, 4, 2, 5, 6, 7}));
        Assert.assertFalse(at.checkPossibility(new int[] {3, 4, 2, 3, 4, 5}));
        Assert.assertTrue(at.checkPossibility(new int[] {4, 2, 3}));
        Assert.assertTrue(at.checkPossibility(new int[] {4, 2}));
        Assert.assertTrue(at.checkPossibility(new int[] {4}));
        Assert.assertFalse(at.checkPossibility(new int[] {4, 2, 1}));
    }

    /**
     * *
     *       输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     *       输出：[[1,6],[8,10],[15,18]]
     *       解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *       示例 2：
     *
     *       输入：intervals = [[1,4],[4,5]]
     *       输出：[[1,5]]
     *       解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     */
    @Test
    public void merge() {
        Assert.assertArrayEquals(new int[][] {{1, 6}, {8, 10}, {15, 18}},
                at.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));

        Assert.assertArrayEquals(new int[][] {{1, 5}},
                at.merge(new int[][]{{1, 4}, {4, 5}}));
    }

    @Test
    public void getRow() {
        List<Integer> row = at.getRow(3);
        System.out.println(row);
        Assert.assertEquals(3, row.get(1).intValue());
        Assert.assertEquals(3, row.get(2).intValue());
    }

    @Test
    public void findDisappearedNumbers() {
        List<Integer> numbers = at.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(numbers);
        Assert.assertEquals(5, numbers.get(0).intValue());
        Assert.assertEquals(6, numbers.get(1).intValue());
    }

    @Test
    public void spiralOrder() {
        /*
         *  * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
         *      * 输出：[1,2,3,6,9,8,7,4,5]
         *      * 示例 2：
         *      *
         *      * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
         *      * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
         */
        List<Integer> order = at.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(order);

        order = at.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(order);
    }

    @Test
    public void searchMatrix() {
        Assert.assertFalse(at.searchMatrix(new int[][] {{1, 1}}, 2));
        int[][] matrix = new int[][]{
                { 1,  3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        Assert.assertTrue(at.searchMatrix(matrix, 3));
        Assert.assertFalse(at.searchMatrix(matrix, 13));
    }

    @Test
    public void searchMatrix2() {
        int[][] matrix = new int[][]{
                { 1,  4,  7, 11, 15},
                { 2,  5,  8, 12, 19},
                { 3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        Assert.assertTrue(at.searchMatrix2(matrix, 5));
        Assert.assertTrue(at.searchMatrix2(matrix, 13));
        Assert.assertFalse(at.searchMatrix2(matrix, 20));
    }

    @Test
    public void generateMatrix() {
        Assert.assertArrayEquals(new int[][] {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, at.generateMatrix(3));
        Assert.assertArrayEquals(new int[][] {{1}}, at.generateMatrix(1));
    }

    @Test
    public void largestNumber() {
        Assert.assertEquals("0", at.largestNumber(new int[] {0, 0}));
        Assert.assertEquals("210", at.largestNumber(new int[] {10, 2}));
        Assert.assertEquals("9534330", at.largestNumber(new int[] {3, 30, 34, 5, 9}));
        Assert.assertEquals("1", at.largestNumber(new int[] {1}));
        Assert.assertEquals("10", at.largestNumber(new int[] {10}));
        Assert.assertEquals("1113111311", at.largestNumber(new int[] {111311, 1113}));
        Assert.assertEquals("83088308830", at.largestNumber(new int[] {8308, 8308, 830}));
        Assert.assertEquals("9999999991", at.largestNumber(new int[] {999999991, 9}));
    }

    @Test
    public void arrayPairSum() {
        Assert.assertEquals(4, at.arrayPairSum(new int[] {1, 4, 3, 2}));
        Assert.assertEquals(9, at.arrayPairSum(new int[] {6,2,6,5,1,2}));
    }

    @Test
    public void nextGreaterElement() {
        Assert.assertArrayEquals(new int[]{-1, 3, -1}, at.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
        Assert.assertArrayEquals(new int[]{3, -1}, at.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4}));
    }

    @Test
    public void nextGreaterElements() {
        Assert.assertArrayEquals(new int[]{2, -1, 2}, at.nextGreaterElements(new int[]{1, 2, 1}));
    }

    @Test
    public void nextGreaterElement1() {
        Assert.assertEquals(1243, at.nextGreaterElement(1234));
        Assert.assertEquals(21, at.nextGreaterElement(12));
        Assert.assertEquals(-1, at.nextGreaterElement(21));
        Assert.assertEquals(-1, at.nextGreaterElement(2147483647));
        Assert.assertEquals(-1, at.nextGreaterElement(2147483387));
    }

    @Test
    public void dailyTemperatures() {
        Assert.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                at.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    @Test
    public void trap() {
        Assert.assertEquals(6, at.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Assert.assertEquals(9, at.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    public void trap02() {
        Assert.assertEquals(6, at.trap02(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Assert.assertEquals(9, at.trap02(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    public void trap01() {
        Assert.assertEquals(6, at.trap01(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Assert.assertEquals(9, at.trap01(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    public void topKsFrequent() {
        Assert.assertArrayEquals(new int[]{2, 1}, at.topKsFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        Assert.assertArrayEquals(new int[]{1}, at.topKsFrequent(new int[]{1}, 1));
    }

    @Test
    public void minimumSize() {
        Assert.assertEquals(3, at.minimumSize(new int[]{9}, 2));
        Assert.assertEquals(2, at.minimumSize(new int[]{2, 4, 8, 2}, 4));
        Assert.assertEquals(7, at.minimumSize(new int[]{7, 17}, 2));
    }

    @Test
    public void countBalls() {
        Assert.assertEquals(2, at.countBalls(1, 10));
        Assert.assertEquals(2, at.countBalls(5, 15));
        Assert.assertEquals(2, at.countBalls(19, 28));
    }

    @Test
    public void restoreArray() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4}, at.restoreArray(new int[][]{{2, 1}, {3, 4}, {3, 2}}));
        Assert.assertArrayEquals(new int[]{-2, 4, 1, -3}, at.restoreArray(new int[][]{{4, -2}, {1, 4}, {-3, 1}}));
        Assert.assertArrayEquals(new int[]{100000, -100000}, at.restoreArray(new int[][]{{100000, -100000}}));
    }

    @Test
    public void matrixReshape() {
        Assert.assertArrayEquals(new int[][]{{1, 2, 3, 4}}, at.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
        Assert.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, at.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4));
    }

    @Test
    public void searchRange() {
        Assert.assertArrayEquals(new int[]{2, 5}, at.searchRange(new int[]{1, 2, 3, 3, 3, 3, 4, 5, 9}, 3));
        Assert.assertArrayEquals(new int[]{3, 4}, at.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertArrayEquals(new int[]{-1, -1}, at.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Assert.assertArrayEquals(new int[]{-1, -1}, at.searchRange(new int[]{}, 0));
    }

    @Test
    public void largestRectangleArea() {
        Assert.assertEquals(0, at.largestRectangleArea(new int[]{0, 0}));
        Assert.assertEquals(2, at.largestRectangleArea(new int[]{1, 2}));
        Assert.assertEquals(2, at.largestRectangleArea(new int[]{2, 1}));
        Assert.assertEquals(10, at.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    @Test
    public void largestRectangleArea01() {
        Assert.assertEquals(0, at.largestRectangleArea01(new int[]{0, 0}));
        Assert.assertEquals(2, at.largestRectangleArea01(new int[]{1, 2}));
        Assert.assertEquals(2, at.largestRectangleArea01(new int[]{2, 1}));
        Assert.assertEquals(10, at.largestRectangleArea01(new int[]{2, 1, 5, 6, 2, 3}));
    }

    @Test
    public void maximalRectangleCommon() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0' , '0'},
                {'1', '0', '1', '1' , '1'},
                {'1', '1', '1', '1' , '1'},
                {'1', '0', '0', '1' , '0'}
        };

        Assert.assertEquals(6, at.maximalRectangleCommon(matrix));

        matrix = new char[][] {};
        Assert.assertEquals(0, at.maximalRectangleCommon(matrix));

        matrix = new char[][] {{'0'}};
        Assert.assertEquals(0, at.maximalRectangleCommon(matrix));

        matrix = new char[][] {{'1'}};
        Assert.assertEquals(1, at.maximalRectangleCommon(matrix));

        matrix = new char[][] {{'0', '0'}};
        Assert.assertEquals(0, at.maximalRectangleCommon(matrix));
    }

    @Test
    public void maximalRectangle() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0' , '0'},
                {'1', '0', '1', '1' , '1'},
                {'1', '1', '1', '1' , '1'},
                {'1', '0', '0', '1' , '0'}
        };

        Assert.assertEquals(6, at.maximalRectangle(matrix));

        matrix = new char[][] {};
        Assert.assertEquals(0, at.maximalRectangle(matrix));

        matrix = new char[][] {{'0'}};
        Assert.assertEquals(0, at.maximalRectangle(matrix));

        matrix = new char[][] {{'1'}};
        Assert.assertEquals(1, at.maximalRectangle(matrix));

        matrix = new char[][] {{'0', '0'}};
        Assert.assertEquals(0, at.maximalRectangle(matrix));
    }

    @Test
    public void firstMissingPositive() {
        Assert.assertEquals(2, at.firstMissingPositive(new int[]{3, 4, -1, 1}));
        Assert.assertEquals(3, at.firstMissingPositive(new int[]{1, 2, 0}));
        Assert.assertEquals(1, at.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}