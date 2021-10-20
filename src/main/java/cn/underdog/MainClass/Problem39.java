package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem39 {

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
        boolean b = hasPathSum1(treeNode1, 10);
        System.out.println(b);
    }

    /**
     * 后续遍历，求当前栈内全部元素的和+当前元素的值是否为 targetSum 如果是则返回true全部路径遍历结束之后如果不存在则返回false
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {

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
                        if(collect+p.val==targetSum)
                            return true;
                    }
                    r = p;
                    p = null;
                }
            }
        }
        return false;
    }
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        return hasPathSumDG(root,targetSum);
    }




    public static boolean hasPathSumDG(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        if(root!=null){
            return  hasPathSumDG(root.left,targetSum-root.val)||hasPathSumDG(root.right,targetSum-root.val);
        }
        return targetSum==0?true:false;

    }
}
