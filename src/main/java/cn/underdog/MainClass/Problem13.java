package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  
 *
 */
public class Problem13 {
    static int currentSum=0;
    static int total=0;
    static int count=0;
    public static void main(String[] args) {

        /*TreeNode root=new TreeNode(10);

        TreeNode node1 =new TreeNode(5);
        TreeNode node2 =new TreeNode(-3);

        TreeNode node3 =new TreeNode(3);
        TreeNode node4 =new TreeNode(2);
        TreeNode node5 =new TreeNode(11);
        TreeNode node6 =new TreeNode(3);
        TreeNode node7 =new TreeNode(-2);
        TreeNode node8 =new TreeNode(1);


        root.left=node1;
        root.right=node2;

        node1.left=node3;
        node1.right=node4;

        node2.right=node5;

        node3.left=node6;
        node3.right=node7;

        node4.right=node8;*/
       /* TreeNode root=new TreeNode(5);

        TreeNode node1 =new TreeNode(4);
        TreeNode node2 =new TreeNode(8);

        TreeNode node3 =new TreeNode(11);
        TreeNode node4 =new TreeNode(13);
        TreeNode node5 =new TreeNode(4);
        TreeNode node6 =new TreeNode(7);
        TreeNode node7 =new TreeNode(2);
        TreeNode node8 =new TreeNode(5);
        TreeNode node9 =new TreeNode(1);

        root.left=node1;
        root.right=node2;

        node1.left=node3;
        node2.left=node4;
        node2.right=node5;

        node3.right=node5;

        node3.left=node6;
        node3.right=node7;
        node5.left=node8;
        node5.right=node9;*/

        TreeNode root=new TreeNode(1);

        TreeNode node1 =new TreeNode(2);


        root.left=node1;

        int i = pathSum(root, 2);
        System.out.println("result");
        System.out.println(i);
        System.out.println("result");

    }

    /**
     * 思路总结：
     *      1.以当前节点为根节点，遍历全部的路径上的值，  如果和target相等就+1；
     *      2.特殊情况，当第一次currentTotal = 0 则不类加
     * @param root
     * @param targetSum
     * @return
     */
    public static int pathSum(TreeNode root, int targetSum) {
        if(root!=null){
            currentSum=0;
            count=0;
            currentRoot(root,targetSum,currentSum);
            pathSum(root.left,targetSum);
            pathSum(root.right,targetSum);
        }
        int result = total / 2;
        return result;
    }

    private static int currentRoot(TreeNode root, int targetSum,int currentSum) {
        if(currentSum==targetSum&&count!=0){
            total+=1;
        }
        if(root!=null){
            count++;
            currentSum+=root.val;
            currentRoot(root.left,targetSum,currentSum);
            currentRoot(root.right,targetSum,currentSum);
        }
        return total; 
    }

}
