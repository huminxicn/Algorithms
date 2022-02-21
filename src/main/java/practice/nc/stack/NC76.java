package practice.nc.stack;

import java.util.Stack;

/**
 * 用两个栈实现队列。
 * https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=117&&tqId=37774&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 * <p>
 * 数据范围： n\le1000n≤1000
 * 要求：存储n个元素的空间复杂度为 O(n)O(n) ，插入与删除的时间复杂度都是 O(1)O(1)
 * <p>
 * push 操作就直接往 stack1 中 push，
 * pop 操作需要分类一下：
 * 如果 stack2 为空，那么需要将 stack1 中的数据转移到 stack2 中，然后再对 stack2 进行 pop，
 * 如果 stack2 不为空，直接 pop 就 ok。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/04 15:58
 */
public class NC76 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push 操作就直接往 stack1 中 push，
     * pop 操作需要分类一下：
     * 如果 stack2 为空，那么需要将 stack1 中的数据转移到 stack2 中，然后再对 stack2 进行 pop，
     * 如果 stack2 不为空，直接 pop 就 ok。
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

}
