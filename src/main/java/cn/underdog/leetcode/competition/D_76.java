package cn.underdog.leetcode.competition;

/**
 * @author underdog_rj
 * @date2022/5/320:06
 */
public class D_76 {
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (min > Math.abs(nums[i])) {
                min = Math.abs(nums[i]);
                res = nums[i];
            } else if (min == Math.abs(nums[i])) {
                min = Math.abs(nums[i]);
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long count = 0;
        for (; total >= 0; total -= cost1) {
            count += 1 + total / cost2;
        }
        return count;
    }

    public class ATM {

        long[] totalNum = new long[5];


        public ATM() {

        }

        public void deposit(int[] banknotesCount) {
            for (int i = 0; i < banknotesCount.length; i++) {
                totalNum[i] += banknotesCount[i];
            }
        }

        public int[] withdraw(int amount) {
            // 先计算500
            int num500 = (int) Math.min(amount / 500, totalNum[4]);
            // 当前剩余
            amount -= num500 * 500;
            // 计算当前200
            int num200 = (int) Math.min(amount / 200, totalNum[3]);
            amount -= num200 * 200;
            // 先计算100
            int num100 = (int) Math.min(amount / 100, totalNum[2]);
            // 当前剩余
            amount -= num100 * 100;
            // 计算当前50
            int num50 = (int) Math.min(amount / 50, totalNum[1]);
            amount -= num50 * 50;
            // 计算20
            int num20 = (int) Math.min(amount / 20, totalNum[0]);
            amount -= num20 * 20;
            if (amount == 0) {
                totalNum[4] -= num500;
                totalNum[3] -= num200;
                totalNum[2] -= num100;
                totalNum[1] -= num50;
                totalNum[0] -= num20;
                return new int[]{num20, num50, num100, num200, num500};
            } else {
                return new int[]{-1};
            }
        }
    }
}


