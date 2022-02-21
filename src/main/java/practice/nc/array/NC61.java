package practice.nc.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和。
 * https://www.nowcoder.com/practice/20ef0972485e41019e39543e8e895b7f?tpId=117&&tqId=37756&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
 * <p>
 * 给出一个整型数组 numbers 和一个目标值 target，请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/03 18:43
 */
public class NC61 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4};
        int[] ints = twoSum(arr, 6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 利用 hash 表来减少时间复杂度。
     *
     * @param numbers int整型一维数组
     * @param target  int整型
     * @return int整型一维数组
     */
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int[] resp = {i + 1, map.get(target - numbers[i])};
                Arrays.sort(resp);
                return resp;
            }
            map.put(numbers[i], i + 1);
        }
        return new int[0];
    }
}
