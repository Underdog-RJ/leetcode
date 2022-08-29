package cn.underdog.leetcode.rating;

import java.util.*;

class SnapshotArray {

    Map<Integer, Map<Integer, Integer>> totalMap = new HashMap<>();
    Map<Integer, Integer> cntMap = new HashMap<>();
    int cnt = 0;
    int pre = 0;

    public SnapshotArray(int length) {
        totalMap.put(cnt, cntMap);
    }

    public void set(int index, int val) {
        if (pre != cnt) {
            pre = cnt;
        }
        cntMap.put(index, val);

    }

    public int snap() {
        int tmp = cnt;
        Map<Integer, Integer> tmpMap = new HashMap<>(cntMap);
        totalMap.put(tmp, tmpMap);
        cnt++;
        return tmp;
    }

    public int get(int index, int snap_id) {
        return totalMap.get(snap_id).getOrDefault(index, 0);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */