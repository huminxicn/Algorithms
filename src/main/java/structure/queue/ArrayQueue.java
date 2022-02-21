package structure.queue;

/**
 * 数组实现队列。
 * <p>
 * https://time.geekbang.org/column/article/41330
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/05 15:03
 */
public class ArrayQueue {
    private String[] items;
    private int capacity;

    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == capacity) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head++;
        return item;
    }
}
