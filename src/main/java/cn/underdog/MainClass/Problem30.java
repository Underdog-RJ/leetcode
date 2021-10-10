package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

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
        sortedArrayToBST(nums);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
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
    }


}
