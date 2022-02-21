package practice.nc.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树。
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 * <p>
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=117&&tqId=37722&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/25 19:15
 */
public class NC14 {
    /**
     * 先层序遍历，然后再翻转。
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean reverse = false;
        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(pRoot);
        for (ArrayList<Integer> level : arrayLists) {
            if (reverse) {
                Collections.reverse(level);
                reverse = false;
            } else {
                reverse = true;
            }
        }
        return arrayLists;
    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resp = new ArrayList<>();
        if (root == null) {
            return resp;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
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
