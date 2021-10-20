package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 */
public class Problem34 {

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode11=new TreeNode(2);
        TreeNode treeNode12=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode21=new TreeNode(3);
        TreeNode treeNode31=new TreeNode(4);
        TreeNode treeNode32=new TreeNode(4);
        treeNode1.left=treeNode11;
        treeNode1.right=treeNode12;
        treeNode11.left=treeNode2;
        treeNode12.right=treeNode21;
        treeNode2.left = treeNode31;
        treeNode21.right = treeNode32;

        boolean balanced = isBalanced(treeNode1);
        System.out.println(balanced);

    }

    /**
     * 当前节点的高度，如果>1直接返回false 之后当前节点都为true时返回true
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {

        if(root!=null){
            int left = isBalancedDG(root.left);
            int right = isBalancedDG(root.right);
            if(Math.abs(left-right)>1)
               return false;
            return isBalanced(root.left)&&isBalanced(root.right);
        }
        return true;
    }

    public static int isBalancedDG(TreeNode root) {
        int ldept=0;
        int rdept=0;
        if(root==null)
            return 0;
        ldept=isBalancedDG(root.left);
        rdept=isBalancedDG(root.right);
        return (ldept>rdept?ldept:rdept)+1;
    }

}
