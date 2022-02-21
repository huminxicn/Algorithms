package practice.nc.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 求二叉树的层序遍历。
 * https://www.nowcoder.com/practice/04a5560e43e24e9db4595865dc9c63a3?tpId=117&&tqId=37723&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-fu-dai-zi-mu-9cfv8/
 * <p>
 * 给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
 * 例如：
 * 给定的二叉树是{3,9,20,#,#,15,7},
 * <p>
 * 该二叉树层序遍历的结果是
 * [
 * [3],
 * [9,20],
 * [15,7]
 * <p>
 * ]
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/02 20:02
 */
public class NC15 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree(Arrays.asList(1, null, 2));
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(root);
        System.out.println(arrayLists.toString());
    }

    /**
     * 层序遍历。
     *
     * @param root
     * @return
     */
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resp = new ArrayList<>();
        if (null == root) {
            return resp;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //当层的结果
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            //添加节点到当层的 list 中
            for (int i = 0; i < size; i++) {
                //节点出队
                TreeNode node = queue.remove();
                //左子树入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                //右子树入队
                if (node.right != null) {
                    queue.add(node.right);
                }
                level.add(node.val);
            }
            resp.add(level);
        }
        return resp;
    }

}
