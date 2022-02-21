package structure.stack;

import java.util.HashMap;
import java.util.Stack;

/**
 * 有效地括号。
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/04 20:55
 */
public class ValidParentheses {
    private HashMap<Character, Character> map;

    public ValidParentheses() {
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
