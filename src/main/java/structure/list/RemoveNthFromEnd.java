package structure.list;

/**
 * 删除链表的倒数第 N 个节点。
 * <p>
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/03 21:40
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEndTwice(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = 0;
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        int step = length - n;
        first = dummy;
        while (step > 0) {
            step--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEndOnce(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public ListNode removeNth(ListNode head, int n) {
        ListNode tmp = head;
        ListNode first = tmp;
        ListNode second = tmp;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return tmp.next;
    }

}
