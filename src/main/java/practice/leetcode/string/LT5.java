package practice.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长回文子串。
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/24 20:10
 */
public class LT5 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("adbabd"));
    }


    /**
     * 动态规划。空间换时间。
     * <p>
     * 所以如果我们想知道 P（i,j）P（i,j）的情况，不需要调用判断回文串的函数了，只需要知道 P（i + 1，j - 1）P（i+1，j−1）的情况就可以了，这样时间复杂度就少了 O(n)。
     * 因此我们可以用动态规划的方法，空间换时间，把已经求出的 P（i，j）存储起来。
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLen = 0;
        String maxStr = "";
        //遍历所有长度
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                //下标已越界，结束本次循环。
                if (end >= length) {
                    break;
                }
                //长度为 1 和 2 的单独判断下
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1])
                        && s.charAt(start) == s.charAt(end);
                if (dp[start][end] && len > maxLen) {
                    maxStr = s.substring(start, end + 1);
                }
            }
        }
        return maxStr;
    }

//    /**
//     * 暴力解法。
//     * 将字符串划分成子串，再一一判断子串是否是回文子串。可以从长子串开始判断。
//     *
//     * @param s
//     * @return
//     */
//    public static String longestPalindrome(String s) {
//        if (s.length() <= 1) {
//            return s;
//        }
//        for (int i = s.length(); i > 0; i--) {
//            List<String> list = truncateString(s, i);
//            for (int j = 0; j < list.size(); j++) {
//                if (isPalindrome(list.get(j))) {
//                    return list.get(j);
//                }
//            }
//        }
//        return null;
//    }
//
//    /**
//     * 将字符串按指定长度分隔。
//     *
//     * @param str
//     * @param n
//     * @return
//     */
//    public static List<String> truncateString(String str, int n) {
//        int index = 0;
//        List<String> subStringList = new ArrayList<>();
//        while (index <= str.length() - n) {
//            subStringList.add(str.substring(index, index + n));
//            index++;
//        }
//        return subStringList;
//    }
//
//    /**
//     * 判断字符串是否是回文串。
//     *
//     * @param str
//     * @return
//     */
//    public static boolean isPalindrome(String str) {
//        if (str.length() <= 1) {
//            return true;
//        }
//        int left = 0;
//        int right = str.length() - 1;
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
}
