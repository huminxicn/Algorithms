package practice.nc.list;

/**
 * 删除链表的倒数第n个节点。
 * https://www.nowcoder.com/practice/f95dcdafbde44b22a6d741baf71653f6?tpId=117&&tqId=37750&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 * 例如，
 * 给出的链表为: 1\to 2\to 3\to 4\to 51→2→3→4→5, n= 2n=2.
 * 删除了链表的倒数第 nn 个节点之后,链表变为1\to 2\to 3\to 51→2→3→5.
 * <p>
 * 数据范围： 链表长度 0\le n \le 10000≤n≤1000，链表中任意节点的值满足 0 \le val \le 1000≤val≤100
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * 备注：
 * 题目保证 nn 一定是有效的
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/05 22:54
 */
public class NC53 {
    /**
     * 采用快慢指针，慢指针比快指针晚 n 步。
     *
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        //快指针。
        ListNode fast = head;
        //慢指针。
        ListNode slow = head;
        //快指针先往前走 n 步。
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //如果 n 刚好为链表长度，则删除第一个。
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

}
