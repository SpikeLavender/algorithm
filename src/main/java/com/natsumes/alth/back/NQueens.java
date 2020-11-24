package com.natsumes.alth.back;

/**
 * 回溯算法：N皇后问题
 *
 * 时间复杂度为 O(n!), 实际为 n!/2
 *
 * 优点：
 * 回溯算法的思想非常简单，大部分情况下，都是用来解决广义的搜索问题，也就是，从一组可能的解
 * 中，选择出一个满足要求的解。回溯算法非常适合用递归来实现，在实现的过程中，剪枝操作是提高回
 * 溯效率的一种技巧。利用剪枝，我们并不需要穷举搜索所有的情况，从而提高搜索效率。
 * 劣势：
 * 效率相对于低（动态规划）
 *
 * 适用场景
 * 回溯算法是个“万金油”。基本上能用的动态规划、贪心解决的问题，我们都可以用回溯算法解决。回溯
 * 算法相当于穷举搜索。穷举所有的情况，然后对比得到最优解。不过，回溯算法的时间复杂度非常高，
 * 是指数级别的，只能用来解决小规模数据的问题。对于大规模数据的问题，用回溯算法解决的执行效率
 * 就很低了
 *
 * @author hetengjiao
 */
public class NQueens {

    /**
     * 皇后数
     */
    private static int QUEENS_NUM = 8;

    /**
     * 下标表示行,值表示queen存储在哪一列
     */
    private int[] result = new int[QUEENS_NUM];

    /**
     * 在每行放置Queen
     */
    public void setQueens(int row) {
        //递归中断
        if (row == QUEENS_NUM) {
            printQueens();
            return;
        }
        //在每行依次放置列 没有合适的则回到上一层
        for(int col = 0; col < QUEENS_NUM; col++){
            if (isOk(row, col)) {
                //设置列
                result[row] = col;
                //开始下一行
                setQueens(row + 1);
            }
        }
    }

    /**
     * 判断是否可放置
     */
    private boolean isOk(int row, int col) {
        int leftUp = col -1;
        int rightUp = col + 1;
        // 逐行往上考察每一行
        for (int i = row - 1; i >= 0; i--) {
            //列上存在queen
            if (result[i] == col) {
                return false;
            }
            //左上对角线存在queen
            if (leftUp >= 0 && result[i] == leftUp) {
                return false;
            }
            //右下对角线存在queen
            if (rightUp < QUEENS_NUM && result[i] == rightUp) {
                return false;
            }
            leftUp--;
            rightUp++;
        }
        return true;
    }

    private void printQueens() {
        for (int i = 0; i < QUEENS_NUM; i++) {
            for (int j = 0; j < QUEENS_NUM; j++) {
                if (result[i] == j) {
                    System.out.print("Q| ");
                } else {
                    System.out.print("*| ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }
}
