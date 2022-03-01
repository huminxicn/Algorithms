package practice.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串。
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/22 18:46
 */
public class LT3 {
    public static void main(String[] args) {
        System.out.println(LT3.lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 1.可以使用两个指针表示字符串中的某个子串的左右边界，其中左指针代表着子串的起始位置，右指针代表最长不重复的子串的位置。
     * 2.如果字符串一直不重复，则右指针一直往右滑。碰到重复字符串时，记录当前子串值，并与最大子串值进行比较。同时将左指针往右移一位，然后继续判断有没有重复。如果还有重复，继续将左指针往右移一位。
     * 3.需要一个记录当前子串的数据结构，用来判断字符串是否有重复。
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        //最长不重复的子串长度
        int maxLength = 0;
        //用来保存当前子串
        Set<Character> subStringSet = new HashSet<>(s.length());
        //左指针
        int left = 0;
        //右指针
        int right = 0;
        while (left < s.length()) {
            while (right < s.length()) {
                if (subStringSet.contains(s.charAt(right))) {
                    maxLength = Math.max(subStringSet.size(), maxLength);
                    subStringSet.remove(s.charAt(left));
                    break;
                } else {
                    subStringSet.add(s.charAt(right));
                    right++;
                }
            }
            maxLength = Math.max(subStringSet.size(), maxLength);
            left++;
        }
        return maxLength;
    }
}
