package practice.nc.list;

/**
 * 反转链表
 * https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=117&&tqId=37777&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给定一个单链表的头结点pHead，长度为n，反转该链表后，返回新链表的表头。
 * 数据范围： n\leq1000n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/11/24 19:58
 */
public class NC78 {
    public ListNode ReverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}

