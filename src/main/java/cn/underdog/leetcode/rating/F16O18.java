package cn.underdog.leetcode.rating;

import cn.underdog.leetcode.MainClass.ListNode;
import cn.underdog.leetcode.entity.TreeNode;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class F16O18 {


    public static void main(String[] args) {
        F16O18 f16O18 = new F16O18();
//        f16O18.expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"});

//        f16O18.expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"});
//        f16O18.findBestValue(new int[]{4, 9, 3}, 10);
        TreeNode treeNode = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.right = treeNode3;
//        f16O18.lcaDeepestLeaves(treeNode);
//        f16O18.numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1}, 2);
//        f16O18.numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3);
//        f16O18.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);
//        f16O18.partitionDisjoint(new int[]{5, 0, 3, 8, 6});
//        f16O18.largestValsFromLabels(new int[]{5, 4, 3, 2, 1}, new int[]{1, 1, 2, 2, 3}, 3, 1);
//        f16O18.largestValsFromLabels(new int[]{2, 6, 3, 6, 5}, new int[]{1, 1, 2, 1, 1}, 3, 1);
//        f16O18.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb");
//        f16O18.minDeletions("accdcdadddbaadbc");
//        f16O18.checkPowersOfThree(10);
//        f16O18.reconstructMatrix(4, 7, new int[]{2, 1, 2, 2, 1, 1, 1});
//        f16O18.maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1});
//        f16O18.maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5});
//        f16O18.totalFruit(new int[]{0, 1, 2, 2});
//        f16O18.isIdealPermutation(new int[]{2, 0, 1});
//        f16O18.countVowelStrings(3);
//        f16O18.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}});
//        f16O18.maximalNetworkRank(2, new int[][]{{0, 1}});
//        f16O18.maximalNetworkRank(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}});
//        f16O18.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5});
//        f16O18.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6});
//        f16O18.numRescueBoats(new int[]{3, 5, 3, 4}, 3);
//        f16O18.tupleSameProduct(new int[]{2, 3, 4, 6});


//        f16O18.closeStrings("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii", "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        f16O18.countPalindromicSubsequence("aabca");
//        f16O18.camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa");
//        f16O18.rotateTheBox(new char[][]{{'#', '.', '#'}});
//        f16O18.rotateTheBox(new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '*', '.', '.'}, {'#', '#', '#', '.', '#', '.'}});
//        f16O18.longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"});
//        f16O18.longestStrChain(new String[]{"abcd", "dbqca"});
//        f16O18.longestStrChain(new String[]{"a", "b","ab","bac"});
//        f16O18.longestStrChain(new String[]{"ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru"});

//        f16O18.flipgame(new int[]{2, 1}, new int[]{1, 2});
//        f16O18.numTriplets(new int[]{43024, 99908}, new int[]{1864});
//        f16O18.minFallingPathSum(new int[][]{{-73, 61, 43, -48, -36}, {3, 30, 27, 57, 10}, {96, -76, 84, 59, -15}, {5, -49, 76, 31, -7}, {97, 91, 61, -46, 67}});
//        f16O18.numFriendRequests(new int[]{20, 30, 100, 110, 120});
//        f16O18.numFriendRequests(new int[]{16, 16});

//        f16O18.numFriendRequests(new int[]{108, 115, 5, 24, 82});
//        f16O18.reorganizeString("aab");
//        f16O18.reorganizeString("aaab");

//        f16O18.countPairs(new int[]{1, 3, 5, 7, 9});
//        f16O18.countPairs(new int[]{149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234});
//        f16O18.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}});
//        f16O18.minimumDeletions("ababaaaabbbbb");
//        f16O18.minimumDeletions("aabbaababbababaabbbaabbbbaababababbabbbababbabbaabaaabbbbbbaaabbbbabaababbaaabbbbaaabababbbaaa");
//        f16O18.minimumDeletions("aabbbbaabababbbbaaaaaabbababaaabaabaabbbabbbbabbabbababaabaababbbbaaaaabbabbabaaaabbbabaaaabbaaabbbaabbaaaaabaa");
//        f16O18.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}});
//        f16O18.maxChunksToSorted(new int[]{5, 4, 3, 2, 1});
//        f16O18.winnerSquareGame1(7);
//        int i = f16O18.findCheapestPrice(10, new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7);
//        System.out.println(i);
//        f16O18.findCheapestPrice(4, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1);
//        f16O18.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15});
//        f16O18.maxAlternatingSum(new int[]{4, 2, 5, 3});
//        f16O18.longestArithSeqLength(new int[]{9, 4, 7, 2, 10});
//        f16O18.getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
//        f16O18.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10);
//        SnapshotArray snapshotArray = new SnapshotArray(1);
//        snapshotArray.set(1, 18);
//        snapshotArray.set(1, 4);
//        snapshotArray.snap();
//        snapshotArray.get(0, 0);
//        snapshotArray.set(0, 20);
//        snapshotArray.snap();
//        snapshotArray.set(0, 2);
//        snapshotArray.set(1, 1);
//        snapshotArray.get(1, 1);
//        snapshotArray.get(1, 0);
//        f16O18.maxSumDivThree(new int[]{3, 6, 5, 1, 8});
//        f16O18.maxSumDivThree(new int[]{366, 809, 6, 792, 822, 181, 210, 588, 344, 618, 341, 410, 121, 864, 191, 749, 637, 169, 123, 472, 358, 908, 235, 914, 322, 946, 738, 754, 908, 272, 267, 326, 587, 267, 803, 281, 586, 707, 94, 627, 724, 469, 568, 57, 103, 984, 787, 552, 14, 545, 866, 494, 263, 157, 479, 823, 835, 100, 495, 773, 729, 921, 348, 871, 91, 386, 183, 979, 716, 806, 639, 290, 612, 322, 289, 910, 484, 300, 195, 546, 499, 213, 8, 623, 490, 473, 603, 721, 793, 418, 551, 331, 598, 670, 960, 483, 154, 317, 834, 352});
//        f16O18.maxProfitAssignment(new int[]{2, 4, 6, 8, 10}, new int[]{10, 20, 30, 40, 50}, new int[]{4, 5, 6, 7});
//        f16O18.closestCost(new int[]{2, 3}, new int[]{4, 5, 100}, 18);
//        f16O18.closestCost(new int[]{3, 10}, new int[]{2, 5}, 9);
//        f16O18.maxCompatibilitySum(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 1}}, new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}});
//        f16O18.rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2});
//        f16O18.rearrangeBarcodes(new int[]{2, 2, 2, 1, 5});
//        f16O18.beautySum("aabcb");
//        f16O18.threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5);
//        f16O18.minInsertions(")))))))");
//        f16O18.minInsertions("))(()()))()))))))()())()(())()))))()())(()())))()(");
//        f16O18.maxFreq("abcabababacabcabc", 3, 3, 10);
//        f16O18.bagOfTokensScore(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2);
//        f16O18.bagOfTokensScore(new int[]{48, 87, 26}, 81);
//        f16O18.bagOfTokensScore(new int[]{71, 55, 82}, 54);
//        f16O18.maxSubarraySumCircular(new int[]{-3, -2, -3});
//        ListNode listNode = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(-3);
//        ListNode listNode5 = new ListNode(-2);
//        listNode.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        f16O18.removeZeroSumSublists(listNode);
//        f16O18.minSideJumps(new int[]{0, 1, 2, 3, 0});
//        f16O18.minSideJumps(new int[]{0, 2, 1, 0, 3, 0});
//        f16O18.getNumberOfBacklogOrders(new int[][]{{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}});
//        f16O18.getNumberOfBacklogOrders(new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}});
//        f16O18.getNumberOfBacklogOrders(new int[][]{{1, 29, 1}, {22, 7, 1}, {24, 1, 0}, {25, 15, 1}, {18, 8, 1}, {8, 22, 0}, {25, 15, 1}, {30, 1, 1}, {27, 30, 0}});
//        System.out.println(1 % 3);
//        f16O18.canArrange(new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3);
//        f16O18.canArrange(new int[]{-4, -7, 5, 2, 9, 1, 10, 4, -8, -3}, 3);
//        f16O18.canArrange(new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5);
//        f16O18.canArrange(new int[]{2, 3, 7, -9, 4, 4, 7, 3, 2, 10, 8, 15, 2, 1, -8, 10, -5, 10, -2, 21, 9, 20, 0, 4, 24, 5, 12, -10, 8, 9, 18, 13, -8, 10, -4, -3, 0, 16, -4, 8, 14, 15, -9, 0, 0, -6, 11, -3, 10, 11, 7, -1, -5, 5, 11, 2, 5, 9, -2, 8, 9, -10, 6, -2, 7, 8, 3, 0, -2, 11}, 18);
//        f16O18.highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}});
//        f16O18.shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{});
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
//        f16O18.isCompleteTree(t1);
//        f16O18.countVowelPermutation(3);
//        f16O18.canChange("_L__R__R_", "L______RR");
//        f16O18.canChange("_L__R__R_", "L______RR");
//        f16O18.canChange("R_L_", "__LR");
//        f16O18.canChange("_R", "_L");
//        f16O18.nextBeautifulNumber(1);
//        f16O18.gridGame(new int[][]{{2, 5, 4}, {1, 5, 1}});
//        f16O18.gridGame(new int[][]{{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}});
//        f16O18.gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}});
//        f16O18.gardenNoAdj(5, new int[][]{{3, 4}, {4, 5}, {3, 2}, {5, 1}, {1, 3}, {4, 2}});
//        f16O18.getMaxLen(new int[]{5, -20, -20, -39, -5, 0, 0, 0, 36, -32, 0, -7, -10, -7, 21, 20, -12, -34, 26, 2});
//        f16O18.getMaxLen(new int[]{0, 1, -2, -3, -4});
//        f16O18.splitString("1234");
        BigInteger bigInteger = new BigInteger("64424509442147483647");
        System.out.println(bigInteger.add(new BigInteger("1")).equals(new BigInteger("64424509442147483648")));
    }


    /**
     * 给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
     * <p>
     * 注意，删除一个元素后，子数组 不能为空。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,-2,0,3]
     * 输出：4
     * 解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
     * 示例 2：
     * <p>
     * 输入：arr = [1,-2,-2,3]
     * 输出：3
     * 解释：我们直接选出 [3]，这就是最大和。
     * 示例 3：
     * <p>
     * 输入：arr = [-1,-1,-1,-1]
     * 输出：-1
     * 解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
     * 我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        int length = arr.length;
        // 表示到dp[i][0]为到i删除0个的最大值，dp[i][1]代表删除1个的最大值
        int[][] dp = new int[length][2];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]);
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]);
            res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
        }
        return res;
    }

    public int expressiveWords(String s, String[] words) {
        List<ExNode> list = new ArrayList<>();
        char pre = s.charAt(0);
        ExNode exNode = new ExNode();
        exNode.count = 1;
        exNode.alp = pre;
        list.add(exNode);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == pre) {
                ExNode temp = list.get(list.size() - 1);
                temp.count++;
            } else {
                ExNode t = new ExNode();
                t.alp = c;
                t.count = 1;
                list.add(t);
                pre = c;
            }
        }
        int res = 0;
        for (String word : words) {
            List<ExNode> cntList = new ArrayList<>();
            char cntPre = word.charAt(0);
            ExNode cntExNode = new ExNode();
            cntExNode.count = 1;
            cntExNode.alp = cntPre;
            cntList.add(cntExNode);
            for (int i = 1; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == cntPre) {
                    ExNode temp = cntList.get(cntList.size() - 1);
                    temp.count++;
                } else {
                    ExNode t = new ExNode();
                    t.alp = c;
                    t.count = 1;
                    cntList.add(t);
                    cntPre = c;
                }
            }
            if (cntList.size() != list.size()) continue;
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).alp == cntList.get(i).alp) {
                    Integer integer1 = list.get(i).count;
                    Integer integer2 = cntList.get(i).count;
                    if (integer1 < integer2) {
                        flag = true;
                        break;
                    }
                    if (!integer1.equals(integer2)) {
                        if (integer1 / 1 < 3) {
                            flag = true;
                            break;
                        }
                    }
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) res++;
        }
        return res;
    }

    class ExNode {
        char alp;
        int count;
    }


    public int findBestValue(int[] arr, int target) {
        int left = 1, right = 100000;
        while (left <= right) {
            int mid = left + right >> 1;
            int cntCount = 0;
            for (int i : arr) {
                if (i > mid) {
                    cntCount += mid;
                } else {
                    cntCount += i;
                }
            }
            if (cntCount >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    int maxDeep = 0;
    int cntDeep = 1;
    TreeNode resLca = null;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        resLca = root;
        dfsLac(root);
        return resLca;
    }

    private void dfsLac(TreeNode root) {
        if (root == null) return;
        cntDeep++;
        dfsLac(root.left);
        dfsLac(root.right);
        cntDeep--;
        if (cntDeep > maxDeep) {
            maxDeep = cntDeep;
            if (root.left != null && root.right != null) resLca = root;
            else if (root.left == null && root.right != null) resLca = root.left;
            else if (root.left != null && root.right == null) resLca = root.right;
            else resLca = root;
        }
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * <p>
     * 请返回这个数组中 「优美子数组」 的数目。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2,1,1], k = 3
     * 输出：2
     * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [2,4,6], k = 1
     * 输出：0
     * 解释：数列中不包含任何奇数，所以不存在优美子数组。
     * 示例 3：
     * <p>
     * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
     * 输出：16
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 50000
     * 1 <= nums[i] <= 10^5
     * 1 <= k <= nums.length
     *
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            int cnt = (nums[i] & 1) == 1 ? 1 : 0;
            preSum[i + 1] = preSum[i] + cnt;
        }
        int res = 0;
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] < k) continue;
            int target = preSum[i] - k;
            int left = 0, right = i;
            while (left <= right) {
                int mid = left + right >> 1;
                if (preSum[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int num1 = left;
            left = 0;
            right = i;
            while (left <= right) {
                int mid = left + right >> 1;
                if (preSum[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int num2 = right;
            res += num2 - num1 + 1;
        }
        return res;
    }


    public int minSwaps(String s) {
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }
        if (Math.abs(count0 - count1) > 1) return -1;
        if ((n & 1) == 1) {
            if (count0 > count1) {
                return to0101(s) / 2;
            } else {
                return to1010(s) / 2;
            }
        } else {
            int num1 = to1010(s);
            int num2 = to0101(s);
            return Math.min(num1, num2) / 2;
        }
    }

    public int to1010(String s) {
        int count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if ((i & 1) == 0) {
                if (s.charAt(i) == '0') count++;
            } else {
                if (s.charAt(i) == '1') count++;
            }
        }
        return count;
    }

    public int to0101(String s) {
        int count = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            if ((i & 1) == 0) {
                if (s.charAt(i) == '1') count++;
            } else {
                if (s.charAt(i) == '0') count++;
            }
        }
        return count;
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int total = n / groupSize;
        for (int i = 0; i < total; i++) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            int key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 1) map.put(key, value - 1);
            for (int j = 0; j < groupSize - 1; j++) {
                key++;
                if (!map.containsKey(key)) return false;
                Integer integer = map.get(key);
                if (integer > 1) map.put(key, integer - 1);
                else map.remove(key);
            }
        }
        return map.size() == 0 ? true : false;
    }

    public int partitionDisjoint(int[] nums) {
        int n = nums.length;
        int[] last = new int[n + 1];
        last[n] = nums[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            last[i] = Math.min(last[i + 1], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, nums[i - 1]);
            if (max < last[i]) return i;
        }
        return -1;
    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] nums = new int[n][2];
        for (int i = 0; i < values.length; i++) {
            nums[i] = new int[]{values[i], labels[i]};
        }
        Arrays.sort(nums, (o1, o2) -> o2[0] - o1[0]);
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length && numWanted > 0; i++) {
            int key = nums[i][1];
            if (!map.containsKey(key)) {
                res += nums[i][0];
                map.put(key, 1);
                numWanted--;
            } else {
                Integer integer = map.get(key);
                if (integer < useLimit) {
                    res += nums[i][0];
                    map.put(key, integer + 1);
                    numWanted--;
                }
            }

        }
        return res;
    }

    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            int cntLeft = left;
            int cntRight = right;
            if (s.charAt(left) != s.charAt(right)) break;
            int cntChar = s.charAt(left);
            while (cntLeft <= right) {
                if (s.charAt(cntLeft) == cntChar) cntLeft++;
                else break;
            }
            while (cntRight >= left) {
                if (s.charAt(cntRight) == cntChar) cntRight--;
                else break;
            }
            left = cntLeft;
            right = cntRight;
        }
        if (left > right) return 0;
        return right - left + 1;
    }

    public int minDeletions(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        TreeMap<Integer, Integer> map1 = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            map1.put(entry.getValue(), map1.getOrDefault(entry.getValue(), 0) + 1);
        }
        int res = 0;
        Set<Integer> set = new HashSet<>(map1.keySet());
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (entry.getValue() <= 1) continue;
            int max = entry.getKey();
            for (Integer j = 0; j < entry.getValue() - 1; j++) {
                int cnt = 0;
                for (int i = max; i > 0; i--) {
                    if (!set.contains(i)) {
                        cnt = i;
                        break;
                    }
                }
                if (cnt != 0) set.add(cnt);
                res += entry.getKey() - cnt;
            }
        }
        return res;
    }

    public boolean checkPowersOfThree(int n) {
        return dfsCheckPow(n, 15, 0);
    }

    private boolean dfsCheckPow(int n, int index, int cntTotal) {
        if (cntTotal == n) return true;
        if (cntTotal > n) return false;
        for (int i = index; i >= 0; i--) {
            int pow = (int) Math.pow(3, i);
            if (cntTotal + pow > n) continue;
            boolean child = dfsCheckPow(n, i - 1, cntTotal + pow);
            if (child) return true;
        }
        return false;
    }

    public boolean hasAllCodes(String s, int k) {
        Set<String> strings = new HashSet<>();
        for (int i = 0; i + k <= s.length(); i++) {
            strings.add(s.substring(i, i + k));
        }
        return strings.size() == (int) Math.pow(2, k);
    }

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int n = colsum.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp1 = new ArrayList<>();
        List<Integer> tmp2 = new ArrayList<>();
        list.add(tmp1);
        list.add(tmp2);
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 0) {
                list.get(0).add(0);
                list.get(1).add(0);
            } else if (colsum[i] == 2) {
                if (upper <= 0 || lower <= 0) return new ArrayList<>();
                list.get(0).add(1);
                list.get(1).add(1);
                upper--;
                lower--;
            } else {
                if (upper > lower) {
                    if (upper <= 0) return new ArrayList<>();
                    list.get(0).add(1);
                    list.get(1).add(0);
                    upper--;
                } else {
                    if (lower <= 0) return new ArrayList<>();
                    list.get(0).add(0);
                    list.get(1).add(1);
                    lower--;
                }
            }
        }
        if (upper != 0 || lower != 0) return new ArrayList<>();
        return list;

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        List<TreeNode> list = new ArrayList<>();
        if (!set.contains(root.val)) list.add(root);
        dfsDelNodes(root, set, list);
        return list;
    }

    private boolean dfsDelNodes(TreeNode root, Set<Integer> set, List<TreeNode> list) {
        if (root == null) return false;
        boolean l = dfsDelNodes(root.left, set, list);
        boolean r = dfsDelNodes(root.right, set, list);
        if (l) root.left = null;
        if (r) root.right = null;
        if (set.contains(root.val)) {
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
            return true;
        }
        return false;
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            set.add(edge.get(1));
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) list.add(i);
        }
        return list;
    }

    // TODO 双指针
    public int maxDistance(int[] nums1, int[] nums2) {
        int res = 0;
        int length1 = nums1.length;
        for (int i = 0; i < nums2.length; i++) {
            int left = 0, right = i >= length1 ? length1 - 1 : i;
            int target = nums2[i];
            while (left <= right) {
                int mid = left + right >> 1;
                if (nums1[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (left < length1 && nums1[left] <= nums2[i]) {
                res = Math.max(res, i - left);
            }
        }
        return res;
    }

    public int totalFruit(int[] fruits) {
        int slow = 0, quick = 0;
        int next = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (quick < fruits.length) {
            int cntKey = fruits[quick];
            if (map.size() == 0) {
                map.put(cntKey, map.getOrDefault(cntKey, 0) + 1);
            } else if (map.size() == 1) {
                if (map.containsKey(cntKey)) map.put(cntKey, map.getOrDefault(cntKey, 0) + 1);
                else {
                    map.put(cntKey, 1);
                    next = quick;
                }
            } else {
                if (map.containsKey(cntKey)) map.put(cntKey, map.getOrDefault(cntKey, 0) + 1);
                else {
                    Integer collect = map.values().stream().collect(Collectors.summingInt(o -> o.intValue()));
                    res = Math.max(res, collect);
                    map.clear();
                    quick = next - 1;
                }
            }
            quick++;
        }
        if (map.size() != 0) {
            Integer collect = map.values().stream().collect(Collectors.summingInt(o -> o.intValue()));
            res = Math.max(res, collect);
        }
        return res;

    }

    public boolean isIdealPermutation(int[] nums) {
        int num1 = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (Math.abs(i - nums[i]) > 1) num1++;
        }
        return num1 == 0;
    }

    public int countVowelStrings(int n) {
        int[][] dp = new int[6][n + 1];
        for (int i = 0; i < 6; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[5][n];
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Set<Integer>[] edges = new Set[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new HashSet<>();
        }
        for (int[] road : roads) {
            edges[road[0]].add(road[1]);
            edges[road[1]].add(road[0]);
        }
        int max = 0;
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                Set<Integer> edge1 = edges[i];
                Set<Integer> edge2 = edges[j];
                int cnt = edge1.size() + edge2.size();
                if (edge1.contains(j)) cnt--;
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    public int eliminateMaximum(int[] dist, int[] speed) {
        int res = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            priorityQueue.add((double) dist[i] / speed[i]);
        }
        while (priorityQueue.size() != 0) {
            Double poll = priorityQueue.poll();
            if (res < poll) res++;
            else break;
        }
        return res;
    }

    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> windows = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        int slow = 0, quick = 0;
        int sum = 0;
        int max = 0;
        while (quick < nums.length) {
            if (!windows.contains(nums[quick])) {
                sum += nums[quick];
                windows.add(nums[quick]);
                list.add(nums[quick]);
            } else {
                max = Math.max(max, sum);
                while (list.peekFirst() != nums[quick]) {
                    int tmp = list.removeFirst();
                    windows.remove(tmp);
                    sum -= tmp;
                }
                int tmp = list.removeFirst();
                windows.remove(tmp);
                sum -= tmp;
                quick--;
            }
            quick++;
        }
        max = Math.max(max, sum);
        return max;
    }

    public int numRescueBoats(int[] people, int limit) {
        int left = 0, right = people.length - 1;
        Arrays.sort(people);
        int res = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            res++;
        }
        return res;
    }

    public int tupleSameProduct(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = nums[i] * nums[j];
                if (map.containsKey(tmp)) {
                    Integer integer = map.get(tmp);
                    res += integer;
                    map.put(tmp, integer + 1);
                } else {
                    map.put(tmp, 1);
                }
            }
        }
        return res << 3;
    }

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if (!map1.keySet().equals(map2.keySet())) return false;
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        if (list1.size() != list2.size()) return false;
        Collections.sort(list1);
        Collections.sort(list2);
        int n = list1.size();
        for (int i = 0; i < n; i++) {
            if (!list1.get(i).equals(list2.get(i))) return false;
        }
        return true;

    }

    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] alp = new int[26];
        for (char c : s.toCharArray())
            alp[c - 'a']++;
        int odd = 0;
        for (int i : alp)
            odd += (i & 1) == 1 ? 1 : 0;
        return odd <= k ? true : false;
    }

    public int countPalindromicSubsequence(String s) {
        HashMap<Character, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            TreeSet<Integer> orDefault = map.getOrDefault(c, new TreeSet<>());
            orDefault.add(i);
            map.put(c, orDefault);
        }
        Set<String> strings = new HashSet<>();
        for (Map.Entry<Character, TreeSet<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() <= 1) continue;
            TreeSet<Integer> integers = entry.getValue();
            int num1 = integers.pollFirst();
            int num2 = integers.pollLast();
            char pre = s.charAt(num1);
            for (int i = num1 + 1; i <= num2 - 1; i++) {
                String tmp = pre + "" + s.charAt(i) + pre;
                strings.add(tmp);
            }
        }

        return strings.size();
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        StringBuilder sb = new StringBuilder();
        String tmp = "[a-z]*";
        sb.append(tmp);
        for (int i = 0; i < pattern.length(); i++) {
            char cnt = pattern.charAt(i);
            sb.append(cnt);
            sb.append(tmp);
        }
        List<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            boolean matches = Pattern.matches(sb.toString(), query);
            booleans.add(matches);
        }
        return booleans;
    }

    public char[][] rotateTheBox(char[][] box) {
        int n = box[0].length, m = box.length;
        for (int i = 0; i < box.length; i++) {
            for (int j = box[i].length - 2; j >= 0; j--) {
                if (box[i][j] == '#') {
                    int index = j + 1;
                    while (index < n && box[i][index] == '.') {
                        box[i][j] = '.';
                        box[i][index] = '#';
                        index++;
                        j++;
                    }
                }
            }
        }
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - i - 1] = box[i][j];
            }
        }
        return res;
    }

    public int longestStrChain(String[] words) {
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        Arrays.sort(words, (o1, o2) -> o1.length() - o2.length());
        int max = 1;
        for (int i = 1; i < words.length; i++) {
            int cntLength = words[i].length();
            for (int j = i - 1; j >= 0; j--) {
                int length = words[j].length();
                if (length == cntLength) continue;
                if (length + 1 == cntLength) {
                    boolean simliar = isSimliar(words[i], words[j]);
                    if (simliar) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                } else {
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean isSimliar(String str1, String str2) {
        int point1 = 0;
        int point2 = 0;
        int tmp = 0;
        while (point1 < str1.length() && point2 < str2.length()) {
            if (str1.charAt(point1) == str2.charAt(point2)) {
                point1++;
                point2++;
            } else {
                tmp++;
                point1++;
            }
        }
        return tmp >= 2 ? false : true;
    }


    /**
     * 当且仅当不同的个数和为偶数时候返回否则返回-1
     * 偶数=偶数+偶数 =奇数+奇数
     * 所以当两个都为偶数时候  (x+y)/2;
     * 当两个都为奇数是否  （x-1）/2+（y-1)/2+2;
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumSwap(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s1.length();
        if (length1 != length2) return -1;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') num1++;
                else num2++;
            }
        }
        if (((num1 + num2) & 1) == 1) return -1;
        return (num1 + 1) / 2 + (num2 + 1) / 2;
    }

    public int flipgame(int[] fronts, int[] backs) {
        int min = Integer.MAX_VALUE;
        TreeSet<Integer> set1 = new TreeSet<>();
        TreeSet<Integer> set2 = new TreeSet<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) set.add(fronts[i]);
            set1.add(fronts[i]);
            set2.add(backs[i]);
        }
        set1.removeAll(set);
        set2.removeAll(set);
        if (set1.size() != 0) min = Math.min(min, set1.pollFirst());
        if (set2.size() != 0) min = Math.min(min, set2.pollFirst());
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        HashMap<Long, Integer> map1 = new HashMap<>();
        HashMap<Long, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long k = (long) nums1[i] * nums1[j];
                map1.put(k, map1.getOrDefault(k, 0) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                long k = (long) nums2[i] * nums2[j];
                map2.put(k, map2.getOrDefault(k, 0) + 1);
            }
        }
        int res = 0;
        for (int i : nums1) {
            long cntK = (long) Math.pow(i, 2);
            res += map2.getOrDefault(cntK, 0);
        }
        for (int i : nums2) {
            long cntK = (long) Math.pow(i, 2);
            res += map1.getOrDefault(cntK, 0);
        }
        return res;
    }


    public int minFallingPathSum(int[][] grid) {
        int n = grid[0].length, m = grid.length;
        int[][] dp = new int[m][n];
        dp[0] = grid[0];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int u = 0; u < n; u++) {
                    if (j == u) continue;
                    min = Math.min(min, dp[i - 1][u]);
                }
                dp[i][j] = grid[i][j] + min;
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }


    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0, n = ages.length;
        for (int i = ages.length - 1; i >= 0; i--) {
            int l = i, r = n - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (ages[mid] > ages[i]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            int left = 0, right = r;
            int y = (int) (0.5 * ages[i]) + 8;
            if (y > ages[i]) continue;
            while (left <= right) {
                int mid = left + right >> 1;
                if (ages[mid] >= y) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res += r - left;
        }
        return res;
    }

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0, res = Integer.MIN_VALUE;
        for (char c1 : croakOfFrogs.toCharArray()) {
            switch (c1) {
                case 'c':
                    c++;
                    break;
                case 'r':
                    r++;
                    break;
                case 'o':
                    o++;
                    break;
                case 'a':
                    a++;
                    break;
                case 'k':
                    k++;
                    break;
            }
            if (r < r || r < o || o < a || a < k) return -1;
            res = Math.max(res, c - k);
        }
        if (c == r && r == o && o == a && a == k) return res;
        else return -1;
    }

    Boolean[][] flags = null;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        Set<Integer>[] edges = new Set[numCourses];
        flags = new Boolean[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new HashSet<>();
        }
        for (int[] prerequisite : prerequisites) {
            edges[prerequisite[1]].add(prerequisite[0]);
        }
        for (int[] query : queries) {
            Boolean aBoolean = flags[query[0]][query[1]];
            if (aBoolean != null) {
                res.add(aBoolean);
            } else {
                res.add(dfsCheckIfPre(query[0], query[1], edges));
            }
        }
        return res;
    }

    private Boolean dfsCheckIfPre(int num1, int num2, Set<Integer>[] edges) {
        Set<Integer> edge = edges[num2];
        if (flags[num1][num2] != null) return flags[num1][num2];
        if (edge.contains(num1)) return true;
        for (Integer integer : edge) {
            Boolean flag = dfsCheckIfPre(num1, integer, edges);
            flags[num1][integer] = flag;
            if (flag) return true;
        }
        flags[num1][num2] = false;
        return flags[num1][num2];
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<int[]> p = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            p.add(new int[]{key - 97, value});
        }
        StringBuilder sb = new StringBuilder();
        int preIndex = -1;
        while (sb.length() != s.length()) {
            if (p.isEmpty()) return "";
            int[] poll = p.poll();
            int cntIndex = poll[0];
            int cntValue = poll[1];
            if (preIndex != cntIndex) {
                sb.append((char) (cntIndex + 97));
                if (cntValue > 1) p.add(new int[]{cntIndex, cntValue - 1});
                preIndex = cntIndex;
            } else {
                if (p.isEmpty()) return "";
                int[] poll1 = p.poll();
                int nextIndex = poll1[0];
                int nextValue = poll1[1];
                sb.append((char) (nextIndex + 97));
                if (nextValue > 1) p.add(new int[]{nextIndex, nextValue - 1});
                preIndex = nextIndex;
                p.add(new int[]{cntIndex, cntValue});
            }
        }
        return sb.toString();
    }

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deliciousness) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer cntK = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < 21; i++) {
                int pow = (int) Math.pow(2, i);
                if (cntK > pow) continue;
                if (cntK == pow) {
                    if (value != 1) {
                        res += (long) value * (value - 1) / 2;
                        res %= 1000000007;
                    }
                    continue;
                }
                int tmp = pow - cntK;
                if (tmp > cntK && map.containsKey(tmp)) {
                    Integer integer = map.get(tmp);
                    res += (long) value * integer;
                    res %= 1000000007;
                }
            }
        }
        return (int) res;
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] targets = new int[n][3];
        for (int i = 0; i < n; i++) {
            targets[i][0] = i;
            targets[i][1] = tasks[i][0];
            targets[i][2] = tasks[i][1];
        }
        Arrays.sort(targets, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] res = new int[n];
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) {
                return o1[2] - o2[2];
            } else {
                return o1[0] - o2[0];
            }
        });
        int time = 1, j = 0;
        for (int i = 0; i < n; ) {
            while (j < n && targets[j][1] <= time) {
                priorityQueue.add(targets[j++]);
            }
            if (priorityQueue.isEmpty() && j < n) {
                time = targets[j][1];
            } else {
                int[] poll = priorityQueue.poll();
                res[i++] = poll[0];
                time += poll[2];
            }
        }
        return res;
    }

    public int minimumDeletions(String s) {
        int min = Integer.MAX_VALUE;
        int length = s.length();
        int[] last = new int[length];
        last[length - 1] = s.charAt(length - 1) == 'a' ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == 'a') {
                last[i] = last[i + 1] + 1;
            } else {
                last[i] = last[i + 1];
            }
        }
        int countA = 0, countB = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == 'b') {
                min = Math.min(min, countB + last[i]);
                countB++;
            } else {
                countA++;
            }
        }
        return Math.min(min, Math.min(countA, countB));
    }


    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] edges = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            edges[dislike[0]].add(dislike[1]);
            edges[dislike[1]].add(dislike[0]);
        }
        Map<Integer, Integer> colors = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!colors.containsKey(i)) {
                boolean flag = dfsPB(edges, colors, i, 0);
                if (!flag) return false;
            }
        }
        return true;
    }

    private boolean dfsPB(List<Integer>[] edges, Map<Integer, Integer> colors, int index, int color) {
        if (colors.containsKey(index)) {
            return colors.get(index) == color;
        }
        colors.put(index, color);
        for (Integer integer : edges[index]) {
            boolean child = dfsPB(edges, colors, integer, color ^ 1);
            if (!child) return false;
        }
        return true;
    }

    public int maxRepOpt1(String text) {
        return 1;
    }


    public int maxChunksToSorted(int[] arr) {
        int n = arr.length, res = 1;
        int[] rightMin = new int[n];
        int[] leftMax = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                leftMax[0] = arr[0];
                rightMin[n - i - 1] = arr[n - i - 1];
            } else {
                leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
                rightMin[n - i - 1] = Math.min(rightMin[n - i], arr[n - i - 1]);
            }
        }
        for (int i = 1; i < n; i++) {
            if (rightMin[i] >= leftMax[i - 1]) res++;
        }
        return res;
    }

    public boolean winnerSquareGame(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        if (n == 1) return true;
        return dfsWSG(map, n) > 0;
    }

    private int dfsWSG(Map<Integer, Integer> map, int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (map.containsKey(n)) return map.get(n);
        int res = 0;
        for (int i = 1; i * i <= n; i++) {
            int child = dfsWSG(map, n - i * i);
            res = Math.max(res, 1 - child);
        }
        map.put(n, res);
        return map.get(n);
    }

    public boolean winnerSquareGame1(int n) {
        if (n == 1) return true;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int res = 0;
            for (int j = 1; j * j <= i; j++) {
                res = Math.max(res, 1 - dp[i - j * j]);
            }
            dp[i] = res;
        }
        return dp[n] > 0;
    }

    /**
     * 700
     * 200
     * 500
     * 14
     * 6
     * 47
     * <p>
     * 700
     * 200
     * 500
     * 36
     * 6
     * 47
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    int INF = 1000007;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] memo = new int[n][k + 2];
        int i = dfsFCP(flights, src, dst, k + 1, memo);
        return i >= INF ? -1 : i;
    }

    private int dfsFCP(int[][] edges, int src, int dst, int k, int[][] memo) {
        if (k < 0) return INF;
        if (src == dst) return 0;
        if (memo[src][k] != 0) return memo[src][k];
        memo[src][k] = INF;
        for (int[] edge : edges) {
            if (edge[0] == src) {
                memo[src][k] = Math.min(memo[src][k], edge[2] + dfsFCP(edges, edge[1], dst, k - 1, memo));
            }
        }
        return memo[src][k];
    }


    HashMap<Integer, Integer> minCostTicket = new HashMap<>();

    public int mincostTickets(int[] days, int[] costs) {
        return dfsMCT(days, costs, 0);
    }

    private int dfsMCT(int[] days, int[] costs, int startIndex) {
        if (startIndex == days.length) return 0;
        if (minCostTicket.containsKey(startIndex)) return minCostTicket.get(startIndex);
        minCostTicket.put(startIndex, Integer.MAX_VALUE);
        for (int i = 0; i <= 2; i++) {
            int tmp = 0;
            if (i == 1) tmp = 6;
            else if (i == 2) tmp = 29;
            int nextTicketDay = days[startIndex] + tmp;
            int j = startIndex + 1;
            for (; j < days.length; j++) {
                if (days[j] > nextTicketDay) break;
            }
            int child = dfsMCT(days, costs, j);
            minCostTicket.put(startIndex, Math.min(child + costs[i], minCostTicket.get(startIndex)));
        }
        return minCostTicket.get(startIndex);
    }

    public long maxAlternatingSum(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(nums[0]);
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= stack.getFirst()) {
                stack.push(nums[i]);
            } else {
                Integer last = stack.getLast();
                Integer first = stack.getFirst();
                res += last - first;
                stack.clear();
                stack.push(nums[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            max = Math.max(max, integer);
        }
        res += max;
        return res;
    }

    public int longestArithSeqLength(int[] nums) {
        int res = 1;
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int j = 1; j < nums.length; j++) {
            for (int u = 0; u < j; u++) {
                int diff = nums[j] - nums[u] + 500;
                dp[j][diff] = dp[u][diff] + 1;
                res = Math.max(res, dp[j][diff]);
            }
        }
        return res + 1;
    }

    public long[] getDistances(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        long[] res = new long[n];
        for (int i = 0; i < arr.length; i++) {
            int cntK = arr[i];
            List<Integer> orDefault = map.getOrDefault(cntK, new ArrayList<>());
            orDefault.add(i);
            map.put(cntK, orDefault);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            int length = value.size();
            long[] pre = new long[length];
            pre[0] = value.get(0);
            for (int i = 1; i < length; i++) {
                pre[i] = pre[i - 1] + value.get(i);
            }
            for (int i = 0; i < length; i++) {
                Integer integer = value.get(i);
                long left = (long) i * (long) integer - (pre[i] - integer);
                long right = (pre[length - 1] - pre[i]) - (long) (length - i - 1) * (long) integer;
                res[integer] = left + right;
            }
        }
        return res;

    }


    public int videoStitching(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == 10000 ? -1 : dp[time];
    }

    int[] resLR = null;
    boolean[] flagsLR = null;
    int[] resCountLR = null;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        resLR = new int[n];
        flagsLR = new boolean[n];
        resCountLR = new int[n];
        Arrays.fill(resCountLR, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (!flagsLR[i]) dfsLP(richer, quiet, i);
        }
        return resLR;
    }

    private int[] dfsLP(int[][] richer, int[] quiet, int startIndex) {
        if (flagsLR[startIndex]) return new int[]{resLR[startIndex], resCountLR[startIndex]};
        int[] childRes = new int[]{startIndex, quiet[startIndex]};
        flagsLR[startIndex] = true;
        for (int[] ints : richer) {
            if (ints[1] == startIndex) {
                int[] child = null;
                if (!flagsLR[ints[0]]) {
                    child = dfsLP(richer, quiet, ints[0]);
                } else {
                    child = new int[]{resLR[ints[0]], resCountLR[ints[0]]};
                }
                if (child[1] < childRes[1]) {
                    childRes[0] = child[0];
                    childRes[1] = child[1];
                }
            }
        }
        resLR[startIndex] = childRes[0];
        resCountLR[startIndex] = childRes[1];
        return childRes;
    }


    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] % 3 == 0) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
            } else if (nums[i - 1] % 3 == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
            }
        }
        return dp[n][0];
    }


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int length = difficulty.length;
        int[][] targets = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] tmp = new int[]{difficulty[i], profit[i]};
            targets[i] = tmp;
        }
        Arrays.sort(targets, (o1, o2) -> o1[0] - o2[0]);
        int max = targets[0][1];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, targets[i][1]);
            targets[i][1] = max;
        }
        int res = 0;
        for (int target : worker) {
            int left = 0, right = length - 1;
            while (left <= right) {
                int mid = left + right >> 1;
                if (targets[mid][0] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left > 0) res += targets[left - 1][1];

        }
        return res;
    }


    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int maxCC = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < baseCosts.length; i++) {
            dfsCC(toppingCosts, baseCosts[i], 0, set);
        }
        int min = Integer.MAX_VALUE;
        for (Integer i : set) {
            if (Math.abs(i - target) < min) {
                min = Math.abs(i - target);
                maxCC = i;
            } else if (Math.abs(i - target) == min) {
                maxCC = Math.min(maxCC, i);
            }
        }
        return maxCC;
    }

    private void dfsCC(int[] toppingCosts, int sum, int startT, Set<Integer> flag) {
        flag.add(sum);
        if (startT >= toppingCosts.length) return;
        for (int i = 0; i < 3; i++) {
            dfsCC(toppingCosts, sum + i * toppingCosts[startT], startT + 1, flag);
        }
    }


    private List<List<Integer>> allSort = new ArrayList<>();
    private List<Integer> cntSort = new ArrayList<>();

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        int m = students[0].length;
        boolean[] flagS = new boolean[n];
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                for (int u = 0; u < m; u++) {
                    if (students[i][u] == mentors[j][u]) tmp++;
                }
                table[i][j] = tmp;
            }
        }
        dfsMB(students, flagS);
        int resMS = 0;
        for (List<Integer> list : allSort) {
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += table[list.get(i)][i];
            }
            resMS = Math.max(resMS, sum);
        }
        return resMS;
    }

    private void dfsMB(int[][] students, boolean[] flagS) {
        if (cntSort.size() == students.length) {
            allSort.add(new ArrayList<>(cntSort));
            return;
        }
        for (int i = 0; i < students.length; i++) {
            if (!flagS[i]) {
                flagS[i] = true;
                cntSort.add(i);
                dfsMB(students, flagS);
                flagS[i] = false;
                cntSort.remove(cntSort.size() - 1);
            }
        }
    }

    public int[] rearrangeBarcodes1(int[] barcodes) {
        int[] clone = barcodes.clone();
        Arrays.sort(clone);
        int n = barcodes.length;
        int half = (n & 1) == 1 ? n / 2 - 1 : n / 2;
        n--;
        int tmpHalf = half;
        int index = 0;
        while (half >= 0 && n > tmpHalf) {
            barcodes[index++] = clone[half--];
            barcodes[index++] = clone[n--];


        }
        while (half >= 0) {
            barcodes[index++] = clone[half--];
        }
        while (n > tmpHalf) {
            barcodes[index++] = clone[n--];
        }
        return barcodes;
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] != o2[1]) return o2[1] - o1[1];
            else return o1[0] - o2[0];
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int index = 0;
        while (!priorityQueue.isEmpty()) {
            int[] poll = priorityQueue.poll();
            barcodes[index++] = poll[0];
            if (!priorityQueue.isEmpty()) {
                int[] poll1 = priorityQueue.poll();
                barcodes[index++] = poll1[0];
                if (poll1[1] > 1) priorityQueue.add(new int[]{poll1[0], poll1[1] - 1});
            }
            if (poll[1] > 1) {
                priorityQueue.add(new int[]{poll[0], poll[1] - 1});
            }
        }
        return barcodes;
    }

    public int maxLength = 0;

    public int maxLength(List<String> arr) {
        int[] chars = new int[26];
        dfsML(arr, 0, chars, 0);
        return maxLength;
    }

    private void dfsML(List<String> arr, int startIndex, int[] chars, int total) {
        for (int i = startIndex; i < arr.size(); i++) {
            String cntStr = arr.get(i);
            int cntCount = 0;
            int[] clone = chars.clone();
            boolean flag = false;
            for (char c : cntStr.toCharArray()) {
                int tmp = (int) c - 'a';
                int count = clone[tmp];
                if (count == 0) {
                    clone[tmp]++;
                    cntCount++;
                } else {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                chars = clone;
                dfsML(arr, i + 1, chars, total + cntCount);
                for (char c : cntStr.toCharArray()) {
                    int tmp = (int) c - 'a';
                    chars[tmp]--;
                }
            }
        }
        maxLength = Math.max(maxLength, total);
    }

    public int beautySum(String s) {
        if (s.length() == 1) return 0;
        if (s.length() == 2) return 0;
        int res = 0, n = s.length();
        for (int i = 3; i <= n; i++) {
            int[] chars = new int[26];
            for (int j = 0; j < i; j++) {
                chars[(int) s.charAt(j) - 'a']++;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int u = 0; u < chars.length; u++) {
                if (chars[u] != 0) {
                    min = Math.min(min, chars[u]);
                    max = Math.max(max, chars[u]);
                }
            }
            res += max - min;
            for (int j = i; j < n; j++) {
                chars[(int) s.charAt(j - i) - 'a']--;
                chars[(int) s.charAt(j) - 'a']++;
                int min2 = Integer.MAX_VALUE;
                int max2 = Integer.MIN_VALUE;
                for (int u = 0; u < chars.length; u++) {
                    if (chars[u] != 0) {
                        min2 = Math.min(min2, chars[u]);
                        max2 = Math.max(max2, chars[u]);
                    }
                }
                res += max2 - min2;
            }
        }

        return res;
    }

    public int threeSumMulti(int[] arr, int target) {
        long res = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            int num = target - arr[i];
            HashMap<Integer, Long> map = new HashMap<>();
            for (int j = i + 1; j < arr.length; j++) {
                int cntK = num - arr[j];
                if (map.containsKey(cntK)) {
                    Long integer = map.get(cntK);
                    res += integer;
                    res %= mod;
                }
                map.put(arr[j], map.getOrDefault(arr[j], 0l) + 1);
            }
        }
        return (int) res;
    }

    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length, max = Integer.MIN_VALUE;
        int[] maxNums = new int[n];
        int[] clone = values.clone();
        for (int i = 0; i < n; i++) {
            clone[i] = clone[i] - i;
        }
        maxNums[n - 1] = clone[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxNums[i] = Math.max(maxNums[i + 1], clone[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, i + values[i] + maxNums[i + 1]);
        }
        return max;
    }

    public int nextBeautifulNumber(int n) {
        while (true) {
            n = n + 1;
            char[] chars = String.valueOf(n).toCharArray();
            int[] tmp = new int[10];
            for (char c : chars) {
                tmp[c - '0']++;
            }
            boolean flags = false;
            for (int i = 0; i < 10; i++) {
                if (tmp[i] > 0 && tmp[i] != i) {
                    flags = true;
                    break;
                }
            }
            if (!flags) break;
        }
        return n;
    }


    public int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = Integer.parseInt(reverseStr(String.valueOf(nums[i])));
            int cntK = nums[i] - tmp;
            map.put(cntK, map.getOrDefault(cntK, 0) + 1);
        }
        long res = 0;
        int mod = 1000000007;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            long tmp = (long) value * (value - 1) / 2;
            res += tmp;
            res %= mod;
        }
        return (int) res;
    }

    private String reverseStr(String valueOf) {
        char[] chars = valueOf.toCharArray();
        int n = valueOf.length();
        for (int i = 0; i < n / 2; i++) {
            char c = valueOf.charAt(i);
            chars[i] = valueOf.charAt(n - i - 1);
            chars[n - i - 1] = c;
        }
        return new String(chars);
    }

    private Set<String> strings = new HashSet<>();
    private int maxUS = 1;

    public int maxUniqueSplit(String s) {
        dfsMUS(s, 0);
        return maxUS;
    }

    private void dfsMUS(String s, int startIndex) {
        if (startIndex == s.length()) maxUS = Math.max(maxUS, strings.size());
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (!strings.contains(substring)) {
                strings.add(substring);
                dfsMUS(s, i + 1);
                strings.remove(substring);
            }
        }
    }

    //TODO 非暴力解法
    public int countSubstrings(String s, String t) {
        int res = 0;
        int n1 = s.length();
        int n2 = s.length();
        if (n1 <= n2) {
            res = countSubstringsTmp(s, t);
        } else {
            res = countSubstringsTmp(t, s);
        }

        return res;
    }

    private int countSubstringsTmp(String t, String s) {
        int res = 0;
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 0; j <= t.length() - i; j++) {
                String substring = t.substring(j, j + i);
                for (int u = 0; u <= s.length() - i; u++) {
                    String substring1 = s.substring(u, u + i);
                    int tmp = 0;
                    for (int z = 0; z < i; z++) {
                        if (substring.charAt(z) != substring1.charAt(z)) {
                            tmp++;
                        }
                    }
                    if (tmp == 1) res++;
                }
            }
        }
        return res;
    }

    public int kConcatenationMaxSum(int[] arr, int k) {
        int dp = 0, sum = 0, max = 0, length = arr.length;
        for (int i = 0; i < 2 * length; i++) {
            if (dp > 0) dp += arr[i % length];
            else dp = arr[i % length];
            max = Math.max(max, dp);
            if (k == 1 && i == length - 1) return max;
            if (i < arr.length) sum += arr[i];
        }
        return (int) (((long) Math.max(0, sum) * (k - 2) + max) % 1000000007);
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i <= s.length() - minSize; i++) {
            String substring = s.substring(i, i + minSize);
            if (isValid(substring, maxLetters)) {
                map.put(substring, map.getOrDefault(substring, 0) + 1);
                max = Math.max(max, map.get(substring));
            }

        }
        return max;
    }

    private boolean isValid(String cntK, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : cntK.toCharArray()) {
            set.add(c);
        }
        return set.size() <= maxLetters;
    }


    public int minInsertions(String s) {
        int count = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) {
                    if (i != s.length() - 1) {
                        if (s.charAt(i + 1) == '(') {
                            res += 2;
                        } else {
                            res++;
                            i++;
                        }
                    } else {
                        res += 2;
                    }
                } else {
                    if (i != s.length() - 1) {
                        if (s.charAt(i + 1) == '(') {
                            res++;
                        } else {
                            i++;
                        }
                    } else {
                        res++;
                    }
                    count--;
                }
            }
        }
        res += count * 2;
        return res;
    }

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int res = 0, n = tokens.length, point = 0;
        if (n == 0) return 0;
        while (left <= right && (power >= tokens[left] || point > 0)) {
            while (left <= right && power >= tokens[left]) {
                point++;
                power -= tokens[left++];
            }
            res = Math.max(res, point);
            if (left <= right && point > 0) {
                point--;
                power += tokens[right--];
            }
        }
        return res;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int dp = 0;
        int max = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dp = nums[i] + Math.max(dp, 0);
            max = Math.max(max, dp);
        }
        int min = 0;
        dp = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            dp = nums[i] + Math.min(dp, 0);
            min = Math.min(min, dp);
        }
        return Math.max(max, sum - min);
    }


    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) return null;
        int sum = 0;
        for (ListNode cursor = head; cursor != null; cursor = cursor.next) {
            if ((sum += cursor.val) == 0) return removeZeroSumSublists(cursor.next);
        }
        head.next = removeZeroSumSublists(head.next);
        return head;

    }

    private StringBuilder sbNTPB = new StringBuilder();

    public int numTilePossibilities1(String tiles) {
        Set<String> set = new HashSet<>();
        int n = tiles.length();
        boolean[] flags = new boolean[n];
        dfsNTPB(tiles, set, flags);
        return set.size();
    }

    private void dfsNTPB(String tiles, Set<String> set, boolean[] flags) {
        if (sbNTPB.toString() != "") {
            set.add(sbNTPB.toString());
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!flags[i]) {
                sbNTPB.append(tiles.charAt(i));
                flags[i] = true;
                dfsNTPB(tiles, set, flags);
                flags[i] = false;
                sbNTPB.deleteCharAt(sbNTPB.length() - 1);
            }
        }
    }

    /**
     * 带优化活字印刷
     *
     * @param tiles
     * @return
     */
    public int numTilePossibilities(String tiles) {
        int[] targets = new int[26];
        for (char c : tiles.toCharArray()) {
            targets[c - 'A']++;
        }
        return dfsNP(targets);
    }

    private int dfsNP(int[] targets) {
        int res = 0;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i] > 0) {
                res++;
                targets[i]--;
                res += dfsNP(targets);
                targets[i]++;
            }
        }
        return res;
    }

    Integer[][] memoMSJ = null;

    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        memoMSJ = new Integer[n][4];
        dfsMSJ(obstacles, 0, 2, 0);
        int min = Integer.MAX_VALUE;
        for (Integer integer : memoMSJ[n - 1]) {
            if (integer != null) {
                min = Math.min(min, integer);
            }
        }
        return min;
    }

    private int dfsMSJ(int[] obstacles, int startIndex, int cntIndex, int count) {
        if (startIndex >= obstacles.length) return 0;
        if (memoMSJ[startIndex][cntIndex] != null) return memoMSJ[startIndex][cntIndex];
        memoMSJ[startIndex][cntIndex] = Integer.MAX_VALUE;
        if (startIndex + 1 < obstacles.length) {
            if (obstacles[startIndex + 1] != cntIndex) {
                dfsMSJ(obstacles, startIndex + 1, cntIndex, count);
            } else {
                if (cntIndex == 1) {
                    if (obstacles[startIndex] != 2) {
                        int num1 = dfsMSJ(obstacles, startIndex, 2, count + 1);
                        memoMSJ[startIndex][cntIndex] = Math.min(num1, memoMSJ[startIndex][cntIndex]);
                    }
                    if (obstacles[startIndex] != 3) {
                        int num1 = dfsMSJ(obstacles, startIndex, 3, count + 1);
                        memoMSJ[startIndex][cntIndex] = Math.min(num1, memoMSJ[startIndex][cntIndex]);
                    }
                } else if (cntIndex == 2) {
                    if (obstacles[startIndex] != 1) {
                        int num1 = dfsMSJ(obstacles, startIndex, 1, count + 1);
                        memoMSJ[startIndex][cntIndex] = Math.min(num1, memoMSJ[startIndex][cntIndex]);
                    }
                    if (obstacles[startIndex] != 3) {
                        int num1 = dfsMSJ(obstacles, startIndex, 3, count + 1);
                        memoMSJ[startIndex][cntIndex] = Math.min(num1, memoMSJ[startIndex][cntIndex]);
                    }
                } else if (cntIndex == 3) {
                    if (obstacles[startIndex] != 1) {
                        int num1 = dfsMSJ(obstacles, startIndex, 1, count + 1);
                        memoMSJ[startIndex][cntIndex] = Math.min(num1, memoMSJ[startIndex][cntIndex]);
                    }
                    if (obstacles[startIndex] != 2) {
                        int num1 = dfsMSJ(obstacles, startIndex, 2, count + 1);
                        memoMSJ[startIndex][cntIndex] = Math.min(num1, memoMSJ[startIndex][cntIndex]);
                    }
                }
            }
        }
        memoMSJ[startIndex][cntIndex] = Math.min(count, memoMSJ[startIndex][cntIndex]);

        return memoMSJ[startIndex][cntIndex];
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> p1 = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        PriorityQueue<int[]> p2 = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (int[] order : orders) {
            if (order[2] == 0) {
                int count = order[1];
                while (!p2.isEmpty() && p2.peek()[0] <= order[0] && count > 0) {
                    int[] ints = p2.poll();
                    if (count >= ints[1]) {
                        count -= ints[1];
                    } else {
                        p2.add(new int[]{ints[0], ints[1] - count});
                        count = 0;
                    }
                }
                if (count > 0) {
                    p1.add(new int[]{order[0], count});
                }
            } else {
                int count = order[1];
                while (!p1.isEmpty() && p1.peek()[0] >= order[0] && count > 0) {
                    int[] ints = p1.poll();
                    if (count >= ints[1]) {
                        count -= ints[1];
                    } else {
                        p1.add(new int[]{order[0], ints[1] - count});
                        count = 0;
                    }
                }
                if (count > 0) {
                    p2.add(new int[]{order[0], count});
                }
            }
        }
        long res = 0;
        int mod = 1000000007;
        while (!p1.isEmpty()) {
            res += p1.poll()[1];
            res %= mod;
        }
        while (!p2.isEmpty()) {
            res += p2.poll()[1];
            res %= mod;
        }
        return (int) res;
    }

    public int getNumberOfBacklogOrders1(int[][] orders) {
        int mod = 1000000007;
        PriorityQueue<int[]> queueSell = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> queueBuy = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int len = orders.length;
        for (int i = 0; i < len; i++) {
            int[] order = orders[i];
            int pricei = order[0], amounti = order[1], orderTypei = order[2];
            if (orderTypei == 0) {
                // buy
                while (!queueSell.isEmpty() && queueSell.peek()[0] <= pricei && amounti > 0) {
                    int[] cur = queueSell.poll();
                    int price = cur[0], amount = cur[1];
                    int dif = Math.min(amounti, amount);
                    amount -= dif;
                    amounti -= dif;
                    if (amount > 0) {
                        queueSell.add(new int[]{price, amount});
                    }
                }
                if (amounti > 0) {
                    queueBuy.add(new int[]{pricei, amounti});
                }
            } else {
                // sell
                while (!queueBuy.isEmpty() && queueBuy.peek()[0] >= pricei && amounti > 0) {
                    int[] cur = queueBuy.poll();
                    int price = cur[0], amount = cur[1];
                    int dif = Math.min(amounti, amount);
                    amount -= dif;
                    amounti -= dif;
                    if (amount > 0) {
                        queueBuy.add(new int[]{price, amount});
                    }
                }
                if (amounti > 0) {
                    queueSell.add(new int[]{pricei, amounti});
                }
            }
        }
        long ans = 0;
        while (!queueBuy.isEmpty()) {
            ans += queueBuy.poll()[1];
            ans %= mod;
        }
        while (!queueSell.isEmpty()) {
            ans += queueSell.poll()[1];
            ans %= mod;
        }
        return (int) ans;
    }


    public boolean canArrange(int[] arr, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            int cntK = (num % k + k) % k;
            map.put(cntK, map.getOrDefault(cntK, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int t = entry.getKey(), occ = entry.getValue();
            if (t > 0 && map.getOrDefault(k - t, 0) != occ) {
                return false;
            }
        }
        return map.getOrDefault(0, 0) % 2 == 0;
    }

    public int[][] highestPeak(int[][] isWater) {
        int n = isWater[0].length, m = isWater.length;
        int[][] targets = new int[m][n];
        for (int i = 0; i < m; i++) Arrays.fill(targets[i], Integer.MAX_VALUE / 2);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    targets[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (targets[i][j] == 0) continue;
                // 上
                if (i > 0) targets[i][j] = Math.min(targets[i][j], targets[i - 1][j] + 1);
                // 左
                if (j > 0) targets[i][j] = Math.min(targets[i][j], targets[i][j - 1] + 1);
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (targets[i][j] == 0) continue;
                // 右
                if (i < m - 1) targets[i][j] = Math.min(targets[i][j], targets[i + 1][j] + 1);
                // 下
                if (j < n - 1) targets[i][j] = Math.min(targets[i][j], targets[i][j + 1] + 1);
            }
        }
        return targets;
    }


    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowPreSum = new int[m][n];
        int[][] colPreSum = new int[m][n];
        int[][] lDiaPreSum = new int[m][n];
        int[][] rDiaPreSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPreSum[i][j] = j == 0 ? grid[i][j] : rowPreSum[i][j - 1] + grid[i][j];
                colPreSum[i][j] = i == 0 ? grid[i][j] : colPreSum[i - 1][j] + grid[i][j];
                lDiaPreSum[i][j] = i == 0 || j == 0 ? grid[i][j] : lDiaPreSum[i - 1][j - 1] + grid[i][j];
                int q = n - 1 - j;
                rDiaPreSum[i][j] = i == 0 || q == n - 1 ? grid[i][q] : rDiaPreSum[i - 1][q + 1] + grid[i][q];
            }
        }
        int ret = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int p = i, q = j;
                while (p >= 0 && q >= 0) {
                    if (checkLMS(p, q, i, j, grid, rowPreSum, colPreSum, lDiaPreSum, rDiaPreSum))
                        ret = Math.max(ret, (i - p + 1));
                    p--;
                    q--;
                }
            }
        }

        return ret;

    }

    private boolean checkLMS(int p, int q, int x, int y, int[][] grid, int[][] rowPreSum, int[][] colPreSum, int[][] lDiaPreSum, int[][] rDiaPreSum) {
        int v1 = rowPreSum[p][y] - rowPreSum[p][q] + grid[p][q];
        int v2 = colPreSum[x][q] - colPreSum[p][q] + grid[p][q];
        int v3 = lDiaPreSum[x][y] - lDiaPreSum[p][q] + grid[p][q];
        int v4 = rDiaPreSum[x][q] - rDiaPreSum[p][y] + grid[p][y];
        if (v1 != v2 || v3 != v4 || v1 != v3) return false;
        for (int i = p; i <= x; i++) {
            int tmp = rowPreSum[i][y] - (q == 0 ? 0 : rowPreSum[i][q - 1]);
            if (tmp != v1) return false;
        }
        for (int j = q; j <= y; j++) {
            int tmp = colPreSum[x][j] - (p == 0 ? 0 : colPreSum[p - 1][j]);
            if (tmp != v2) return false;
        }
        return true;
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res = new int[n];
        boolean[] flags = new boolean[n];
        boolean[] canFinshed = new boolean[n];

        for (int i = 1; i < n; i++) {

        }

        return res;
    }

    private int[] dfsSAP(int start, int end, int[][] redEdges, int[][] blueEdges, int color, boolean[] flags, boolean[] canFinshed) {
        if (start == end) return new int[]{0, 0};
        flags[start] = true;
        int count = 0;
        if (color == 0) {
            for (int[] redEdge : redEdges) {
                if (redEdge[0] == start) {
                    count++;
                    dfsSAP(redEdge[1], end, redEdges, blueEdges, color ^ 1, flags, canFinshed);

                }
            }
        } else {
            for (int[] blueEdge : blueEdges) {
                if (blueEdge[0] == start) {
                    count++;
                    dfsSAP(blueEdge[1], end, redEdges, blueEdges, color ^ 1, flags, canFinshed);

                }
            }
        }
        return new int[]{-1, color};
    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        TreeNode p = root;
        boolean flag = false;
        while (!treeNodes.isEmpty()) {
            p = treeNodes.poll();
            if (p == null) {
                if (treeNodes.size() == 0) return true;
                else return false;
            } else {
                if (p.left != null || p.right != null) {
                    // 如果当前点不是叶子节点，并且之前已经出现过叶子节点，直接返回false
                    if (flag) {
                        return false;
                    }
                    treeNodes.add(p.left);
                    treeNodes.add(p.right);
                } else {
                    // 叶子节点往后的点都是叶子节点
                    if (!flag) {
                        flag = true;
                    }
                }

            }
        }
        return true;
    }

    public int countVowelPermutation(int n) {
        if (n == 1) return 5;
        long sum = 0;
        int mod = 1000000007;
        long[] dp = new long[5];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            long[] tmp = new long[5];
            for (int j = 0; j < 5; j++) {
                if (j == 0) {
                    tmp[1] += dp[0];
                    tmp[1] %= mod;
                } else if (j == 1) {
                    tmp[0] += dp[1];
                    tmp[0] %= mod;
                    tmp[2] += dp[1];
                    tmp[2] %= mod;
                } else if (j == 2) {
                    tmp[0] += dp[2];
                    tmp[0] %= mod;
                    tmp[1] += dp[2];
                    tmp[1] %= mod;
                    tmp[3] += dp[2];
                    tmp[3] %= mod;
                    tmp[4] += dp[2];
                    tmp[4] %= mod;
                } else if (j == 3) {
                    tmp[2] += dp[3];
                    tmp[2] %= mod;
                    tmp[4] += dp[3];
                    tmp[4] %= mod;
                } else {
                    tmp[0] += dp[4];
                    tmp[0] %= mod;
                }
            }
            dp = tmp;
        }
        for (long l : dp) {
            sum += l;
            sum %= mod;
        }
        return (int) sum;
    }

    /**
     * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
     * <p>
     * 请你返回让 s 成为回文串的 最少操作次数 。
     * <p>
     * 「回文串」是正读和反读都相同的字符串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "zzazz"
     * 输出：0
     * 解释：字符串 "zzazz" 已经是回文串了，所以不需要做任何插入操作。
     * 示例 2：
     * <p>
     * 输入：s = "mbadm"
     * 输出：2
     * 解释：字符串可变为 "mbdadbm" 或者 "mdbabdm" 。
     * 示例 3：
     * <p>
     * 输入：s = "leetcode"
     * 输出：5
     * 解释：插入 5 个字符后字符串变为 "leetcodocteel" 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-insertion-steps-to-make-a-string-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int minInsertions1(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        dp[i][j] = 1;
                    } else if (i - j == 1) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, Math.max(dp[i + 1][j], dp[i][j - 1]));
                    }
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return length - dp[0][length - 1];
    }

    /**
     * 有效括号字符串类型与对应的嵌套深度计算方法如下图所示：
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
     * <p>
     * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
     * A 或 B 中的元素在原字符串中可以不连续。
     * A.length + B.length = seq.length
     * 深度最小：max(depth(A), depth(B)) 的可能取值最小。
     * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
     * <p>
     * answer[i] = 0，seq[i] 分给 A 。
     * answer[i] = 1，seq[i] 分给 B 。
     * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：seq = "(()())"
     * 输出：[0,1,1,1,1,0]
     * 示例 2：
     * <p>
     * 输入：seq = "()(())()"
     * 输出：[0,0,0,1,1,0,1,1]
     * 解释：本示例答案不唯一。
     * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
     * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
     *
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        int num1 = 0, num2 = 0, n = seq.length();
        int[] res = new int[n];
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                if (num1 - num2 == 0) {
                    res[i] = 0;
                    num1++;
                } else {
                    res[i] = 1;
                    num2++;
                }
            } else {
                if (num1 - num2 == 0) {
                    res[i] = 1;
                    num2--;
                } else {
                    res[i] = 0;
                    num1--;
                }
            }
        }
        return res;
    }

    public boolean canChange(String start, String target) {
        List<int[]> list = new ArrayList<>();
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'L') {
                list.add(new int[]{num1, num2, num3});
                num1++;
            } else if (target.charAt(i) == 'R') {
                num2++;
            } else {
                num3++;
            }
        }
        num1 = 0;
        num2 = 0;
        num3 = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                if (num1 < list.size()) {
                    int[] ints = list.get(num1);
                    if (ints[0] != num1) return false;
                    else if (ints[1] != num2) return false;
                    else if (num3 < ints[2]) return false;
                    num1++;
                } else return false;
            } else if (start.charAt(i) == 'R') {
                num2++;
            } else {
                num3++;
            }
        }
        if (num1 != list.size()) return false;
        num1 = 0;
        num2 = 0;
        num3 = 0;
        list.clear();
        for (int i = target.length() - 1; i >= 0; i--) {
            if (target.charAt(i) == 'L') {
                num1++;
            } else if (target.charAt(i) == 'R') {
                list.add(new int[]{num1, num2, num3});
                num2++;
            } else {
                num3++;
            }
        }
        num1 = 0;
        num2 = 0;
        num3 = 0;
        for (int i = target.length() - 1; i >= 0; i--) {
            if (start.charAt(i) == 'L') {
                num1++;
            } else if (start.charAt(i) == 'R') {
                if (num2 < list.size()) {
                    int[] ints = list.get(num2);
                    if (ints[0] != num1) return false;
                    else if (ints[1] != num2) return false;
                    else if (num3 < ints[2]) return false;
                    num2++;
                } else return false;
            } else {
                num3++;
            }
        }
        if (num2 != list.size()) return false;
        return true;
    }

    public boolean canTransform(String start, String end) {
        List<int[]> list = new ArrayList<>();
        int num1 = 0, num2 = 0, num3 = 0;
        for (int i = 0; i < end.length(); i++) {
            if (end.charAt(i) == 'L') {
                list.add(new int[]{num1, num2, num3});
                num1++;
            } else if (end.charAt(i) == 'R') {
                num2++;
            } else {
                num3++;
            }
        }
        num1 = 0;
        num2 = 0;
        num3 = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L') {
                if (num1 < list.size()) {
                    int[] ints = list.get(num1);
                    if (ints[0] != num1) return false;
                    else if (ints[1] != num2) return false;
                    else if (num3 < ints[2]) return false;
                    num1++;
                } else return false;
            } else if (start.charAt(i) == 'R') {
                num2++;
            } else {
                num3++;
            }
        }
        if (num1 != list.size()) return false;
        num1 = 0;
        num2 = 0;
        num3 = 0;
        list.clear();
        for (int i = end.length() - 1; i >= 0; i--) {
            if (end.charAt(i) == 'L') {
                num1++;
            } else if (end.charAt(i) == 'R') {
                list.add(new int[]{num1, num2, num3});
                num2++;
            } else {
                num3++;
            }
        }
        num1 = 0;
        num2 = 0;
        num3 = 0;
        for (int i = end.length() - 1; i >= 0; i--) {
            if (start.charAt(i) == 'L') {
                num1++;
            } else if (start.charAt(i) == 'R') {
                if (num2 < list.size()) {
                    int[] ints = list.get(num2);
                    if (ints[0] != num1) return false;
                    else if (ints[1] != num2) return false;
                    else if (num3 < ints[2]) return false;
                    num2++;
                } else return false;
            } else {
                num3++;
            }
        }
        if (num2 != list.size()) return false;
        return true;
    }


    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[][] preSum = new long[2][n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[0][i] = preSum[0][i - 1] + grid[0][i - 1];
            preSum[1][i] = preSum[1][i - 1] + grid[1][i - 1];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, Math.max(preSum[0][n] - preSum[0][i], preSum[1][i - 1]));
        }
        return ans;
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] edges = new List[n + 1];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            int garden0 = path[0], garden1 = path[1];
            if (garden0 < garden1) {
                edges[garden1].add(garden0);
            } else {
                edges[garden0].add(garden1);
            }

        }
        int[] res = new int[n];
        for (int i = 1; i <= n; i++) {
            List<Integer> edge = edges[i];
            boolean[] flags = new boolean[5];
            if (res[i - 1] != 0) flags[res[i - 1]] = true;
            for (Integer integer : edge) {
                int color = res[integer - 1];
                if (color != 0) {
                    flags[color] = true;
                }
            }
            if (res[i - 1] == 0) {
                for (int j = 1; j < flags.length; j++) {
                    if (!flags[j]) {
                        flags[j] = true;
                        res[i - 1] = j;
                        break;
                    }
                }
            }
            for (Integer integer : edge) {
                if (res[integer - 1] == 0) {
                    for (int j = 1; j < flags.length; j++) {
                        if (!flags[j]) {
                            flags[j] = true;
                            res[integer - 1] = j;
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int getMaxLen1(int[] nums) {
        int num1 = nums[0] > 0 ? 1 : 0;
        int num2 = nums[0] < 0 ? 1 : 0;
        int max = Math.max(num1, 0);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                num1++;
                num2 = num2 > 0 ? num2 + 1 : 0;
            } else if (nums[i] < 0) {
                int tmp = num1;
                num1 = num2 > 0 ? num2 + 1 : 0;
                num2 = tmp + 1;
            } else {
                num1 = 0;
                num2 = 0;
            }
            max = Math.max(max, num1);
        }
        return max;
    }

    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] positive = new int[n];
        int[] negative = new int[n];
        if (nums[0] > 0) {
            positive[0] = 1;
        } else if (nums[0] < 0) {
            negative[0] = 1;
        }
        max = Math.max(max, positive[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                positive[i] = positive[i - 1] + 1;
                negative[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
            } else if (nums[i] < 0) {
                positive[i] = negative[i - 1] > 0 ? negative[i - 1] + 1 : 0;
                negative[i] = positive[i - 1] + 1;
            } else {
                positive[i] = 0;
                negative[i] = 0;
            }
            max = Math.max(max, positive[i]);
        }
        return max;
    }

    List<BigInteger> cntSS = new ArrayList<>();

    public boolean splitString(String s) {
        return dfsSS(s, 0);
    }
    private boolean dfsSS(String s, int startIndex) {
        if (startIndex == s.length()) return cntSS.size() > 1;
        for (int i = startIndex; i < s.length(); i++) {
            BigInteger substring = new BigInteger(s.substring(startIndex, i + 1));
            if (cntSS.size() == 0) {
                cntSS.add(substring);
                if (dfsSS(s, i + 1)) return true;
                cntSS.remove(cntSS.size() - 1);
            } else {
                BigInteger integer = cntSS.get(cntSS.size() - 1);
                if (integer.equals(substring.add(new BigInteger("1")))) {
                    cntSS.add(substring);
                    if (dfsSS(s, i + 1)) return true;
                    cntSS.remove(cntSS.size() - 1);
                }
            }
        }
        return false;
    }


}