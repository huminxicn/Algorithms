package practice.leetcode.array;

/**
 * 下一个排列。
 * https://leetcode-cn.com/problems/next-permutation/
 * <p>
 * 整数数组的一个排列就是将其所有成员以序列或线性顺序排列。
 * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
 * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。
 * 更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。
 * 如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
 * <p>
 * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
 * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
 * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/03/03 21:10
 */
public class LT31 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2};
        nextPermutation(arr);
    }

    /**
     * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     * <p>
     * 具体地，我们这样描述该算法，对于长度为 n 的排列 a：
     * 1.首先从后向前查找第一个顺序对 (i,i+1)，满足 a[i] < a[i+1]。这样「较小数」即为 a[i]。此时 [i+1,n) 必然是下降序列。
     * 2.如果找到了顺序对，那么在区间 [i+1,n) 中从后向前查找第一个元素 j 满足 a[i] < a[j]。这样「较大数」即为 a[j]。
     * 3.交换 a[i] 与 a[j]，此时可以证明区间 [i+1,n) 必为降序。我们可以直接使用双指针反转区间 [i+1,n) 使其变为升序，而无需对该区间进行排序。
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            print(nums);
        }
        int i = -1;
        for (int k = nums.length - 1; k > 0; k--) {
            //假如存在一个顺序对，记录下 i 的位置。
            if (nums[k - 1] < nums[k]) {
                i = k - 1;
                break;
            }
        }
        //当不存一个顺序对时，需要将原数组倒序。
        if (i < 0) {
            reverse(nums, 0, nums.length - 1);
            print(nums);
        } else {
            //从后向前找第一个大于 nums[i] 的数，并交换位置。
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, j, i);
                    break;
                }
            }
            //反转 (i+1,n) 中间的数字。
            reverse(nums, i + 1, nums.length - 1);
            print(nums);
        }
    }

    public static void print(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int j = 0; j < nums.length - 1; j++) {
            sb.append(nums[j]);
            sb.append(",");
        }
        sb.append(nums[nums.length - 1]);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void reverse(int[] arr, int l, int r) {
        if (arr.length <= 1) {
            return;
        }
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    public static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

//
//    /**
//     * 1.从最小位往最高位寻找，将遍历的数字放入数字集中，直到找到比数字集中的数小的那一位（假设为 m）为止，同时记录 m 所在的位置。
//     * 2.从数字集中找出刚好比 m 大的数（假设为 n），并将 n 放在 m 的位置上，并从数字集中移除 n。
//     * 3.将数字集中剩下的数从小到大拼接在 n 的后面。
//     *
//     * @param nums
//     */
//    public static void nextPermutation(int[] nums) {
//        //1.临界值判断
//        if (nums.length == 0) {
//            return;
//        }
//        if (nums.length == 1) {
//            System.out.println(nums[0]);
//            return;
//        }
//        //数字集。
//        List<Integer> list = new ArrayList<>();
//        list.add(nums[nums.length - 1]);
//        //用来记录 m 的位置。
//        int i = 0;
//        //数字集中最小的数。
//        int min = 0;
//        point:
//        for (i = nums.length - 2; i >= 0; i--) {
//            list.add(nums[i]);
//            Collections.sort(list);
//            for (int j = 0; j < list.size(); j++) {
//                min = list.get(j);
//                if (min > nums[i]) {
//                    list.remove(j);
//                    break point;
//                }
//            }
//        }
//        //i<0 说明数组是一个倒序数组，只需要将其翻转即可。
//        if (i < 0) {
//            reverse(nums);
//        } else {
//            nums[i] = min;
//            for (int j = 0; j < list.size(); j++) {
//                nums[++i] = list.get(j);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (int j = 0; j < nums.length - 1; j++) {
//            sb.append(nums[j]);
//            sb.append(",");
//        }
//        sb.append(nums[nums.length - 1]);
//        sb.append("]");
//        System.out.println(sb.toString());
//    }
//
//    public static void reverse(int[] arr) {
//        if (arr.length <= 1) {
//            return;
//        }
//        int left = 0;
//        int right = arr.length - 1;
//        while (left <= right) {
//            swap(arr, left, right);
//            left++;
//            right--;
//        }
//    }
//
//    public static void swap(int[] arr, int m, int n) {
//        int tmp = arr[m];
//        arr[m] = arr[n];
//        arr[n] = tmp;
//    }
}
