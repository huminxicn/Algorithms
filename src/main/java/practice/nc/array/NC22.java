package practice.nc.array;

/**
 * 合并两个有序的数组。
 * https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=117&&tqId=37727&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给出一个有序的整数数组 A 和有序的整数数组 B ，请将数组 B 合并到数组 A 中，变成一个有序的升序数组
 * <p>
 * 数据范围： 0 \le n,m \le 1000≤n,m≤100，|A_i| <=100∣A
 * i
 * ​
 * ∣<=100， |B_i| <= 100∣B
 * i
 * ​
 * ∣<=100
 * <p>
 * 注意：
 * 1.保证 A 数组有足够的空间存放 B 数组的元素， A 和 B 中初始的元素数目分别为 m 和 n，A的数组空间大小为 m+n
 * 2.不要返回合并的数组，将数组 B 的数据合并到 A 里面就好了
 * 3.A 数组在[0,m-1]的范围也是有序的
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/06 23:12
 */
public class NC22 {
    /**
     * 利用临时数组实现。
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void merge(int A[], int m, int B[], int n) {
        if (n == 0) {
            return;
        }
        //利用临时数组来保存合并之后的数据。
        int[] tmp = new int[m + n];
        //A 数组指针。
        int i = 0;
        //B 数组指针。
        int j = 0;
        //临时数组指针。
        int k = 0;
        //合并 A B 数组中的数据。
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = B[j++];
            }
        }
        //将 A 数组中的剩余数据 copy 到 tmp 中。
        while (i < m) {
            tmp[k++] = A[i++];
        }
        //将 B 数组中的剩余数据 copy 到 tmp 中。
        while (j < n) {
            tmp[k++] = B[j++];
        }
        //将临时数组中的数据 copy 到 A 数组中。
        for (int l = 0; l < m + n; l++) {
            A[l] = tmp[l];
        }
    }

    /**
     * 利用尾指针实现。
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    public void mergeNew(int A[], int m, int B[], int n) {
        if (n == 0) {
            return;
        }
        //A 数组尾指针。
        int i = m - 1;
        //B 数组尾指针。
        int j = n - 1;
        //扩展之后 A 数组的尾指针。
        int k = m + n - 1;
        //合并 A B 数组中的数据。
        while (i >= 0 && j >= 0) {
            if (A[i] >= B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }
        //如果还剩下 A 数组中的数据，则不需要处理。
        //如果还剩下 B 数组中的数据，需要合并到 A 中。
        if (j >= 0) {
            for (int l = j; l >= 0; l--) {
                A[k--] = B[j--];
            }
        }
    }

}
