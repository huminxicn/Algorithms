package structure.queue;

/**
 * 循环队列。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/12/14 20:09
 */
public class CycleQueue {

    private final int capacity;
    private final Object[] items;
    private int head = 0;
    private int tail = 0;

    public CycleQueue(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
    }

    public boolean deQueue() {
        if (head == tail) {
            return false;
        }
        Object item = items[head];
        head = (head + 1) % capacity;
        return true;
    }

    public boolean enQueue(Object item) {
        // 会浪费一个数组元素。
        if ((tail + 1) % capacity == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

}
