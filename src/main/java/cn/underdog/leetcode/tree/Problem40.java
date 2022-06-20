package cn.underdog.leetcode.tree;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import cn.underdog.leetcode.entity.TreeNode;


import java.util.*;

public class Problem40 {

    public static void main(String[] args) {
        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode11=new TreeNode(2);
        TreeNode treeNode12=new TreeNode(2);
        TreeNode treeNode2=new TreeNode(3);
        TreeNode treeNode21=new TreeNode(3);
        TreeNode treeNode31=new TreeNode(4);
        TreeNode treeNode32=new TreeNode(4);
        TreeNode treeNode33=new TreeNode(4);
        treeNode1.left=treeNode11;
        treeNode1.right=treeNode12;
        treeNode11.left=treeNode2;
        treeNode12.right=treeNode21;
        treeNode2.left = treeNode31;
        treeNode21.right = treeNode32;
        treeNode2.right=treeNode33;
        List<List<Integer>> list = pathSum(treeNode1, 10);
        for (List<Integer> integers : list) {
            System.out.println(integers);
        }
    }

  /*  public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
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
                        Integer collect = treeNodes.stream().collect(Collectors.summingInt(item -> item.val));
                        if (collect + p.val == targetSum) {
                            List<Integer> temp = new ArrayList<>();
                            treeNodes.stream().forEach(item -> temp.add(item.val));
                            temp.add(p.val);
                            list.add(temp);
                        }
                    }
                    r = p;
                    p = null;
                }
            }
        }
        return list;
    }*/
    static List<List<Integer>> list = new ArrayList<>();
    static Deque<TreeNode> path = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return list;
    }

    private static void dfs(TreeNode root, int targetSum) {
        if(root!=null){
            path.add(root);
            if (root.left == null && root.right == null) {
                if (root.val == targetSum) {
                    List<Integer> temp = new ArrayList<>();
                    path.forEach(item->temp.add(item.val));
                    list.add(temp);
                }else {
                    path = new LinkedList<>();
                }
            }
            dfs(root.left,targetSum-root.val);
            dfs(root.right,targetSum-root.val);
            path.pollLast();
        }
    }
}
