package practice.leetcode.list;

/**
 * 两数相加。
 * <p>
 * https://leetcode-cn.com/problems/add-two-numbers/
 * <p>
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/21 20:41
 */
public class LT2 {
    /**
     * 需要分两个变量来处理加和位和进位。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int bit = 0;
        int carry = 0;
        ListNode head = new ListNode();
        ListNode current = head;
        //当 l1 和 l2 都不为 null 时，按位相加。
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry);
            bit = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(bit);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        //当 l1 为 null 时，需要处理进位和 l2。
        if (l1 == null) {
            processCarry(carry, l2, current);
        } else {
            //当 l2 为 null 时，需要处理进位和 l1。
            processCarry(carry, l1, current);
        }
        return head.next;
    }

    /**
     * 处理进位
     */
    public void processCarry(int carry, ListNode remainListNode, ListNode current) {
        int bit = 0;
        // 可能存在进位为 1，剩余为 999 的情况，此时会发生连续进位。
        while (carry != 0 && remainListNode != null) {
            int sum = (remainListNode.val + carry);
            bit = sum % 10;
            carry = sum / 10;
            current.next = new ListNode(bit);
            current = current.next;
            remainListNode = remainListNode.next;
        }
        //判断最高位是进位的情况。
        if (carry != 0) {
            current.next = new ListNode(carry);
        } else {
            current.next = remainListNode;
        }
    }
}
