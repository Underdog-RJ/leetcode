package cn.underdog.leetcode.competition;


import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/320:53
 */
public class D_71 {
    public int minimumSum(int num) {
        int[] tmp = new int[4];
        String str = String.valueOf(num);
        for (int i = 0; i < 4; i++) {
            tmp[i] =Integer.parseInt(str.charAt(i)+"");
        }
        Arrays.sort(tmp);

        int t1 = Integer.parseInt(tmp[0] + "" + tmp[2]);
        int t2 = Integer.parseInt(tmp[1] + "" + tmp[3]);
        return t1 + t2;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> small = new ArrayList<>();
        List<Integer> big = new ArrayList<>();
        int equal = 0;
        for (int num : nums) {
            if (num < pivot)
                small.add(num);
            else if (num == pivot)
                equal++;
            else
                big.add(num);
        }
        int length = nums.length;
        int[] res = new int[length];
        for (int i = 0; i < small.size(); i++) {
            res[i] = small.get(i);
        }
        for (int i = 0; i < equal; i++) {
            res[i + small.size()] = pivot;
        }
        for (int i = 0; i < big.size(); i++) {
            res[i + small.size() + equal] = big.get(i);
        }
        return res;
    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        // 枚举全部可能的数字因为只有四位数字
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int u = 0; u < 10; u++) {
                    for (int t = 0; t < 10; t++) {
                        // 计算当前的值
                        int tmp = Integer.parseInt(i + "" + j) * 60 + Integer.parseInt(u + "" + t);
                        if (tmp == targetSeconds) {
                            // 去掉前导0
                            int num = Integer.parseInt(i + "" + j);
                            if (num == 0) {
                                int cnt  = Integer.parseInt(u + "" + t);
                                strings.add(String.valueOf(cnt));
                            } else {
                                strings.add(num + "" + u + t);
                            }
                        }
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int before = startAt;
        for (String string : strings) {
            int tmp = 0;
            startAt = before;
            for (int i = 0; i < string.length(); i++) {
                if (Integer.parseInt(string.charAt(i) + "") == startAt) {
                    tmp += pushCost;
                } else {
                    startAt = Integer.parseInt(string.charAt(i) + "");
                    tmp += moveCost + pushCost;
                }
            }
            min = Math.min(tmp, min);
        }
        return min;

    }
}
