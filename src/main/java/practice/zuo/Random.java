package practice.zuo;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/19 22:45
 */
public class Random {
    public static void main(String[] args) {
        int times = 10000000;
        int k = 10;
        int[] counts = new int[k];
        for (int i = 0; i < times; i++) {
            int ans = (int) (Math.random() * k);
            counts[ans]++;
        }
        for (int i = 0; i < counts.length; i++) {
            System.out.println("counts[" + i + "]=" + counts[i]);
        }

        System.out.println("=========");
        double x = 0.6;
        int count = 0;
        for (int i = 0; i < times; i++) {
            if (xToPower2() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) times);
        System.out.println(Math.pow(x, 2));
    }

    /**
     * [0,x) 范围上的数出现的概率由原来的 x 调整为 x 平方。
     *
     * @return
     */
    public static double xToPower2() {
        return Math.max(Math.random(), Math.random());
    }

    public static double xToPower3() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }
}
