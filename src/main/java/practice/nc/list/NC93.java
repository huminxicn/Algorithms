package practice.nc.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 设计LRU缓存结构。
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=117&&tqId=37804&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 描述
 * 设计LRU(最近最少使用)缓存结构，该结构在构造时确定大小，假设大小为 k ，并有如下两个功能
 * 1. set(key, value)：将记录(key, value)插入该结构
 * 2. get(key)：返回key对应的value值
 * 提示:
 * 1.某个key的set或get操作一旦发生，认为这个key的记录成了最常使用的，然后都会刷新缓存。
 * 2.当缓存的大小超过k时，移除最不经常使用的记录。
 * 3.输入一个二维数组与k，二维数组每一维有2个或者3个数字，第1个数字为opt，第2，3个数字为key，value
 * 若opt=1，接下来两个整数key, value，表示set(key, value)
 * 若opt=2，接下来一个整数key，表示get(key)，若key未出现过或已被移除，则返回-1
 * 对于每个opt=2，输出一个答案
 * 4.为了方便区分缓存里key与value，下面说明的缓存里key用""号包裹
 * <p>
 * 要求：set和get操作复杂度均为 O(1)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/11/29 22:28
 */
public class NC93 {
    public static void main(String[] args) {
        int[][] operators = new int[][]{{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        NC93 nc93 = new NC93();
        int[] lru = nc93.LRU(operators, 3);
        for (int i = 0; i < lru.length; i++) {
            System.out.println(lru[i]);
        }
    }


    class Node {
        int key, value;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    //LRU 缓存上限
    private int maxLRUSize;

    public int[] LRU(int[][] operators, int k) {
        //1.构建要返回数组
        int count = (int) Arrays.stream(operators).filter(e -> e[0] == 2).count();
        int[] respArray = new int[count];
        //2.构建 LRU 链表
        head.next = tail;
        tail.prev = head;
        //3.指定 LRU 的最大容量
        this.maxLRUSize = k;
        //4.遍历操作数组，执行 set 或 get 方法。
        int tmp = 0;
        for (int i = 0; i < operators.length; i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1], operators[i][2]);
            } else {
                respArray[tmp++] = get(operators[i][1]);
            }
        }
        return respArray;
    }

    public void set(int key, int value) {
        //如果 key 已存在，则更新 value 值；否则，插入新值。
        if (map.get(key) != null) {
            map.get(key).value = value;
        } else {
            //如果达到缓存上限，需要根据 LRU(Least Recently Used) 算法淘汰数据。清除最近最少使用的数据，即 tail 前面的节点。
            if (maxLRUSize == map.size()) {
                Node removedNode = tail.prev;
                removedNode.prev.next = tail;
                tail.prev = removedNode.prev;
                map.remove(removedNode.key);
                //help GC
                removedNode = null;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            moveToHead(node);
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //将当前 node 移至队头。
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void moveToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }


}
