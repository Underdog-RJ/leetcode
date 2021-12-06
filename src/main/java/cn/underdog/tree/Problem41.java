package cn.underdog.tree;

import cn.underdog.entity.TreeNode;

/**
 * 翻转一棵二叉树。
 */
public class Problem41 {
    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode11=new TreeNode(2);
        TreeNode treeNode12=new TreeNode(3);
        TreeNode treeNode2=new TreeNode(4);
        TreeNode treeNode21=new TreeNode(5);
        treeNode1.left=treeNode11;
        treeNode1.right=treeNode12;
        treeNode11.left=treeNode2;
        treeNode11.right=treeNode21;
        TreeNode treeNode = invertTree(treeNode1);
        System.out.println(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            if (root.left != null && root.right != null) {
                TreeNode temp = root.left;
                root.left=root.right;
                root.right=temp;
            }else if(root.left == null && root.right != null)
            {
                root.left=root.right;
                root.right=null;
            }
            else if(root.left != null && root.right == null)
            {
               root.right=root.left;
               root.left=null;
            }
        }

        return root;
    }

}
