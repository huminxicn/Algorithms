package structure.array;

/**
 * 固定长度数组。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/12/03 21:50
 */
public class Arrays {
    private Object[] data;
    private int size;
    private int capacity;

    public Arrays() {
        this(10);
    }

    public Arrays(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void add(Object element) {
        data[size] = element;
    }

    public void add(int index, Object element) {
        checkIndex(index);
        //index 之后的元素都要向后挪动一位。
        for (int i = size - 1; i > index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    public Object remove(int index) {
        checkIndex(index);
        Object removeObject = data[index];
        //index 之后的元素都要向前挪动一位。
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return removeObject;
    }

    public Object get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int getSize() {
        return this.size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException(index + " 不是有效的下标。");
        }
    }
}
