package practice.nc.array;

/**
 * 排序。
 * https://www.nowcoder.com/practice/2baf799ea0594abd974d37139de27896?tpId=117&&tqId=37851&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给定一个长度为 n 的数组，请你编写一个函数，返回该数组排序后的结果。
 * 数据范围： 0 \le n \le 10000000≤n≤1000000，数组中每个元素都满足 0 \le val \le 10000000000≤val≤1000000000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/11/25 22:36
 */
public class NC140 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 1, 8, 4, 6, 5, 7};
        MySort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    public static int[] MySort(int[] arr) {
        // write code here
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
        return arr;
    }

    private static void mergeSort(int[] arr, int left, int right, int[] tmp) {
        //当数组只有一个元素，就不用排序了。
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid + 1, right, tmp);
        merge(arr, left, mid, right, tmp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        //表示左指针。
        int l = left;
        //表示右指针。
        int r = mid + 1;
        //临时数组指针。
        int i = 0;
        while (l <= mid && r <= right) {
            if (arr[l] >= arr[r]) {
                tmp[i++] = arr[r++];
            } else {
                tmp[i++] = arr[l++];
            }
        }
        //将左数组剩下的值填充到临时数组。
        while (l <= mid) {
            tmp[i++] = arr[l++];
        }
        //将右数组剩下的值填充到临时数组。
        while (r <= right) {
            tmp[i++] = arr[r++];
        }
        //将临时数组中数据复制到原数组。
        int j = 0;
        while (left <= right) {
            arr[left++] = tmp[j++];
        }
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
