package structure.list;

/**
 * 找到单向链表的中间结点。
 * <p>
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/04 11:01
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        if (head.next == null) {
            return head;
        }
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            length += 2;
        }
        if (fast.next == null) {
            length += 1;
        } else {
            length += 2;
        }
        if (length % 2 == 0) {
            return slow.next;
        } else {
            return slow;
        }
    }
}
