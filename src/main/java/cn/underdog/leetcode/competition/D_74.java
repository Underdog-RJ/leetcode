package cn.underdog.leetcode.competition;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author underdog_rj
 * @date2022/5/320:24
 */
public class D_74 {

    public static void main(String[] args) {
        D_74 d_74 = new D_74();
//        d_74.maximumSubsequenceCount_1("abdcdbc", "ac");
        d_74.halveArray_1(new int[]{3, 8, 20});
    }

    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0) + 1;
            map.put(num, orDefault);
        }
        int length = nums.length;
        int half = length / 2;

        int size = map.size();
        if (size > half) {
            return false;
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            count += value / 2;
        }
        return count == half;
    }

    public long maximumSubsequenceCount(String text, String pattern) {
        long count = 0, count1 = 0, count2 = 0;
        for (char c : text.toCharArray()) {
            count += c == pattern.charAt(1) ? count1 : 0;
            count2 += c == pattern.charAt(1) ? 1 : 0;
            count1 += c == pattern.charAt(0) ? 1 : 0;
        }
        return count + Math.max(count1, count2);
    }


    public int halveArray(int[] nums) {
        PriorityQueue<Double> treeSet = new PriorityQueue<>(new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (o1 > o2) {
                    return -1;
                } else
                    return 1;
            }
        });
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            treeSet.add((double) nums[i]);
        }
        double half = sum / 2;
        int total = 0;
        while (half < sum) {
            Double aDouble = treeSet.poll();
            double tmp = aDouble / 2;
            treeSet.add(tmp);
            sum -= tmp;

            total++;
        }
        return total;


    }


    /**
     * 贪心的思想，想要达到最多，必须前面添加pattern(0)或者后面添加pattern(1)
     * 因为只有两个字符
     * 我们统计第一个字符出现的次数，让为第二个字符是，直接添加上第一个字符的个数。。
     *
     * @param text
     * @param pattern
     * @return
     */
    public long maximumSubsequenceCount_1(String text, String pattern) {
        String str1 = pattern.substring(0, 1) + text;
        long sum1 = 0;
        long count1 = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == pattern.charAt(0)) {
                sum1++;
            } else if (str1.charAt(i) == pattern.charAt(1)) {
                count1 += sum1;
            }
        }
        String str2 = text + pattern.substring(1);
        long sum2 = 0;
        long count2 = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == pattern.charAt(0)) {
                sum2++;
            } else if (str2.charAt(i) == pattern.charAt(1)) {
                count2 += sum2;
            }
        }
        // 如果两者相等，则结果为等差列数的前n项和 S = n*(n-1)/2
        /**
         * yyyyyy
         *  对于第2个y有1中
         *  对于第3个y有2中
         *  对于第4个y有6中
         * ....
         */
        if (pattern.charAt(0) == pattern.charAt(1))
            return sum1 * (sum1 - 1) / 2;
        return Math.max(count1, count2);
    }

    /**
     * 贪心的思想：为了达到次数最少，每次选择最多的数组进行减半，维护一个大根堆
     *
     * @param nums
     * @return
     */
    public int halveArray_1(int[] nums) {
        long sum = 0;
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>(((o1, o2) -> Double.compare(o2, o1)));
        for (int num : nums) {
            sum += num;
            priorityQueue.add((double) num);
        }
        double target = sum / 2d;
        long cntTotal = 0;
        int res = 0;
        while (target > 0) {
            double poll = priorityQueue.poll();
            double tmp = poll / 2d;
            target -= tmp;
            priorityQueue.add(tmp);
            res++;
        }
        return res;
    }
}
