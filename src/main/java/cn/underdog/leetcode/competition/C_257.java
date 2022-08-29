package cn.underdog.leetcode.competition;

import java.util.Arrays;
import java.util.Stack;

public class C_257 {

    public static void main(String[] args) {
        C_257 c_257 = new C_257();
//        c_257.numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}});
//        c_257.numberOfWeakCharacters(new int[][]{{1, 1}, {2, 1}, {2, 2}, {1, 2}});
        c_257.firstDayBeenInAllRooms(new int[]{0, 0, 2});

    }

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int u = j + 1; u < nums.length; u++) {
                    int cnt = nums[i] + nums[j] + nums[u];
                    for (int t = u + 1; t < nums.length; t++) {
                        if (cnt == nums[t]) count++;
                    }
                }
            }
        }
        return count;
    }

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int count = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][0] <= properties[stack.peek()][0]) {
                stack.push(i);
            } else {
                while (!stack.empty() && properties[i][0] > properties[stack.peek()][0] && properties[i][1] > properties[stack.peek()][1]) {
                    stack.pop();
                    count++;
                }
                stack.push(i);
            }
        }
        return count;
    }

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int count = 0;
        int length = nextVisit.length;
        int[] dp = new int[length];
        int next = 0;
        for (; next < nextVisit.length; ) {
            if (next == length - 1)
                return count;
            dp[next]++;
            int cntTotal = dp[next];
            if ((cntTotal & 1) == 1) {
                next = nextVisit[next];
            } else {
                next = (next + 1) % length;
            }
            count++;
        }
        return count;

    }

}
