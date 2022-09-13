package cn.underdog.leetcode.competition;

import java.util.*;

public class C_309 {

    public static void main(String[] args) {
        C_309 c_309 = new C_309();
//        c_309.longestNiceSubarray(new int[]{1, 3, 8, 48, 10});
        c_309.mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}});
    }

    public boolean checkDistances(String s, int[] distance) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char cntK = s.charAt(i);
            List<Integer> orDefault = map.getOrDefault(cntK, new ArrayList<>());
            orDefault.add(i);
            map.put(cntK, orDefault);
        }
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            Character key = entry.getKey();
            int index = key - 'a';
            int dis = distance[index];
            List<Integer> value = entry.getValue();
            int tmp = value.get(1) - value.get(0) - 1;
            if (tmp != dis)
                return false;
        }
        return true;
    }

    public int longestNiceSubarray(int[] nums) {
        int[] flags = new int[32];
        int left = 0, right = 0, n = nums.length, max = 1;
        while (right < n) {
            String s = Integer.toBinaryString(nums[right]);
            for (int i = 0; i < s.length(); i++) {
                flags[s.length() - i - 1] += Integer.parseInt(s.charAt(i) + "");
            }
            while (!isOk(flags)) {
                String s1 = Integer.toBinaryString(nums[left]);
                for (int i = 0; i < s1.length(); i++) {
                    flags[s1.length() - i - 1] -= Integer.parseInt(s1.charAt(i) + "");
                }
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }

    private boolean isOk(int[] flags) {
        for (int flag : flags) {
            if (flag > 1) return false;
        }
        return true;
    }


    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> exists = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        int[] res = new int[n];
        for (int[] meeting : meetings) {
            int i = meeting[0];
            while (!exists.isEmpty() && exists.peek()[2] <= i) {
                int[] poll = exists.poll();
                pq.add(poll[0]);
            }
            if (!pq.isEmpty()) {
                Integer index = pq.poll();
                res[index]++;
                exists.add(new int[]{index, meeting[0], meeting[1]});
            } else {
                int[] poll = exists.poll();
                int index = poll[0];
                res[index]++;
                int dur = meeting[1] - meeting[0];
                exists.add(new int[]{index, poll[2], poll[2] + dur});
            }
        }
        int maxIndex = -1;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > maxCount) {
                maxCount = res[i];
                maxIndex = i;
            }
        }
        return maxIndex;

    }


}
