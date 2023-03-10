package cn.underdog.leetcode.tree;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class TraverseTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(-2);
        root.left = node1;
        node1.left = node3;
        node3.left = node6;
        node3.right = node7;
        PreOrder(root);
        //PreOrder(root);
        //InOrder(root);
        //PostOrder(root);
//        int i = BDepth(root);
//        System.out.println(i);
//        System.out.println(BDepthByLevel(root));
    }

    /**
     * 先根遍历，借助栈的思想
     *
     * @param root
     */
    /*public static void PreOrder(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = root;
        while (!treeNodes.empty() || p != null) {
            if (p != null) {
                System.out.println(p.val);
                treeNodes.push(p);
                p = p.left;
            } else {
                p = treeNodes.pop();
                p = p.right;
            }
        }
    }*/
    public static void PreOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }

    }


    /**
     * 中序遍历
     *
     * @param treeNode
     */
/*
    public static void InOrder(TreeNode treeNode) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = treeNode;
        while (!treeNodes.empty() || p != null) {
            if (p != null) {
                treeNodes.push(p);
                p = p.left;
            } else {
                p = treeNodes.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }
*/
    public static void InOrder(TreeNode treeNode) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = treeNode;
        while (!treeNodes.empty() || p != null) {
            if (p != null) {
                treeNodes.push(p);
                p = p.left;
            } else {
                p = treeNodes.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }

    /**
     * 后序遍历
     * r代表上次访问的右边节点，如果不引入r，会造成一直遍历右边节点
     */
   /* public static void PostOrder(TreeNode treeNode) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = treeNode;
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
                    System.out.println(p.val);
                    r = p;
                    p = null;
                }
            }
        }
    }
*/
    public static void PostOrder(TreeNode treeNode) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = treeNode;
        TreeNode r = p;
        while (!treeNodes.empty() || p != null) {
            // 如果此时p 不为null则一直遍历左边，知道遍历到左下角
            if (p != null) {
                treeNodes.push(p);
                p = p.left;
            }
            // 如果此时p 为null,则证明左边遍历完了
            else {
                // 查看栈顶元素
                p = treeNodes.peek();
                // 如果此时栈顶元素的右边没有遍历过，则应该向右边遍历
                if (p.right != null && p.right != r) {
                    p = p.right;
                    treeNodes.push(p);
                    p = p.left;
                }
                // 此时证明，右边没有原则，则应该输出
                else {
                    p = treeNodes.pop();
                    System.out.println(p.val);
                    r = p;
                    p = null;
                }
            }
        }
    }

    /**
     * 层次遍历
     */
    public static void LevelOrder(TreeNode treeNode) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode p = treeNode;
        treeNodeQueue.add(p);
        int count = 0;
        while (p != null || !treeNodeQueue.isEmpty()) {
            p = treeNodeQueue.remove();
            System.out.println(p.val);
            if (p.left != null) {
                treeNodeQueue.add(p.left);
            }
            if (p.right != null) {
                treeNodeQueue.add(p.right);
            }
            p = null;
        }
        System.out.println(count);
    }

    /**
     * 递归求二叉树的深度
     *
     * @param treeNode
     * @return
     */
    public static int BDepth(TreeNode treeNode) {
        int ldept = 0;
        int rdept = 0;
        if (treeNode == null)
            return 0;
        ldept = BDepth(treeNode.left);
        rdept = BDepth(treeNode.right);
        return (ldept > rdept ? ldept : rdept) + 1;
    }

    /**
     * 层次遍历求树的深度,用currentHead指向下一层的最开始的元素，flag 代表本次是由已经添加过了。
     */
    public static int BDepthByLevel(TreeNode treeNode) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        TreeNode p = treeNode;
        TreeNode currentHead = p;
        boolean flag = false;
        treeNodeQueue.add(p);
        int count = p == null ? 0 : 1;
//        int count = 0;
        while (p != null || !treeNodeQueue.isEmpty()) {
            p = treeNodeQueue.remove();
            if (p == currentHead)
                flag = false;
            if (p.left != null) {
                treeNodeQueue.add(p.left);

                // 如果flag == false 代表本层并未添加
                if (!flag) {
                    count++;
                    flag = true;
                    currentHead = p.left;
                }

            }
            if (p.right != null) {
                treeNodeQueue.add(p.right);
                // 如果flag == false 代表本层并未添加
                if (!flag) {
                    count++;
                    flag = true;
                    currentHead = p.right;
                }
            }
            p = null;
        }
        return count;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode p = root;
        TreeNode currntTail = root;
        TreeNode nextTail = root;
        if (root.left != null)
            nextTail = root.left;
        if (root.right != null)
            nextTail = root.right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        List<Integer> integers = new ArrayList<>();
        while (!queue.isEmpty() || p != null) {
            p = queue.remove();
            if (p.left != null) {
                queue.add(p.left);
                nextTail = p.left;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextTail = p.right;
            }
            if (p == currntTail) {
                integers.add(p.val);
                List<Integer> list = new ArrayList<>();
                list.addAll(integers);
                res.add(list);
                integers.clear();
                currntTail = nextTail;
            } else {
                integers.add(p.val);
            }
            p = null;
        }
        Collections.reverse(res);
        return res;
    }

}
