package structure.list;

/**
 * 反转单向链表。
 * <p>
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/03 14:06
 */
public class ReverseSinglyLinkedList {
    /**
     * 单链表反转
     *
     * @param head
     * @return
     */
    public ListNode reverseListIterate(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }


    public ListNode reverseListRecurse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseListRecurse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}
