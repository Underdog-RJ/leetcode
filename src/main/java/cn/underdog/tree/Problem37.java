package cn.underdog.tree;

import cn.underdog.entity.TreeNode;

import java.util.Stack;

/**
 * 求最小高度
 */
public class Problem37 {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(0);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(3);
        TreeNode treeNode22 = new TreeNode(-1);
        TreeNode treeNode31 = new TreeNode(5);
        TreeNode treeNode32 = new TreeNode(1);
        TreeNode treeNode41 = new TreeNode(6);
        TreeNode treeNode42 = new TreeNode(8);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        treeNode11.left = treeNode2;
        treeNode12.left = treeNode21;
        treeNode12.right = treeNode22;
        treeNode2.left = treeNode31;
        treeNode2.right = treeNode32;
        treeNode21.right = treeNode41;
        treeNode22.right = treeNode42;

        int i = minDepth(treeNode1);
        System.out.println(i);
    }

    static int dept = 1;
    static int min = Integer.MAX_VALUE;

    public static int minDepth(TreeNode root) {

        if(root==null)
            return 0;

        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = root;
        TreeNode r = p;
        while (!treeNodes.empty() || p != null) {
            if (p != null) {
                treeNodes.push(p);
                p = p.left;
            } else {
                p = treeNodes.peek();
                if (p.right != null && p.right != r) {
                    p = p.right;
                    treeNodes.push(p);
                    p = p.left;
                } else {
                    p = treeNodes.pop();
                    if (p.left == null && p.right == null) {
                        if (min > treeNodes.size() + 1) {
                            min=treeNodes.size()+1;
                        }
                    }
                    r = p;
                    p = null;
                }
            }
        }

        return min;
    }
}
