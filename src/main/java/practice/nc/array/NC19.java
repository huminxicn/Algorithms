package practice.nc.array;

/**
 * 连续子数组的最大和。
 * https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=117&&tqId=37797&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 数据范围:
 * 1 <= n <= 10^51<=n<=10
 * 5
 * <p>
 * -100 <= a[i] <= 100−100<=a[i]<=100
 * <p>
 * 要求:时间复杂度为 O(n)O(n)，空间复杂度为 O(n)O(n)
 * 进阶:时间复杂度为 O(n)O(n)，空间复杂度为 O(1)O(1)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/06 20:26
 */
public class NC19 {
    /**
     * 思想很简单，就是对下标为 i 的元素 array[i]，先试探的加上 array[i], 如果和为负数，显然，以 i 结尾的元素对整个结果不作贡献。
     * <p>
     * 具体过程：
     * 初始化：维护一个变量 tmp = 0
     * 如果 tmp+array[i] < 0, 说明以 i 结尾的不作贡献，重新赋值tmp = 0
     * 否则更新 tmp = tmp + array[i]
     * 最后判断 tmp 是否等于 0， 如果等于 0，说明数组都是负数，选取一个最大值为答案。
     *
     * @param array
     * @return
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0];
        int maxSingle = array[0];
        int tmpSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (maxSingle < array[i]) {
                maxSingle = array[i];
            }
            if (tmpSum + array[i] < 0) {
                tmpSum = 0;
            } else {
                tmpSum += array[i];
            }
            maxSum = Math.max(maxSum, tmpSum);
        }
        if (tmpSum != 0) {
            return maxSum;
        } else {
            return maxSingle;
        }
    }
}
