package cn.underdog.tree;

import cn.underdog.entity.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        /*TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode11 = new TreeNode(2);
        TreeNode treeNode12 = new TreeNode(3);
        TreeNode treeNode22 = new TreeNode(3);
        TreeNode treeNode23 = new TreeNode(1);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        treeNode11.right=treeNode22;
        treeNode12.right=treeNode23;*/
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(3);
        TreeNode treeNode22 = new TreeNode(4);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        treeNode11.right = treeNode22;

        rob(treeNode1);

        TreeNode treeNode111 = new TreeNode(2);
        TreeNode treeNode112 = new TreeNode(1);
        TreeNode treeNode122 = new TreeNode(3);
        TreeNode treeNode223 = new TreeNode(4);
        TreeNode treeNode224 = new TreeNode(7);
        treeNode111.left = treeNode112;
        treeNode111.right = treeNode122;
        treeNode112.right = treeNode223;
        treeNode122.right = treeNode224;

//        mergeTrees(treeNode1, treeNode111);
    }

    static int last = 0;
    static int count = 0;
    static int min = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        dfsGetMinimumDifference(root);
        return min;
    }

    private static void dfsGetMinimumDifference(TreeNode root) {
        if (root != null) {
            dfsGetMinimumDifference(root.left);
            if (count != 0 && root.val - last < min)
                min = root.val - last;
            count++;
            last = root.val;
            dfsGetMinimumDifference(root.right);
        }
    }

    static int max = Integer.MIN_VALUE;

    /**
     * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
     * <p>
     *  
     * <p>
     * 示例 :
     * 给定二叉树
     * <p>
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftD = 0;
        int rightD = 0;
        if (root.left != null) {
            leftD = BDept(root.left);
        }
        if (root.right != null) {
            rightD = BDept(root.right);
        }
        if (leftD + rightD > max) {
            max = leftD + rightD;
        }
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        return max;
    }

    public static int BDept(TreeNode treeNode) {
        int lc = 0;
        int rc = 0;
        if (treeNode == null)
            return 0;
        lc = BDept(treeNode.left);
        rc = BDept(treeNode.right);
        return Math.max(lc, rc) + 1;
    }

    /**
     * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
     * <p>
     * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
     * 输入：root = [1,3,null,null,2]
     * 输出：[3,1,null,null,2]
     * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     */

    static int index = 0;
    static int countRe = 0;
    static List<Integer> list = new ArrayList<>();

    public static void recoverTree(TreeNode root) {
        if (countRe == 0) {
            InOrder(root);
            Collections.sort(list);
        }

        countRe++;
        if (root != null) {
            recoverTree(root.left);
            if (root.val != list.get(index)) {
                root.val = list.get(index);
            }
            index++;
            recoverTree(root.right);
        }

    }

    public static void InOrder(TreeNode treeNode) {
        if (treeNode != null) {
            InOrder(treeNode.left);
            list.add(treeNode.val);
            InOrder(treeNode.right);
        }
    }

    // 二叉搜索树，就需要的节点
    TreeNode ans = null;

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val > val)
            searchBST(root.left, val);
        else if (root.val < val)
            searchBST(root.right, val);
        else
            ans = root;
        return ans;
    }

    static List<Integer> listRightSideView = new ArrayList<>();

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return listRightSideView;
        PostOrder(root);
        int count = listPath.get(listPath.size() - 1).size();
        listRightSideView.addAll(listPath.get(listPath.size() - 1));
        for (int i = listPath.size() - 2; i >= 0; i--) {
            List<Integer> currentPath = listPath.get(i);
            int currentSize = currentPath.size();
            if (currentSize > count) {
                listRightSideView.addAll(currentPath.subList(count, currentSize));
                count = currentSize;
            }
        }
        return listRightSideView;
    }

    static Deque<Integer> deque = new LinkedList<>();
    static List<List<Integer>> listPath = new ArrayList<>();

    public static void PostOrder(TreeNode root) {
        if (root != null) {
            deque.add(root.val);
            if (root.left == null && root.right == null) {
                listPath.add(new ArrayList<>(deque));
            }
            PostOrder(root.left);
            PostOrder(root.right);
            deque.pollLast();
        }
    }


    static TreeNode res = null;

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * Tree 1                     Tree 2
     * 1                         2
     * / \                       / \
     * 3   2                     1   3
     * /                           \   \
     * 5                             4   7
     * 输出:
     * 合并后的树:
     * 3
     * / \
     * 4   5
     * / \   \
     * 5   4   7
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root1
     * @param root2
     * @return
     */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null && root2 != null)
            root1 = new TreeNode();
        if (root2 != null && root2 == null)
            root2 = new TreeNode();
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            if (root1.left == null && root2.left != null) {
                root1.left = new TreeNode();
            }
            if (root1.left != null && root2.left == null) {
                root2.left = new TreeNode();
            }
            mergeTrees(root1.left, root2.left);
            if (root1.right == null && root2.right != null) {
                root1.right = new TreeNode();
            }
            if (root1.right != null && root2.right == null) {
                root2.left = new TreeNode();
            }
            mergeTrees(root1.right, root2.right);
        }
        return root1;
    }

    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        InOrder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            Integer integer1 = list.get(left);
            Integer integer2 = list.get(right);
            if (integer1 + integer2 > k) {
                right--;
            } else if (integer1 + integer2 < k) {
                left++;
            } else
                return true;
        }
        return false;
    }

    public static void InOrder(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            InOrder(treeNode.left, list);
            list.add(treeNode.val);
            InOrder(treeNode.right, list);
        }
    }


    /**
     * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
     * <p>
     * <p>
     * <p>
     * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
     * <p>
     * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
     * <p>
     * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：root1 = [1], root2 = [1]
     * 输出：true
     * 示例 3：
     * <p>
     * 输入：root1 = [1], root2 = [2]
     * 输出：false
     * 示例 4：
     * <p>
     * 输入：root1 = [1,2], root2 = [2,2]
     * 输出：true
     * 示例 5：
     * <p>
     * <p>
     * <p>
     * 输入：root1 = [1,2,3], root2 = [1,3,2]
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/leaf-similar-trees
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        PreOrder(root1, list1);
        PreOrder(root2, list2);
        return list1.equals(list2) ? true : false;
    }

    public void PreOrder(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left == null && root.right == null)
                list.add(root.val);
            PreOrder(root.left, list);
            PreOrder(root.right, list);
        }
    }


    /**
     * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
     * 输出：32
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
     * 输出：23
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/range-sum-of-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    static int rangeSumResult;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root != null) {
            rangeSumBST(root.left, low, high);
            if (root.val <= high && root.val >= low)
                rangeSumResult += root.val;
            rangeSumBST(root.right, low, high);
        }
        return rangeSumResult;
    }


    // 先层次遍历，后dp

    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     * <p>
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,3,null,3,null,1]
     * <p>
     * 3
     * / \
     * 2   3
     * \   \
     * 3   1
     * <p>
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     * <p>
     * 输入: [3,4,5,1,3,null,1]
     * <p>
     *      3
     * / \
     * 4   5
     * / \   \
     * 1   3   1
     * <p>
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    // 用money存储当前节点的最大值
    static Map<TreeNode, Integer> money = new HashMap<>();

    public static int rob(TreeNode root) {
        if (money.containsKey(root)) return money.get(root);
        if (root == null) {
            money.put(root, 0);
            return 0;
        }
        if (root.left == null && root.right == null) {
            money.put(root, root.val);
            return root.val;
        }
        // 决定打劫当前节点则遍历左右孩子的的左右节点
        int yes = root.val;
        if (root.left != null) {
            yes += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            yes += rob(root.right.left) + rob(root.right.right);
        }
        int no = rob(root.left) + rob(root.right);
        money.put(root, Math.min(yes, no));
        return Math.max(yes, no); // 取打劫或不打劫根节点的最高一个。

    }
  /*  public static int rob(TreeNode root) {
        if (root == null)
            return 0;
        List<List<Integer>> resList = levelOrder(root);
        List<Integer> tempList = new ArrayList<>();
        for (List<Integer> integers : resList) {
            tempList.add(integers.stream().collect(Collectors.summingInt(item -> item.intValue())));
        }
        int[] dp = new int[tempList.size()];
        if (tempList.size() == 1)
            return tempList.get(0);
        dp[0] = tempList.get(0);
        if (tempList.size() == 2)
            return Math.max(tempList.get(0), tempList.get(1));
        dp[1] = Math.max(tempList.get(0), tempList.get(1));
        for (int i = 2; i < tempList.size(); i++) {
            dp[i] = Math.max(tempList.get(i) + dp[i - 2], dp[i - 1]);
        }
        return Arrays.stream(dp).max().getAsInt();

    }*/

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode p = root;
        TreeNode currentTail = root;
        TreeNode nextTail = root;
        if (p.left != null)
            nextTail = p.left;
        if (p.right != null)
            nextTail = p.right;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        List<Integer> integers = new ArrayList<>();
        while (!queue.isEmpty() || p != null) {
            p = queue.poll();
            if (p.left != null) {
                queue.add(p.left);
                nextTail = p.left;
            }
            if (p.right != null) {
                queue.add(p.right);
                nextTail = p.right;
            }
            if (p == currentTail) {
                integers.add(p.val);
                currentTail = nextTail;
                res.add(new ArrayList<>(integers));
                integers.clear();
            } else {
                integers.add(p.val);
            }
            p = null;
        }

        return res;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> list = levelOrder(root);
        List<Double> res = new ArrayList<>();
        for (List<Integer> integers : list) {
            res.add(integers.stream().collect(Collectors.averagingDouble(item -> item.intValue())));
        }
        return res;
    }

    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeDG(root, root.val);
    }

    private boolean isUnivalTreeDG(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return  isUnivalTreeDG(root.left, val)&&isUnivalTreeDG(root.right, val);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


}
