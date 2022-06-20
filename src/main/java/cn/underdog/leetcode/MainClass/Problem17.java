package cn.underdog.leetcode.MainClass;

import cn.underdog.leetcode.entity.TreeNode;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Problem17 {

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode11=new TreeNode(2);
        TreeNode treeNode12=new TreeNode(3);
        TreeNode treeNode2=new TreeNode(1);
        TreeNode treeNode21=new TreeNode(2);
//        TreeNode treeNode22=new TreeNode();
        treeNode1.left=treeNode11;
        treeNode1.right=treeNode12;
        treeNode2.left=treeNode21;
//        treeNode2.right=treeNode22;
        boolean sameTree = isSameTree(treeNode1, treeNode2);
        System.out.println(sameTree);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null){
            if(p.val==q.val){
                boolean lflag = isSameTree(p.left, q.left);
                boolean rflag = isSameTree(p.right, q.right);
                return lflag&&rflag;
            }else {
                return false;
            }
        }else if(p!=null&&q==null){
            return false;
        }else if(p==null&&q!=null){
            return false;
        }else {
            return true;
        }

    }

}
