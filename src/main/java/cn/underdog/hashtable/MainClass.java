package cn.underdog.hashtable;


import java.util.*;

public class MainClass {
    public static void main(String[] args) {
//        containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3);
//        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
        canConstruct("aa", "ab");
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[3,2,3]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：[2,2,1,1,1,2,2]
     * 输出：2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/majority-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int majorityElement(int[] nums) {
        int length = nums.length / 2;
        Map<Integer, Integer> integerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            integerMap.put(nums[i], integerMap.getOrDefault(nums[i], 0) + 1);

        int res = -1;
        Set<Map.Entry<Integer, Integer>> entries = integerMap.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() > length) {
                res = entry.getKey();
                break;
            }
        }
        return res;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
       /* Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
        Set<Map.Entry<Integer, List<Integer>>> entries = map.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            if (entry.getValue().size() >= 2) {
                List<Integer> value = entry.getValue();
                for (int i = 0; i < value.size() - 1; i++) {
                    if (Math.abs(value.get(i) - value.get(i + 1)) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;*/
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // 如果当前滑动窗口包含当前的数字则直接返回true
            if (set.contains(nums[i])) return true;
            // 添加当前元素
            set.add(nums[i]);
            // 如果窗口大小大于k窗口向前移动一个位置
            if (set.size() > k) set.remove(nums[i - k]);
        }
        return false;

    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ransomMap = new HashMap<>();
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++)
            ransomMap.put(ransomNote.charAt(i), ransomMap.getOrDefault(ransomNote.charAt(i), 0) + 1);
        for (int i = 0; i < magazine.length(); i++)
            magazineMap.put(magazine.charAt(i), magazineMap.getOrDefault(magazine.charAt(i), 0) + 1);

        Set<Map.Entry<Character, Integer>> entries = ransomMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer valueR = entry.getValue();
            Integer valueM = magazineMap.getOrDefault(key, 0);
            if (valueR > valueM)
                return false;
        }
        return true;
    }

}
