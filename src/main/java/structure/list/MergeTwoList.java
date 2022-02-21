package structure.list;

/**
 * 合并两个有序链表。
 * <p>
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/03 20:55
 */
public class MergeTwoList {
    public ListNode mergeListRecurse(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeListRecurse(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeListRecurse(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeListIterate(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = (l1 == null ? l2 : l1);
        return preHead.next;
    }

}
