package practice.nc.list;

/**
 * 合并两个排序的链表。
 * https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=117&&tqId=37735&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 数据范围： 0 \le n \le 10000≤n≤1000，-1000 \le 节点值 \le 1000−1000≤节点值≤1000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/03 23:54
 */
public class NC33 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        //一般创建单链表，都会设一个虚拟头结点，也叫哨兵，因为这样每一个结点都有一个前驱结点。
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return head.next;
    }

    /**
     * 递归写法
     * 方法一的迭代版本，很好理解，代码也好写。但是有必要介绍一下递归版本，可以练习递归代码。
     * 写递归代码，最重要的要明白递归函数的功能。可以不必关心递归函数的具体实现。
     * 比如这个ListNode* Merge(ListNode* pHead1, ListNode* pHead2)
     * 函数功能：合并两个单链表，返回两个单链表头结点值小的那个节点。
     *
     * 如果知道了这个函数功能，那么接下来需要考虑2个问题：
     *
     * 递归函数结束的条件是什么？
     * 递归函数一定是缩小递归区间的，那么下一步的递归区间是什么？
     * 对于问题1.对于链表就是，如果为空，返回什么
     * 对于问题2，跟迭代方法中的一样，如果PHead1的所指节点值小于等于pHead2所指的结点值，那么phead1后续节点和pHead节点继续递归
     */
//    public ListNode Merge(ListNode list1, ListNode list2) {
//        if (list1 == null) {
//            return list2;
//        }
//        if (list2 == null) {
//            return list1;
//        }
//        if (list1.val <= list2.val) {
//            list1.next = Merge(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = Merge(list2.next, list1);
//            return list2;
//        }
//    }

}
