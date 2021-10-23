package cn.underdog.MainClass;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] ：
 * <p>
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Problem63 {
    public static void main(String[] args) {
        HashMap<String,String > map =new HashMap<>();
        map.put(null,"sd");
        try {
            System.out.println("das");
            return;
        } finally {
            System.out.println("1231");
        }
    }



    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 4)
            return list;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int length = nums.length - 2;
        int length0 = nums.length - 3;
        for (int j = 0; j < length0; j++) {
            int currentNum0 = nums[j];
            for (int i = j + 1; i < length; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                int currentNum = nums[i];
                while (left < right) {
                    int total = currentNum0 + currentNum + nums[left] + nums[right];
                    if (total > target)
                        right--;
                    else if (total < target)
                        left++;
                    else {
                        LinkedList<Integer> listTemp = new LinkedList<>();
                        listTemp.add(nums[j]);
                        listTemp.add(nums[i]);
                        listTemp.add(nums[left]);
                        listTemp.add(nums[right]);
                        ans.add(listTemp);
                        left++;
                    }
                }
            }
        }
        list.addAll(ans);
        return list;
    }

}
