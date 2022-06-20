package cn.underdog.leetcode.prefixSum;

import java.util.*;

public class MainClass {
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
//        System.out.println();
//        mainClass.platesBetweenCandles("***|**|*****|**||**|*", new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}});
//        mainClass.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2},    2);
//        mainClass.goodDaysToRobBank(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2);
//        mainClass.productExceptSelf(new int[]{1, 2, 3, 4});
//        mainClass.isCovered(new int[][]{{15, 36}, {15, 23}, {15, 44}, {30, 49}, {2, 19}, {27, 36}, {7, 42}, {12, 41}}, 19, 47);
//        mainClass.isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21);
//        mainClass.findMiddleIndex(new int[]{2, 3, -1, 8, 4});
//        mainClass.subarraySum(new int[]{1, 1, 1, 3, 1, 1, 1}, 3);
//        mainClass.subarraySum(new int[]{1, 2, 3}, 3);
//        mainClass.numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2);
//        mainClass.numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0);

//        NumArray array = new NumArray(new int[]{0, 9, 5, 7, 3});
//        array.sumRange(4, 4);
//        array.sumRange(2, 4);
//        array.sumRange(3, 3);
//        array.sumRange(4, 5);
//        array.update(1, 7);
//        array.update(0, 8);
//        array.update(1, 2);
//        array.update(1, 9);
//        array.sumRange(4, 4);
//        array.update(3, 4);
//        NumMatrix matrix = new NumMatrix(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
//        System.out.println(matrix.sumRegion(2, 1, 4, 3));
//
//        System.out.println(matrix.sumRegion(1, 1, 2, 2));
//        System.out.println(matrix.sumRegion(1, 2, 2, 4));
//        mainClass.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        mainClass.largestRectangleArea(new int[]{1, 1});

    }

    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * <p>
     * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * <p>
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * <p>
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     * 示例 2：
     * <p>
     * 输入：nums = [1, 2, 3]
     * 输出：-1
     * 解释：
     * 数组中不存在满足此条件的中心下标。
     * 示例 3：
     * <p>
     * 输入：nums = [2, 1, -1]
     * 输出：0
     * 解释：
     * 中心下标是 0 。
     * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
     * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-pivot-index
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int[] prev = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prev[i + 1] = prev[i] + nums[i];
            int tail = sum - nums[i] - prev[i];
            if (tail == prev[i]) return i;
        }
        return -1;
    }


     /*public int[] platesBetweenCandles(String s, int[][] queries) {
        int row = queries.length;
        int[] res = new int[row];
        if (row == 0)
            return res;
        for (int i = 0; i < row; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            boolean lflag = false;
            boolean rflag = false;
            int count = 0;
            while (left < right) {
                if (lflag && rflag) {
                    if (s.charAt(left++) == '*')
                        count++;
                    if (s.charAt(right--) == '*')
                        count++;
                } else {
                    if (s.charAt(left) == '*') {
                        lflag = false;
                        left++;
                    } else {
                        lflag = true;
                    }
                    if (s.charAt(right) == '*') {
                        rflag = true;
                        right--;
                    } else {
                        rflag = true;
                    }
                }
            }
            if (left == right && s.charAt(left) == '*')
                count++;
            res[i] = count;
        }
        return res;
    }*/

    /**
     * 思路：
     * 双指针+前缀和(TreeSet版本)
     * 用left+right做为左边界和有边界，来搜索左右边界中第一次出现的|，接着根据left+right截取字符串算出*的个数
     * 在计算*的个数时
     * 1.用for循环来统计出当前左右区间内的个数--》此时时间复杂度已经达到了n的平方（弃用）
     * 2.此时我们可以使用前缀和的思想
     * 2.1当前位置的*的总个数==上一次的总个数+当前位置是否为*
     * 在计算left和right的位置时
     * 1.此时对于二维数组中的元素每次都需要计算left和right的位置--》此时时间复杂度再次达到O(n2)（弃用）
     * 2.我们可以算出每个|的位置，对于数组内每个left和right我们可以选择距离最近的
     * 2.1选择TreeSet数据结构
     * 2.1.1提供了celling（返回有序数组中第一个大于的元素，不存在返回null）
     * 2.1.2提供了floor（返回有序数组中第一个小于目标的元素，不存在返回null）
     *
     * @param s
     * @param queries
     * @return
     */
    /*public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        int[] stars = new int[length];
        int[] res = new int[queries.length];

        // 首先统计每个区间的*的个数(前缀和)
        if (s.charAt(0) == '*')
            stars[0] = 1;
        for (int i = 1; i < length; i++) {
            stars[i] = stars[i - 1];
            if (s.charAt(i) == '*')
                stars[i]++;
        }
        // 用treeSet来记录当前的数组
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                set.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            Integer ceiling = set.ceiling(left);//Olog(n)
            Integer floor = set.floor(right);
            if ((ceiling == null || floor == null) || ceiling >= floor)
                res[i] = 0;
            else {
                res[i] = stars[floor] - stars[ceiling];
            }
        }
        return res;
    }*/
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int length = s.length();
        int[] stars = new int[length];
        int[] res = new int[queries.length];

        // 首先统计每个区间的*的个数(前缀和)
        if (s.charAt(0) == '*')
            stars[0] = 1;
        for (int i = 1; i < length; i++) {
            stars[i] = stars[i - 1];
            if (s.charAt(i) == '*')
                stars[i]++;
        }

        int tmp = -1;
        //保存每个的位置（包括）左边的最右边的|
        int[] leftDise = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                tmp = i;
            leftDise[i] = tmp;
        }
        //从右往左数，每次找到最左边的|，赋给右边的数组
        tmp = -1;
        int[] rightDise = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                tmp = i;
            rightDise[i] = tmp;
        }

        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int lF = rightDise[left];//O(1)
            int rF = leftDise[right];//O(1)
            if (lF == -1 || rF == -1 || lF > rF)
                res[i] = 0;
            else
                res[i] = stars[rF] - stars[lF];
        }
        return res;
    }

/**
 * 思路：前缀和
 * 1.如果直接取security中第i个元素的前，后个time个来计算的判断前面的是否为非递增，和后面的非递减，存在重复计算问题要排除此种重复计算
 * 2.我们使用前缀和的思想
 * 2.1用pre来保存保存前i个前面连续递减的个数第i个的计算方式
 * 2.1.1如果当前是非递增的则类加上上一次的递减的个数
 * 2.1.2如果当前不是非递增的，则把当前的i为0
 * 2.2用last来保存后缀和，第i个的计算方式
 * 2.2.1如果当前的是非递减的则类加上后面的递减的个数
 * 2.2.2如果当前不是非递减的，则把当前i为0
 *
 * @param security
 * @param time
 * @return 滑动窗口解决问题
 * <p>
 * 滑动窗口解决问题
 * <p>
 * 滑动窗口解决问题
 */
    /*public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        int[] pre = new int[security.length];
        int[] last = new int[security.length];
        pre[0] = 0;
        for (int i = 1; i < security.length; i++) {
            if (security[i] - security[i - 1] <= 0) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 0;
            }
        }
        last[last.length - 1] = 0;
        for (int i = last.length - 2; i >= 0; i--) {
            if (security[i] - security[i + 1] <= 0) {
                last[i] = last[i + 1] + 1;
            } else {
                last[i] = 0;
            }
        }
        for (int i = 0; i < security.length; i++) {
            if (pre[i] >= time && last[i] >= time) {
                res.add(i);
            }
        }
        return res;
    }*/

    /**
     * 滑动窗口解决问题
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        // 如果当前不满足，则直接返回
        if (security.length < time * 2 + 1)
            return list;
        // 如果time为0则全部都满足
        if (time == 0) {
            for (int i = 0; i < security.length; i++)
                list.add(i);
            return list;
        }
        // 判断前0个的到time的递增的个数(不满足的个数)
        int up = 0;
        for (int i = 0; i < time; i++) {
            if (security[i] < security[i + 1])
                up++;
        }
        // 判断从time到time+time递减的个数（不满足的个数）
        int down = 0;
        for (int i = time; i < time + time; i++) {
            if (security[i] > security[i + 1])
                down++;
        }
        // 从符合条件开始查找
        for (int i = time + 1; i <= security.length - time; i++) {
            // 如果上次的不满足条件都为0则个数+1
            if (up == 0 && down == 0)
                list.add(i - 1);
            // 如果达到最后一个则直接跳出循环
            if (i == security.length - time)
                break;
            // 滑动窗口 把时间复杂度从O(n)---O(1)
            // O(n)是每次都截取2*time个进行判断  0-time递减 time-time+time递增
            // 判断up前一个是否（不满足）如果不满则减去
            if (security[i - time - 1] < security[i - time])
                up--;
            // 判断up当前是否不满足
            if (security[i - 1] < security[i])
                up++;
            // 判断down
            if (security[i - 1] > security[i])
                down--;
            if (security[i + time - 1] > security[i + time])
                down++;
        }
        return list;
    }

    /**
     * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
     * <p>
     * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
     * <p>
     * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-3,2,-3,4,2]
     * 输出：5
     * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
     * 累加求和
     *                 startValue = 4 | startValue = 5 | nums
     *                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
     *                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
     *                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
     *                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
     *                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2]
     * 输出：1
     * 解释：最小的 startValue 需要是正数。
     * 示例 3：
     * <p>
     * 输入：nums = [1,-2,-3]
     * 输出：5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-value-to-get-positive-step-by-step-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
// 空间复杂度不行
   /* public int minStartValue(int[] nums) {

        int[] tmp = new int[nums.length];
        tmp[0] = nums[0] + 1;
        int min = tmp[0];
        for (int i = 1; i < nums.length; i++) {
            tmp[i] = tmp[i - 1] + nums[i];
            if (tmp[i] < min)
                min = tmp[i];
        }
        if (min >= 1) {
            return 1;
        } else {
            return Math.abs(min) + 2;
        }

    }*/

// 优化空间复杂度
    public int minStartValue(int[] nums) {
        int tmp = nums[0] + 1;
        int min = tmp;
        for (int i = 1; i < nums.length; i++) {
            tmp += nums[i];
            if (tmp < min)
                min = tmp;
        }
        if (min >= 1)
            return 1;
        else
            return Math.abs(min) + 2;
    }

    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = nums[i] + res[i - 1];
        }

        return res;

    }

    /**
     * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
     * <p>
     * 子数组 定义为原数组中的一个连续子序列。
     * <p>
     * 请你返回 arr 中 所有奇数长度子数组的和 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：arr = [1,4,2,5,3]
     * 输出：58
     * 解释：所有奇数长度子数组和它们的和为：
     * [1] = 1
     * [4] = 4
     * [2] = 2
     * [5] = 5
     * [3] = 3
     * [1,4,2] = 7
     * [4,2,5] = 11
     * [2,5,3] = 10
     * [1,4,2,5,3] = 15
     * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
     * 示例 2：
     * <p>
     * 输入：arr = [1,2]
     * 输出：3
     * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
     * 示例 3：
     * <p>
     * 输入：arr = [10,11,12]
     * 输出：66
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param arr
     * @return
     */
// 未使用前缀数组
    /*public int sumOddLengthSubarrays(int[] arr) {
        int length = arr.length;
        int sum = 0;
        for (int j = 1; j <= length; j += 2) {
            for (int i = 0; i <= length - j; i++) {
                int[] tmp = new int[j];
                System.arraycopy(arr, i, tmp, 0, j);
                sum += Arrays.stream(tmp).sum();
            }
        }
        return sum;
    }*/
// 使用前缀数组  -->> 前缀和 计算出开始下边,减去前面的和
    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length];
        preSum[0] = arr[0];
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            preSum[i] = arr[i] + preSum[i - 1];
        }
        for (int i = 3; i <= arr.length; i += 2) {
            int start = i - 1;
            int count = 0;
            for (; start < arr.length; start++) {
                int tmp = 0;
                if (count != 0) {
                    tmp = preSum[start] - preSum[start - i];
                } else {
                    tmp = preSum[start];
                    count++;
                }
                sum += tmp;
            }
        }
        return sum;
    }

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * <p>
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * <p>
     * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     * <p>
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int[] pre = new int[length];
        int[] tail = new int[length];
        pre[0] = nums[0];
        tail[length - 1] = nums[length - 1];
        for (int i = 1; i < length; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            tail[i] = tail[i + 1] * nums[i];
        }
        res[0] = tail[1];
        res[length - 1] = pre[length - 2];
        for (int i = 1; i < length - 1; i++) {
            res[i] = tail[i + 1] * pre[i - 1];
        }
        return res;
    }

    /**
     * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
     * <p>
     * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：gain = [-5,1,5,0,-7]
     * 输出：1
     * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
     * 示例 2：
     * <p>
     * 输入：gain = [-4,-3,-2,-1,4,3,2]
     * 输出：0
     * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-highest-altitude
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param gain
     * @return
     */
    public int largestAltitude(int[] gain) {
        int max = 0;
        int tmp = 0;
        for (int i = 0; i < gain.length; i++) {
            tmp += gain[i];
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;

    }

    /**
     * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
     * <p>
     * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
     * <p>
     * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
     * 输出：true
     * 解释：2 到 5 的每个整数都被覆盖了：
     * - 2 被第一个区间覆盖。
     * - 3 和 4 被第二个区间覆盖。
     * - 5 被第三个区间覆盖。
     * 示例 2：
     * <p>
     * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
     * 输出：false
     * 解释：21 没有被任何一个区间覆盖。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param ranges
     * @param left
     * @param right
     * @return
     */
    /*public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(ranges[0]);
        for (int i = 1; i < ranges.length; i++) {
            int[] ints = list.get(list.size() - 1);
            int cTail = ints[1];
            int nHead = ranges[i][0];
            int nTail = ranges[i][1];
            if (cTail < nTail && cTail > nHead) {
                ints[1] = nTail;
            } else if (cTail + 1 == nHead) {
                ints[1] = Math.max(cTail,nTail);
            } else if (cTail < nHead) {
                list.add(ranges[i]);
            }
        }
        for (int[] ints : list) {
            int Cleft = ints[0];
            int CRight = ints[1];
            if (Cleft <= left && right <= CRight) {
                return true;
            }
        }
        return false;
    }*/
  /*  public boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (o1, o2) -> o1[0] - o2[0]);
        for (int[] range : ranges) {
            int l = range[0];
            int r = range[1];
            if (l <= left && left <= r) {
                left = r + 1;
            }
        }

        return left > right;
    }*/

//TODO 差分数组
    public boolean isCovered(int[][] ranges, int left, int right) {
        // 维护一个差分数组
        int[] diff = new int[52];
        for (int[] range : ranges) {
            ++diff[range[0]];
            --diff[range[1] + 1];
        }

        // 维护当前的前缀和，对差分数组求和是原数组
        int cntTotal = 0;
        for (int i = 1; i <= 50; i++) {
            cntTotal += diff[i];
            if (i >= left && i <= right && cntTotal <= 0)
                return false;
        }
        return true;


    }

    /**
     * 给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
     * <p>
     * 中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
     * <p>
     * 如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
     * <p>
     * 请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,-1,8,4]
     * 输出：3
     * 解释：
     * 下标 3 之前的数字和为：2 + 3 + -1 = 4
     * 下标 3 之后的数字和为：4 = 4
     * 示例 2：
     * <p>
     * 输入：nums = [1,-1,4]
     * 输出：2
     * 解释：
     * 下标 2 之前的数字和为：1 + -1 = 0
     * 下标 2 之后的数字和为：0
     * 示例 3：
     * <p>
     * 输入：nums = [2,5]
     * 输出：-1
     * 解释：
     * 不存在符合要求的 middleIndex 。
     * 示例 4：
     * <p>
     * 输入：nums = [1]
     * 输出：0
     * 解释：
     * 下标 0 之前的数字和为：0
     * 下标 0 之后的数字和为：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-the-middle-index-in-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findMiddleIndex(int[] nums) {
        int length = nums.length;
        int[] pre = new int[length];
        int[] tail = new int[length];
        pre[0] = nums[0];
        tail[length - 1] = nums[length - 1];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
            tail[length - i - 1] = tail[length - i] + nums[length - i - 1];
        }
        for (int i = 0; i < length; i++) {
            if (pre[i] == tail[i])
                return i;
        }
        return -1;
    }

    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1]
     * 输出: 2
     * 说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。
     * 示例 2:
     * <p>
     * 输入: nums = [0,1,0]
     * 输出: 2
     * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/contiguous-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int max = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(count, -1);
        for (int i = 0; i < nums.length; i++) {
            count = nums[i] == 1 ? count + 1 : count - 1;
            if (map.containsKey(count))
                max = Math.max(max, i - map.get(count));
            else
                map.put(count, i);
        }
        return max;
    }

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] preSum = new int[length];
        int count = 0;
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        for (int i = 0; i < preSum.length; i++) {
            if (preSum[i] == k)
                count++;
            for (int j = i + 1; j < preSum.length; j++) {
                int tmp = preSum[j] - preSum[i];
                if (tmp == k)
                    count++;
            }
        }

        return count;

    }

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * <p>
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 * 示例 2：
 * <p>
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/corporate-flight-bookings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param bookings
 * @param n
 * @return
 */
// 暴力解题
  /*  public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            for (int i = start - 1; i < end; i++) {
                res[i] += booking[2];
            }
        }
        return res;
    }*/

    /**
     * 差分数组的性值
     * 原数组:   [1,2,2,4]
     * 差分数组:  [1,1,0,2]
     * 对差分数组进行类加可以得到原数组
     * 对原数组进行范围的类加，时间复杂度为o(n)
     * 可以转换为对差分数据进行时间复杂度为o(1)
     * 比如对原数组(1,2)范围类加1
     * 此时需要对原数组进行范围的遍历
     * 原数组：[1,3,3,4]
     * 差分数组可以为  diff[l] + inc(增量此时为1)
     * diff[r] - inc
     * 常量的范围
     *
     * @param bookings
     * @param n
     * @return
     */
// 差分数组
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] booking : bookings) {
            int start = booking[0];
            int end = booking[1];
            int count = booking[2];
            res[start - 1] += count;
            if (end < n) {
                res[end] -= count;
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        return res;
    }


    /**
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     * <p>
     * 子数组 是数组的一段连续部分。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,1,0,1], goal = 2
     * 输出：4
     * 解释：
     * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,0,0,0], goal = 0
     * 输出：15
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-subarrays-with-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param goal
     * @return
     */
    /*public int numSubarraysWithSum(int[] nums, int goal) {
        int length = nums.length;
        int[] preSum = new int[length];
        int res = nums[0] == goal ? 1 : 0;
        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
            if (preSum[i] == goal)
                res++;
        }
        // 双重for暴力求解，不优雅
        for (int i = 1; i < preSum.length; i++) {
            for (int j = i; j < preSum.length; j++) {
                if (preSum[j] - preSum[i - 1] == goal) {
                    res++;
                }
            }
        }
        return res;
    }*/
    // TODO 滑动窗口求解
    /*public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int length = nums.length;
        int left = 0;
        int right = left + 1;
        int currentSum = nums[0];
        while (left < right) {
            if (currentSum == goal) {
                if (right + 1 < length) {
                    currentSum += nums[right++];
                } else {
                    currentSum -= nums[left++];
                }
                res++;
            } else if (currentSum < goal) {
                // 如果此时右指针已经到达最后一个，并且此时的和仍然小于goal则直接返回，因为向后移动和越来越小
                if (right == length)
                    return res;
                currentSum += nums[right++];
            } else {
                currentSum -= nums[left++];
            }
        }
        return res;
    }*/

    // hashMap求解
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        int sum = 0;
        // 用hashMap存储前缀和
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            // 先判断当前sum是否存在如果
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // 当前和
            sum += num;
            // 判断sum-goal是否出现过
            res += map.getOrDefault(sum - goal, 0);
        }

        return res;
    }

    public int trap(int[] height) {
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int res = 0;
        for (int i = 1; i < length - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * 解释：最大的矩形为图中红色区域，面积为 10
     * 示例 2：
     * <p>
     * <p>
     * <p>
     * 输入： heights = [2,4]
     * 输出： 4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/largest-rectangle-in-histogram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights
     * @return
     */
    /**
     * 记录当前坐标，左边和右边最小的值的下标索引
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int length = heights.length;
        // 记录每个柱子 左边第一个小于该柱子的下标
        int[] leftMin = new int[length];
        // 记录每个柱子，右边第一个小于该柱子的小标
        int[] rightMin = new int[length];
        // 赋值初始值为-1防止死循环
        leftMin[0] = -1;
        for (int i = 1; i < length; i++) {
            int t = i - 1;
            while (t >= 0 && heights[t] >= heights[i]) {
                t = leftMin[t];
            }
            leftMin[i] = t;
        }
        rightMin[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            int t = i + 1;
            while (t <= length - 1 && heights[t] >= heights[i]) {
                t = rightMin[t];
            }
            rightMin[i] = t;
        }
        for (int i = 0; i < length; i++) {
            int tmp = (rightMin[i] - leftMin[i] - 1) * heights[i];
            res = Math.max(tmp, res);
        }
        return res;
    }

}
