package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/320:55
 */
public class C_278 {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        for (int num : nums) {
            if (num == original) {
                original *= 2;
            }
        }
        return original;
    }

    public List<Integer> maxScoreIndices(int[] nums) {
        int length = nums.length;
        int cntTotal0 = 0;
        int Max = Integer.MIN_VALUE;
        int total1 = 0;
        for (int num : nums) {
            if (num == 1) {
                total1++;
            }
        }

        List<Integer> res = new ArrayList<>();
        // 计算0
        res.add(0);
        Max = total1;
        for (int i = 1; i < length; i++) {
            if (nums[i - 1] == 0) {
                cntTotal0++;
            }
            // 右边1的个数
            int tmp = cntTotal0 + (total1 - (i - cntTotal0));
            if (tmp > Max) {
                Max = tmp;
                res.clear();
                res.add(i);
            } else if (tmp == Max) {
                res.add(i);
            }
        }
        //和最后一个
        if (nums[length - 1] == 0) {
            cntTotal0++;
        }
        if (cntTotal0 > Max) {
            res.clear();
            res.add(length);
        } else if (cntTotal0 == Max) {
            res.add(length);
        }

        return res;

    }

    // TODO 不会做
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        return "";
    }
}
