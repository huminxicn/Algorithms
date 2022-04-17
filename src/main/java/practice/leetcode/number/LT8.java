package practice.leetcode.number;

/**
 * 字符串转换整数 (atoi)。
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 1.读入字符串并丢弃无用的前导空格。
 * 2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 5.如果整数数超过 32 位有符号整数范围 [−2^31,2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 6.返回整数作为最终结果。
 * <p>
 * 注意：
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/13 19:00
 */
public class LT8 {
    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }

    public static int myAtoi(String s) {
        //1.去掉前导空格。
        int i = 0;
        int length = s.length();
        while (i < length && s.charAt(i) == ' ') {
            i++;
        }
        int start = i;
        //默认为正数
        int sign = 1;
        int ans = 0;
        //2.检查下一个字符是正号还是负号，读取该字符。
        for (; i < length; i++) {
            char c = s.charAt(i);
            if (i == start && c == '-') {
                sign = -1;
            } else if (i == start && c == '+') {
                sign = 1;
            } else if (Character.isDigit(c)) {
                int num = c - '0';
                if (ans < Integer.MIN_VALUE / 10 || (ans == -214748364 && num > 8)) {
                    return Integer.MIN_VALUE;
                }
                if (ans > Integer.MAX_VALUE / 10 || (ans == 214748364 && num > 7)) {
                    return Integer.MAX_VALUE;
                }
                ans = ans * 10 + sign * num;
            } else {
                break;
            }
        }
        return ans;
    }
}
