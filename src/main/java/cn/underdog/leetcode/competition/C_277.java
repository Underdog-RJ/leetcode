package cn.underdog.leetcode.competition;

import java.util.*;
import java.util.TreeMap;

/**
 * @author underdog_rj
 * @date2022/5/320:57
 */
public class C_277 {
    public int countElements(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        Integer min = map.firstKey();
        Integer large = map.lastKey();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (min != key && large != key) {
                res += entry.getValue();
            }
        }
        return res;
    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        int num0 = 0;
        int num1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = list1.get(num0++);
            } else {
                nums[i] = list2.get(num1++);
            }
        }

        return nums;
    }

    public List<Integer> findLonely(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            list.add(nums[0]);
            return list;
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1] && nums[0] != nums[1] - 1) {
            list.add(nums[0]);
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i - 1] + 1 && nums[i] != nums[i + 1] && nums[i] != nums[i + 1] - 1) {
                list.add(nums[i]);
            }
        }
        int length = nums.length - 1;
        if (nums[length] != nums[length - 1] && nums[length] != nums[length - 1] + 1) {
            list.add(nums[length]);
        }
        return list;
    }
}
