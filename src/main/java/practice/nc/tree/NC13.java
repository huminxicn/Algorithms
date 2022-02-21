package practice.nc.tree;

/**
 * 二叉树的最大深度。
 * <p>
 * https://www.nowcoder.com/practice/8a2b2bf6c19b4f23a9bdb9b233eefa73?tpId=117&&tqId=37721&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/24 22:31
 */
public class NC13 {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }
}
