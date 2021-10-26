package cn.underdog.MainClass;

import java.util.HashMap;
import java.util.Stack;

/***
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 *
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
 *     对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
 *     对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
 *     对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem67 {
    public static void main(String[] args) {
        nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for (int j = nums2.length - 1; j >= 0; j--) {
                if (nums1[i] != nums2[j]) {
                    stack.push(nums2[j]);
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                boolean tt = false;
                while (!stack.isEmpty()) {
                    Integer temp = stack.pop();
                    if (temp > nums1[i]) {
                        res[index++] = temp;
                        tt = true;
                        break;
                    }
                }
                if (!tt) {
                    res[index++] = -1;
                }

            } else {
                res[index++] = -1;
            }
            stack.clear();

        }
        return res;

    }
}
