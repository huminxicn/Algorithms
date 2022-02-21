package practice.nc.list;

/**
 * 两个链表的第一个公共结点。
 * https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=117&&tqId=37761&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 * <p>
 * 数据范围： n \le 1000n≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 例如，输入{1,2,3},{4,5},{6,7}时，两个无环的单向链表的结构如下图所示：
 * <p>
 * 可以看到它们的第一个公共结点的结点值为6，所以返回结点值为6的结点。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/07 23:14
 */
public class NC66 {
    /**
     * 这里先假设链表A头结点与结点8的长度 与 链表B头结点与结点8的长度相等，那么就可以用双指针。
     * <p>
     * 初始化：指针ta指向链表A头结点，指针tb指向链表B头结点
     * 如果ta == tb， 说明找到了第一个公共的头结点，直接返回即可。
     * 否则，ta != tb，则++ta，++tb
     * 所以现在的问题就变成，如何让本来长度不相等的变为相等的？
     * 假设链表A长度为a， 链表B的长度为b，此时a != b
     * 但是，a+b == b+a
     * 因此，可以让a+b作为链表A的新长度，b+a作为链表B的新长度。
     * <p>
     * 时间复杂度：O(m+n), m，n分别为链表A，B的长度，最坏情况下，公共结点为最后一个，需要遍历m+n个结点
     * 空间复杂度：O(1)
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode a = pHead1;
        ListNode b = pHead2;
        while (a != b) {
            a = (a != null) ? a.next : pHead2;
            b = (b != null) ? b.next : pHead1;
        }
        return a;
    }
}
