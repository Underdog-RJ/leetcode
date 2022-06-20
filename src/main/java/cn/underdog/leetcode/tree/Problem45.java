package cn.underdog.leetcode.tree;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Problem45 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);

        TreeNode treeNode21 = new TreeNode(4);
        TreeNode treeNode22 = new TreeNode(5);
        TreeNode treeNode31 = new TreeNode(1);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode11.left = treeNode21;
        treeNode11.right = treeNode22;
//        treeNode21.left = treeNode31;
        sumOfLeftLeaves(treeNode1);
    }


    static Deque<Integer> integers = new LinkedList<>();

    public static int sumNumbers(TreeNode root) {
        return hasPathSum(root,new ArrayList<Integer>());
    }


    public static int hasPathSum(TreeNode root,List<Integer> list) {
        if(root==null)
            return 0;
        if (root.left == null && root.right == null) {
            StringBuilder sb =new StringBuilder();
            integers.forEach(item->sb.append(item));
            sb.append(root.val);
            list.add(Integer.parseInt(sb.toString()));
        }
        if (root != null) {
            integers.add(root.val);
            hasPathSum(root.left,list);
            hasPathSum(root.right,list);
            integers.pollLast();
        }
        return list.stream().collect(Collectors.summingInt(item->item));
    }

    /*public int sumNumbers(TreeNode root) {

        Stack<TreeNode> treeNodes = new Stack<>();
        List<Integer> list =new ArrayList<>();
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
                        StringBuilder sb =new StringBuilder();
                        treeNodes.forEach(item->sb.append(item.val));
                        sb.append(p.val);
                        list.add(Integer.parseInt(sb.toString()));
                    }
                    r = p;
                    p = null;
                }
            }
        }
        return list.stream().collect(Collectors.summingInt(item->item));
    }*/


    static List<String> strings = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return null;
        if (root.left == null && root.right == null) {
            StringBuilder sb =new StringBuilder();
            integers.forEach(item->sb.append(item+"->"));
            sb.append(root.val);
            strings.add(sb.toString());
        }
        if (root != null) {
            integers.add(root.val);
            binaryTreePaths(root.left);
            binaryTreePaths(root.right);
            integers.pollLast();
        }
        return strings;
    }

    static int sum = 0;
    static Deque<TreeNode> treeNodeDeque = new LinkedList<>();
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        if (root.left == null && root.right == null) {
            if(!treeNodeDeque.isEmpty()){
                TreeNode last = treeNodeDeque.getLast();
                if (last.left == root) {
                    sum+=root.val;
                }
            }
        }
        if (root != null) {
            treeNodeDeque.add(root);
            sumOfLeftLeaves(root.left);
            sumOfLeftLeaves(root.right);
            treeNodeDeque.pollLast();
        }
        return sum;
    }
}
