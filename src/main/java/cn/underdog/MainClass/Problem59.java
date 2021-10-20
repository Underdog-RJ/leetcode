package cn.underdog.MainClass;

/**
 *给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.*;

public class Problem59 {

    public static void main(String[] args) {
        threeSum(new int[]{-2,0,1,1,2});
    }

    /**
     * 1.将数组排序
     * 2.遍历数组
     *      2.1 选取当前位置，取当前位置的left 作为做指针，nums.length 作为右指针，
     *          2.1.1 如果当前 currenNum + nums[left] + num[right] 大于0 right 指针左移动
     *          2.1.2 如果当前 currenNum + nums[left] + num[right] 小于0 left 指针右移动
     *          2.1.2 如果当前 currenNum + nums[left] + num[right] 等于于0 添加，left 右移动
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(nums);
        int length=nums.length-2;
        for (int i = 0; i < length; i++) {
            int left = i+1;
            int right = nums.length-1;
            int currentNum = nums[i];
            while (left<right){
                int total = currentNum+ nums[left] + nums[right];
                if(total>0)
                    right--;
                else if(total<0)
                    left++;
                else
                {
                    LinkedList<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    left++;
                }
            }
        }
        List<List<Integer>> list =new ArrayList<>(ans);
        return list;
    }
}
