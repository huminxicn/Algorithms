package practice.nc.array;

import java.util.Arrays;

/**
 * 数组中出现次数超过一半的数字。
 * <p>
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=117&&tqId=37770&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/24 23:18
 */
public class NC73 {
    /**
     * 可以先将数组排序，然后可能的众数肯定在数组中间，然后判断一下。
     *
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        Arrays.sort(array);
        int num = array[array.length / 2];
        int count = 0;
        for (int j : array) {
            if (num == j) {
                count++;
            }
        }
        if (count > array.length / 2) {
            return num;
        }
        return 0;
    }
}
