package cn.underdog.leetcode.competition;

import java.util.*;

public class D_89 {
    public static void main(String[] args) {
        D_89 d_89 = new D_89();
//        d_89.productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}});
//        d_89.productQueries(2, new int[][]{{0, 0}})
//        [4,7,2,2,9,19,16,0,3,15];
        d_89.minimizeArrayValue(new int[]{4,7,2,2,9,19,16,0,3,15});
    }


    public int[] productQueries(int n, int[][] queries) {
        int length = queries.length;
        int[] res = new int[length];
        int mod = 1000000007;
        String s = Integer.toBinaryString(n);
        s = new StringBuffer(s).reverse().toString();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                list.add((int) Math.pow(2, i));
            }
        }
        int index = 0;
        for (int[] query : queries) {
            long cnt = 1;
            int left = query[0];
            int right = query[1];
            int maxRight = Math.min(right, list.size() - 1);
            boolean flag = false;
            for (int i = left; i <= maxRight; i++) {
                cnt *= list.get(i);
                cnt %= mod;
                flag = true;
            }
            if (cnt == 1) {
                if (flag) {
                    res[index++] = 1;
                }
            } else {
                res[index++] = (int) (cnt % mod);
            }
        }
        return res;

    }


    public int minimizeArrayValue(int[] nums) {
        int total = nums[0];
        int avg = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > avg) {
                total += nums[i];
                avg = (int) Math.ceil((double) total / (i + 1));
            } else {
                total += nums[i];
            }
        }
        return avg;
    }

    private boolean isOk(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0) {
                int tmp = (int) Math.ceil((double) diff / 2);
                nums[i - 1] += tmp;
                nums[i] -= tmp;
                flag = true;
                int tmpIndex = i - 1;
                while (tmpIndex >= 1 && nums[tmpIndex] - nums[tmpIndex - 1] > 0) {
                    int tmpT = (int) Math.ceil((double) (nums[tmpIndex] - nums[tmpIndex - 1]) / 2);
                    nums[tmpIndex - 1] += tmpT;
                    nums[tmpIndex] -= tmpT;
                    tmpIndex--;
                }
            }
        }
        return flag;
    }


}
