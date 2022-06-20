package cn.underdog.leetcode.competition;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author underdog_rj
 * @date2022/5/320:51
 */
public class C_279 {
    public int[] sortEvenOdd(int[] nums) {
        PriorityQueue<Integer> even = new PriorityQueue<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = even.poll();
            } else {
                nums[i] = odd.poll();
            }
        }
        return nums;

    }

    public long smallestNumber(long num) {
        if (num > 0) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            String str = String.valueOf(num);
            int num0 = 0;
            for (int i = 0; i < str.length(); i++) {
                int cnt = Integer.parseInt(str.charAt(i) + "");
                if (cnt == 0) {
                    num0++;
                } else {
                    priorityQueue.add(cnt);
                }
            }
            Integer poll = priorityQueue.poll();
            StringBuilder sb = new StringBuilder(String.valueOf(poll));
            for (int i = 0; i < num0; i++) {
                sb.append("0");
            }
            while (priorityQueue.size() != 0) {
                sb.append(priorityQueue.poll());
            }
            return Long.parseLong(sb.toString());
        } else if (num < 0) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            String str = String.valueOf(Math.abs(num));
            int num0 = 0;
            for (int i = 0; i < str.length(); i++) {
                int cnt = Integer.parseInt(str.charAt(i) + "");
                if (cnt == 0) {
                    num0++;
                } else {
                    priorityQueue.add(cnt);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (priorityQueue.size() != 0) {
                sb.append(priorityQueue.poll());
            }
            for (int i = 0; i < num0; i++) {
                sb.append("0");
            }
            return -Long.parseLong(sb.toString());
        } else {
            return 0;
        }

    }
    public class Bitset {
        char[] chars = null;
        char[] reverse = null;
        int cnt = 0;

        public Bitset(int size) {
            chars = new char[size];
            reverse = new char[size];
            Arrays.fill(chars, '0');
            Arrays.fill(reverse, '1');
        }

        public void fix(int idx) {
            if (chars[idx] == '0') {
                chars[idx] = '1';
                cnt++;
            }
            reverse[idx] = '0';
        }

        public void unfix(int idx) {
            if (chars[idx] == '1') {
                chars[idx] = '0';
                cnt--;
            }
            reverse[idx] = '1';
        }

        public void flip() {
            char[] tmp = chars;
            chars = reverse;
            reverse = tmp;
            cnt = chars.length - cnt;
        }

        public boolean all() {
            return cnt == chars.length;
        }

        public boolean one() {
            return cnt>0;
        }

        public int count() {
            return cnt;
        }

        public String toString() {
            return new String(chars);
        }
    }
}
