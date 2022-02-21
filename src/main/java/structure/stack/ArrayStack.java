package structure.stack;

/**
 * 基于数组实现的顺序栈。
 * <p>
 * https://time.geekbang.org/column/article/41222
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/04 16:21
 */
public class ArrayStack {
    private String[] items;
    private int count;
    private int capacity;

    ArrayStack(int capacity) {
        this.items = new String[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    public boolean push(String item) {
        if (count == capacity) {
            return false;
        }
        items[count] = item;
        count++;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        String tmp = items[count - 1];
        count--;
        return tmp;
    }
}
