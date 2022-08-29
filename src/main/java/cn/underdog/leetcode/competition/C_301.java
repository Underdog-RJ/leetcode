package cn.underdog.leetcode.competition;

import java.util.PriorityQueue;

public class C_301 {
    public static void main(String[] args) {
        C_301 c_301 = new C_301();

    }

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : amount) {
            if (i != 0) {
                priorityQueue.add(i);
            }
        }
        int res = 0;
        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.size() >= 2) {
                Integer poll1 = priorityQueue.poll();
                Integer poll2 = priorityQueue.poll();
                if (poll1 > 1) {
                    priorityQueue.add(poll1 - 1);
                }
                if (poll2 > 1) {
                    priorityQueue.add(poll2 - 1);
                }
            } else {
                Integer poll = priorityQueue.poll();
                if (poll > 1) {
                    priorityQueue.add(poll - 1);
                }
            }
            res++;
        }

        return res;

    }

    public boolean canChange(String start, String target) {
        int n = start.length();
        int[] dp1 = new int[n];
        int cnt = 0;
        int pre = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == '_') {
                cnt++;
            } else if (start.charAt(i) == 'L') {
                dp1[i] = cnt + pre;
                cnt = 0;
                pre = dp1[i];
            }
        }
        cnt = 0;
        pre = 0;
        int[] dp2 = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (start.charAt(i) == '_') {
                cnt++;
            } else if (start.charAt(i) == 'R') {
                dp2[i] = cnt + pre;
                cnt = 0;
                pre = dp2[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (target.charAt(i) == 'L') {

            }
        }
        return false;

    }


}
