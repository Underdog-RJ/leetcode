package cn.underdog.mediumAlgorithm;

import java.util.*;


public class day_09 {
    public static void main(String[] args) {
//        combinationSum(new int[]{2, 3, 5}, 8);
        combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
//        combinationSum2P(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 30);
    }

    /**
     * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
     * <p>
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入: candidates = [2,3,6,7], target = 7
     * 输出: [[7],[2,2,3]]
     * 示例 2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     * 示例 4：
     * <p>
     * 输入: candidates = [1], target = 1
     * 输出: [[1]]
     * 示例 5：
     * <p>
     * 输入: candidates = [1], target = 2
     * 输出: [[1,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> current = new LinkedList<>();
        for (int candidate : candidates) {
            current.add(candidate);
            dfsCombination(candidates, current, candidate, res, target);
            current.clear();
        }
        for (List<Integer> re : res) {
            Collections.sort(re);
        }
        res = new ArrayList<>(new HashSet<>(res));
        return res;
    }

    private static void dfsCombination(int[] candidates, Deque<Integer> current, int candidate, List<List<Integer>> res, int target) {
        if (candidate == target) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (candidate > target) {
            return;
        }
        for (int i : candidates) {
            current.add(i);
            candidate += i;
            dfsCombination(candidates, current, candidate, res, target);
            candidate -= current.pollLast();
        }
    }


    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 注意：解集不能包含重复的组合。 
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 输出:
     * [
     * [1,1,6],
     * [1,2,5],
     * [1,7],
     * [2,6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 输出:
     * [
     * [1,2,2],
     * [5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> current = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        dfsCombination2(candidates, current, 0, res, target, flag);
        return res;
    }

    private static void dfsCombination2(int[] candidates, Deque<Integer> current, int start, List<List<Integer>> res, int target, boolean[] flag) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }
        if (start >= candidates.length) return;
        for (int i = start; i < candidates.length; i++) {
            if (!flag[i]) {
                if(target-candidates[i]<0) break;
                current.add(candidates[i]);
                flag[i] = true;
                dfsCombination2(candidates, current, i + 1, res, target - candidates[i], flag);
                current.pollLast();
                flag[i] = false;
            }
        }
    }
    /*public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> current = new LinkedList<>();
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        for (int i = 0; i < candidates.length; i++) {
            current.add(candidates[i]);
            flag[i] = true;
            dfsCombination2(candidates, current, candidates[i], res, target, flag);
            current.clear();
            flag = new boolean[candidates.length];
        }
        return res;
    }

    private static void dfsCombination2(int[] candidates, Deque<Integer> current, int candidate, List<List<Integer>> res, int target, boolean[] flag) {
        if (candidate == target) {
            ArrayList<Integer> integers = new ArrayList<>(current);
            Collections.sort(integers);
            if (!res.contains(integers)) {
                res.add(integers);
            }
            return;
        }
        if (candidate > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            if (!flag[i]) {
                current.add(candidates[i]);
                flag[i] = true;
                candidate += candidates[i];
                dfsCombination2(candidates, current, candidate, res, target, flag);
                candidate -= current.pollLast();
                flag[i] = false;
            }
        }
    }*/

    public static List<List<Integer>> combinationSum2P(int[] candidates, int target) {
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

    }


}
