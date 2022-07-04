package practice.nc.list;

/**
 * 24.两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/07/04 18:56
 */
public class NC24 {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5};
        ListNode list1 = ListNode.createList(list);
        ListNode.print(list1);
        ListNode.print(swapPairs(list1));
    }

    /**
     * 可以定义三个指针，分别指向前一个、当前一个和后一个。
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个哨兵节点，方便记录表头数据。
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;
        while (prev.next != null && prev.next.next != null) {
            //通过 prev 节点获取 current 和 next 节点。
            ListNode current = prev.next;
            ListNode next = prev.next.next;
            //交换 current 和 next。注意要记录 current.next，这样可以防止链表断裂。
            current.next = next.next;
            next.next = current;
            //串联当前链表头节点。
            prev.next = next;
            //将 prev 节点往后挪一位。开启下一轮循环。
            prev = current;
        }
        return sentinel.next;
    }

}
