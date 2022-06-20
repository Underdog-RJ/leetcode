package cn.underdog.leetcode.monotoneStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 单调栈：
 * 解决的问题：通常是一维数组，要寻找任一个元素的右边或者左边第一个比自己大或者小的位置时间复杂度为O(n);
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
//        main.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
//        main.nextGreaterElements(new int[]{1, 2, 1});
//        main.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        main.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     * <p>
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= temperatures.length <= 105
     * 30 <= temperatures[i] <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 1; i < length; i++) {
            if (temperatures[i] < temperatures[stack.peek()]) {
                stack.push(i);
            } else if (temperatures[i] == temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                while (stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]) {
                    Integer nextIndex = stack.pop();
                    res[nextIndex] = i - nextIndex;
                }
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 简化代码
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures_1(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            while (stack.size() != 0 && temperatures[stack.peek()] < temperatures[i]) {
                Integer nextIndex = stack.pop();
                res[nextIndex] = i - nextIndex;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
     * <p>
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
     * <p>
     * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
     * <p>
     * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出：[-1,3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     * - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
     * - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
     * 示例 2：
     * <p>
     * 输入：nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出：[3,-1]
     * 解释：nums1 中每个值的下一个更大元素如下所述：
     * - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
     * - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 104
     * nums1和nums2中所有整数 互不相同
     * nums1 中的所有整数同样出现在 nums2 中
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/next-greater-element-i
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] res = new int[length1];
        // 单调栈里面存储的是下一个更大元素的值，从栈头到栈低，单调递增
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < length2; i++) {
            if (nums2[i] <= stack.peek()) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                    Integer pop = stack.pop();
                    map.put(pop, nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }
        for (int i = 0; i < length1; i++) {
            if (map.containsKey(nums1[i])) {
                res[i] = map.get(nums1[i]);
            } else {
                res[i] = -1;
            }
        }
        return res;
    }

    /**
     * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
     * <p>
     * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     * 示例 2:
     * <p>
     * 输入: nums = [1,2,3,4,3]
     * 输出: [2,3,4,-1,4]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/next-greater-element-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * length; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peek()]) {
                Integer pop = stack.pop();
                res[pop] = nums[i % length];
            }
            stack.push(i % length);
        }
        return res;
    }


    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                // 如果相等，先弹出，在加入按照行来计算，需要的是最右边的值
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    Integer mid = stack.pop();
                    if (!stack.isEmpty()) {
                        Integer leftMax = stack.peek();
                        int h = Math.min(height[leftMax], height[i]) - height[mid];
                        int w = i - leftMax - 1;
                        res += h * w;
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }

    /**
     * 此题和接雨水不同，接雨水，第一个和最后一个需要考虑，而本题第一个和最后一个都有面积，所以添加数组长度
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] tmp = new int[length + 2];
        // 在收尾个添加高度为0的柱子
        System.arraycopy(heights, 0, tmp, 1, length);
        heights = tmp;
        Stack<Integer> stack = new Stack<>();
        // 添加0,针对本题来说，栈一定不为空
        stack.push(0);
        int res = 0;
        // 下标从1开始，0已经添加过了（此时为原数组的第0个）
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                // 保存最右侧点
                stack.push(i);
            } else {
                // 此时栈一定不空
                while (heights[i] < heights[stack.peek()]) {
                    Integer mid = stack.pop();
                    Integer leftMin = stack.peek();
//                    heights[mid] 为高
//                    i - leftMin - 1为宽
                    res = Math.max(res, heights[mid] * (i - leftMin - 1));
                }
                stack.push(i);
            }
        }

        return res;

    }
}
