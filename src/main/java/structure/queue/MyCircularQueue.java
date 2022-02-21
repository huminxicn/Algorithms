package structure.queue;

/**
 * 循环队列。
 * <p>
 * https://leetcode-cn.com/problems/design-circular-queue/
 * <p>
 * 对于一个固定大小的数组，任何位置都可以是队首，只要知道队列长度，就可以根据下面公式计算出队尾位置：
 * tailIndex = (headIndex + count - 1) mod capacity
 * 其中 capacity 是数组长度，count 是队列长度，headIndex 和 tailIndex 分别是队首 head 和队尾 tail 索引。
 * <p>
 * 下图展示了使用数组实现循环的队列的例子。
 * https://pic.leetcode-cn.com/Figures/622/622_queue_with_array.png
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/08 15:10
 */
public class MyCircularQueue {
    private int count = 0;
    private int head = 0;
    private final int capacity;
    private final int[] items;

    public MyCircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (count == capacity) {
            return false;
        }
        count++;
        items[(head + count - 1) % capacity] = value;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (count == 0) {
            return false;
        }
        count--;
        head = (head + 1) % capacity;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (count == 0) {
            return -1;
        }
        return items[head];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return items[(head + count - 1) % capacity];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return count == capacity;
    }
}
