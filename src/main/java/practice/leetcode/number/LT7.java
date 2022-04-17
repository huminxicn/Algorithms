package practice.leetcode.number;

import java.util.Stack;

/**
 * 整数反转。
 * https://leetcode-cn.com/problems/reverse-integer/
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31,2^31− 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/11 19:07
 */
public class LT7 {
    public static void main(String[] args) {
        System.out.println(reverse(-2123456789));
    }

    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x = x / 10;
            result = result * 10 + digit;
        }
        return result;
    }
//    //1.先将 x 转成 String，然后反转 String 的数字部分。
//    //2.判断反转之后的数字有没有超过范围。
//    public static int reverse(int x) {
//        if (x == 0) {
//            return x;
//        }
//        String num = String.valueOf(x);
//        String numReverse = null;
//        if (x < 0) {
//            numReverse = "-" + reverse(num.substring(1, num.length()));
//        } else {
//            numReverse = reverse(num);
//        }
//        if (Long.parseLong(numReverse) > (long) Integer.MAX_VALUE
//                || Long.parseLong(numReverse) < (long) Integer.MIN_VALUE) {
//            return 0;
//        }
//        return Integer.parseInt(numReverse);
//    }
//
//    public static String reverse(String s) {
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            stack.push(s.charAt(i));
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()) {
//            sb.append(stack.pop());
//        }
//        return sb.toString();
//    }
}
