package cn.underdog.leetcode.competition;


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.stream.Collectors;

public class C_253 {

    public static void main(String[] args) {
        C_253 c_253 = new C_253();
//        c_253.minStoneSum(new int[]{5, 4, 9}, 2);
//        c_253.minSwaps("][][");
//        c_253.minSwaps("]]][[[");
        c_253.longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2});
//        c_253.longestObstacleCourseAtEachPosition(new int[]{2, 2, 1});
//        c_253.longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2});
    }


    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int pile : piles) {
            priorityQueue.add(pile);
        }
        while (k != 0) {
            priorityQueue.add((int) Math.ceil((double) priorityQueue.poll() / 2));
            k--;
        }
        Integer collect = priorityQueue.stream().collect(Collectors.summingInt(o -> o.intValue()));
        return collect == null ? 0 : collect;
    }

    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char peek = stack.peek();
                if (c == '[') {
                    stack.add(c);
                } else {
                    if (peek == '[') stack.pop();
                    else stack.add(c);
                }
            } else {
                stack.add(c);
            }
        }
        int res = (int) Math.ceil((double) stack.size() / 4);
        return res;
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int length = obstacles.length;
        int[] dp = new int[length];
        int[] lisNum = new int[length];
        int cntIdnex = 0;
        lisNum[cntIdnex++] = obstacles[0];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            if (obstacles[i] >= lisNum[cntIdnex - 1]) {
                lisNum[cntIdnex++] = obstacles[i];
                dp[i] = cntIdnex;
            } else {
                int left = 0, right = cntIdnex;
                while (left <= right) {
                    int mid = left + right >> 1;
                    if (lisNum[mid] > obstacles[i]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                lisNum[left] = obstacles[i];
                dp[i] = left + 1;
            }
        }
        return dp;
    }



}
