package cn.underdog.MainClass;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 *
 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 输入：nums = [1,2,3]
 输出：3
 解释：
 只需要3次操作（注意每次操作会增加两个元素的值）：
 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
public class Problem62 {

    public static void main(String[] args) {

    }

    public int minMoves(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int sum = 0;
        for (int num : nums) {
            sum += num-min;
        }
        return sum;
    }
}
