package algorithms.search;

/**
 * 二分查找循环数组。
 * <p>
 * https://time.geekbang.org/column/article/42733
 * <p>
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/08/11 15:54
 */
public class BinarySearchCycle {

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (nums.length < 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左半边有序。
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            //右半边有序
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,1};
        System.out.println(search(arr, 1 ));
    }
}
