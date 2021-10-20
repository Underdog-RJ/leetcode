package cn.underdog.MainClass;

import cn.underdog.entity.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem43 {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(6);

        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(4);
        TreeNode treeNode31 = new TreeNode(1);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode11.left = treeNode21;
        treeNode11.right = treeNode22;
        treeNode21.left = treeNode31;


        System.out.println(lowestCommonAncestor(treeNode1, treeNode31, treeNode12).val);
    }

    static List<Integer> list = new ArrayList<>() {{
        add(Integer.MAX_VALUE);
    }};

  /*  public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        InOrder(root);
        int length=list.size()-1;
        for (;length >0; length--) {
            if(list.get(length)!=Integer.MIN_VALUE)
                break;
        }
        list=list.subList(0,length+1);

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
    }*/

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true){
            if(ancestor.val<p.val&&ancestor.val<q.val){
                ancestor=ancestor.right;
            } else if (ancestor.val > q.val&&ancestor.val>p.val) {
                ancestor=ancestor.left;
            }else
                break;
        }
        return ancestor;
    }

    public static void InOrder(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode p = root;
        treeNodeQueue.add(p);
        while (p != null || !treeNodeQueue.isEmpty()) {
            p = treeNodeQueue.remove();
            if(p==null){
                list.add(Integer.MIN_VALUE);
            }
            if (p != null) {
                list.add(p.val);
                treeNodeQueue.add(p.left);
                treeNodeQueue.add(p.right);
            }

            p = null;
        }
    }


}
