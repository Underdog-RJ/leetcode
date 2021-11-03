package cn.underdog.mediumAlgorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day_08 {

    public static void main(String[] args) {
        permuteUnique(new int[]{1,2,3});
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            dfsPermuteUnique(length, i, current, res, nums, visited);
            visited=new boolean[length];
        }
        return res;
    }

    private static void dfsPermuteUnique(int length, int i, List<Integer> current, List<List<Integer>> res, int[] nums, boolean[] visited) {
        if (current.size() == length) {
            res.add(new ArrayList<>(current));
            current.clear();
            return;
        }
        for (int j = 0; j < length; j++) {
            if(!visited[j]){
                visited[j]=true;
                current.add(nums[j]);
                dfsPermuteUnique(length,j+1,current,res,nums,visited);
            }
        }
    }


}
