package practice.nc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子数组。
 * https://www.nowcoder.com/practice/b56799ebfd684fb394bd315e89324fb4?tpId=117&&tqId=37816&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * <p>
 * 数据范围：0\le arr.length \le 10^60≤arr.length≤10
 * 6
 * ，0 < arr[i] \le 10^50<arr[i]≤10
 * 5
 * <p>
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(nlogn)O(nlogn)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/09 21:09
 */
public class NC41 {
    public static void main(String[] args) {
        int i = maxLength(new int[]{1,2,3,4,1,5,6,7,8,1});
        System.out.println(i);
    }

    /**
     * 我们使用两个指针，一个 i，一个j。最开始的时候 i 和 j 指向第一个元素，然后 i 往后移，把扫描过的元素都放到 map 中。
     * 如果 i 扫描过的元素没有重复的就一直往后移，顺便记录一下最大值 max，如果 i 扫描过的元素有重复的，就改变 j 的位置。
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public static int maxLength(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                j = Math.max(j, map.get(arr[i]) + 1);
            }
            map.put(arr[i], i);
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }

}
