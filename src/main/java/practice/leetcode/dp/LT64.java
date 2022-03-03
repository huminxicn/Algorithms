package practice.leetcode.dp;

/**
 * 最小路径和。
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * <p>
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/03/02 23:52
 */
public class LT64 {
    /**
     * 1.定义数组的含义。
     * 当机器人从左上角走到 [i, j] 这个位置时，最小的路径和是 dp[i][j]。那么，dp[m-1][n-1] 就是我们要的答案了。
     * 2.找出数组元素间的关系式。
     * 机器人从 [i-1][j] 这个位置走一步到达。
     * 机器人从 [i][j-1] 这个位置走一步到达。
     * 不过这次不是计算所有可能路径，而是计算哪一个路径和是最小的。
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + arr[i][j]; //arr[i][j] 表示网格中的值。
     * 3.找初始值
     * 当 dp[i][j] 中如果 i 或者 j 为 0 时，i-1 或 j-1 为负数，数组越界了，此时就不能使用关系式。
     * dp[0][j] = dp[0][j-1] + arr[0][j]; // 相当于最上面一行，机器人只能一直往右走
     * dp[i][0] = dp[i-1][0] + arr[i][0]; // 相当于最左面一列，机器人只能一直往下走
     * 所以需要初始化所有的 dp[i][0] 和 dp[0][j]。
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        //1.定义 dp[i][j]
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //2.初始化
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //3.推导出 dp[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
