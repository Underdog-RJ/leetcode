package cn.underdog.leetcode.tree;

import cn.underdog.leetcode.entity.TreeNode;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.List;

public class Problem44 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(6);

        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(4);
        TreeNode treeNode31 = new TreeNode(1);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode11.left = treeNode21;
        treeNode11.right = treeNode22;
        treeNode21.left = treeNode31;
        flatten(treeNode1);
    }

    public static void flatten(TreeNode root) {

        List<TreeNode> treeNodes = new ArrayList<>();
        PreOrder(root, treeNodes);

        if (root == null)
            return;
        for (TreeNode treeNode : treeNodes) {
            if (treeNode.left != null) {
                treeNode.left = null;
            }
            if (treeNode.right != null) {
                treeNode.right = null;
            }
        }
        root.left = null;
        root.right = null;
        TreeNode p = root;
        for (int i = 1; i < treeNodes.size(); i++) {
            p.right = treeNodes.get(i);
            p = p.right;
        }


    }

    public static void PreOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            PreOrder(root.left, list);
            PreOrder(root.right, list);
        }
    }

}
