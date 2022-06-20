package cn.underdog.leetcode.MainClass;

import cn.underdog.leetcode.entity.TreeNode;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 *
 */
import java.util.ArrayList;
import java.util.List;
public class Problem51 {
    public static void main(String[] args) {

    }

    static List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
       InOrder(root);
       return list.get(k-1);
    }

    private static void InOrder(TreeNode root){
        if (root != null) {
            InOrder(root.left);
            list.add(root.val);
            InOrder(root.right);
        }
    }
}
