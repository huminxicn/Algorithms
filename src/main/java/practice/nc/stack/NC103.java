package practice.nc.stack;

import java.util.Stack;

/**
 * 反转字符串。
 * https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=117&&tqId=37827&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 数据范围： 0 \le n \le 10000≤n≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/08 23:05
 */
public class NC103 {
    /**
     * 利用入栈出栈进行反转。
     *
     * @param str string字符串
     * @return string字符串
     */
    public String solve(String str) {
        if (null == str || str.length() == 1) {
            return str;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
