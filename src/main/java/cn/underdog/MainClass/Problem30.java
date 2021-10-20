package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 输入：nums = [-10,-3,0,5,9]
 输出：[0,-3,9,-10,null,5]
 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 输入：nums = [1,3]
 输出：[3,1]
 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */
public class Problem30 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};

        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

    /**
     * 1.对于传过来的数组首先求mid
     *      1.1如果能整除则直接除以
     *      1.2如果不能整除则取中位数的右边
     *      1.3root.var = nums[mid]
     * 2.每次把传过来的数组按照中位数分割为左右两个数组。
     *      2.1递归操作本次数组
     *      2.2递归出口条件为nums.length()==0
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root =new TreeNode();
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        if(right%2==0)
            mid = (left+right)/2;
        else
            mid = (left+right)/2+1;
        root.val= nums[mid];
        int[] lnums = new int[mid-left];
        int[] rnums = new int[right-mid];
        if(lnums.length!=0){
            for (int i = 0; i < lnums.length; i++)
                lnums[i]=nums[i];
            TreeNode lTreeNode = sortedArrayToBST(lnums);
            if(root.val>lTreeNode.val)
                root.left=lTreeNode;
            else
                root.right=lTreeNode;
        }
        if(rnums.length!=0){
            for (int i = 0; i < rnums.length; i++)
                rnums[i]=nums[i+mid+1];
            TreeNode rTreeNode = sortedArrayToBST(rnums);
            if(root.val>rTreeNode.val)
                root.left=rTreeNode;
            else
                root.right=rTreeNode;
        }
        return root;
    }

    /*public static TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        int mid = length/2;
        int left = mid-1;
        int right = mid+1;
        TreeNode root= new TreeNode();
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        root.val=nums[mid==0?1:mid];
        while (left>=0||right<=length){
            if(left>=0)
            {
                TreeNode temp = new TreeNode(nums[left]);
                left--;
                leftNode.left=temp;
                leftNode = temp;
            }
            if(right<=length){
                TreeNode temp = new TreeNode(nums[right]);
                right++;
                rightNode.right = temp;
                rightNode = temp;
            }
        }
        return null;
    }*/


}
