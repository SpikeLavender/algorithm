package com.natsumes.daily;

/**
 * @author hetengjiao
 */
public class MaximalRectangle {

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     *  
     *
     * 示例 1：
     *      1   0   1   0   0
     *      1   0   1   1   1
     *      1   1   1   1   1
     *      1   0   0   1   0
     *
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     *
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     *
     * 输入：matrix = [["0"]]
     * 输出：0
     * 示例 4：
     *
     * 输入：matrix = [["1"]]
     * 输出：1
     * 示例 5：
     *
     * 输入：matrix = [["0","0"]]
     * 输出：0
     *  
     *
     * 提示：
     *
     * rows == matrix.length
     * cols == matrix[0].length
     * 0 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maximalRectangle(char[][] matrix) {
        return doMaximalRectangle(matrix);
    }

    /**
     * 解法二： 单调队列 todo
     */
    public int doMaximalRectangle(char[][] matrix) {
        return 0;
    }

    /**
     * 暴力破解法
     */
    public int doMaximalRectangleCommon(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int maxArea = 0;
        int[][] width = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == '1') {
                    if (col == 0) {
                        width[row][col] = 1;
                    } else {
                        // 递归思想，数学归纳法
                        width[row][col] = width[row][col - 1] + 1;
                    }
                } else {
                  width[row][col] = 0;
                }
                //记录所有行中最小的数
                int minWidth = width[row][col];
                for (int up = row; up >= 0; up--) {
                    int height = row - up + 1;
                    minWidth = Math.min(minWidth, width[up][col]);
                    maxArea = Math.max(maxArea, height * minWidth);
                }
            }
        }
        return maxArea;
    }
}
