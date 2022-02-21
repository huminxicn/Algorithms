package practice.nc.tree;

/**
 * 判断是不是平衡二叉树。
 * <p>
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=117&&tqId=37757&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/24 22:33
 */
public class NC62 {
    private boolean isBalance = true;

    /**
     * 只需要判断左右子树的深度绝对值不超过 1 即可。
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        maxDepth(root);
        return isBalance;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        //左右子树深度大于 1，则不是平衡二叉树。
        if (Math.abs(l - r) > 1) {
            isBalance = false;
        }
        return Math.max(l, r) + 1;
    }

}
