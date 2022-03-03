package practice.leetcode.dp;

/**
 * 不同路径。
 * https://leetcode-cn.com/problems/unique-paths/
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 *
 * @author huminxi2017@gmail.com
 * @since 2022/03/01 19:20
 */
public class LT62 {
    /**
     * 1.定义数组的含义。
     * dp[i][j] 表示当机器人从左上角走到 [i][j] 位置时，一共有 dp[i][j] 种路径。那么 dp[m-1][n-1] 就是答案。
     * 2.找出数组元素间的关系式。
     * 机器人从 [i-1][j] 这个位置走一步到达。
     * 机器人从 [i][j-1] 这个位置走一步到达。
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]。
     * 3.找初始值
     * 当 dp[i][j] 中如果 i 或者 j 为 0 时，i-1 或 j-1 为负数，数组越界了，此时就不能使用关系式。
     * dp[0][j] = 1，相当于最上面一行，机器人只能一直往右走。
     * dp[i][0] = 1，相当于最左边一列，机器人只能一直往下走。
     * 所以需要初始化所有的 dp[i][0] 和 dp[0][j]。
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        //1.定义 dp[i][j]
        int[][] dp = new int[m][n];
        //2.初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //3.推导出 dp[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
