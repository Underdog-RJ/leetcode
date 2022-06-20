package cn.underdog.leetcode.tree;

import cn.underdog.leetcode.entity.TreeNode;

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
//        TreeNode treeNode1 = new TreeNode(1);
//        TreeNode treeNode11 = new TreeNode(10);
//        TreeNode treeNode12 = new TreeNode(4);
//        TreeNode treeNode22 = new TreeNode(3);
//        TreeNode treeNode21 = new TreeNode(7);
//        TreeNode treeNode23 = new TreeNode(9);
//        TreeNode treeNode24 = new TreeNode(12);
//        TreeNode treeNode25 = new TreeNode(8);
//        TreeNode treeNode26 = new TreeNode(6);
//        TreeNode treeNode27 = new TreeNode(2);
//        treeNode1.left = treeNode11;
//        treeNode1.right = treeNode12;
//        treeNode11.left = treeNode22;
//        treeNode12.left = treeNode21;
//        treeNode12.right = treeNode23;
//        treeNode22.left = treeNode24;
//        treeNode22.right = treeNode25;
//        treeNode21.left = treeNode26;
//        treeNode23.right = treeNode27;

//        Node root = new Node(1);
//        List<Node> children = new ArrayList<>();
//        Node node1 = new Node(3);
//        Node node2 = new Node(2);
//        Node node3 = new Node(4);
//        children.add(node1);
//        children.add(node2);
//        children.add(node3);
//        root.children = children;
//        List<Node> child = new ArrayList<>();
//        Node node5 = new Node(5);
//        Node node6 = new Node(6);
//        child.add(node5);
//        child.add(node6);
//        node1.children = child;

//        rob(treeNode1);

       /* TreeNode treeNode111 = new TreeNode(2);
        TreeNode treeNode112 = new TreeNode(1);
        TreeNode treeNode122 = new TreeNode(3);
        TreeNode treeNode223 = new TreeNode(4);
        TreeNode treeNode224 = new TreeNode(7);
        treeNode111.left = treeNode112;
        treeNode111.right = treeNode122;
        treeNode112.right = treeNode223;
        treeNode122.right = treeNode224;*/
//        mergeTrees(treeNode1, treeNode111);
        MainClass mainClass = new MainClass();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        treeNode1.left = treeNode;
        treeNode1.right = treeNode2;
        mainClass.inorderSuccessor(treeNode1, treeNode);
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

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y)
            return false;
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
            if (p.left != null && p.right != null) {
                if ((p.left.val == x || p.right.val == x) && (p.left.val == y || p.right.val == y))
                    return false;
            }
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
                if (integers.contains(x) && integers.contains(y))
                    return true;
                integers.clear();
            } else {
                integers.add(p.val);
            }
            p = null;
        }
        return false;
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
                return isUnivalTreeDG(root.left, val) && isUnivalTreeDG(root.right, val);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }


    /**
     * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
     * <p>
     * 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。
     * <p>
     * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [2,2,5,null,null,5,7]
     * 输出：5
     * 解释：最小的值是 2 ，第二小的值是 5 。
     * 示例 2：
     * <p>
     * <p>
     * 输入：root = [2,2,2]
     * 输出：-1
     * 解释：最小的值是 2, 但是不存在第二小的值。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int findSecondMinimumValue(TreeNode root) {

        return findSecondMinimumValueDG(root, root.val);

    }

    private int findSecondMinimumValueDG(TreeNode root, int val) {
        if (root == null)
            return -1;
        if (root.val > val)
            return root.val;
        int left = findSecondMinimumValueDG(root.left, val);
        int right = findSecondMinimumValueDG(root.right, val);
        if (left >= 0 && right >= 0) {
            return Math.min(left, right);
        } else {
            return Math.max(left, right);
        }

    }


    /**
     * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
     * <p>
     * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
     * <p>
     * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：root = [1,0,1,0,1,0,1]
     * 输出：22
     * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
     * 示例 2：
     * <p>
     * 输入：root = [0]
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：root = [1]
     * 输出：1
     * 示例 4：
     * <p>
     * 输入：root = [1,1]
     * 输出：3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public int sumRootToLeaf(TreeNode root) {
        dfsRootToLeaf(root);
        return resSumToLeaf;
    }

    Deque<Integer> dequeRootToLeaf = new ArrayDeque<>();
    int resSumToLeaf = 0;

    public void dfsRootToLeaf(TreeNode root) {
        if (root != null) {
            dequeRootToLeaf.add(root.val);
            if (root.left == null && root.right == null) {
                String str = "";
                for (Integer integer : dequeRootToLeaf) {
                    str += integer + "";
                }
                resSumToLeaf += Integer.parseInt(str, 2);
            }
            dfsRootToLeaf(root.left);
            dfsRootToLeaf(root.right);
            deque.pollLast();
        }
    }

    /**
     * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
     * <p>
     * 假设二叉树中至少有一个节点。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: root = [2,1,3]
     * 输出: 1
     * 示例 2:
     * <p>
     * <p>
     * <p>
     * 输入: [1,2,3,4,null,5,6,null,null,7]
     * 输出: 7
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public static int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> list = levelOrder(root);
        List<Integer> list1 = list.get(list.size() - 1);
        return list1.get(0);
    }

    /**
     * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
     * <p>
     * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
     * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
     * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
     * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
     * 输出：true
     * 解释：每一层的节点值分别是：
     * 0 层：[1]
     * 1 层：[10,4]
     * 2 层：[3,7,9]
     * 3 层：[12,8,6,2]
     * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/even-odd-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public boolean isEvenOddTree(TreeNode root) {
        List<List<Integer>> list = levelOrder(root);
        for (int i = 0; i < list.size(); i++) {
            List<Integer> currentList = list.get(i);
            // 偶数
            if (i % 2 == 0) {
                for (int j = 0; j < currentList.size(); j++) {
                    if (j + 1 == currentList.size()) {
                        if (currentList.get(j) % 2 == 0) {
                            return false;
                        }
                    } else {
                        if (currentList.get(j) % 2 == 0 || currentList.get(j + 1) % 2 == 0)
                            return false;
                        else {
                            if (currentList.get(j) >= currentList.get(j + 1))
                                return false;
                        }
                    }

                }
            } else {
                for (int j = 0; j < currentList.size(); j++) {
                    if (j + 1 == currentList.size()) {
                        if (currentList.get(j) % 2 != 0) {
                            return false;
                        }
                    } else {
                        if (currentList.get(j) % 2 != 0 || currentList.get(j + 1) % 2 != 0)
                            return false;
                        else {
                            if (currentList.get(j) <= currentList.get(j + 1))
                                return false;
                        }
                    }
                }
            }
        }

        return true;
    }


    public List<Integer> preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node p = root;
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                res.add(p.val);
                List<Node> children = p.children;
                if (children == null || children.size() == 0)
                    p = null;
                else {
                    // 栈是先进后出
                    p = children.get(0);
                    children.remove(0);
                    for (int i = children.size() - 1; i >= 0; i--) {
                        stack.push(children.get(i));
                    }
                }
            } else {
                p = stack.pop();
            }
        }
        return res;
    }


    /**
     * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
     * <p>
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // 递归实现
    /*List<Integer> resPostOrder = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root != null) {
            List<Node> children = root.children;
            for (Node child : children) {
                postorder(child);
            }
            resPostOrder.add(root.val);
        }
        return resPostOrder;
    }*/
    // 非递归实现
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node p = root;
        Node r = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                List<Node> children = p.children;
                // 如果当前node没有孩子则直接输出
                if ((children == null || children.size() == 0)) {
                    // 输出结果
                    res.add(p.val);
                    stack.pop();
                    r = p;
                    p = null;
                } else {
                    // 判断该下层是否访问过
                    if (children.contains(r)) {
                        res.add(p.val);
                        stack.pop();
                        r = p;
                        p = null;
                    } else {
                        p = children.get(0);
                        for (int i = children.size() - 1; i > 0; i--) {
                            stack.push(children.get(i));
                        }
                    }

                }
            } else {
                p = stack.pop();
            }
        }
        return res;
    }


    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     * <p>
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 二叉树: [1,2,3,4]
     * 1
     * /   \
     * 2     3
     * /
     * 4
     * <p>
     * 输出: "1(2(4))(3)"
     * <p>
     * 解释: 原本将是“1(2(4)())(3())”，
     * 在你省略所有不必要的空括号对之后，
     * 它将是“1(2(4))(3)”。
     * 示例 2:
     * <p>
     * 输入: 二叉树: [1,2,3,null,4]
     * 1
     * /   \
     * 2     3
     * \
     * 4
     * <p>
     * 输出: "1(2()(4))(3)"
     * <p>
     * 解释: 和第一个示例相似，
     * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root != null) {
            String lstr = tree2str(root.left);
            String rstr = tree2str(root.right);
            if (lstr != "" && rstr != "") {
                return root.val + "(" + lstr + ")" + "(" + rstr + ")";
            } else if (lstr == "" && rstr != "") {
                return root.val + "()" + "(" + rstr + ")";
            } else if (lstr != "" && rstr == "") {
                return root.val + "(" + lstr + ")";
            } else {
                return root.val + "";
            }
        } else {
            return "";
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        InOrder(root1, list);
        InOrder(root2, list);
        Collections.sort(list);
        return list;
    }


    /**
     * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     * <p>
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     * <p>
     * 示例 1:
     * <p>
     * 输入: root = [2,1,3], p = 1
     * <p>
     * 2
     * / \
     * 1   3
     * <p>
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: root = [5,3,6,2,4,null,null,1], p = 6
     * <p>
     * 5
     * / \
     * 3   6
     * / \
     * 2   4
     * /
     * 1
     * <p>
     * 输出: null
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/successor-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        InOrderSuccessor(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).val == p.val) {
                if (i == list.size() - 1) {
                    return null;
                } else {
                    return list.get(i + 1);
                }
            }
        }
        return null;
    }

    private void InOrderSuccessor(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        } else {
            InOrderSuccessor(root.left, list);
            list.add(root);
            InOrderSuccessor(root.right, list);
        }

    }

    /*private TreeNode InOrderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root == p) {
            return root;
        } else {
            TreeNode left = InOrderSuccessor(root.left, p);
            if (left == p)
                return root;
            InOrderSuccessor(root.right, p);
        }
        return null;
    }*/


}
