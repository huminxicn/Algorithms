package practice.leetcode.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数。
 * https://leetcode-cn.com/problems/roman-to-integer/
 * <p>
 * 罗马数字包含以下七种字符I，V，X，L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II，即为两个并列的 1。12 写做 XII，即为 XII。 27 写做 XXVII, 即为 XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V(5) 和 X(10) 的左边，来表示 4 和 9。
 * X 可以放在 L(50) 和 C(100) 的左边，来表示 40 和 90。
 * C 可以放在 D(500) 和 M(1000) 的左边，来表示 400 和 900。
 *
 * @author huminxi2017@gmail.com
 * @since 2022/04/17 22:30
 */
public class LT13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 可以用一个 map 保存罗马数字和阿拉伯数字的转换关系。
     * <p>
     * 当前数如果小于等于前一个数，则加上当前值；否则，当前值需要先减掉两倍的前一个数，再相加（因为前面多加了一次）。
     *
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> roman2NumMap = initMap();
        if (s.length() == 0) {
            return 0;
        }
        int prevNum = roman2NumMap.get(s.charAt(0));
        int ans = prevNum;
        for (int i = 1; i < s.length(); i++) {
            Integer currentNum = roman2NumMap.get(s.charAt(i));
            if (currentNum <= prevNum) {
                ans = ans + currentNum;
            } else {
                ans = ans + (currentNum - 2 * prevNum);
            }
            prevNum = currentNum;
        }
        return ans;
    }

    public static Map<Character, Integer> initMap() {
        Map<Character, Integer> romanToNumMap = new HashMap<>();
        romanToNumMap.put('I', 1);
        romanToNumMap.put('V', 5);
        romanToNumMap.put('X', 10);
        romanToNumMap.put('L', 50);
        romanToNumMap.put('C', 100);
        romanToNumMap.put('D', 500);
        romanToNumMap.put('M', 1000);
        return romanToNumMap;
    }
}
