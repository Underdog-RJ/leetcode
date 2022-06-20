package cn.underdog.leetcode.mediumAlgorithm;


import java.util.*;

public class day_07 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{2,1,2,1,3});
        System.out.println(subsets);
    }

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        // 暴力求阶，遍历到新的数值是，把当前的res里面的集合复制一遍，并且每个都添加当前数值之后添加到res中
      /*  for (int num : nums) {
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> temp = null;
            for (List<Integer> re : res) {
                temp = new ArrayList<>();
                temp.addAll(re);
                temp.add(num);
                list.add(temp);
            }
            res.addAll(list);
        }
        for (List<Integer> re : res) {
            Collections.sort(re);
        }
        return new LinkedList<>(new HashSet<>(res));*/

        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            // 当前子集
            List<Integer> currentSet = new ArrayList<>();
            dfs(res, nums, i, currentSet, 0);
        }

        return res;
    }

    /**
     * 回溯法
     * 每次选出当前为k的数组，每次回溯过程中k-1;
     *
     * @param res
     * @param nums
     * @param k          当前currentSet的大小
     * @param currentSet
     * @param start      nums开始的索引下标
     */
    public static void dfs(List<List<Integer>> res, int[] nums, int k, List<Integer> currentSet, int start) {
        if (k == 0) {
            if(!res.contains(currentSet)){
                res.add(new ArrayList<>(currentSet));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            currentSet.add(nums[i]);
            dfs(res, nums, k - 1, currentSet, i + 1);
            currentSet.remove(currentSet.size() - 1);
        }
    }
}
