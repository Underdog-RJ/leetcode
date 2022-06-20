package cn.underdog.leetcode.diffArray;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

class MyCalendarTwo {

    TreeMap<Integer, Integer> map = null;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int max = 0;
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            max = Math.max(max, cnt);
        }
        if (max > 2) {
            map.put(start, map.getOrDefault(start, 0) - 1);
            map.put(end, map.getOrDefault(end, 0) + 1);
            return false;
        } else {
            return true;
        }
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */