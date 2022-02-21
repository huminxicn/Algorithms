package practice.leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。。
 * <p>
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * <p>
 * 那么，利用回文串的特点，定义 2个指针 分别指向字符串的 头/尾。
 * <p>
 * 当2个指针遇到的字符相同时，左指针向右移动 ->，右指针向左移动 <-。（两个指针 同时 移动）
 * 当2个指针遇到的字符不相同，只要保证，跳过 这一个不同的字符，后面的字符串 任然 是回文串即可。
 * 那么，这个时候就会有两个选择，可以移动左指针，或者移动右指针。（只移动一个指针）
 * <p>
 * 作者：fengziL
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii/solution/shuang-zhi-zhen-3fen-jian-ji-dai-ma-680-2l707/
 * 来源：力扣（LeetCode）
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/12 23:54
 */
public class LT680 {
    public static void main(String[] args) {
        System.out.println(validPalindrome("abc"));
    }

    public static boolean validPalindrome(String s) {
        if (s == null || s.length() <= 2) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                //当字符串不匹配时，可以把指针往左或者往右移一位，如果此时能匹配上，则返回 true。
                if (isOk(s, left + 1, right) || isOk(s, left, right - 1)) {
                    return true;
                }
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isOk(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
