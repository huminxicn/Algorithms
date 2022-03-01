package practice.leetcode.array;

/**
 * 寻找两个正序数组的中位数。
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * @author huminxi2017@gmail.com
 * @since 2022/02/23 19:13
 */
public class LT4 {
    /**
     * 有以下三种情况需要特殊处理：
     * 如果 A[k/2-1] 或者 B[k/2−1] 越界，那么我们可以选取对应数组中的最后一个元素。在这种情况下，我们必须根据排除数的个数减少 k 的值，而不能直接将 k 减去 k/2。
     * 如果一个数组为空，说明该数组中的所有元素都被排除，我们可以直接返回另一个数组中第 k 小的元素。
     * 如果 k=1，我们只要返回两个数组首元素的最小值即可。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int totalLength = l1 + l2;
        if (totalLength % 2 == 1) {
            int mid = totalLength / 2;
            double median = getKthElement(nums1, nums2, mid + 1);
            return median;
        } else {
            int mid1 = totalLength / 2 - 1;
            int mid2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, mid1 + 1) + getKthElement(nums1, nums2, mid2 + 1)) * 0.5;
            return median;
        }
    }

    /**
     * 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较。这里的 "/" 表示整除。
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) = k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     *
     * @param num1
     * @param num2
     * @param k
     * @return
     */
    public int getKthElement(int[] num1, int[] num2, int k) {
        int l1 = num1.length;
        int l2 = num2.length;
        int index1 = 0;
        int index2 = 0;
        while (true) {
            //边界情况
            if (index1 == l1) {
                return num2[index2 + k - 1];
            }
            if (index2 == l2) {
                return num1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(num1[index1], num2[index2]);
            }
            //正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, l1) - 1;
            int newIndex2 = Math.min(index2 + half, l2) - 1;
            int pivot1 = num1[newIndex1];
            int pivot2 = num2[newIndex2];
            if (pivot1 <= pivot2) {
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
