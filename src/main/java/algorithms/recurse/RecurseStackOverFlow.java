package algorithms.recurse;

/**
 * 递归代码警惕堆栈溢出。
 * <p>
 * 设置每个线程的堆栈大小。 JDK5.0以后每个线程堆栈大小为1M，以前每个线程堆栈大小为256K。
 * <p>
 * JVM 参数: -Xss256k。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/09 20:32
 */
public class RecurseStackOverFlow {
    public static void main(String[] args) {
        RecurseStackOverFlow recurse = new RecurseStackOverFlow();
        System.out.println(recurse.f(2500));
    }

    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        return f(n - 1) + 1;
    }
}
