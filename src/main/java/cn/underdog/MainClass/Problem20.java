package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem20 {
    public static void main(String[] args) {

        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(2);
        TreeNode treeNode4=new TreeNode(1);
        TreeNode treeNode5=new TreeNode(1);
        TreeNode treeNode6=new TreeNode();
        treeNode1.left=treeNode2;
        treeNode1.right=treeNode3;
        treeNode2.left=treeNode4;
        treeNode3.right=treeNode5;
        boolean symmetric = isSymmetric(treeNode1);
        System.out.println(symmetric);


    }
/*
    public static boolean isSymmetric(TreeNode root) {

        boolean flag =false;
        if(root!=null){
            if(root.left!=null&&root.right!=null){
                if(root.left.val==root.right.val){
                    flag=isSymmetric(root.left)&&isSymmetric(root.right);
                }
                else {
                    flag= false;
                }
            }else if(root.left==null&&root.right==null){
                flag= true;
            }else {
                flag= false;
            }
        }


        return flag;
    }*/

    public static boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        if(root.left!=null&&root.right!=null){
            return isSameTree(root.left,root.right);
        }else if(root.left==null&&root.right==null){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p!=null&&q!=null){
            if(p.val==q.val){
                boolean lflag = isSameTree(p.left, q.right);
                boolean rflag = isSameTree(p.right, q.left);
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
