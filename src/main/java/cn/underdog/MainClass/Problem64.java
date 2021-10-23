package cn.underdog.MainClass;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * 输入：[3,2,3]
 * 输出：[3]
 * 输入：nums = [1]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：[1,1,1,3,3,2,2,2]
 * 输出：[1,2]
 * https://leetcode-cn.com/problems/majority-element-ii/
 */

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem64 {

    public static void main(String[] args) {
//        majorityElement(new int[]{3,2,3});
//        majorityElement(new int[]{3});
        majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2});
    }

    public static List<Integer> majorityElement(int[] nums) {
        int total = nums.length / 3;

       return Arrays.stream(nums).boxed()
               .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > total)
               .map(e -> e.getKey())
               .collect(Collectors.toList());


//        List<Integer> list = new ArrayList<>();
//        Arrays.sort(nums);
//        int sum = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
//                sum += 1;
//            } else {
//                if (sum > total)
//                    list.add(nums[i]);
//                sum = 1;
//            }
//        }
//        return list;
    }

}
