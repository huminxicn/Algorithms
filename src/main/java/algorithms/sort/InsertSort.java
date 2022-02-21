package algorithms.sort;

/**
 * 插入排序。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/10 11:03
 */
public class InsertSort {

    /**
     * 插入排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return 排序后数组
     */
    public static int[] sort(int[] a, int n) {
        if (n <= 1) {
            return a;
        }
        //查询插入的位置
        for (int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            //移动数据
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //插入数据
            a[j + 1] = value;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 2, 7, 6};
        int[] ints = InsertSort.sort(a, a.length);
        for (int anInt : ints) {
            System.out.print(anInt);
        }
    }
}
