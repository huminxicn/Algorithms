package practice.leetcode.dp;

/**
 * 编辑距离。
 * https://leetcode-cn.com/problems/edit-distance/
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * @author huminxi2017@gmail.com
 * @since 2022/03/03 00:18
 */
public class LT72 {
    /**
     * 1.定义数组的含义。
     * 当字符串 word1 的长度为 i，字符串 word2 的长度为 j 时，将 word1 转化为 word2 所使用的最少操作次数为 dp[i][j]。
     * 2.找出数组元素间的关系式。
     * 由于我们是要让操作的次数最小，所以我们要寻找最佳操作。那么有如下关系式：
     * 如果我们 word1[i] 与 word2 [j] 相等，这个时候不需要进行任何操作
     * --此时 dp[i][j] = dp[i-1][j-1]。
     * 如果我们 word1[i] 与 word2 [j] 不相等，这个时候我们就必须进行调整，而调整的操作有 3 种，我们要选择一种：
     * --如果把字符 word1[i] 替换成与 word2[j] 相等，则有 dp[i][j] = dp[i-1][j-1] + 1;
     * --如果在字符串 word1 末尾插入一个与 word2[j] 相等的字符，则有 dp[i][j] = dp[i][j-1] + 1;
     * --如果把字符 word1[i] 删除，则有 dp[i][j] = dp[i-1][j] + 1;
     * --此时 dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[[i-1][j]]) + 1;
     * 3.找初始值
     * 当 dp[i][j] 中如果 i 或者 j 为 0 时，i-1 或 j-1 为负数，数组越界了，此时就不能使用关系式。
     * 所以需要初始化所有的 dp[i][0] 和 dp[0][j]。
     * 因为当有一个字符串的长度为 0 时，转化为另外一个字符串，那就只能一直进行插入或者删除操作了。
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        //1.定义 dp[i][j]
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        //2.初始化
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        //3.推导出 dp[i][j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
