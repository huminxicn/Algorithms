package practice.nc.stack;

import java.util.Stack;

/**
 * 有效括号序列。
 * https://www.nowcoder.com/practice/37548e94a270412c8b9fb85643c8ccc2?tpId=117&&tqId=37749&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * <p>
 * 数据范围：字符串长度 0\le n \le 100000≤n≤10000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/12 22:39
 */
public class NC52 {
    /**
     * 建立一个栈，存储遍历的字符串再进行对比
     * 1、遍历字符串遇到 ‘(’ '[' '{' 左括号，就把相应的右括号（‘)’ ']' '}'）入栈
     * 2、如果遍历遇到右括号 ‘)’ ']' '}' ，则判断是否和栈顶元素相同
     * 2.1、不同则直接返回false
     * 2.2、相同则将栈顶元素出栈
     * 3、遍历结束判断栈是否为空
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public static boolean isValid(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            // 碰到左括号，就把相应的右括号入栈。
            if (c.equals('{')) {
                stack.push('}');
            } else if (c.equals('[')) {
                stack.push(']');
            } else if (c.equals('(')) {
                stack.push(')');
            }
            // 如果是右括号判断是否和栈顶元素匹配
            else if (stack.isEmpty() || !c.equals(stack.pop())) {
                return false;
            }
        }
        //最后判断栈中元素是否剩余
        return stack.isEmpty();
    }
}
