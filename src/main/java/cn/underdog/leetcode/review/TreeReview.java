package cn.underdog.leetcode.review;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class TreeReview {

    public static void main(String[] args) {

    }

    /**
     * 后根非递归遍历
     *
     * @param node
     */
    public void PostOrder(TreeNode node) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode p = node;
        TreeNode r = p;
        while (!treeNodes.isEmpty() || p != null) {
            if (p != null) {
                treeNodes.add(p);
                p = p.left;
            } else {
                p = treeNodes.peek();
                if (p.right != null && p.right != r) {
                    p = p.right;
                    treeNodes.push(p);
                    p = p.left;
                } else {
                    p = treeNodes.pop();
                    r = p;
                    p = null;
                }
            }
        }
    }

    /**
     * 1、offer()和add()的区别
     * add()和offer()都是向队列中添加一个元素。但是如果想在一个满的队列中加入一个新元素，调用 add() 方法就会抛出一个 unchecked 异常，而调用 offer() 方法会返回 false。可以据此在程序中进行有效的判断！
     * <p>
     * 2、peek()和element()的区别
     * peek()和element()都将在不移除的情况下返回队头，但是peek()方法在队列为空时返回null，调用element()方法会抛出NoSuchElementException异常。
     * <p>
     * 3、poll()和remove()的区别
     * poll()和remove()都将移除并且返回对头，但是在poll()在队列为空时返回null，而remove()会抛出NoSuchElementException异常。
     * <p>
     * 层序遍历
     */
    public void LevelOrder(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode p = node;
        while (p != null || !queue.isEmpty()) {
            p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
            p = null;
        }
    }

    // 求二叉树的深度
    public int BDept(TreeNode node) {
        int ldept = 0;
        int rdept = 0;
        if (node == null)
            return 0;
        ldept = BDept(node.left);
        rdept = BDept(node.right);
        return Math.max(ldept, rdept) + 1;
    }


    /**
     * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
     * <p>
     * 叶子节点 是指没有子节点的节点。
     * <p>
     * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
     * 输出：[[5,4,11,2],[5,8,4,5]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/path-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static List<List<Integer>> res = new ArrayList<>();
    static Deque<Integer> integers = new LinkedList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfsPathSum(root, targetSum);
        return res;
    }

    private static void dfsPathSum(TreeNode root, int targetSum) {
        if (root != null) {
            integers.offer(root.val);
            // 如果当前节点时叶子节点时
            if (root.left == null && root.right == null) {
                //如果当前路径相等则添加
                if (root.val == targetSum) {
                    res.add(new ArrayList<>(integers));
                }
                // 否则清空当前路径
                else {
                    integers.clear();
                }
            }
        }
        dfsPathSum(root.left, targetSum - root.val);
        dfsPathSum(root.right, targetSum - root.val);
        integers.pollLast();
    }

    // 反转二叉树
    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            if (root.left != null && root.right != null) {
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            } else if (root.left != null && root.right == null) {
                root.right = root.left;
                root.left = null;
            } else if (root.left == null && root.right != null) {
                root.left = root.right;
                root.right = null;
            }
        }

        return root;
    }

    // 平衡二叉树的最近公共祖先
    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val > root.val && q.val > root.val) {
                ancestor = ancestor.right;
            } else if (p.val < root.val && q.val < root.val) {
                ancestor = ancestor.left;
            } else {
                break;
            }
        }
        return ancestor;
    }

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
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root == p || root == q)
            return root;
        TreeNode lc = lowestCommonAncestor(root.left, p, q);
        TreeNode rc = lowestCommonAncestor(root.right, p, q);
        if (lc != null && rc != null)
            return root;
        else if (lc != null)
            return lc;
        else if (rc != null)
            return rc;
        else
            return null;
    }

    /**
     * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
     * <p>
     * 假定 BST 有如下定义：
     * <p>
     * 结点左子树中所含结点的值小于等于当前结点的值
     * 结点右子树中所含结点的值大于等于当前结点的值
     * 左子树和右子树都是二叉搜索树
     * 1
     * \
     * 2
     * /
     * 2
     * 返回[2].
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // 中序遍历，二叉排序数为有序的，则可知，相同的数也是连续出现的，
    public static int[] findMode(TreeNode root) {
        dfsFindMode(root);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++)
            res[i] = ans.get(i);
        return res;
    }

    private static void dfsFindMode(TreeNode root) {
        if (root != null) {
            dfsFindMode(root.left);
            update(root.val);
            dfsFindMode(root.right);
        }
    }

    static int last, maxCount, currentCount;
    static List<Integer> ans;

    private static void update(int current) {
        // 如果上次的值和本次相同，更新
        if (last == current) {
            currentCount++;
        } else {
            currentCount = 1;
            last = current;
        }
        if (currentCount == maxCount) {
            ans.add(current);
        } else if (currentCount > maxCount) {
            ans.clear();
            ans.add(current);
            maxCount = currentCount;
        }
    }


    private static int[] findMode1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        int maxCount = 0, currentCount = 0;
        int last = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (last == list.get(i)) {
                currentCount++;
            } else {
                currentCount = 1;
                last = list.get(i);
            }
            if (currentCount == maxCount) {
                ans.add(list.get(i));
            } else if (currentCount > maxCount) {
                ans.clear();
                ans.add(list.get(i));
                maxCount = currentCount;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private static void InOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            InOrder(root.left, list);
            list.add(root.val);
            InOrder(root.right, list);
        }
    }

    /**
     * 给定一个二叉树，计算 整个树 的坡度 。
     * <p>
     * 一个树的 节点的坡度 定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值 。如果没有左子树的话，左子树的节点之和为 0 ；没有右子树的话也是一样。空结点的坡度是 0 。
     * <p>
     * 整个树 的坡度就是其所有节点的坡度之和。
     * 输入：root = [1,2,3]
     * 输出：1
     * 解释：
     * 节点 2 的坡度：|0-0| = 0（没有子节点）
     * 节点 3 的坡度：|0-0| = 0（没有子节点）
     * 节点 1 的坡度：|2-3| = 1（左子树就是左子节点，所以和是 2 ；右子树就是右子节点，所以和是 3 ）
     * 坡度总和：0 + 0 + 1 = 1
     * <p>
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static int findTileAns = 0;

    public static int findTilt(TreeNode root) {
        extracted(root);
        return findTileAns;
    }

    private static int extracted(TreeNode root) {
        if (root == null)
            return 0;
        int lc = findTilt(root.left);
        int rc = findTilt(root.right);
        findTileAns += Math.abs(lc - rc);
        return lc + rc + root.val;
    }
}
