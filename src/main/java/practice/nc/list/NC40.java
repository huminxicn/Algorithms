package practice.nc.list;

/**
 * 两个链表生成相加链表。
 * <p>
 * https://www.nowcoder.com/practice/c56f6c70fb3f4849bc56e33ff2a50b6b?tpId=117&&tqId=37814&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/25 19:54
 */
public class NC40 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.createList(new int[]{9});
        ListNode l2 = ListNode.createList(new int[]{6});
        ListNode listNode = addInList(l1, l2);
        ListNode.print(listNode);
    }

    /**
     * 先把两个链表反转，然后按位加，最后把结果链表反转。
     *
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        //1.反转链表
        ListNode l1 = reverse(head1);
        ListNode l2 = reverse(head2);
        //2.按位加
        ListNode add = add(l1, l2);
        //3.反转结果
        return reverse(add);
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        int carry = 0;
        int bit = 0;
        while (l1 != null && l2 != null) {
            int sum = (l1.val + l2.val + carry);
            bit = sum % 10;
            carry = sum / 10;
            if (result != null) {
                result.next = new ListNode(bit);
                result = result.next;
            } else {
                result = new ListNode(bit);
                head = result;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null && l2 != null) {
            processCarry(l2, carry, result);
        } else {
            processCarry(l1, carry, result);
        }
        return head;
    }

    /**
     * 处理进位
     *
     * @param listNode
     * @param result
     * @return
     */
    public static void processCarry(ListNode listNode, int carry, ListNode result) {
        result.next = listNode;
        //如果是 999 + 1 的情况，会产生连续进位。
        while (carry > 0) {
            if (listNode == null) {
                listNode = new ListNode(carry);
                result.next = listNode;
                break;
            } else {
                int sum = listNode.val + carry;
                carry = sum / 10;
                if (carry > 0) {
                    listNode.val = sum % 10;
                } else {
                    listNode.val = sum;
                }
                listNode = listNode.next;
            }
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
