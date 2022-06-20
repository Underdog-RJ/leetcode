package cn.underdog.leetcode.binarySearch;

import java.util.*;

/**
 * 模板：
 * 对于查找某
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        main.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
//        main.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
//        main.findRadius(new int[]{1, 2, 3, 4}, new int[]{1, 4});
//        main.findRadius(new int[]{1, 5}, new int[]{10});
//        main.findRadius(new int[]{1, 2, 3}, new int[]{2});
//        main.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
//        main.minFlipsMonoIncr("00011000");
        main.minOperations(new int[]{6, 4, 8, 1, 3, 2}, new int[]{4, 7, 6, 2, 3, 8, 6, 1});
    }


    /**
     * 查找某一个数字
     */
    public int binary_search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 查找左边界
     */
    public int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 查找右边界
     */
    public int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    /**
     * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
     * <p>
     * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。  
     * <p>
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * <p>
     * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：piles = [3,6,7,11], h = 8
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：piles = [30,11,23,4,20], h = 5
     * 输出：30
     * 示例 3：
     * <p>
     * 输入：piles = [30,11,23,4,20], h = 6
     * 输出：23
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= piles.length <= 104
     * piles.length <= h <= 109
     * 1 <= piles[i] <= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/koko-eating-bananas
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param piles
     * @param h
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            long count = 0;
            for (int pile : piles) {
                count += Math.ceil((double) pile / mid); // 向上取整
            }
            if (count < h) {
                right = mid - 1;
            } else if (count > h) {
                left = mid + 1;
            } else if (count == h) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
     * <p>
     * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
     * <p>
     * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
     * 输出：15
     * 解释：
     * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
     * 第 1 天：1, 2, 3, 4, 5
     * 第 2 天：6, 7
     * 第 3 天：8
     * 第 4 天：9
     * 第 5 天：10
     * <p>
     * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
     * 示例 2：
     * <p>
     * 输入：weights = [3,2,2,4,1,4], days = 3
     * 输出：6
     * 解释：
     * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
     * 第 1 天：3, 2
     * 第 2 天：2, 4
     * 第 3 天：1, 4
     * 示例 3：
     * <p>
     * 输入：weights = [1,2,3,1,1], days = 4
     * 输出：3
     * 解释：
     * 第 1 天：1
     * 第 2 天：2
     * 第 3 天：3
     * 第 4 天：1, 1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= days <= weights.length <= 5 * 104
     * 1 <= weights[i] <= 500
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param weights
     * @param days
     * @return
     */
    public int shipWithinDays(int[] weights, int days) {
        int left = Arrays.stream(weights).max().getAsInt(), right = 500 * 50000;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int current = 0;
            for (int i = 0; i < weights.length; i++) {
                if (current + weights[i] <= mid) {
                    current += weights[i];
                } else {
                    current = weights[i];
                    count++;
                }
            }
            if (count < days) {
                right = mid - 1;
            } else if (count > days) {
                left = mid + 1;
            } else if (count == days) {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
     * <p>
     * 设计一个算法使得这 m 个子数组各自和的最大值最小。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [7,2,5,10,8], m = 2
     * 输出：18
     * 解释：
     * 一共有四种方法将 nums 分割为 2 个子数组。
     * 其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。
     * 因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,4,5], m = 2
     * 输出：9
     * 示例 3：
     * <p>
     * 输入：nums = [1,4,4], m = 3
     * 输出：4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/split-array-largest-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt(), right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int cnt = 0;
            for (int num : nums) {
                if (num + cnt <= mid) {
                    cnt += num;
                } else {
                    cnt = num;
                    count++;
                }
            }
            if (count < m) {
                right = mid - 1;
            } else if (count > m) {
                left = mid + 1;
            } else if (count == m) {
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int cntTotal = numbers[left] + numbers[right];
            if (cntTotal == target)
                return new int[]{left + 1, right + 1};
            else if (cntTotal > target)
                right--;
            else
                left++;
        }
        return new int[]{-1, -1};
    }

    /**
     * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
     * <p>
     * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
     * <p>
     * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
     * <p>
     * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: houses = [1,2,3], heaters = [2]
     * 输出: 1
     * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
     * 示例 2:
     * <p>
     * 输入: houses = [1,2,3,4], heaters = [1,4]
     * 输出: 1
     * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
     * 示例 3：
     * <p>
     * 输入：houses = [1,5], heaters = [2]
     * 输出：3
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/heaters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @return
     */
    /**
     * 1.先对两个数组进行排序，
     * 1-1e9 枚举半径，对于每个半径来说
     * 当前房屋，判断当前供暖器+半径，
     * 如果小于当前房屋的索引，说明此供暖期的位置不能覆盖房屋，选用下一个供暖期，j++直到能给此房间供暖位置
     * 如果大于房间的索引，判断当前 供暖期的半径范围是否覆盖房屋索引，如果不覆盖则直接返回，此半径太小
     *
     * @param houses
     * @param heaters
     * @return
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int left = 0, right = (int) 1e9;
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean flag = false;
            for (int i = 0, j = 0; i < houses.length; i++) {
                while (j < heaters.length && heaters[j] + mid < houses[i])
                    j++;
                if (j < heaters.length && heaters[j] - mid <= houses[i] && houses[i] <= heaters[j] + mid)
                    continue;
                else {
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    /*public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int heater : heaters) {
            treeSet.add(heater);
        }
        int max = Integer.MIN_VALUE;
        for (int hourse : houses) {
            Integer floor = treeSet.floor(hourse);
            int left = 0;
            if (floor == null) {
                left = Integer.MAX_VALUE;
            } else {
                left = hourse - floor;
            }
            Integer ceiling = treeSet.ceiling(hourse);
            int right = 0;
            if (ceiling == null) {
                right = Integer.MAX_VALUE;
            } else {
                right = ceiling - hourse;
            }
            max = Math.max(max, Math.min(left, right));
        }
        return max;
    }*/

    public int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
        int[] preSum = new int[length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] < target)
                continue;
            int left = 0;
            int right = i;
            while (left <= right) {
                int mid = left + right >> 1;
                int num = preSum[i] - preSum[mid];
                if (num >= target) {
                    left = mid + 1;
                } else if (num < target) {
                    right = mid - 1;
                }
            }
            min = Math.min(min, i - right);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     *  
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int[] lisNum = new int[length];
        int cntIndex = 0;
        lisNum[cntIndex++] = nums[0];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = nums[i];
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] >= nums[i]) {
                        right = mid - 1;
                    } else if (lisNum[mid] < nums[i]) {
                        left = mid + 1;
                    }
                }
                lisNum[left] = nums[i];
            }
            max = Math.max(max, cntIndex);
        }

        return max;
    }


    /**
     * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
     * <p>
     * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
     * <p>
     * 返回使 s 单调递增的最小翻转次数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "00110"
     * 输出：1
     * 解释：翻转最后一位得到 00111.
     * 示例 2：
     * <p>
     * 输入：s = "010110"
     * 输出：2
     * 解释：翻转得到 011111，或者是 000111。
     * 示例 3：
     * <p>
     * 输入：s = "00011000"
     * 输出：2
     * 解释：翻转得到 00000000。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/flip-string-to-monotone-increasing
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    /**
     * 问题转换为最长非递减子序列问题，最优解发为贪心+二分
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        Arrays.fill(dp, 1);
        int cntIndex = 0;
        int[] lisNum = new int[chars.length];
        lisNum[cntIndex++] = chars[0] - '0';
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            int tmp = chars[i] - '0';
            if (tmp >= lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = tmp;
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] > tmp) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lisNum[left] = tmp;
            }
            max = Math.max(max, cntIndex);
        }
        return chars.length - max;
    }

    /**
     * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
     *
     * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
     *
     * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
     *
     * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：target = [5,1,3], arr = [9,4,2,3,4]
     * 输出：2
     * 解释：你可以添加 5 和 1 ，使得 arr 变为 [5,9,4,1,2,3,4] ，target 为 arr 的子序列。
     * 示例 2：
     *
     * 输入：target = [6,4,8,1,3,2], arr = [4,7,6,2,3,8,6,1]
     * 输出：3
     *  
     *
     * 提示：
     *
     * 1 <= target.length, arr.length <= 105
     * 1 <= target[i], arr[i] <= 109
     * target 不包含任何重复元素。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/minimum-operations-to-make-a-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param target
     * @param arr
     * @return
     */
    /**
     * LCS转化为LIS的条件是其中一个数组的元素各不相同
     * 1.先求出两个数组的公共元素，
     * 2.求公共元素的最长递增子序列
     *
     * @param target
     * @param arr
     * @return
     */
    public int minOperations(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            map.put(target[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (map.containsKey(num))
                list.add(map.get(num));
        }
        if (list.size() == 0)
            return target.length;
        int length = list.size();
        int[] dp = new int[length];
        int[] lisNum = new int[length];
        int cntIndex = 0;
        lisNum[cntIndex++] = list.get(0);
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > lisNum[cntIndex - 1]) {
                lisNum[cntIndex++] = list.get(i);
            } else {
                int left = 0, right = cntIndex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] >= list.get(i)) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lisNum[left] = list.get(i);
            }
            max = Math.max(max, cntIndex);
        }
        return target.length - max;

    }
}
