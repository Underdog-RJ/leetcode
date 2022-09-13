package cn.underdog.leetcode.competition;

import java.util.*;

public class D_86 {


    public static void main(String[] args) {
        D_86 d_86 = new D_86();
//        System.out.println(d_86.maximumRows(new int[][]{{1, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 1, 1}, {0, 0, 0, 1, 0, 0, 1}}, 5));
//        System.out.println(Integer.valueOf("9", 3));
//        System.out.println(d_86.maximumRobots(new int[]{3, 6, 1, 3, 4}, new int[]{2, 1, 3, 4, 5}, 25));
        System.out.println(d_86.isStrictlyPalindromic(9));
    }

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (set.contains(nums[i] + nums[i + 1])) return true;
            set.add(nums[i] + nums[i + 1]);
        }
        return false;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String s = TenTransToN(n, i);
            System.out.println(s);
            boolean flag = isPar(s);
            if (!flag) return false;
        }
        return true;
    }

    private boolean isPar(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            else {
                left++;
                right--;
            }
        }
        return true;
    }

    String TenTransToN(long val, int radix) {

        long temp = val;
        int len = 1; //目标进制的字符串长度
        while (temp >= radix) {
            temp = temp / radix;
            len++;
        }

        char[] buf = new char[len];
        formatLong(buf, val, radix, len);

        return new String(buf);
    }

    void formatLong(char[] buf, long val, int radix, int len) {
        long temp;
        long radixPow;
        int charPos = len;
        --len;
        while (charPos != 0) {
            //Math.pow 方法某些数据较大时得不到正确的值。 如：Math.pow(15, 14) 结果的个位不是5. 见注释1
            radixPow = (long) Math.pow(radix, --charPos);
            temp = val;
            if (val >= radixPow) {
                val = temp % radixPow;
                buf[len - charPos] = digits[(int) (temp / radixPow)];
            } else {
                buf[len - charPos] = '0';
            }
        }
    }

    char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};


    private Integer maxRows = 0;
    private List<Integer> cntMaxRow = new ArrayList<>();

    public int maximumRows(int[][] mat, int cols) {
        int n = mat.length;
        int m = mat[0].length;
        Set<Integer>[] sets = new Set[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    sets[i].add(j);
                }
            }
        }
        dfsMR(sets, 0, n, m, cols);
        return maxRows;
    }

    private void dfsMR(Set<Integer>[] sets, int startIndex, int n, int m, int cols) {
        if (cols == 0) {
            int count = 0;
            for (Set<Integer> set : sets) {
                HashSet<Integer> tmp = new HashSet<>(set);
                tmp.removeAll(cntMaxRow);
                if (tmp.size() == 0) {
                    count++;
                }
            }
            maxRows = Math.max(maxRows, count);
            return;
        }
        if (cols < 0) return;
        for (int i = startIndex; i < m; i++) {
            cntMaxRow.add(i);
            dfsMR(sets, i + 1, n, m, cols - 1);
            cntMaxRow.remove(cntMaxRow.size() - 1);
        }
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int res = 0;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        long sum = 0;
        int left = 0, right = 0, n = chargeTimes.length;
        Deque<Integer> list = new LinkedList<>();
        while (right < n) {
            int cntK = chargeTimes[right];
            treeMap.put(cntK, treeMap.getOrDefault(cntK, 0) + 1);
            sum += runningCosts[right];
            list.add(runningCosts[right]);
            long k = list.size();
            while (!treeMap.isEmpty() && (treeMap.lastKey() + k * sum) > budget) {
                sum -= runningCosts[left];
                list.pollFirst();
                Integer count = treeMap.get(chargeTimes[left]);
                if (count.equals(1)) {
                    treeMap.remove(chargeTimes[left]);
                } else {
                    treeMap.put(chargeTimes[left], count - 1);
                }
                left++;
            }
            res = Math.max(list.size(), res);
            right++;
        }

        return res;
    }

}
