package algorithms.sort;

import java.util.Arrays;

/**
 * 快速排序。
 * <p>
 * https://leetcode-cn.com/problems/sort-an-array/solution/pai-xu-shu-zu-by-leetcode-solution/
 * https://emn178.pixnet.net/blog/post/88613503
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/12 15:54
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, a.length - 1);
        return a[K - 1];
    }


    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        // middle pivot
        int pivotIndex = (left + right) / 2;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; ++i) {
            if (array[i] <= pivot) {
                swap(array, i, swapIndex);
                swapIndex++;
            }
        }
        swap(array, swapIndex, right);

        quickSort(array, swapIndex + 1, right);
        quickSort(array, left, swapIndex - 1);



    }

    private static void swap(int[] array, int indexA, int indexB) {
        int tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }

}
