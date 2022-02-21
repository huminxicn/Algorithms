package structure.array;

/**
 * 支持动态扩容的数组。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/12/03 21:51
 */
public class DynamicArrays {
    private Object[] data;
    private int size;
    private int capacity;

    public DynamicArrays() {
        this(10);
    }

    public DynamicArrays(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public void add(Object element) {
        checkCapacity();
        data[size] = element;
    }

    public void add(int index, Object element) {
        checkCapacity();
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

    private void checkCapacity() {
        if (size == capacity) {
            Object[] newData = new Object[2 * size];
            System.arraycopy(data, 0, newData, 0, size);
            size = newData.length;
            data = newData;
        }
    }

}
