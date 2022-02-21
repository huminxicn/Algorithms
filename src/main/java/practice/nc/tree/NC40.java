package practice.nc.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现二叉树先序，中序和后序遍历。
 * https://www.nowcoder.com/practice/a9fec6c46a684ad5a3abd4e365a9d362?tpId=117&&tqId=37819&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 * <p>
 * 给定一棵二叉树，分别按照二叉树先序，中序和后序打印所有的节点。
 * 数据范围：0 \le n \le 10000≤n≤1000，树上每个节点的val值满足 0 \le val \le 1000≤val≤100
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 *
 * @author huminxi2017@gmail.com
 * @since 2021/11/30 23:10
 */
public class NC40 {

    /**
     * 如何将所有节点都遍历打印出来呢？经典的方法有三种，前序遍历、中序遍历和后序遍历。
     * 其中，前、中、后序，表示的是节点与它的左右子树节点遍历打印的先后顺序。
     * 前序遍历是指，对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树。
     * 中序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它本身，最后打印它的右子树。
     * 后序遍历是指，对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点本身。
     * <p>
     * https://static001.geekbang.org/resource/image/ab/16/ab103822e75b5b15c615b68560cb2416.jpg
     *
     * @param root
     * @return
     */
    public int[][] threeOrders(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        List<Integer> inOrderList = new ArrayList<>();
        List<Integer> postOrderList = new ArrayList<>();
        preOrder(root, preOrderList);
        inOrder(root, inOrderList);
        postOrder(root, postOrderList);
        int[][] result = new int[3][preOrderList.size()];
        for (int i = 0; i < preOrderList.size(); i++) {
            result[0][i] = preOrderList.get(i);
            result[1][i] = inOrderList.get(i);
            result[2][i] = postOrderList.get(i);
        }
        return result;
    }

    private void preOrder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    private void postOrder(TreeNode node, List<Integer> list) {
        if (null == node) {
            return;
        }
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.val);
    }
}

