package practice.nc.list;

/**
 * 判断链表中是否有环。
 * https://www.nowcoder.com/practice/650474f313294468a4ded3ce0f7898b9?tpId=117&&tqId=37714&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 * <p>
 * <p>
 * 数据范围：链表长度 0 \le n \le 100000≤n≤10000，链表中任意节点的值满足 |val| <= 100000∣val∣<=100000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 输入分为2部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。-1代表无环，其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/05 22:17
 */
public class NC4 {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
