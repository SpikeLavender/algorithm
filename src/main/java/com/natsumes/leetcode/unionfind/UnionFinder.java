package com.natsumes.leetcode.unionfind;

import java.util.*;

/**
 * 并查集
 *
 * <a href="https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph/">323.无向图中连通分量的数目</a>
 * @see UnionFinder#countComponents(int, int[][])
 *
 * <a href="https://leetcode-cn.com/problems/graph-valid-tree/">261.以图判树</a>
 * @see UnionFinder#validTree(int, int[][])
 *
 * <a href="https://leetcode-cn.com/problems/number-of-islands-ii/">305.岛屿数量 II</a>
 * @see UnionFinder#numIslands2(int, int, int[][])
 *
 * <a href="https://leetcode-cn.com/problems/similar-string-groups/">839.相似字符串组</a>
 * @see UnionFinder#numSimilarGroups(java.lang.String[])
 *
 * <a href="https://leetcode-cn.com/problems/number-of-islands/">200.岛屿数量 </a>
 * @see UnionFinder#numIslands(char[][])
 *
 * <a href="https://leetcode-cn.com/problems/satisfiability-of-equality-equations/">990.等式方程的可满足性</a>
 * @see UnionFinder#equationsPossible(java.lang.String[])
 *
 * <a href="https://leetcode-cn.com/problems/surrounded-regions/">130.被围绕的区域</a>
 * @see UnionFinder#solve(char[][])
 *
 * <a href="https://leetcode-cn.com/problems/longest-consecutive-sequence/">128.最长连续序列</a>
 * @see UnionFinder#longestConsecutive(int[])
 *
 * <a href="https://leetcode-cn.com/problems/number-of-provinces/">547.省份数量</a>
 * @see UnionFinder#findCircleNum(int[][])
 *
 * <a href="https://leetcode-cn.com/problems/redundant-connection/">684.冗余连接</a>
 * @see UnionFinder#findRedundantConnection(int[][])
 *
 * <a href="https://leetcode-cn.com/problems/accounts-merge/">721.账户合并</a>
 * @see UnionFinder#accountsMerge(java.util.List)
 *
 * <a href="https://leetcode-cn.com/problems/bricks-falling-when-hit/">803.打砖块</a>
 * @see UnionFinder#hitBricks(int[][], int[][])
 *
 * @author hetengjiao
 */
public class UnionFinder {

    /**
     * 323. 无向图中连通分量的数目
     * 给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。
     *
     * 示例 1:
     *
     * 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
     *
     *      0          3
     *      |          |
     *      1 --- 2    4
     *
     * 输出: 2
     * 示例 2:
     *
     * 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
     *
     *      0           4
     *      |           |
     *      1 --- 2 --- 3
     *
     * 输出:  1
     * 注意:
     * 你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0]  相同，所以它们不会同时在 edges 中出现。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @see com.natsumes.leetcode.unionfind.UnionFinder#countComponents(int, int[][])
     */
    public int countComponents(int n, int[][] edges) {
        Union union = new Union(n);
        for (int[] edge : edges) {
            union.union(edge[0], edge[1]);
        }
        return union.count();
    }

    /**
     * 261. 以图判树
     * 给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），
     * 请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。
     *
     * 示例 1：
     *
     * 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
     * 输出: true
     * 示例 2:
     *
     * 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
     * 输出: false
     * 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，
     * 因此不会同时出现在边列表 edges 中。
     */
    public boolean validTree(int n, int[][] edges) {
        Union union = new Union(n);
        for (int[] edge : edges) {
            if (union.connect(edge[0], edge[1])) {
                return false;
            }
            union.union(edge[0], edge[1]);
        }
        return union.count() == 1;
    }

    /**
     * 305. 岛屿数量 II
     * 假设你设计一个游戏，用一个 m 行 n 列的 2D 网格来存储你的游戏地图。
     *
     * 起始的时候，每个格子的地形都被默认标记为「水」。我们可以通过使用 addLand 进行操作，
     * 将位置 (row, col) 的「水」变成「陆地」。
     *
     * 你将会被给定一个列表，来记录所有需要被操作的位置，然后你需要返回计算出来 每次 addLand 操作后岛屿的数量。
     *
     * 注意：一个岛的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。
     * 你可以假设地图网格的四边均被无边无际的「水」所包围。
     *
     * 请仔细阅读下方示例与解析，更加深入了解岛屿的判定。
     *
     * 示例:
     *
     * 输入: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
     * 输出: [1,1,2,3]
     * 解析:
     *
     * 起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
     *
     * 0 0 0
     * 0 0 0
     * 0 0 0
     * 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。
     *
     * 1 0 0
     * 0 0 0   Number of islands = 1
     * 0 0 0
     * 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。
     *
     * 1 1 0
     * 0 0 0   岛屿的数量为 1
     * 0 0 0
     * 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。
     *
     * 1 1 0
     * 0 0 1   岛屿的数量为 2
     * 0 0 0
     * 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。
     *
     * 1 1 0
     * 0 0 1   岛屿的数量为 3
     * 0 1 0
     * 拓展：
     *
     * 你是否能在 O(k log mn) 的时间复杂度程度内完成每次的计算？（k 表示 positions 的长度）
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        Union union = new Union(m * n + 1);
        int dummy = m * n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                union.union(i * n + j, dummy);
            }
        }

        for (int[] position : positions) {
            if (union.connect(position[0] * n + position[1], dummy)) {
                union.breakUnion(position[0] * n + position[1]);
                int[][] d = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
                for (int k = 0; k < 4; k++) {
                    int x = position[0] + d[k][0];
                    int y = position[1] + d[k][1];
                    if (x >= 0 && y >= 0 && x < m && y < n && !union.connect(x * n + y, dummy)) {
                        union.union(position[0] * n + position[1], x * n + y);
                    }
                }
            }
            res.add(union.count() - 1);
        }
        return res;
    }

    /**
     * 839. 相似字符串组
     * 如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。
     * 如果这两个字符串本身是相等的，那它们也是相似的。
     *
     * 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，
     * 但是 "star" 不与 "tars"，"rats"，或 "arts" 相似。
     *
     * 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同一组中，
     * 即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。
     *
     * 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？
     *
     *
     *
     * 示例 1：
     *
     * 输入：strs = ["tars","rats","arts","star"]
     * 输出：2
     * 示例 2：
     *
     * 输入：strs = ["omv","ovm"]
     * 输出：1
     *
     *
     * 提示：
     *
     * 1 <= strs.length <= 100
     * 1 <= strs[i].length <= 1000
     * sum(strs[i].length) <= 2 * 104
     * strs[i] 只包含小写字母。
     * strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。
     *
     *
     * 备注：
     *
     *       字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。
     */
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        Union union = new Union(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i; j < len; j++) {
                if (check(strs[i], strs[j], strs[i].length())) {
                    union.union(i, j);
                }
            }
        }
        return union.count();
    }

    private boolean check(String s1, String s2, int len) {
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 200. 岛屿数量
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     *
     *
     * 示例 1：
     *
     * 输入：grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 示例 2：
     *
     * 输入：grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * 输出：3
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Union union = new Union(m * n + 1);
        int dummy = m * n;
        int[][] d = new int[][] {{0 , 1}, {1, 0}, {-1, 0}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == '1') {
                            union.union(i * n + j, x * n + y);
                        }
                    }
                } else {
                    union.union(dummy, i * n + j);
                }
            }
        }

        return union.count() - 1;
    }

    /**
     * 990. 等式方程的可满足性
     * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
     *
     * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
     * 并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
     *
     * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
     *
     *
     *
     * 示例 1：
     *
     * 输入：["a==b","b!=a"]
     * 输出：false
     * 解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。
     * 没有办法分配变量同时满足这两个方程。
     * 示例 2：
     *
     * 输入：["b==a","a==b"]
     * 输出：true
     * 解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
     * 示例 3：
     *
     * 输入：["a==b","b==c","a==c"]
     * 输出：true
     * 示例 4：
     *
     * 输入：["a==b","b!=c","c==a"]
     * 输出：false
     * 示例 5：
     *
     * 输入：["c==c","b==d","x!=z"]
     * 输出：true
     *
     *
     * 提示：
     *
     * 1 <= equations.length <= 500
     * equations[i].length == 4
     * equations[i][0] 和 equations[i][3] 是小写字母
     * equations[i][1] 要么是 '='，要么是 '!'
     * equations[i][2] 是 '='
     */
    public boolean equationsPossible(String[] equations) {
        Union union = new Union(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                union.union(x - 'a', y - 'a');
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                char x = equation.charAt(0);
                char y = equation.charAt(3);
                if (union.connect(x - 'a', y - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 130. 被围绕的区域
     *
     * https://leetcode-cn.com/problems/surrounded-regions/
     *
     * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
     *
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     *
     * 示例:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * 运行你的函数后，矩阵变为：
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * 解释:
     *
     * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，
     * 或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
     */
    public void solve(char[][] board) {
        // 并查集
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        Union union = new Union(m * n + 1);
        int dummy = m * n;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O'){
                union.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                union.union(i * n + n - 1, dummy);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O'){
                union.union(j, dummy);
            }
            if (board[m - 1][j] == 'O') {
                union.union((m - 1) * n + j, dummy);
            }
        }

        int[][] d = new int[][] {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            union.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!union.connect(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * 暴力 dfs 解法 O(MN)
     */
    public void solveByDfs(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }

        for (int i = 0; i < m; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        int n = board.length;
        int m = board[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
    }

    /**
     * 128. 最长连续序列
     *
     * https://leetcode-cn.com/problems/longest-consecutive-sequence/
     *
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int curLongest = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    curLongest += 1;
                }
                longest = Math.max(longest, curLongest);
            }
        }
        return longest;
    }

    /**
     * 547. 省份数量
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，
     * 那么城市 a 与城市 c 间接相连。
     *
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     *
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     *
     * 返回矩阵中 省份 的数量。
     *
     * 示例 1：
     *
     *
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     *
     *
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     *
     *
     * 提示：
     *
     * 1 <= n <= 200
     * n == isConnected.length
     * n == isConnected[i].length
     * isConnected[i][j] 为 1 或 0
     * isConnected[i][i] == 1
     * isConnected[i][j] == isConnected[j][i]
     *
     * @param isConnected isConnected
     * @return int
     */
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length;
        if (m == 0) {
            return 0;
        }
        int n = isConnected[0].length;
        Union union = new Union(n);
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union.union(i, j);
                }
            }
        }
        return union.count();
    }

    /**
     * 684. 冗余连接
     * 在本问题中, 树指的是一个连通且无环的无向图。
     *
     * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。
     * 附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     *
     * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
     *
     * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，
     * 则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
     *
     * 示例 1：
     *
     * 输入: [[1,2], [1,3], [2,3]]
     * 输出: [2,3]
     * 解释: 给定的无向图为:
     *   1
     *  / \
     * 2 - 3
     * 示例 2：
     *
     * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
     * 输出: [1,4]
     * 解释: 给定的无向图为:
     * 5 - 1 - 2
     *     |   |
     *     4 - 3
     * 注意:
     *
     * 输入的二维数组大小在 3 到 1000。
     * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
     *
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Union union = new Union(n);
        for (int[] edge : edges) {
            if (union.connect(edge[0] - 1, edge[1] - 1)) {
                return new int[]{edge[0], edge[1]};
            }
            union.union(edge[0] - 1, edge[1] - 1);
        }
        return null;
    }

    /**
     * 721. 账户合并
     * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，
     * 其余元素是 emails 表示该账户的邮箱地址。
     *
     * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
     * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。
     * 一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
     *
     * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。
     * 账户本身可以以任意顺序返回。
     *
     *
     *
     * 示例 1：
     *
     * 输入：
     * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
     * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     * 输出：
     * [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
     * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     *
     * 解释：
     * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
     * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
     * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
     * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
     *
     *
     * 提示：
     *
     * accounts的长度将在[1，1000]的范围内。
     * accounts[i]的长度将在[1，10]的范围内。
     * accounts[i][j]的长度将在[1，30]的范围内。
     */
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>(16);
        Map<String, String> emailToName = new HashMap<>(16);
        int emailsCount = 0;
        for (List<String> account : accounts) {
            String name = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, emailsCount++);
                    emailToName.put(email, name);
                }
            }
        }

        Union union = new Union(emailsCount);
        for (List<String> account : accounts) {
            String firstEmail = account.get(1);
            int firstIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for (int i = 2; i < size; i++) {
                String nextEmail = account.get(i);
                int nextIndex = emailToIndex.get(nextEmail);
                union.union(firstIndex, nextIndex);
            }
        }

        Map<Integer, List<String>> indexToEmails = new HashMap<>(16);
        for (String email : emailToIndex.keySet()) {
            int index = union.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index, new ArrayList<>());
            account.add(email);
            indexToEmails.put(index, account);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> emails : indexToEmails.values()) {
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            res.add(account);
        }
        return res;
    }

    /**
     * 803. 打砖块
     * 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
     *
     * 一块砖直接连接到网格的顶部，或者
     * 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
     * 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli) 位置上的砖块时，
     * 对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，
     * 它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
     *
     * 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
     *
     * 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。
     *
     *
     *
     * 示例 1：
     *
     * 输入：grid = [[1,0,0,0],[1,1,1,0]], hits = [[1,0]]
     * 输出：[2]
     * 解释：
     * 网格开始为：
     * [[1,0,0,0]，
     *  [1,1,1,0]]
     * 消除 (1,0) 处加粗的砖块，得到网格：
     * [[1,0,0,0]
     *  [0,1,1,0]]
     * 两个加粗的砖不再稳定，因为它们不再与顶部相连，也不再与另一个稳定的砖相邻，因此它们将掉落。得到网格：
     * [[1,0,0,0],
     *  [0,0,0,0]]
     * 因此，结果为 [2] 。
     * 示例 2：
     *
     * 输入：grid = [[1,0,0,0],[1,1,0,0]], hits = [[1,1],[1,0]]
     * 输出：[0,0]
     * 解释：
     * 网格开始为：
     * [[1,0,0,0],
     *  [1,1,0,0]]
     * 消除 (1,1) 处加粗的砖块，得到网格：
     * [[1,0,0,0],
     *  [1,0,0,0]]
     * 剩下的砖都很稳定，所以不会掉落。网格保持不变：
     * [[1,0,0,0],
     *  [1,0,0,0]]
     * 接下来消除 (1,0) 处加粗的砖块，得到网格：
     * [[1,0,0,0],
     *  [0,0,0,0]]
     * 剩下的砖块仍然是稳定的，所以不会有砖块掉落。
     * 因此，结果为 [0,0] 。
     *
     *
     * 提示：
     *
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * grid[i][j] 为 0 或 1
     * 1 <= hits.length <= 4 * 104
     * hits[i].length == 2
     * 0 <= xi <= m - 1
     * 0 <= yi <= n - 1
     * 所有 (xi, yi) 互不相同
     *
     * @param grid grid
     * @param hits hits
     * @return int[]
     */
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] copy = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, copy[i], 0, n);
        }

        for (int[] hit : hits) {
            copy[hit[0]][hit[1]] = 0;
        }
        int dummy = m * n;
        Union union = new Union(m * n + 1);
        for (int j = 0; j < n; j++) {
            if (copy[0][j] == 1) {
                union.union(dummy, j);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 1) {
                    if (copy[i - 1][j] == 1) {
                        union.union((i - 1) * n + j, i * n + j);
                    }
                    if (j > 0 && copy[i][j - 1] == 1) {
                        union.union(i * n + j - 1, i * n + j);
                    }
                }
            }
        }

        int len = hits.length;
        int[] res = new int[len];
        int[][] d = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int i = len - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                continue;
            }
            int origin = union.getSize(dummy);
            if (x == 0) {
                union.union(y, dummy);
            }
            for (int k = 0; k < 4; k++) {
                int newX = x + d[k][0];
                int newY = y + d[k][1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && copy[newX][newY] == 1) {
                    union.union(x * n + y, newX * n + newY);
                }
            }
            int current = union.getSize(dummy);
            res[i] = Math.max(0, current - origin - 1);
            copy[x][y] = 1;
        }
        return res;
    }

    /**
     * 并查集
     */
    private static class Union {

        /**
         * 记录连通分量
         */
        private int count;

        /**
         * 节点 x 的父节点是 parent[x]
         */
        private int[] parent;

        /**
         * 记录树的重量
         */
        private int[] size;

        Union(int n) {
            this.count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        /**
         * 将 p 和 q 连接
         * @param p p
         * @param q q
         */
        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (size[pRoot] > size[qRoot]) {
                parent[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            } else {
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            }
            count--;
        }

        /**
         * 判断p和q是否连通
         * @param p p
         * @param q q
         */
        boolean connect(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            return pRoot == qRoot;
        }

        void breakUnion(int x) {
            //int i = find(x);
            parent[x] = x;
            count++;
        }

        private int find(int x) {
            if (parent[x] != x) {
                // 进行路径压缩
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        /**
         * 返回图中有多少个连通分量
         * @return 连通分量
         */
        int count() {
            return count;
        }

        int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }
}
