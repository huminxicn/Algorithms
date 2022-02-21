package practice.nc.array;

import java.util.ArrayList;

/**
 * 最小的 K 个数。
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=117&&tqId=37765&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 * 数据范围：0\le k,n \le 100000≤k,n≤10000，数组中每个数的大小0 \le val \le 10000≤val≤1000
 * 要求：空间复杂度 O(n)O(n) ，时间复杂度 O(nlogn)O(nlogn)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/01 19:49
 */
public class NC119 {
    /**
     * 先将数组排序，然后返回前 k 个。
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        mergeSort(input, 0, input.length - 1, new int[input.length]);
        ArrayList<Integer> resp = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resp.add(input[i]);
        }
        return resp;
    }

    /**
     * 归并排序。
     *
     * @param arr
     * @param left
     * @param right
     * @param tmp
     */
    public void mergeSort(int[] arr, int left, int right, int[] tmp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, tmp);
        mergeSort(arr, mid + 1, right, tmp);
        merge(arr, left, mid, right, tmp);
    }

    public void merge(int[] arr, int left, int mid, int right, int[] tmp) {
        int i = left;
        int j = mid + 1;
        int idx = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                tmp[idx++] = arr[i++];
            } else {
                tmp[idx++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[idx++] = arr[i++];
        }
        while (j <= right) {
            tmp[idx++] = arr[j++];
        }
        int k = 0;
        while (left <= right) {
            arr[left++] = tmp[k++];
        }
    }
}
