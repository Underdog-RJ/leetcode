package cn.underdog.leetcode.tree;
import cn.underdog.leetcode.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class Problem16 {
   static List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        TreeNode treeNode1=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        treeNode.right=treeNode1;
        treeNode1.left=treeNode2;
        List<Integer> list = InOrder(treeNode);
        list.forEach(System.out::println);

    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        if(root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }


    public static List<Integer> InOrder(TreeNode root){
        Stack<TreeNode> treeNodes =new Stack<>();
        TreeNode p =root;
        while (!treeNodes.empty()||p!=null){
            if(p!=null){
                treeNodes.push(p);
                p=p.left;
            }else {
                p=treeNodes.pop();
                list.add(p.val);
                p=p.right;
            }
        }
        return list;
    }

}
