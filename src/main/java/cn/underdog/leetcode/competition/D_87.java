package cn.underdog.leetcode.competition;

import java.util.*;

public class D_87 {
    public static void main(String[] args) {
        D_87 d_87 = new D_87();
//        d_87.smallestSubarrays(new int[]{1, 0, 2, 1, 3});
//        d_87.smallestSubarrays(new int[]{1, 2});
        d_87.smallestSubarrays(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 32, 2, 0, 0, 0, 0, 0, 0, 28, 16, 32, 0, 0, 0, 0, 0, 0, 0, 1, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 0, 0, 0, 2, 0, 0, 32, 0, 0, 0, 4, 16, 0, 4, 0, 32, 0, 0, 8, 0, 1, 1, 0, 0, 0, 0, 0});
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String[] split1 = arriveAlice.split("-");
        String[] split2 = leaveAlice.split("-");
        String[] split3 = arriveBob.split("-");
        String[] split4 = leaveBob.split("-");
        int num1 = Integer.parseInt(split1[0]);
        int num2 = Integer.parseInt(split1[1]);
        int num3 = Integer.parseInt(split2[0]);
        int num4 = Integer.parseInt(split2[1]);
        int num5 = Integer.parseInt(split3[0]);
        int num6 = Integer.parseInt(split3[1]);
        int num7 = Integer.parseInt(split4[0]);
        int num8 = Integer.parseInt(split4[1]);
        if (num3 == num5) {
            return Math.abs(num4 - num6 + 1);
        } else if (num1 == num7) {
            return Math.abs(num2 - num8 + 1);
        }
        return 0;
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int trainer : trainers) {
            map.put(trainer, map.getOrDefault(trainer, 0) + 1);
        }
        int res = 0;
        for (int i = 0; i < players.length; i++) {
            if (!map.isEmpty()) {
                Map.Entry<Integer, Integer> entry = map.ceilingEntry(players[i]);
                if (entry != null) {
                    res++;
                    Integer value = entry.getValue();
                    if (value > 1) {
                        map.put(entry.getKey(), value - 1);
                    } else {
                        map.remove(entry.getKey());

                    }
                }
            }
        }
        return res;
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], rightMax[i + 1] | nums[i]);
        }
        int[] target = new int[32];
        int left = 0, right = 0, cnt = 0, index = 0;
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        while (right < n) {
            cnt = hannleNum(target, nums[right]);
            while (left < right && left < n && cnt == rightMax[left]) {
                res[left] = Math.min(res[left], right - left + 1);
                cnt = hannleNum1(target, nums[left]);
                left++;

            }
            right++;
        }
        res[n - 1] = 1;
        return res;
    }

    private int hannleNum(int[] target, int num) {
        String s = Integer.toBinaryString(num);
        for (int i = 0; i < s.length(); i++) {
            target[s.length() - i - 1] += s.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i : target) {
            if (i >= 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    private int hannleNum1(int[] target, int num) {
        String s = Integer.toBinaryString(num);
        for (int i = 0; i < s.length(); i++) {
            target[s.length() - i - 1] -= s.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        for (int i : target) {
            if (i >= 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

}
