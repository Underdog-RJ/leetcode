package cn.underdog.tree;

import cn.underdog.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 */
public class Problem36 {
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
        postorderTraversal(treeNode1);
    }

    static List<Integer> list = new ArrayList<>();

//    public static List<Integer> preorderTraversal(TreeNode root) {
//        if(root!=null){
//            list.add(root.val);
//            preorderTraversal(root.left);
//            preorderTraversal(root.right);
//        }
//        return list;
//    }

    //    public static List<Integer> preorderTraversal(TreeNode root) {
//        Stack<TreeNode> stack =new Stack<>();
//        while (!stack.empty()||root!=null){
//            if(root!=null){
//                list.add(root.val);
//                stack.push(root);
//                root=root.left;
//            }else {
//                TreeNode pop = stack.pop();
//                root=pop.right;
//            }
//
//        }
//        return list;
//    }
//    public List<Integer> postorderTraversal(TreeNode root) {
//
//        if (root != null) {
//            postorderTraversal(root.left);
//            postorderTraversal(root.right);
//            list.add(root.val);
//        }
//        return list;
//    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodes= new Stack<>();
        TreeNode p=root;
        TreeNode r=p;
        while (!treeNodes.empty()||p!=null){
            if (p != null) {
                treeNodes.add(p);
                p=p.left;
            }else {
                p = treeNodes.peek();

                if (p.right != null && p.right != r) {
                    p=p.right;
                    treeNodes.push(p);
                    p=p.left;
                }else {
                    p=treeNodes.pop();
                    list.add(p.val);
                    r=p;
                    p=null;
                }
            }
        }
        return list;
    }
}
