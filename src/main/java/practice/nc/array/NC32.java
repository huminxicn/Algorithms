package practice.nc.array;

/**
 * 求平方根。
 * <p>
 * https://www.nowcoder.com/practice/09fbfb16140b40499951f55113f2166c?tpId=117&&tqId=37734&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 算法
 * 二分查找
 * 1.初始范围为1，x
 * 2.当middle*middle <= x && (middle+1)*(middle+1) > x时，返回结果
 * 3.当middle*middle < x时，到右半部分继续寻找
 * 4.当middle*middle > x时，到左半部分继续寻找
 * ps：避免溢出使用逆向运算
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/24 23:55
 */
public class NC32 {
    /**
     * @param x int整型
     * @return int整型
     */
    public int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 1, right = x, mid;
        while (true) {
            mid = (left + right) >> 1;
            if (mid <= x / mid && mid + 1 > x / (mid + 1)) {
                return mid;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
