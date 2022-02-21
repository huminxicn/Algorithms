package structure.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 二叉树。
 *
 * @author huminxi https://github.com/huminxicn
 * @since 2019/09/02 14:51
 */
public class Tree {

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode binaryTree = createBinaryTree(inputList);
        System.out.println("前序遍历");
        Tree.preOrderTravel(binaryTree);
        System.out.println("\n");
        Tree.preOrderTravelWithStack(binaryTree);
        System.out.println("中序遍历");
        Tree.inOrderTravel(binaryTree);
        System.out.println("\n");
        Tree.inOrderTravelWithStack(binaryTree);
        System.out.println("后序遍历");
        Tree.postOrderTravel(binaryTree);
        System.out.println("\n");
//        Tree.postOrderTravelWithStack(binaryTree);
        System.out.println("层序遍历");
        Tree.levelOrderTravel(binaryTree);
        System.out.println("层序遍历");
        Tree.levelOrderTravelNew(binaryTree);
    }

    /**
     * 创建二叉树
     *
     * @param inputList 元素序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (null == inputList || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 前序遍历
     * https://time.geekbang.org/column/article/67856
     *
     * @param node
     */
    public static void preOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTravel(node.leftChild);
        preOrderTravel(node.rightChild);
    }

    /**
     * 中序遍历
     *
     * @param node
     */
    public static void inOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTravel(node.leftChild);
        System.out.println(node.data);
        inOrderTravel(node.rightChild);
    }

    /**
     * 后序遍历
     */
    public static void postOrderTravel(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTravel(node.leftChild);
        postOrderTravel(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 前序遍历二叉树(利用栈实现)
     *
     * @param root
     */
    public static void preOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 中序遍历(利用栈实现)
     *
     * @param root
     */
    public static void inOrderTravelWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 后序遍历(利用栈实现)
     *
     * @param root
     */
//    public static void postOrderTravelWithStack(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode treeNode = root;
//        while (treeNode != null || !stack.isEmpty()) {
//            //迭代访问节点的左孩子，并入栈
//            while (treeNode != null) {
//                stack.push(treeNode);
//                treeNode = treeNode.leftChild;
//            }
//            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
//            if (!stack.isEmpty()) {
//                treeNode = stack.pop();
//                System.out.println(treeNode.data);
//                treeNode = treeNode.rightChild;
//            }
//        }
//    }

    /**
     * 层序遍历
     * <p>
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-ceng-xu-bian-li-fu-dai-zi-mu-9cfv8/
     *
     * @param root
     */
    public static void levelOrderTravel(TreeNode root) {
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    public static void levelOrderTravelNew(TreeNode root) {
        java.util.Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
    }

}

/**
 * 二叉树节点
 */
class TreeNode {
    int data;
    TreeNode leftChild;
    TreeNode rightChild;

    TreeNode(int data) {
        this.data = data;
    }
}
