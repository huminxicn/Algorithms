package practice.zuo;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/19 21:44
 */
public class PrintBinaryNumber {

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int2Binary(a);
        System.out.println(~a + 1);
        int b = 0;
        int2Binary(b);
        System.out.println(~b + 1);

    }

    public static void int2Binary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }
}
