package cn.underdog.leetcode.competition;

import java.util.*;

public class C_273 {
    public static void main(String[] args) {
        C_273 c_273 = new C_273();
//        System.out.println(c_273.isSameAfterReversals(12300));
//        System.out.println(c_273.executeInstructions(3, new int[]{0, 1}, "RRDDLU").toString());
        c_273.getDistances(new int[]{2, 1, 3, 1, 2, 3, 3});
    }

    public boolean isSameAfterReversals(int num) {
        StringBuilder sb = new StringBuilder(num + "");
        String s = sb.reverse().toString();
        int i1 = Integer.parseInt(s);
        sb = new StringBuilder(i1 + "");
        String s1 = sb.reverse().toString();
        int i = Integer.parseInt(s1);
        return i == num;
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        // 从第一条指令开始计算
        for (int i = 0; i < s.length(); i++) {
            // 计算最多可以执行的指令
            int cnt = 0;
            int row = startPos[0];
            int col = startPos[1];
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'L') {
                    if (col == 0)
                        break;
                    else {
                        col--;
                        cnt++;
                    }
                }
                if (s.charAt(j) == 'R') {
                    if (col == n - 1)
                        break;
                    else {
                        col++;
                        cnt++;
                    }
                }
                if (s.charAt(j) == 'U') {
                    if (row == 0)
                        break;
                    else {
                        row--;
                        cnt++;
                    }
                }
                if (s.charAt(j) == 'D') {
                    if (row == n - 1)
                        break;
                    else {
                        row++;
                        cnt++;
                    }
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public long[] getDistances1(int[] arr) {
        long[] res = new long[arr.length];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> orDefault = map.getOrDefault(arr[i], new ArrayList<>());
            orDefault.add(i);
            map.put(arr[i], orDefault);
        }

       /* Collection<List<Integer>> values = map.values();
        for (List<Integer> integers : values) {
            for (int i = 0; i < integers.size(); i++) {
                for (int j = i + 1; j < integers.size(); j++) {
                    int abs =integers.get(j) - integers.get(i);
                    res[integers.get(i)]+=abs;
                    res[integers.get(j)]+=abs;
                }
            }
        }*/

        for (int i = 0; i < arr.length; i++) {
            long temp = 0;
            for (Integer integer : map.get(arr[i])) {
                temp += Math.abs(i - integer);
            }
            res[i] = temp;
        }
        return res;
    }

    // 前缀和，目前不会
    public long[] getDistances(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], t -> new ArrayList<>()).add(i);
        }
        long[] result = new long[arr.length];
        for (ArrayList<Integer> list : map.values()) {
            for (int i : list) {
                result[list.get(0)] += i - list.get(0);
            }
            for (int i = 1; i < list.size(); i++) {
                result[list.get(i)] = result[list.get(i - 1)] + (2 * i - list.size()) * (list.get(i) - list.get(i - 1));
            }
        }
        return result;
    }

    public int[] recoverArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1, result[] = new int[nums.length / 2]; ; i++) {
            if (nums[i] > nums[0] && (nums[i] - nums[0]) % 2 == 0) {
                ArrayDeque<Integer> deque = new ArrayDeque<>();
                for (int j = 0, k = 0; j < nums.length; j++) {
                    if (!deque.isEmpty() && deque.peek() == nums[j]) {
                        deque.poll();
                    } else if (k == result.length) {
                        break;
                    } else {
                        deque.offer(nums[j] + nums[i] - nums[0]);
                        result[k++] = nums[j] + (nums[i] - nums[0]) / 2;
                    }
                }
                if (deque.isEmpty()) {
                    return result;
                }
            }
        }
    }

}
