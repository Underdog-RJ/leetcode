package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

/**
 * 给定一个二叉树，计算 整个树 的坡度 。
 *
 * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
 *
 * 整个树 的坡度就是其所有节点的坡度之和。
 *输入：root = [1,2,3]
 * 输出：1
 * 解释：
 * 节点 2 的坡度：|0-0| = 0（没有子节点）
 * 节点 3 的坡度：|0-0| = 0（没有子节点）
 * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
 * 坡度总和：0 + 0 + 1 = 1
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem79 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node3 = new TreeNode(9);
        root.left = node1;
        root.right = node3;
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(7);
        node1.left = node4;
        node1.right = node5;
        node3.right = node6;
        System.out.println(findTilt(root));

    }

    static int ans = 0;

    public static int findTilt(TreeNode root) {
        PostOrder(root);
        return ans;
    }

    public static int PostOrder(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int left = PostOrder(treeNode.left);
        int right = PostOrder(treeNode.right);
        ans += Math.abs(left - right);
        return left + right + treeNode.val;
    }
}
