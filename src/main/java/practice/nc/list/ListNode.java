package practice.nc.list;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/02 22:11
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public static ListNode createList(int[] array) {
        ListNode head = null;
        for (int i = 0; i < array.length; i++) {
            if (head == null) {
                head = new ListNode(array[i]);
            } else {
                head.next = new ListNode(array[i]);
                head = head.next;
            }
        }
        return head;
    }

    public static void print(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val);
            sb.append(",");
            listNode = listNode.next;
        }
        System.out.println(sb.toString());
    }

}
