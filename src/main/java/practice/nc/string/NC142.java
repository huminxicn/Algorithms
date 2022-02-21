package practice.nc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长重复子串。
 * <p>
 * https://www.nowcoder.com/practice/4fe306a84f084c249e4afad5edf889cc?tpId=117&&tqId=37853&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/27 22:42
 */
public class NC142 {
    public static void main(String[] args) {
        System.out.println(solve("nwlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoqhnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsnfwzqfjmafadrrwsofsbcnuvqhffbsaqxwpqcacehchzvfrkmlnozjkpqpxrjxkitzyxacbhhkicqcoendtomfgdwdwfcgpxiqvkuytdlcgdewhtaciohordtqkvwcsgspqoqmsboaguwnnyqxnzlgdgwpbtrwblnsadeuguumoqcdrubetokyxhoachwdvmxxrdryxlmndqtukwagmlejuukwcibxubumenmeyatdrmydiajxloghiqfmzhlvihjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgruowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdhiixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuftsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddbuotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnunneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmoxeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasjeuygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbfcriqifpgynkrrefxsnvucftpwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwl"));
    }

    /**
     * 暴力解法。
     * 如果字符串长度为 5，那么可能的重复子串最多为 2、1。从大往小找。
     * 1.先将字符串按长度分隔，返回子串集合。
     * 2.判断子串集合中是否有重复子串，如果有，则返回子串长度。
     * 3.如果没有，重复步骤 1、2。
     *
     * @param a string字符串 待计算字符串
     * @return int整型
     */
    public static int solve(String a) {
        if (a == null || a.length() <= 0) {
            return 0;
        }
        for (int i = a.length() / 2; i > 0; i--) {
            List<String> split = split(a, i);
            if (hasRepeatSubString(split, a)) {
                return i * 2;
            }
        }
        return 0;
    }

    /**
     * 返回指定长度的子串集合。
     *
     * @param str
     * @param sunLength
     * @return
     */
    public static List<String> split(String str, int sunLength) {
        List<String> subStrList = new ArrayList<>();
        for (int i = 0; i < str.length() - sunLength; i++) {
            String subStr = str.substring(i, i + sunLength);
            subStrList.add(subStr);
        }
        return subStrList;
    }

    /**
     * 判断子串集合中是否有重复子串。
     *
     * @param subStrList
     * @param str
     * @return
     */
    public static boolean hasRepeatSubString(List<String> subStrList, String str) {
        for (String subStr : subStrList) {
            String replace = str.replace(subStr + subStr, "");
            //String replace = str.replace(subStr, "");
            if (str.length() - replace.length() >= subStr.length() * 2) {
                return true;
            }
        }
        return false;
    }
}
