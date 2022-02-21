package practice.nc.string;

/**
 * 大数加法。
 * <p>
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=117&&tqId=37842&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/24 23:30
 */
public class NC1 {
    public static void main(String[] args) {
        System.out.println(solve("92", "923"));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public static String solve(String s, String t) {
        //1.补齐长度
        while (s.length() < t.length()) {
            s = 0 + s;
        }
        while (s.length() > t.length()) {
            t = 0 + t;
        }
        //2.按位加，注意进位
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            int sum = (Integer.parseInt(s.substring(i, i + 1)) + Integer.parseInt(t.substring(i, i + 1)) + carry);
            int bit = sum % 10;
            carry = sum / 10;
            sb.append(bit);
        }
        //3.处理最高位进位大于零的情况
        if (carry > 0) {
            sb.append(carry);
        }
        //4.反转结果串
        String s1 = sb.reverse().toString();
        return s1;
    }
}
