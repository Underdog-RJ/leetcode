package cn.underdog.tree;

import cn.underdog.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem28 {

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
        System.out.println(maxDepth1(treeNode1));
    }

    public static int maxDepth(TreeNode root) {

        int ldept=0;
        int rdept=0;
        if(root==null)
            return 0;
        ldept=maxDepth(root.left);
        rdept=maxDepth(root.right);
        return (ldept>rdept?ldept:rdept)+1;
    }

    public static int maxDepth1(TreeNode root) {

        Queue<TreeNode> treeNodeQueue =new LinkedList<>();
        TreeNode p=root;
        TreeNode currentHead=p;
        boolean flag=false;
        int count=0;
        if(p!=null){
            treeNodeQueue.add(p);
            count=1;
        }
        while (p!=null||!treeNodeQueue.isEmpty()){
            p=treeNodeQueue.remove();
            if(p==currentHead)
                flag=false;
            if(p.left!=null){
                treeNodeQueue.add(p.left);
                // 如果flag == false 代表本层并未添加
                if(!flag) {
                    count++;
                    flag=true;
                    currentHead=p.left;
                }
            }
            if(p.right!=null)
            {
                treeNodeQueue.add(p.right);
                // 如果flag == false 代表本层并未添加
                if(!flag) {
                    count++;
                    flag=true;
                    currentHead=p.right;
                }
            }
            p=null;
        }
        return count;
    }






}
