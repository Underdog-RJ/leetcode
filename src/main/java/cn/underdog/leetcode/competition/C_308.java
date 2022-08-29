package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.*;

public class C_308 {

    public static void main(String[] args) {
        C_308 c_308 = new C_308();
//        c_308.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3});
        c_308.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
    }


    private Integer cnt = 0;

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        int[] res = new int[n];
        for (int i = 0; i < queries.length; i++) {
            int sum = queries[i];
            int j = 0;
            for (; j < nums.length; j++) {
                if (sum > nums[j]) {
                    sum -= nums[j];
                } else {
                    break;
                }
            }
            res[i] = j;
        }
        return res;
    }

    private void dfsAQ(int[] nums, int query, int startIndex, int count) {
        if (query < 0) {
            cnt = Math.max(count - 1, cnt);
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            dfsAQ(nums, query - nums[i], i + 1, count + 1);
        }
        cnt = Math.max(count, cnt);

    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int n = travel.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + travel[i - 1];
        }
        Map<Character, Integer> map = new HashMap<>();
        int num1 = -1, num2 = -1, num3 = -1;
        for (int i = 0; i < garbage.length; i++) {
            String tmp = garbage[i];
            for (int j = 0; j < tmp.length(); j++) {
                char cntK = tmp.charAt(j);
                if (cntK == 'M') {
                    num1 = i;
                } else if (cntK == 'P') {
                    num2 = i;
                } else {
                    num3 = i;
                }
                map.put(cntK, map.getOrDefault(cntK, 0) + 1);
            }
        }
        int res = 0;
        if (num1 >= 0) {
            Integer m = map.getOrDefault('M', 0);
            res += preSum[num1] + m;
        }
        if (num2 >= 0) {
            Integer m = map.getOrDefault('P', 0);
            res += preSum[num2] + m;
        }
        if (num3 >= 0) {
            Integer m = map.getOrDefault('G', 0);
            res += preSum[num3] + m;
        }

        return res;
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        dfsSS(root, limit, root.val);
        return root;
    }

    private boolean dfsSS(TreeNode root, int limit, int val) {
        if (root != null) {
            if (root.left != null) {
                boolean b = dfsSS(root.left, limit, root.left.val + val);
            }

            return true;
        } else {
            return false;
        }
    }


}
