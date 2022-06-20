package cn.underdog.leetcode.competition;
import java.util.*;
/**
 * @author underdog_rj
 * @date2022/5/320:41
 */
public class D_72 {
    public int countPairs(int[] nums, int k) {
        int res = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> orDefault = map.getOrDefault(nums[i], new ArrayList<>());
            orDefault.add(i);
            map.put(nums[i], orDefault);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() >= 2) {
                for (int i = 0; i < value.size(); i++) {
                    for (int j = i + 1; j < value.size(); j++) {
                        int tmp = value.get(i) * value.get(j);
                        if (tmp % k == 0) {
                            res++;
                        }
                    }
                }
            }
        }

        return res;

    }

    public long[] sumOfThree(long num) {
        long left = 0;
        long right = num - 1;
        if(num == 0){
            return  new long[]{-1, 0, 1};
        }
        while (left <= right) {
            long mid = (left + right) / 2;
            long tmp = mid * 3 + 3;
            if (tmp > num) {
                right = mid - 1;
            } else if (tmp < num) {
                left = mid + 1;
            } else {
                left = mid;
                break;
            }
        }
        if (left * 3 + 3 == num) {
            return new long[]{left, left + 1, left + 2};
        } else {
            return new long[0];
        }
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 == 0) {
            long start = 2;
            while (finalSum >= start) {
                res.add(start);
                finalSum -= start;
                start += 2;
            }
            if (finalSum != 0) {
                Long remove = res.remove(res.size() - 1);
                res.add(remove+finalSum);
            }

        }
        return res;
    }
}
