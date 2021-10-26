package cn.underdog.MainClass;


import cn.underdog.entity.TreeNode;
import cn.underdog.entity.tree.Node;

import java.util.LinkedList;
import java.util.Queue;


public class day_06 {
    public static void main(String[] args) {
      /*  TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(3);
        TreeNode treeNode12 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(0);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        treeNode11.left = treeNode2;
        treeNode11.right = treeNode21;
        treeNode21.left = treeNode22;

        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(1);
        TreeNode treeNode33 = new TreeNode(2);

        treeNode31.left = treeNode32;
        treeNode31.right = treeNode33;*/
      /*  TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode21 = new TreeNode(1);
        TreeNode treeNode22 = new TreeNode(2);
        treeNode1.left = treeNode11;
        treeNode11.left = treeNode12;
        treeNode12.left = treeNode2;
        treeNode2.left = treeNode21;
        treeNode2.right = treeNode22;

        TreeNode treeNode31 = new TreeNode(1);
        TreeNode treeNode32 = new TreeNode(1);
        TretreeNode31.left = treeNode32;
        treeNode31.right = treeNode33;eNode treeNode33 = new TreeNode(2);

        */
        TreeNode treeNode1 = new TreeNode(-2);
        TreeNode treeNode11 = new TreeNode(-1);
        TreeNode treeNode12 = new TreeNode(8);
        TreeNode treeNode2 = new TreeNode(-6);
        TreeNode treeNode21 = new TreeNode(-2);
        TreeNode treeNode22 = new TreeNode(3);
        TreeNode treeNode23 = new TreeNode(9);
        TreeNode treeNode24 = new TreeNode(-5);
        TreeNode treeNode25 = new TreeNode(0);
        TreeNode treeNode26 = new TreeNode(7);
        treeNode1.left = treeNode11;
       /* treeNode1.right = treeNode12;

        treeNode11.left = treeNode2;
        treeNode11.right = treeNode21;

        treeNode12.left = treeNode22;
        treeNode12.right = treeNode23;

        treeNode2.left =treeNode24;

        treeNode22.left=treeNode25;
        treeNode22.right=treeNode26;*/

        TreeNode treeNode31 = new TreeNode(-2);
        TreeNode treeNode32 = new TreeNode(0);
        TreeNode treeNode33 = new TreeNode(5848);

//        treeNode31.left = treeNode32;
//        treeNode31.right = treeNode33;


//        boolean subtree = isSubtree(treeNode1, treeNode31);
//        System.out.println(subtree);

        Node root = new Node(1);
        Node root1 = new Node(2);
        Node root2 = new Node(3);
        Node root3 = new Node(4);
        Node root4 = new Node(5);
        Node root5 = new Node(7);
        root.left = root1;
        root.right = root2;

        root1.left = root3;
        root1.right = root4;
        root2.right = root5;


        connect(root);
    }

    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
     * <p>
     * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        boolean l = false;
        boolean r = false;
        if (root != null && subRoot != null) {
            l = isSubtree(root.left, subRoot);
            r = isSubtree(root.right, subRoot);
            if (l || r)
                return true;
            if (root.val == subRoot.val) {
                boolean dfs = dfs(root.left, subRoot.left);
                boolean dfs1 = dfs(root.right, subRoot.right);
                return dfs && dfs1;
            }
        }
        return l || r;
    }

    public static boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null && subRoot != null)
            return false;
        if (root != null && subRoot == null)
            return false;
        if (root.val != subRoot.val)
            return false;
        boolean lflag = dfs(root.left, subRoot.left);
        boolean rflag = dfs(root.right, subRoot.right);
        return lflag && rflag;
    }

    /**
     * 给定一个二叉树
     * <p>
     * struct Node {
     * int val;
     * Node *left;
     * Node *right;
     * Node *next;
     * }
     * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * <p>
     * 初始状态下，所有 next 指针都被设置为 NULL。
     * <p>
     *  
     * <p>
     * 进阶：
     * <p>
     * 你只能使用常量级额外空间。
     * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
     *  
     * <p>
     * 示例：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,2,3,4,5,null,7]
     * 输出：[1,#,2,3,#,4,5,7,#]
     * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指针连接），'#' 表示每层的末尾。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public static Node connect(Node root) {
        if (root == null)
            return null;
        Node p = root;
        Node currentTail = root;
        Node nextTail = root;
        if (root.left != null)
            nextTail = root.left;
        if (root.right != null)
            nextTail = root.right;
        Queue<Node> queue = new LinkedList<>();
        queue.add(p);
        while (p != null || !queue.isEmpty()) {
            p = queue.remove();
            if (p.left != null) {
                queue.add(p.left);
                nextTail = p.left;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextTail = p.right;
            }
            if (currentTail == p) {
                p.next = null;
                currentTail = nextTail;
            } else {
                Node next = queue.peek();
                p.next = next;
            }
            p = null;
        }
        return root;
    }

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * <p>
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * <p>
     * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回矩阵中 省份 的数量。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
     * 输出：2
     * 示例 2：
     * <p>
     * <p>
     * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
     * 输出：3
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {

        for (int i = 0; i < isConnected.length-1; i++) {
            for (int j = i; j < isConnected.length; j++) {
                if (isConnected[i][j + 1] == 1) {

                }
            }
        }

        return 0;

    }


}
