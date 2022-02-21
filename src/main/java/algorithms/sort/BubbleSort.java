package algorithms.sort;

import java.security.SecureRandom;
import java.util.Random;

/**
 * 冒泡排序。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/09 21:42
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     * @return 排序后的数组
     */
    public static int[] sort(int[] a, int n) {
        if (n <= 1) {
            return a;
        }
        for (int i = 0; i < n; i++) {
            //如果数组本来就有序，可以提前退出冒泡循环。
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    //表示有数据交换
                    flag = true;
                }
            }
            //没有数据交换，提前退出
            if (!flag) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int length = 100000;
        Random random = new SecureRandom();
        int[] randomArray = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray[i] = random.nextInt();
        }
        long startTime = System.currentTimeMillis();
        System.out.println("BubbleSort strTime=" + startTime);
        BubbleSort.sort(randomArray, randomArray.length);
        System.out.println("BubbleSort endTime=" + System.currentTimeMillis() + " cost=" + (System.currentTimeMillis() - startTime));

        Random random2 = new SecureRandom();
        int[] randomArray2 = new int[length];
        for (int i = 0; i < length; i++) {
            randomArray2[i] = random2.nextInt();
        }

        long startTime2 = System.currentTimeMillis();
        System.out.println("InsertSort strTime=" + startTime);
        InsertSort.sort(randomArray2, randomArray2.length);
        System.out.println("InsertSort endTime=" + System.currentTimeMillis() + " cost=" + (System.currentTimeMillis() - startTime2));

    }

}
