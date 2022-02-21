package algorithms.recurse;

import java.util.HashMap;
import java.util.Map;

/**
 * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 * <p>
 * 我们仔细想下，实际上，可以根据第一步的走法把所有走法分为两类，第一类是第一步走了 1 个台阶，另一类是第一步走了 2 个台阶。
 * 所以 n 个台阶的走法就等于先走 1 阶后，n-1 个台阶的走法 加上先走 2 阶后，n-2 个台阶的走法。用公式表示就是：f(n) = f(n-1)+f(n-2)
 * <p>
 * https://time.geekbang.org/column/article/41440
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2020/06/09 20:42
 */
public class RecurseCount {

    Map<Integer, Integer> hasSolvedMap = new HashMap<Integer, Integer>();

    /**
     * 为了避免重复计算，我们可以通过一个数据结构（比如散列表）来保存已经求解过的 f(k)。
     * 当递归调用到 f(k) 时，先看下是否已经求解过了。
     *
     * @param n
     * @return
     */
    public int countOpt(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (hasSolvedMap.entrySet().contains(n)) {
            return hasSolvedMap.get(n);
        }
        int result = countOpt(n - 1) + countOpt(n - 2);
        hasSolvedMap.put(n, result);
        return result;
    }

    public int countOpt2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (hasSolvedMap.keySet().contains(n)) {
            return hasSolvedMap.get(n);
        }
        int result = countOpt2(n - 1) + countOpt2(n - 2);
        hasSolvedMap.put(n, result);
        return result;
    }

    public int count2(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return count2(n - 1) + count2(n - 2);
    }

    public int count(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return count(n - 1) + count(n - 2);
    }


    public static void main(String[] args) {
        RecurseCount recurseCount = new RecurseCount();
        int n = 40;
        long startTime4 = System.currentTimeMillis();
        System.out.println(recurseCount.countOpt2(n) + " countOpt2 costTime=" + (System.currentTimeMillis() - startTime4));
        long startTime2 = System.currentTimeMillis();
        System.out.println(recurseCount.count(n) + " count costTime=" + (System.currentTimeMillis() - startTime2));
        long startTime = System.currentTimeMillis();
        System.out.println(recurseCount.countOpt(n) + " countOpt costTime=" + (System.currentTimeMillis() - startTime));
        long startTime3 = System.currentTimeMillis();
        System.out.println(recurseCount.count2(n) + " count2 costTime=" + (System.currentTimeMillis() - startTime3));

    }
}
