package cn.underdog.tree;

import cn.underdog.entity.TreeNode;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 *  1
 *     \
 *      2
 *     /
 *    2
 *返回[2].
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.ArrayList;
import java.util.List;
public class Problem52 {
    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(5);
//        TreeNode treeNode11 = new TreeNode(3);
//        TreeNode treeNode12 = new TreeNode(7);
//
//        TreeNode treeNode21 = new TreeNode(3);
//        TreeNode treeNode22 = new TreeNode(7);
//
//        treeNode1.left = treeNode11;
//        treeNode1.right = treeNode12;
//        treeNode11.left=treeNode21;
//        treeNode12.left=treeNode22;
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        treeNode1.right=treeNode2;
        findMode(treeNode1);
    }

    static List<Integer> answer = new ArrayList<>();
    static int maxCount,base,count;
    /**
     * 中序遍历，为非递减数组，相等的数字连续出现。
     *          如果当前数字出现过，count ++
     *          如果当前数字未出现过，记录当前数字，并且出现次数置为1
     *
     *          如果当前count==maxCount
     *              则添加元素到结果集
     *          如果当前count>MaxCount
     *              则前面的结果集无效，清空结果集，更新未本次的结果。
     * @param root
     */
    public static int[] findMode(TreeNode root) {
        dfs(root);
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i)
            mode[i] = answer.get(i);
        return mode;
    }


    private static void dfs(TreeNode root) {
        if(root==null)
            return;
        dfs(root.left);
        update(root.val);
        dfs(root.right);
    }

    private static void update(int x) {
        if(base==x){
            count++;
        }else {
            base = x;
            count = 1;
        }
        if(count==maxCount){
            answer.add(base);
        }
        if(count>maxCount){
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }


}
