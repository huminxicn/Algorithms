package structure.heap;

/**
 * https://time.geekbang.org/column/article/69913
 * <p>
 * 前面我们提到，堆是一种特殊的树。我们现在就来看看，什么样的树才是堆。我罗列了两点要求，只要满足这两点，它就是一个堆。
 * 1.堆是一个完全二叉树。
 * 2.堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/08/25 15:56
 */
public class Heap {
    private int[] array;
    private int capacity;
    private int count;

    public Heap(int capacity) {
        this.array = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    public void insert(int data) {
        //堆满了
        if (count >= capacity) {
            return;
        }
        ++count;
        array[count] = data;
        int index = count;
        while ((index / 2 > 0) && (array[index] > array[index / 2])) {
            swap(array, index, index / 2);
            index = index / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        array[1] = array[count];
        --count;
        heapify(array, count, 1);
    }


    /**
     * 自顶向下堆化
     *
     * @param array
     * @param count
     * @param index
     */
    private void heapify(int[] array, int count, int index) {
        while (true) {
            int maxElementPos = index;
            if (index * 2 <= count && array[index] < array[index * 2]) {
                maxElementPos = index * 2;
            }
            if (index * 2 + 1 <= count && array[maxElementPos] <= array[index * 2 + 1]) {
                maxElementPos = index * 2 + 1;
            }
            if (maxElementPos == index) {
                break;
            }
            swap(array, index, maxElementPos);
            index = maxElementPos;
        }

    }

    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
