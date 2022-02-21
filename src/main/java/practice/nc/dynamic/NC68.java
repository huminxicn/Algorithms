package practice.nc.dynamic;

/**
 * 跳台阶。
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=117&&tqId=37764&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * <p>
 * 数据范围：0 \leq n \leq 400≤n≤40
 * 要求：时间复杂度：O(n)O(n) ，空间复杂度： O(1)O(1)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/04 16:07
 */
public class NC68 {
    public int jumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }
}
