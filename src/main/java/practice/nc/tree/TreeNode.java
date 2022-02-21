package practice.nc.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * 一句话概括功能。
 *
 * @author huminxi2017@gmail.com
 * @since 2021/12/02 22:11
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int data) {
        this.val = data;
    }


    public static TreeNode createBinaryTree(List<Integer> list) {
        LinkedList<Integer> inputList = new LinkedList<>(list);
        return createBinaryTree(inputList);
    }

    /**
     * 创建二叉树
     *
     * @param inputList 元素序列
     * @return
     */
    private static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (null == inputList || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }


}
