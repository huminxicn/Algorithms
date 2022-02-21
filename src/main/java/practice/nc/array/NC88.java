package practice.nc.array;

import java.util.Arrays;

/**
 * 寻找第 K 大。
 * https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=117&&tqId=37791&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * https://static001.geekbang.org/resource/image/08/e7/086002d67995e4769473b3f50dd96de7.jpg
 * <p>
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第 k 大的数。
 * <p>
 * 给定一个整数数组 a ,同时给定它的大小n和要找的 k ，请返回第 k 大的数(包括重复的元素，不用去重)，保证答案存在。
 * 要求：时间复杂度 O(nlogn)O(nlogn)，空间复杂度 O(1)O(1)
 * 数据范围：0\le n \le 10000≤n≤1000， 1 \le K \le n1≤K≤n，数组中每个元素满足 0 \le val \le 100000000≤val≤10000000
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/01 22:03
 */
public class NC88 {
    public static void main(String[] args) {
        int[] arr = {1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        int kth = findKth(arr, 49, 24);
        System.out.println(kth);
    }

    /**
     * 先倒序排序，再返回第 K-1 个。
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public static int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, a.length - 1);
        return a[K - 1];
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = (left + right) / 2;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; i++) {
            //倒序
            if (arr[i] >= pivot) {
                swap(arr, swapIndex, i);
                swapIndex++;
            }
        }
        swap(arr, swapIndex, right);

        quickSort(arr, left, swapIndex - 1);
        quickSort(arr, swapIndex + 1, right);
    }

    private static void swap(int[] arr, int source, int target) {
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }
}
