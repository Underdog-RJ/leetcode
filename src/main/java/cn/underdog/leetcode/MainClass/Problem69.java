package cn.underdog.leetcode.MainClass;

import java.util.ArrayList;
import java.util.List;

public class Problem69 {

    public static void main(String[] args) {
        int[] temp = new int[]{1, 4, 5, 2, 4, 5};
        singleNumber(temp);
    }


    public static int[] singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // hashMap 求解
      /*  HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        map.forEach((k, v) -> {
            if (v == 1) {
                list.add(k);
            }
        });*/
        /**
         * 利用异或，
         *      1.首先求出两个不同的数字之和  resVal ^= num;
         *      2.求出不同数字之和中任意一位为1，（因为是异或操作，所以说这两个数字在这一位一定不相等，
         *      所以，可以根据此性质将数字分别2组，重复的会被抵消）
         */
        int resVal = 0;
        int k = -1;
        for (int num : nums)
            resVal ^= num;
        for (int i = 31; i >= 0 && k == -1; i--) {
            if (((resVal >> i) & i) == 1) {
                k = i;
            }
        }
        int[] res = new int[2];
        for (int num : nums) {
            if (((num >> k) & 1) == 1) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }

}
