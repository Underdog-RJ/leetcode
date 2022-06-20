package cn.underdog.leetcode.competition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author underdog_rj
 * @date2022/5/320:19
 */
public class C_286 {

    public static void main(String[] args) {
        C_286 c_286 = new C_286();
//        c_286.minDeletion_1(new int[]{1, 1, 2, 3, 4, 5});
//        c_286.minDeletion_1(new int[]{0, 1, 5, 4, 2, 4, 7, 2, 3, 0, 3, 0, 0, 9, 7, 5, 9, 4, 3, 9, 9, 2, 1, 6, 3, 1, 0, 7, 6, 6, 6, 0, 1, 7, 1, 9, 4, 9, 3, 3, 4, 5, 0, 3, 8, 7, 1, 8, 4, 5});
        c_286.kthPalindrome_1(new int[]{392015495, 5, 4, 1, 425320571, 565971690, 3, 7, 6, 3, 506222280, 468075092, 5},
                2);
    }


    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> tmp1 = new HashSet<>(set1);

        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        Set<Integer> tmp2 = new HashSet<>(set2);
        set1.removeAll(set2);
        set2.removeAll(tmp1);
        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;

    }

    public int minDeletion(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i - count) % 2 != 0)
                continue;
            if (nums[i] == nums[i + 1])
                count++;
        }
        int length = nums.length;
        if (length % 2 == 0) {
            if (count % 2 == 0) {
                return count;
            } else {
                return count + 1;
            }
        } else {
            if (count % 2 == 0) {
                return count + 1;
            } else {
                return count;
            }
        }

    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        int total = queries.length;
        long[] res = new long[total];
        long min = (long) Math.pow(10, (intLength + 1) / 2 - 1);
        long max = (long) Math.pow(10, (intLength + 1) / 2) - 1;
        boolean flag = false;
        if (intLength % 2 == 0) {
            flag = true;
        }
        for (int i = 0; i < queries.length; i++) {
            // 计算回文数左边
            long halfPalindrome = min + queries[i] - 1;
            // 如果当前偏移量大于最大值则直接返回-1
            if (halfPalindrome > max) {
                res[i] = -1;
                continue;
            }
            // 如果当前时偶数直接反转并且拼接
            StringBuilder sb = new StringBuilder(String.valueOf(halfPalindrome));
            if (flag) {
                res[i] = Long.parseLong(sb.toString() + sb.reverse().toString());
            } else {
                String str = sb.toString();
                str = str.substring(0, str.length() - 1);
                StringBuilder sb1 = new StringBuilder(str);
                res[i] = Long.parseLong(sb.toString() + sb1.reverse().toString());
            }
        }
        return res;
    }

    private List<Long> palindromeF(long start, long end) {
        List<Long> list = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            // 判断是不是回文数字
            if (isPalindrome(i)) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean isPalindrome(long i) {
        String str = String.valueOf(i);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    public int minDeletion_1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (((i - count) & 1) == 0) {
                int start = i;
                while (i + 1 < nums.length && nums[start] == nums[i + 1]) {
                    count++;
                    i++;
                }
            }
        }
        if ((nums.length - count) % 2 == 0) {
            return count;
        } else {
            return count + 1;
        }
    }

    public long[] kthPalindrome_1(int[] queries, int intLength) {
        int length = queries.length;
        long[] res = new long[length];
        if (intLength == 1) {
            for (int i = 0; i < queries.length; i++) {
                if (queries[i] > 9) {
                    res[i] = -1;
                } else {
                    res[i] = queries[i];
                }
            }
            return res;
        }
        long start = (long) Math.pow(10, (intLength + 1) / 2 - 1);
        long end = (long) Math.pow(10, (intLength + 1) / 2) - 1;
        if ((intLength & 1) == 0) {
            for (int i = 0; i < queries.length; i++) {
                long half = start + queries[i] - 1;
                if (half > end) {
                    res[i] = -1;
                    continue;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(half));
                res[i] = Long.parseLong(sb.toString() + sb.reverse().toString());

            }
        } else {
            for (int i = 0; i < queries.length; i++) {
                long half = start + queries[i] - 1;
                if (half > end) {
                    res[i] = -1;
                    continue;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(half));
                res[i] = Long.parseLong(sb.toString() + sb.reverse().substring(1));
            }
        }
        return res;
    }
}
