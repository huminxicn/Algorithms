package structure.list;

/**
 * 判断一个单向链表是否是回文结构。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/11/17 21:51
 */
public class SingleListIsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverseListIterate(slow);
        fast = head;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

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

    public static void main(String[] args) {
        String s="{\"checkout-js\":\"30\",\"worldpay-card\":\"40\"}";
        System.out.println(s);
    }

}
