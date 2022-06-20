package cn.underdog.leetcode.backtracking;

import java.util.*;

/**
 * 回溯
 */
public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.combine(4, 2);
//        mainClass.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        mainClass.combinationSum3(3, 7);
//        mainClass.letterCombinations("23");
//        mainClass.partition("aab");
//        mainClass.restoreIpAddresses("101023");
//        mainClass.subsetsWithDup(new int[]{1, 2, 2});
//        mainClass.findSubsequences(new int[]{4, 6, 7, 7});
//        mainClass.findSubsequences(new int[]{4, 4, 3, 2, 1});
//        mainClass.permuteUnique(new int[]{1, 1, 2});
        List<List<String>> list = new ArrayList<>();
        list.add(List.of("MUC", "LHR"));
        list.add(List.of("JFK", "MUC"));
        list.add(List.of("SFO", "SJC"));
        list.add(List.of("LHR", "SFO"));
//        mainClass.findItinerary(list);
//        mainClass.makesquare(new int[]{1, 1, 2, 2, 2});
//        System.out.println(mainClass.makesquare(new int[]{5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));
        mainClass.canPartitionKSubsets(new int[]{10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8}, 11);
    }

    List<List<Integer>> resCombine = new ArrayList<>();
    List<Integer> pathCombine = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrackingCombine(n, k, 1);
        return resCombine;
    }

    private void backtrackingCombine(int n, int k, int startIndex) {
        // 回溯循环结束条件，如果当前路径的长度和k相同则直接返回
        if (pathCombine.size() == k) {
            resCombine.add(new ArrayList<>(pathCombine));
            return;
        }
//        for (int i = startIndex; i <= n; i++) {
        // 剪枝优化
        for (int i = startIndex; i <= n - (k - pathCombine.size()) + 1; i++) {
            // 添加回溯
            pathCombine.add(i);
            backtrackingCombine(n, k, i + 1);
            // 撤销本次回溯
            pathCombine.remove(pathCombine.size() - 1);
        }
    }

    List<List<Integer>> resCombineSum = new ArrayList<>();
    List<Integer> listCombineSum = new ArrayList<>();
    int combinationSum2 = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrackingCombine2(candidates, target, 0);
        return resCombineSum;
    }

    private void backtrackingCombine2(int[] candidates, int target, int startIndex) {
        if (target == combinationSum2) {
            resCombineSum.add(new ArrayList<>(listCombineSum));
            return;
        }
        for (int i = startIndex; i < candidates.length && combinationSum2 + candidates[i] <= target; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1])
                continue;
            listCombineSum.add(candidates[i]);
            combinationSum2 += candidates[i];
            backtrackingCombine2(candidates, target, i + 1);
            combinationSum2 -= candidates[i];
            listCombineSum.remove(listCombineSum.size() - 1);
        }
    }



    /*public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        // 排序方便进行剪枝
        Arrays.sort(candidates);
        dfs(res, path, candidates, 0, target);
        return res;
    }
    private static void dfs(List<List<Integer>> res, Deque<Integer> path, int[] candidates, int index, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (index >= candidates.length) return;

        List<Integer> pre = new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (pre.contains(candidates[i])) continue;
            if (target - candidates[i] < 0) break;
            path.add(candidates[i]);
            pre.add(candidates[i]);
            dfs(res, path, candidates, i + 1, target - candidates[i]);
            path.pollLast();
        }

    }*/

    List<List<Integer>> resCombine3 = new ArrayList<>();
    List<Integer> pathCombine3 = new ArrayList<>();
    int sum3 = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrackingCombine3(k, n, 1);
        return resCombine3;
    }

    private void backtrackingCombine3(int k, int n, int startIndex) {
        // 如果当前的和大于n进行剪枝操作
        if (sum3 > n)
            return;
        if (pathCombine3.size() == k) {
            if (sum3 == n) {
                resCombine3.add(new ArrayList<>(pathCombine3));
            }
            return;
        }

        for (int i = startIndex; i <= 9; i++) {

            pathCombine3.add(i);
            sum3 += i;
            backtrackingCombine3(k, n, i + 1);
            sum3 -= i;
            pathCombine3.remove(pathCombine3.size() - 1);
        }
    }


    List<String> resLetterCombinations = new ArrayList<>();
    StringBuilder sbLetterCombinations = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return resLetterCombinations;
        String[] strings = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrackingLetterCombination(strings, digits, 0);
        return resLetterCombinations;
    }

    private void backtrackingLetterCombination(String[] strings, String digits, int startIndex) {
        if (digits.length() == startIndex) {
            resLetterCombinations.add(sbLetterCombinations.toString());
            return;
        }
        String string = strings[digits.charAt(startIndex) - '0'];
        for (int j = 0; j < string.length(); j++) {
            sbLetterCombinations.append(string.charAt(j));
            backtrackingLetterCombination(strings, digits, startIndex + 1);
            sbLetterCombinations.deleteCharAt(sbLetterCombinations.length() - 1);
        }
    }

    List<List<Integer>> resCombineSum1 = new ArrayList<>();
    List<Integer> pathCombineSum1 = new ArrayList<>();
    int combinationSum1 = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrackingCombinationSum(candidates, target, 0);
        return resCombineSum1;
    }

    private void backtrackingCombinationSum(int[] candidates, int target, int indexStart) {
        if (combinationSum1 > target)
            return;
        if (combinationSum1 == target) {
            resCombineSum1.add(new ArrayList<>(pathCombineSum1));
            return;
        }
        for (int i = indexStart; i < candidates.length && combinationSum1 + candidates[i] <= target; i++) {
            pathCombineSum1.add(candidates[i]);
            combinationSum1 += candidates[i];
            backtrackingCombinationSum(candidates, target, i);
            combinationSum1 -= candidates[i];
            pathCombineSum1.remove(pathCombineSum1.size() - 1);
        }
    }

    /**
     * public List<List<Integer>> combinationSum(int[] candidates, int target) {
     * List<List<Integer>> res = new ArrayList<>();
     * Deque<Integer> current = new LinkedList<>();
     * Arrays.sort(candidates);
     * current.add(candidates[0]);
     * dfsCombination(candidates, current, candidates[0], res, target);
     * return res;
     * }
     * private  void dfsCombination(int[] candidates, Deque<Integer> current, int candidate, List<List<Integer>> res, int target) {
     * if (candidate == target) {
     * res.add(new ArrayList<>(current));
     * return;
     * }
     * if (candidate > target) {
     * return;
     * }
     * for (int i : candidates) {
     * current.add(i);
     * candidate += i;
     * dfsCombination(candidates, current, candidate, res, target);
     * candidate-=current.pollLast();
     * }
     * }
     */

    List<List<String>> resPartition = new ArrayList<>();
    List<String> cntPartition = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrackingPartition(s, 0);
        return resPartition;
    }

    private void backtrackingPartition(String s, int startIndex) {
        // 回溯结束条件
        if (startIndex >= s.length()) {
            resPartition.add(new ArrayList<>(cntPartition));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断当前是否是回文串
            if (isPalindrome(s, startIndex, i)) {
                cntPartition.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            backtrackingPartition(s, i + 1);
            cntPartition.remove(cntPartition.size() - 1);
        }
    }

    private boolean isPalindrome(String str, int startIndex, int end) {
        int left = startIndex;
        int right = end;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }

        return true;
    }

    List<String> resIpAddress = new ArrayList<>();
    List<String> cntIpAddress = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12)
            return resIpAddress;
        backtrackingIpAddresses(s, 0);
        return resIpAddress;
    }

    private void backtrackingIpAddresses(String s, int indexStart) {
        if (cntIpAddress.size() == 3) {
            if (!isValid(s, indexStart, s.length() - 1)) {
                String substring = s.substring(indexStart);
                String join = String.join("", cntIpAddress) + substring;
                resIpAddress.add(join);
            }
            return;
        }
        for (int i = indexStart; i < s.length() && i - indexStart < 3; i++) {
            if (!isValid(s, indexStart, i)) {
                String tmp = s.substring(indexStart, i + 1) + ".";
                cntIpAddress.add(tmp);
            } else {
                continue;
            }
            backtrackingIpAddresses(s, i + 1);
            cntIpAddress.remove(cntIpAddress.size() - 1);
        }

    }

    private boolean isValid(String s, int indexStart, int i) {
        s = s.substring(indexStart, i + 1);
        if (s.equals("") || s.length() > 3) {
            return true;
        }
        int tmp = Integer.parseInt(s);
        if (tmp > 255)
            return true;
        return s.startsWith("0") && s.length() > 1;
    }

    List<List<Integer>> resSubsets = new ArrayList<>();
    List<Integer> cntSubset = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrackingSubset(nums, 0);
        return resSubsets;
    }

    private void backtrackingSubset(int[] nums, int startIndex) {
        resSubsets.add(new ArrayList<>(cntSubset));
        for (int i = startIndex; i < nums.length; i++) {
            cntSubset.add(nums[i]);
            backtrackingSubset(nums, i + 1);
            cntSubset.remove(cntSubset.size() - 1);
        }
    }

    /**
     * public List<List<Integer>> subsetsWithDup(int[] nums) {
     * <p>
     * List<List<Integer>> res = new ArrayList<>();
     * res.add(new ArrayList<>());
     * Arrays.sort(nums);
     * for (int i = 1; i <= nums.length; i++) {
     * // 当前子集
     * List<Integer> currentSet = new ArrayList<>();
     * dfs(res, nums, i, currentSet, 0);
     * }
     * <p>
     * return res;
     * }
     * public  void dfs(List<List<Integer>> res, int[] nums, int k, List<Integer> currentSet, int start) {
     * if (k == 0) {
     * if(!res.contains(currentSet)){
     * res.add(new ArrayList<>(currentSet));
     * }
     * return;
     * }
     * for (int i = start; i < nums.length; i++) {
     * currentSet.add(nums[i]);
     * dfs(res, nums, k - 1, currentSet, i + 1);
     * currentSet.remove(currentSet.size() - 1);
     * }
     * }
     */

    List<List<Integer>> resSubSetsDup = new ArrayList<>();
    List<Integer> pathSubSetsDup = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 相同元素聚在一起，消除同层之间的重复
        Arrays.sort(nums);
        backtrackingSubsetDup(nums, 0);
        return resSubSetsDup;
    }

    private void backtrackingSubsetDup(int[] nums, int startIndex) {
        resSubSetsDup.add(new ArrayList<>(pathSubSetsDup));
        for (int i = startIndex; i < nums.length; i++) {
            // 同层之间不能有重复
            if (i > startIndex && nums[i] == nums[i - 1])
                continue;
            pathSubSetsDup.add(nums[i]);
            backtrackingSubsetDup(nums, i + 1);
            pathSubSetsDup.remove(pathSubSetsDup.size() - 1);
        }
    }

    List<List<Integer>> resSubsequences = new ArrayList<>();
    List<Integer> pathSubsequences = new ArrayList<>();

    /**
     * 数组不是有序的，用num[i-1]和num[i]判断是不能作为一依据
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrackingSubsequences(nums, 0);
        return resSubsequences;
    }

    private void backtrackingSubsequences(int[] nums, int startIndex) {
        if (pathSubsequences.size() >= 2) {
            resSubsequences.add(new ArrayList<>(pathSubsequences));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (set.contains(nums[i]))
                continue;
            if (pathSubsequences.size() > 0 && pathSubsequences.get(pathSubsequences.size() - 1) > nums[i]) {
                continue;
            }
            set.add(nums[i]);
            pathSubsequences.add(nums[i]);
            backtrackingSubsequences(nums, i + 1);
            pathSubsequences.remove(pathSubsequences.size() - 1);
        }
    }

    List<List<Integer>> listPermute = new ArrayList<>();
    List<Integer> pathPermute = new ArrayList<>();
    boolean[] flagsPermute;

    public List<List<Integer>> permute(int[] nums) {
        flagsPermute = new boolean[nums.length];
        backtrackingPermute(nums);
        return listPermute;
    }

    private void backtrackingPermute(int[] nums) {
        if (pathPermute.size() == nums.length) {
            listPermute.add(new ArrayList<>(pathPermute));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flagsPermute[i])
                continue;
            pathPermute.add(nums[i]);
            flagsPermute[i] = true;
            backtrackingPermute(nums);
            flagsPermute[i] = false;
            pathPermute.remove(pathPermute.size() - 1);
        }
    }

    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        List<Integer> current = new ArrayList<>();
        int length = nums.length;
        dfsPermute(length, nums, res, current);
        return res;
    }
    private void dfsPermute(int length, int[] nums, List<List<Integer>> res, List<Integer> current) {
        if (current.size() == length) {
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!current.contains(nums[i])){
                current.add(nums[i]);
                dfsPermute(length,nums,res,current);
                current.remove(current.size()-1);
            }
        }

    }*/
    List<List<Integer>> resPermuteUnique = new ArrayList<>();
    List<Integer> pathPermuteUnique = new ArrayList<>();
    boolean[] permuteFlag;

    public List<List<Integer>> permuteUnique(int[] nums) {
        permuteFlag = new boolean[nums.length];
        Arrays.sort(nums);
        backtrackingPermuteUnique(nums);
        return resPermuteUnique;
    }

    private void backtrackingPermuteUnique(int[] nums) {
        if (pathPermuteUnique.size() == nums.length) {
            resPermuteUnique.add(new ArrayList<>(pathPermuteUnique));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (permuteFlag[i])
                continue;
            if (i > 0 && nums[i] == nums[i - 1] && !permuteFlag[i - 1])
                continue;
            permuteFlag[i] = true;
            pathPermuteUnique.add(nums[i]);
            backtrackingPermuteUnique(nums);
            permuteFlag[i] = false;
            pathPermuteUnique.remove(pathPermuteUnique.size() - 1);
        }
    }

    List<String> resFindItinerary = new ArrayList<>();
    List<String> pathFindItinerary = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String str1 = ticket.get(0);
            String str2 = ticket.get(1);
            if (map.containsKey(str1)) {
                PriorityQueue<String> strings = map.get(str1);
                strings.add(str2);
            } else {
                PriorityQueue<String> strings = new PriorityQueue<>();
                strings.add(str2);
                map.put(str1, strings);
            }
        }
        pathFindItinerary.add("JFK");
        backtrackingFindItinerary(map, "JFK");
        return pathFindItinerary;
    }

    private void backtrackingFindItinerary(Map<String, PriorityQueue<String>> map, String key) {
        PriorityQueue<String> strings = map.getOrDefault(key, new PriorityQueue<>());
        while (strings.size() > 0) {
            String cntKey = strings.poll();
            pathFindItinerary.add(cntKey);
            backtrackingFindItinerary(map, cntKey);
        }
    }


    /**
     * 一个数组的 异或总和 定义为数组中所有元素按位 XOR 的结果；如果数组为 空 ，则异或总和为 0 。
     * <p>
     * 例如，数组 [2,5,6] 的 异或总和 为 2 XOR 5 XOR 6 = 1 。
     * 给你一个数组 nums ，请你求出 nums 中每个 子集 的 异或总和 ，计算并返回这些值相加之 和 。
     * <p>
     * 注意：在本题中，元素 相同 的不同子集应 多次 计数。
     * <p>
     * 数组 a 是数组 b 的一个 子集 的前提条件是：从 b 删除几个（也可能不删除）元素能够得到 a 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3]
     * 输出：6
     * 解释：[1,3] 共有 4 个子集：
     * - 空子集的异或总和是 0 。
     * - [1] 的异或总和为 1 。
     * - [3] 的异或总和为 3 。
     * - [1,3] 的异或总和为 1 XOR 3 = 2 。
     * 0 + 1 + 3 + 2 = 6
     * 示例 2：
     * <p>
     * 输入：nums = [5,1,6]
     * 输出：28
     * 解释：[5,1,6] 共有 8 个子集：
     * - 空子集的异或总和是 0 。
     * - [5] 的异或总和为 5 。
     * - [1] 的异或总和为 1 。
     * - [6] 的异或总和为 6 。
     * - [5,1] 的异或总和为 5 XOR 1 = 4 。
     * - [5,6] 的异或总和为 5 XOR 6 = 3 。
     * - [1,6] 的异或总和为 1 XOR 6 = 7 。
     * - [5,1,6] 的异或总和为 5 XOR 1 XOR 6 = 2 。
     * 0 + 5 + 1 + 6 + 4 + 3 + 7 + 2 = 28
     * 示例 3：
     * <p>
     * 输入：nums = [3,4,5,6,7,8]
     * 输出：480
     * 解释：每个子集的全部异或总和值之和为 480 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-all-subset-xor-totals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int subsetXORSum_1(int[] nums) {


        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> tmp = new ArrayList<>();
            List<Integer> temp = null;
            for (List<Integer> integers : list) {
                temp = new ArrayList<>(integers);
                temp.add(num);
                tmp.add(temp);
            }

            list.addAll(tmp);
        }

        int res = 0;
        for (List<Integer> integers : list) {
            if (integers.size() == 0)
                continue;
            else if (integers.size() == 1)
                res += integers.get(0);
            else {
                int tmp = integers.get(0);
                for (int i = 1; i < integers.size(); i++) {
                    tmp = tmp ^ integers.get(i);
                }
                res += tmp;
            }

        }


        return res;

    }

    /**
     * 现有一份 n + m 次投掷单个 六面 骰子的观测数据，骰子的每个面从 1 到 6 编号。观测数据中缺失了 n 份，你手上只拿到剩余 m 次投掷的数据。幸好你有之前计算过的这 n + m 次投掷数据的 平均值 。
     * <p>
     * 给你一个长度为 m 的整数数组 rolls ，其中 rolls[i] 是第 i 次观测的值。同时给你两个整数 mean 和 n 。
     * <p>
     * 返回一个长度为 n 的数组，包含所有缺失的观测数据，且满足这 n + m 次投掷的 平均值 是 mean 。如果存在多组符合要求的答案，只需要返回其中任意一组即可。如果不存在答案，返回一个空数组。
     * <p>
     * k 个数字的 平均值 为这些数字求和后再除以 k 。
     * <p>
     * 注意 mean 是一个整数，所以 n + m 次投掷的总和需要被 n + m 整除。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：rolls = [3,2,4,3], mean = 4, n = 2
     * 输出：[6,6]
     * 解释：所有 n + m 次投掷的平均值是 (3 + 2 + 4 + 3 + 6 + 6) / 6 = 4 。
     * 示例 2：
     * <p>
     * 输入：rolls = [1,5,6], mean = 3, n = 4
     * 输出：[2,3,2,2]
     * 解释：所有 n + m 次投掷的平均值是 (1 + 5 + 6 + 2 + 3 + 2 + 2) / 7 = 3 。
     * 示例 3：
     * <p>
     * 输入：rolls = [1,2,3,4], mean = 6, n = 4
     * 输出：[]
     * 解释：无论丢失的 4 次数据是什么，平均值都不可能是 6 。
     * 示例 4：
     * <p>
     * 输入：rolls = [1], mean = 3, n = 1
     * 输出：[5]
     * 解释：所有 n + m 次投掷的平均值是 (1 + 5) / 2 = 3 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-missing-observations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param rolls
     * @param mean
     * @param n
     * @return
     */
    public int[] missingRolls_1(int[] rolls, int mean, int n) {
        int rLength = rolls.length;
        int total = rLength + n;
        int totalSum = total * mean;
        int currentSum = Arrays.stream(rolls).sum();
        // 如果大的不符合则直接返回
        if (totalSum - currentSum > n * 6)
            return new int[0];
        // 如果小的不符合直接返回
        if (totalSum < currentSum || n > totalSum - currentSum)
            return new int[0];
        int needSum = totalSum - currentSum;
        //能整除
        if (needSum % n == 0) {
            int[] ints = new int[n];
            Arrays.fill(ints, needSum / n);
            return ints;
        }
        int[] res = new int[n];
        int di = needSum / n;
        int tar = di * n;
        int totalI = needSum - tar;
        Arrays.fill(res, di);
        for (int i = 0; i < totalI; i++) {
            ++res[i];
        }
        return res;

    }

    /**
     * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。
     * <p>
     * 如果你能使这个正方形，则返回 true ，否则返回 false 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入: matchsticks = [1,1,2,2,2]
     * 输出: true
     * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
     * 示例 2:
     * <p>
     * 输入: matchsticks = [3,3,3,3,4]
     * 输出: false
     * 解释: 不能用所有火柴拼成一个正方形。
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/matchsticks-to-square
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matchsticks
     * @return
     */

    /**
     * 如果不是4的倍数，直接返回，
     * 思路：维护一个大小为4的数组，为数组中的每一个元素添加当前元素，如果
     *
     * @param matchsticks
     * @return
     */
    // TODO 状态压缩
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0)
            return false;
        int target = sum / 4;
        // 进行逆序排序,减少回溯次数
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int tmp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - i - 1];
            matchsticks[matchsticks.length - i - 1] = tmp;
        }
        int[] edges = new int[4];
        return backtrackingMakeSquare(matchsticks, 0, edges, target);
    }

    private boolean backtrackingMakeSquare(int[] matchsticks, int index, int[] edges, int target) {
        if (index == matchsticks.length)
            return true;
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= target && backtrackingMakeSquare(matchsticks, index + 1, edges, target)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

    /**
     * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
     * 示例 1：
     * <p>
     * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
     * 输出： True
     * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3,4], k = 3
     * 输出: false
     *
     * @param nums
     * @param k
     * @return
     */
    /**
     * 数字角度，分为k个大小地桶，遍历每个数字，查看当前数组能否放入k个桶中地任意一个，如如果可以全部放入则为true，否则为false
     * 剪枝1：当前的数字+当前桶大小》每个桶的最大值，则当前数字一定不能放入其中
     * 剪枝2：
     *
     * @param nums
     * @param k
     * @return
     */
    // TODO 状态压缩
    public boolean canPartitionKSubsets(int[] nums, int k) {

        if (k > nums.length) return false;
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0)
            return false;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
        int[] edges = new int[k];
        return backtrackingCanPartitionKSubsets(nums, edges, 0, sum / k);
    }

    private boolean backtrackingCanPartitionKSubsets(int[] nums, int[] edges, int index, int target) {
        if (index == nums.length)
            return true;
        for (int i = 0; i < edges.length; i++) {
            // 剪枝1，数组为逆序，尽可能地减少回溯次数i
            if (edges[i] + nums[index] > target) {
                continue;
            }
            if (i > 0 && edges[i] == edges[i - 1])
                continue;
            edges[i] += nums[index];
            if (backtrackingCanPartitionKSubsets(nums, edges, index + 1, target)) {
                return true;
            }
            edges[i] -= nums[index];
        }
        return false;
    }


}
