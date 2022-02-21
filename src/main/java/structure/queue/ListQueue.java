package structure.queue;

/**
 * 用链表实现队列。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/05 16:09
 */
public class ListQueue {
    private int count = 0;

    private Node head;
    private Node tail;

    public ListQueue() {
    }

    public boolean enqueue(String item) {
        Node newNode = new Node(item);
        if (count == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
        }
        tail = tail.next;
        count++;
        return true;
    }

    public String dequeue() {
        if (count == 0) {
            return null;
        }
        if (count == 1) {
            tail = null;
        }
        String item = head.val;
        head = head.next;
        count--;
        return item;
    }

    private static class Node {
        String val;
        Node next;

        public Node(String val) {
            this.val = val;
            this.next = null;
        }
    }

}
