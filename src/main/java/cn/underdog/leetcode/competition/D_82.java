package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;


public class D_82 {

    public static void main(String[] args) {
        D_82 d_82 = new D_82();
//        d_82.minSumSquareDiff(new int[]{1, 4, 10, 12}, new int[]{5, 8, 6, 9}, 9, 9);
        d_82.validSubarraySize(new int[]{1, 3, 4, 3, 1}, 6);
    }


    public boolean evaluateTree(TreeNode root) {
        dfsEva(root);
        return root.val == 1 ? true : false;
    }

    private void dfsEva(TreeNode root) {
        if (root.left != null) {
            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            boolean flag = false;
            if (root.val == 2) {
                flag = left || right;
            } else if (root.val == 3) {
                flag = left && right;
            }
            root.val = flag ? 1 : 0;
        }
    }

    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int abs = Math.abs(nums1[i] - nums2[i]);
            map.put(abs, map.getOrDefault(abs, 0) + 1);
        }
        long total = k1 + k2;
        if (map.containsKey(0)) map.remove(0);
        while (total > 0 && map.size() != 0) {
            Map.Entry<Integer, Integer> integerIntegerEntry = map.lastEntry();
            Integer value = integerIntegerEntry.getValue();
            Integer key = integerIntegerEntry.getKey();
            if (value <= total) {
                total -= value;
                map.remove(integerIntegerEntry.getKey());
                if (key != 1) {
                    map.put(key - 1, map.getOrDefault(key - 1, 0) + value);
                } else {
                    map.clear();
                }
            } else {
                value -= (int) total;
                map.put(integerIntegerEntry.getKey(), value);
                if (key != 1) {
                    map.put(key - 1, map.getOrDefault(key - 1, 0) + (int) total);
                }
                total = 0;
            }
        }
        if (map.size() == 0) return 0;
        long res = 0;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            long tmp = (long) Math.pow(key, 2) * integerIntegerEntry.getValue();
            res += tmp;
        }
        return res;
    }

    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        for (int bus : buses) {
            int left = 2;
            int right = (int) 1e9;

        }

        return 0;
    }

    public int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;
        // 非递减数组
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < nums.length; i++) {
            while (stack.size() > 1 && nums[stack.peek()] > nums[i]) {
                int height = nums[stack.pop()];
                int len = i - stack.peek() - 1;
                if (height > threshold / len) {
                    return len;
                }
            }
            stack.push(i);
        }
        while (stack.size() > 1) {
            int height = nums[stack.pop()];
            int len = n - stack.peek() - 1;
            if (height > threshold / len) {
                return len;
            }
        }
        return -1;
    }

}
