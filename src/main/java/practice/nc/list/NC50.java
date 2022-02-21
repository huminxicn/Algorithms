package practice.nc.list;

import java.util.Stack;

/**
 * 链表中的节点每 k 个一组翻转。
 * https://www.nowcoder.com/practice/b49c3dc907814e9bbfa8437c251b028e?tpId=117&&tqId=37746&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * <p>
 * 数据范围： \ 0 \le n \le 2000 0≤n≤2000 ， 1 \le k \le 20001≤k≤2000 ，链表中每个元素都满足 0 \le val \le 10000≤val≤1000
 * 要求空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 例如：
 * 给定的链表是 1\to2\to3\to4\to51→2→3→4→5
 * 对于 k = 2k=2 , 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 k = 3k=3 , 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/04 16:19
 */
public class NC50 {
    /**
     * 将链表分成每段长度为 k 的子链表，将每个链表存入栈中，当栈中有 k 个元素即可一一取出，之后按取出的顺序重组链表就是这一段中翻转的链表。
     * 要注意的是处理尾部不满长度为 k 的链表块时直接取栈底的元素做为最后一段即可。
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || null == head) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode result = new ListNode(0);
        ListNode now = result;
        while (true) {
            for (int i = 0; i < k; i++) {
                stack.push(head);
                head = head.next;
                if (head == null) break;
            }
            if (stack.size() == k) {
                while (!stack.isEmpty()) {
                    now.next = stack.pop();
                    now = now.next;
                    now.next = null;
                }
            }
            if (head == null) break;
        }
        ListNode end = null;
        while (!stack.isEmpty()) {
            end = stack.pop();
        }
        now.next = end;
        return result.next;
    }
}
