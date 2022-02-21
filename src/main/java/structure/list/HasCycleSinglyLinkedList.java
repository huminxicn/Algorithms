package structure.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 判断单向链表是否有环。
 * <p>
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/03 20:05
 */
public class HasCycleSinglyLinkedList {
    public boolean hasCycleHash(ListNode head) {
        Set<ListNode> scanNode = new HashSet<ListNode>();
        while (head != null) {
            if (scanNode.contains(head)) {
                return true;
            } else {
                scanNode.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleFast(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
