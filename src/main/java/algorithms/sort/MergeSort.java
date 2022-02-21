package algorithms.sort;

import java.util.Arrays;

/**
 * 归并排序。
 * <p>
 * 利用分治思想。
 * <p>
 * https://www.cnblogs.com/chengxiao/p/6194356.html#:~:text=%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F%EF%BC%88MERGE%2DSORT%EF%BC%89,%E5%9C%A8%E4%B8%80%E8%B5%B7%EF%BC%8C%E5%8D%B3%E5%88%86%E8%80%8C%E6%B2%BB%E4%B9%8B)%E3%80%82
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/10 20:47
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        //如果只有一个元素，那就不用排序了
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid, temp);
        sort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        //左序列指针
        int i = left;
        //右序列指针
        int j = mid + 1;
        //临时数组指针
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        //将temp中的元素全部拷贝到原数组中
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
