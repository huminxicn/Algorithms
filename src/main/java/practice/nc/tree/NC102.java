package practice.nc.tree;

import java.util.*;

/**
 * 在二叉树中找到两个节点的最近公共祖先。
 * <p>
 * https://www.nowcoder.com/practice/e0cc33a83afe4530bcec46eba3325116?tpId=117&&tqId=37826&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * @author huminxi2017@gmail.com
 * @since 2022/01/25 23:13
 */
public class NC102 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createBinaryTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        int i = lowestCommonAncestor(root, 5, 1);
        System.out.println(i);
    }

    /**
     * 可以用哈希表存储所有节点的父节点，然后我们就可以利用节点的父节点信息从 o1 结点开始不断往上跳，并记录已经访问过的节点，再从 o2 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是要找的最近公共祖先。
     * 算法流程：
     * 1、从根节点开始遍历整棵二叉树，用哈希表记录每个节点的父节点指针。
     * 2、从 o1 节点开始不断往它的祖先移动，并用数据结构记录已经访问过的祖先节点。
     * 3、同样，我们再从 o2 节点开始不断往它的祖先移动，如果有祖先已经被访问过，即意味着这是 o1 和 o2 的深度最深的公共祖先
     *
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        //1.添加所有祖先节点
        preOrder(root);
        //2.遍历存储 o1 所有祖先
        while (parent.get(o1) != null) {
            visit.add(o1);
            o1 = parent.get(o1);
        }
        //3.如果 o2 是 o1 祖先路径上的一点，直接返回 o2；否则，遍历 o2 的所有祖先，看 visit 集合中是否有重复。
        while (parent.get(o2) != null) {
            if (visit.contains(o2)) {
                return o2;
            }
            o2 = parent.get(o2);
        }
        return root.val;
    }

    /**
     * 节点祖先集合
     */
    static Map<Integer, Integer> parent = new HashMap<>();
    /**
     * 访问节点集合
     */
    static Set<Integer> visit = new HashSet<>();

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        if (null != node.left) {
            parent.put(node.left.val, node.val);
        }
        if (null != node.right) {
            parent.put(node.right.val, node.val);
        }
        preOrder(node.left);
        preOrder(node.right);
    }
}
