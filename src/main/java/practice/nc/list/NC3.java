package practice.nc.list;

import java.util.HashMap;

/**
 * 链表中环的入口结点。
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=117&&tqId=37713&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 * <p>
 * 数据范围： n\le10000n≤10000，1<=结点值<=100001<=结点值<=10000
 * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 例如，输入{1,2},{3,4,5}时，对应的环形链表如下图所示：
 * <p>
 * 可以看到环的入口结点的结点值为3，所以返回结点值为3的结点。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/05 22:45
 */
public class NC3 {

    /**
     * 利用 hash 表存储节点值，发现第一个重复的就返回当前节点。
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        while (pHead != null) {
            if (map.containsKey(pHead.val)) {
                return map.get(pHead.val);
            } else {
                map.put(pHead.val, pHead);
            }
            pHead = pHead.next;
        }
        return null;
    }
}
