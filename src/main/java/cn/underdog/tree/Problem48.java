package cn.underdog.tree;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 二叉树：[3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */

import cn.underdog.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem48 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);

        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(5);
        TreeNode treeNode31 = new TreeNode(1);

      /*  treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode11.left = treeNode21;
        treeNode11.right = treeNode22;*/
        treeNode1.left = treeNode11;
        treeNode11.left = treeNode12;

        treeNode12.left = treeNode21;
        treeNode21.right = treeNode22;
        List<List<Integer>> list = levelOrder(treeNode1);
        for (List<Integer> integers : list) {
            System.out.println(integers.toString());
        }
    }

    static List currentList = new ArrayList();

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode p = root;
        TreeNode nextHead = root;
        boolean flag = false;
        if (root != null) {
            treeNodeQueue.add(p);
            currentList.add(root.val);
        }
        while (p != null || !treeNodeQueue.isEmpty()) {
            p = treeNodeQueue.remove();
            if (p == nextHead) {
                result.add(currentList);
                flag = false;
                currentList = new ArrayList();
            }
            if (p.left != null) {
                treeNodeQueue.add(p.left);
                currentList.add(p.left.val);
                if (!flag) {
                    nextHead = p.left;
                    flag = true;
                }
            }
            if (p.right != null) {
                treeNodeQueue.add(p.right);
                currentList.add(p.right.val);
                if (!flag) {
                    nextHead = p.right;
                    flag = true;
                }
            }
            p = null;
        }
        if (currentList != null && currentList.size() > 0) {
            result.add(currentList);
        }
        return result;
    }
}
