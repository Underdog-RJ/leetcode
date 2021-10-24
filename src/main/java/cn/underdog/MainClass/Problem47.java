package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings({"all"})
public class Problem47 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(37);
        TreeNode treeNode11 = new TreeNode(-34);
        TreeNode treeNode12 = new TreeNode(-48);

        TreeNode treeNode21 = new TreeNode(100);
        TreeNode treeNode22 = new TreeNode(-101);
        TreeNode treeNode31 = new TreeNode(48);

        TreeNode treeNode41 = new TreeNode(-54);
        TreeNode treeNode42 = new TreeNode(-71);
        TreeNode treeNode44 = new TreeNode(-22);
        TreeNode treeNode45 = new TreeNode(8);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode11.right = treeNode21;

        treeNode12.left = treeNode22;
        treeNode12.right = treeNode31;

        treeNode31.left = treeNode41;
        treeNode41.left = treeNode42;
        treeNode41.right = treeNode44;
        treeNode44.right = treeNode45;


        TreeNode treeNode = lowestCommonAncestor(treeNode1, treeNode42, treeNode45);
        System.out.println(treeNode.val);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归出口条件
        if(root==p||root==q)
            return root;
        if (root != null) {
            // 返回左子树
            TreeNode lnode = lowestCommonAncestor(root.left, p, q);
            TreeNode rnode = lowestCommonAncestor(root.right, p, q);
            if(lnode!=null&&rnode!=null)
                return root;
            else if (lnode != null) {
                return lnode;
            }
            else {
                return rnode;
            }
        }
        return null;
    }

    static TreeNode ans;
    private static boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return false;
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);

        if(root.val == p.val)
            lson=true;
        if(root.val == q.val)
            rson=true;
        if(lson&&rson){
            ans=root;
            return true;
        }
        else
            return false;
    }



   /*
    static List<Integer> list = new ArrayList<>() {{
        add(Integer.MAX_VALUE);
    }};
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LevelOrder(root);
        int length = list.size() - 1;
        for (; length > 0; length--) {
            if (list.get(length) != Integer.MIN_VALUE)
                break;
        }
        list = list.subList(0, length + 1);

        int left = 1;
        int right = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == p.val) {
                left = i;
            } else if (list.get(i) == q.val) {
                right = i;
            }
        }

        while (left != right) {
            if (left > right) {
                left = left / 2;
            } else {
                right = right / 2;
            }
        }
        return new TreeNode(list.get(left));
    }

    public static void LevelOrder(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode p = root;
        treeNodeQueue.add(p);
        Integer integer = levelOrderForLast(root);
        boolean flag = true;

        while (p != null || !treeNodeQueue.isEmpty()) {

            p = treeNodeQueue.remove();
            if (!flag)
                break;
            if (p != null) {
                if (p.val == integer) {
                    flag = false;
                }
            }
            if (p == null) {
                list.add(Integer.MIN_VALUE);
                treeNodeQueue.add(null);
                treeNodeQueue.add(null);
            }
            if (p != null) {
                list.add(p.val);
                treeNodeQueue.add(p.left);
                treeNodeQueue.add(p.right);
            }

            p = null;
        }
    }

    static List currentList = new ArrayList();

    public static Integer levelOrderForLast(TreeNode root) {
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
        List<Integer> listff = result.get(result.size() - 1);
        return listff.get(listff.size() - 1);
    }*/
}


