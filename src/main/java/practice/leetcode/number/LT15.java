package practice.leetcode.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和。
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0。请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/18 23:09
 */
public class LT15 {
    /**
     * 排序 + 双指针
     * 本题的难点在于如何去除重复解。
     * <p>
     * 算法流程：
     * 1.特判，对于数组长度 n，如果数组为 null 或者数组长度小于 3，返回 []。
     * 2.对数组进行排序。
     * 3.遍历排序后数组：
     * 3.1.若 nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 0，直接返回结果。
     * 3.2.对于重复元素：跳过，避免出现重复解。
     * 3.3.令左指针 L=i+1，右指针 R=n-1，当 L<R 时，执行循环：
     * 3.3.1.当 nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,R 移到下一位置，寻找新的解。
     * 3.3.2.若和大于 0，说明 nums[R] 太大，R 左移
     * 3.3.3.若和小于 0，说明 nums[L] 太小，L 右移
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    //排查当前循环中的重复解。
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
