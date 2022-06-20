package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.MainClass.ListNode;
import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class C_270 {

    public static void main(String[] args) {
//        findEvenNumbers(new int[]{2, 1, 3, 0});
//        findEvenNumbers(new int[]{2,2,8,8,2});
//        findEvenNumbers(new int[]{0, 0, 0});
        /*TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode12 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(6);
        TreeNode treeNode42 = new TreeNode(4);
        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;
        treeNode11.left = treeNode22;
        treeNode12.left = treeNode32;
        treeNode12.right = treeNode42;*/
        TreeNode treeNode1 = new TreeNode(18);
        TreeNode treeNode11 = new TreeNode(5);
        TreeNode treeNode12 = new TreeNode(12);
        TreeNode treeNode22 = new TreeNode(6);
        TreeNode treeNode32 = new TreeNode(19);
        TreeNode treeNode42 = new TreeNode(16);
        TreeNode treeNode43 = new TreeNode(1);
        TreeNode treeNode44 = new TreeNode(15);
        TreeNode treeNode99 = new TreeNode(20);
        TreeNode treeNode98 = new TreeNode(4);
        TreeNode treeNode97 = new TreeNode(14);
        TreeNode treeNode96 = new TreeNode(3);
        TreeNode treeNode95 = new TreeNode(7);
        TreeNode treeNode94 = new TreeNode(2);
        TreeNode treeNode93 = new TreeNode(8);
        TreeNode treeNode92 = new TreeNode(17);
        TreeNode treeNode91 = new TreeNode(11);
        TreeNode treeNode90 = new TreeNode(9);
        TreeNode treeNode89 = new TreeNode(10);
        TreeNode treeNode88 = new TreeNode(13);

        treeNode1.left = treeNode11;
        treeNode1.right = treeNode12;

        treeNode11.left = treeNode22;
        treeNode11.right = treeNode32;

        treeNode12.left = treeNode42;
        treeNode12.right = treeNode43;

        treeNode22.right = treeNode44;

        treeNode32.left = treeNode99;
        treeNode32.right = treeNode98;

        treeNode42.left = treeNode97;
        treeNode42.right = treeNode96;

        treeNode43.left = treeNode95;

        treeNode44.left = treeNode94;
        treeNode44.right = treeNode93;

        treeNode99.left = treeNode92;

        treeNode98.left = treeNode91;

        treeNode97.left = treeNode90;
        treeNode97.right = treeNode89;

        treeNode95.right = treeNode88;


        getDirections(treeNode1, 3, 12);
    }

    /**
     * 给你一个整数数组 digits ，其中每个元素是一个数字（0 - 9）。数组中可能存在重复元素。
     *
     * 你需要找出 所有 满足下述条件且 互不相同 的整数：
     *
     * 该整数由 digits 中的三个元素按 任意 顺序 依次连接 组成。
     * 该整数不含 前导零
     * 该整数是一个 偶数
     * 例如，给定的 digits 是 [1, 2, 3] ，整数 132 和 312 满足上面列出的全部条件。
     *
     * 将找出的所有互不相同的整数按 递增顺序 排列，并以数组形式返回。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：digits = [2,1,3,0]
     * 输出：[102,120,130,132,210,230,302,310,312,320]
     * 解释：
     * 所有满足题目条件的整数都在输出数组中列出。
     * 注意，答案数组中不含有 奇数 或带 前导零 的整数。
     * 示例 2：
     *
     * 输入：digits = [2,2,8,8,2]
     * 输出：[222,228,282,288,822,828,882]
     * 解释：
     * 同样的数字（0 - 9）在构造整数时可以重复多次，重复次数最多与其在 digits 中出现的次数一样。
     * 在这个例子中，数字 8 在构造 288、828 和 882 时都重复了两次。
     * 示例 3：
     *
     * 输入：digits = [3,7,5]
     * 输出：[]
     * 解释：
     * 使用给定的 digits 无法构造偶数。
     * 示例 4：
     *
     * 输入：digits = [0,2,0,0]
     * 输出：[200]
     * 解释：
     * 唯一一个不含 前导零 且满足全部条件的整数是 200 。
     * 示例 5：
     *
     * 输入：digits = [0,0,0]
     * 输出：[]
     * 解释：
     * 构造的所有整数都会有 前导零 。因此，不存在满足题目条件的整数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/finding-3-digit-even-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @return
     */
    public static int[] findEvenNumbers(int[] digits) {
        Arrays.sort(digits);
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 0) {
                for (int j = 0; j < digits.length; j++) {
                    if (i == j)
                        continue;
                    for (int u = 0; u < digits.length; u++) {
                        if (u == j || u == i)
                            continue;
                        String numStr = digits[i] + "" + digits[j] + "" + digits[u] + "";
                        int num = Integer.parseInt(numStr);
                        if (num % 2 == 0) {
                            set.add(num);
                        }
                    }
                }
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        return res;
    }


    /**
     * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
     *
     * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
     *
     * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：head = [1,3,4,7,1,2,6]
     * 输出：[1,3,4,1,2,6]
     * 解释：
     * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
     * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
     * 返回结果为移除节点后的新链表。
     * 示例 2：
     *
     *
     *
     * 输入：head = [1,2,3,4]
     * 输出：[1,2,4]
     * 解释：
     * 上图表示给出的链表。
     * 对于 n = 4 ，值为 3 的节点 2 是中间节点，用红色标注。
     * 示例 3：
     *
     *
     *
     * 输入：head = [2,1]
     * 输出：[2]
     * 解释：
     * 上图表示给出的链表。
     * 对于 n = 2 ，值为 1 的节点 1 是中间节点，用红色标注。
     * 值为 2 的节点 0 是移除节点 1 后剩下的唯一一个节点。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-the-middle-node-of-a-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        if (length == 1)
            return null;
        p = head;
        int middle = length / 2;
        while (middle != 0) {
            p = p.next;
            middle--;
        }
        ListNode q = p.next;

        if (q != null) {
            p.next = q.next;
        } else {
            p.next = null;
        }
        return head;
    }

    /**
     * 给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
     *
     * 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
     *
     * 'L' 表示从一个节点前往它的 左孩子 节点。
     * 'R' 表示从一个节点前往它的 右孩子 节点。
     * 'U' 表示从一个节点前往它的 父 节点。
     * 请你返回从 s 到 t 最短路径 每一步的方向。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
     * 输出："UURL"
     * 解释：最短路径为：3 → 1 → 5 → 2 → 6 。
     * 示例 2：
     *
     *
     *
     * 输入：root = [2,1], startValue = 2, destValue = 1
     * 输出："L"
     * 解释：最短路径为：2 → 1 。
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param root
     * @param startValue
     * @param destValue
     * @return
     */
    public static String getDirections(TreeNode root, int startValue, int destValue) {
        // 找到公共祖先节点
        TreeNode commmonAncestor = findCommmonAncestor(root, startValue, destValue);
        // 遍历当前公共节点上的全部路径
        PostOrder(commmonAncestor);
        Map<Integer, String> startMap = null;
        Map<Integer, String> endMap = null;
        StringBuilder sb = new StringBuilder();
        // 如果当前根节点包含startValue或这destValue 表明一定在一个里面
        if (startValue == commmonAncestor.val || destValue == commmonAncestor.val) {
            // 找到当前map
            for (int i = 0; i < listPath.size(); i++) {
                if (listPath.get(i).containsKey(startValue) && listPath.get(i).containsKey(destValue))
                    startMap = listPath.get(i);
            }
            Set<Map.Entry<Integer, String>> entries = startMap.entrySet();
            boolean flag = false;
            /**
             * 两种情况，看是startValue先出现还是destValue先出现
             *      如果startValue - destValue则表明是右上道下的
             *      如果destValue-startValue则表明是右下到上的
             */
            for (Map.Entry<Integer, String> entry : entries) {
                if (entry.getKey() == startValue) {
                    flag = true;
                    break;
                } else if (entry.getKey() == destValue) {
                    break;
                }
            }
            if (flag) {
                boolean F = false;
                for (Map.Entry<Integer, String> entry : entries) {
                    if (entry.getKey() == startValue) {
                        F = true;
                        continue;
                    }
                    if (entry.getKey() == destValue) {
                        sb.append(entry.getValue());
                        break;
                    }
                    if (F) {
                        sb.append(entry.getValue());
                    }
                }
            } else {
                boolean F = false;
                for (Map.Entry<Integer, String> entry : entries) {
                    if (entry.getKey() == destValue) {
                        F = true;
                        continue;
                    }
                    if (entry.getKey() == startValue) {
                        sb.append("U");
                        break;
                    }
                    if (F) {
                        sb.append("U");
                    }
                }
            }
        } else {
            // 表明在两个map里面
            boolean s = false;
            boolean d = false;
            for (Map<Integer, String> integerStringMap : listPath) {
                Set<Integer> set = integerStringMap.keySet();
                if (set.contains(startValue) && !s) {
                    startMap = integerStringMap;
                    s = true;
                }
                if (set.contains(destValue) && !d) {
                    endMap = integerStringMap;
                    d = true;
                }
                if (d && s) {
                    break;
                }
            }
            // 先从map里面倒叙查找
            Set<Map.Entry<Integer, String>> entries = startMap.entrySet();
            int start = 0;
            for (Map.Entry<Integer, String> entry : entries) {
                if (entry.getKey() != startValue) {
                    start++;
                } else {
                    break;
                }
            }
            while (start != 0) {
                sb.append("U");
                start--;
            }
            // 从endMap里面从上到下
            Set<Map.Entry<Integer, String>> entries1 = endMap.entrySet();
            int count = 0;
            for (Map.Entry<Integer, String> integerStringEntry : entries1) {
                if (count == 0) {
                    count++;
                    continue;
                }
                if (integerStringEntry.getKey() == destValue) {
                    sb.append(integerStringEntry.getValue());
                    break;
                } else {
                    sb.append(integerStringEntry.getValue());

                }
            }
        }
        return sb.toString();
    }


    static Map<Integer, String> map = new LinkedHashMap<>();
    static List<Map<Integer, String>> listPath = new ArrayList<>();
    static String current = "U";

    // 后续遍历，记录当前的root节点的全部路径。用K代表当前路径上的值，V代表方向操作
    public static void PostOrder(TreeNode root) {
        if (root != null) {
            map.put(root.val, current);
            if (root.left == null && root.right == null)
                listPath.add(new LinkedHashMap<>(map));
            current = "L";
            PostOrder(root.left);
            current = "R";
            PostOrder(root.right);
            map.remove(root.val);
        }
    }

    public static TreeNode findCommmonAncestor(TreeNode root, int startValue, int destValue) {
        if (root == null || root.val == startValue || root.val == destValue)
            return root;
        TreeNode l = findCommmonAncestor(root.left, startValue, destValue);
        TreeNode r = findCommmonAncestor(root.right, startValue, destValue);
        if (l != null && r != null)
            return root;
        if (l == null)
            return r;
        if (r == null)
            return l;
        return null;
    }
}
