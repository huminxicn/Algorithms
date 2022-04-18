package practice.leetcode.string;

import java.util.Arrays;

/**
 * 最长公共前缀。
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/18 19:21
 */
public class LT14 {
    public static void main(String[] args) {
        String[] strings = Arrays.asList("dog", "racecar", "car").toArray(new String[]{});
        System.out.println(longestCommonPrefix(strings));
    }

    /**
     * 可以用双循环解决这个问题。
     * 外循环是数组中第一个字符串的字符，从左到右。
     * 内循环是到目前为止的字符串是否匹配，或者有长度不够的字符串。
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length <= 1) {
            return strs[0];
        }

        StringBuilder ans = new StringBuilder();
        String baseStr = strs[0];
        outSide:
        for (int i = 0; i < baseStr.length(); i++) {
            char c = baseStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < i + 1 || strs[j].charAt(i) != c) {
                    break outSide;
                }
            }
            ans.append(c);
        }
        return ans.toString();
    }
}
