package cn.underdog.leetcode.competition;

import java.util.Map;
import java.util.TreeMap;

/**
 * Map.Entry<Integer, Integer> floorEntry = map.floorEntry(left);
 * Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(left);
 * if (floorEntry == null && ceilingEntry == null) {
 * map.put(left, right - left + 1);
 * count += right - left + 1;
 * } else if (floorEntry == null && ceilingEntry != null) {
 * int tmpRight = Math.min(right, ceilingEntry.getKey() - 1);
 * map.put(left, tmpRight - left + 1);
 * count += tmpRight - left + 1;
 * } else if (floorEntry != null && ceilingEntry == null) {
 * int tmpLeft = Math.max(left, floorEntry.getKey() + floorEntry.getValue() - 1);
 * map.put(tmpLeft, right - tmpLeft + 1);
 * count += right - tmpLeft + 1;
 * } else {
 * int tmpRight = Math.min(right, ceilingEntry.getKey() - 1);
 * int tmpLeft = Math.max(left, floorEntry.getKey() + floorEntry.getValue() - 1);
 * map.put(tmpLeft, tmpRight - tmpLeft + 1);
 * count += tmpRight - tmpLeft + 1;
 * }
 */
class CountIntervals {

    class Node {
        int lc, rc, update, sum;
        boolean change;
    }

    int N = (int) 1e9, M = 5000, cnt = 1;
    Node[] target = new Node[M];

    void lazyCreate(int rt) {
        if (target[rt] == null) target[rt] = new Node();
        if (target[rt].lc == 0) {
            target[rt].lc = ++cnt;
            target[target[rt].lc] = new Node();
        }
        if (target[rt].rc == 0) {
            target[rt].rc = ++cnt;
            target[target[rt].rc] = new Node();
        }
    }


    void pushDown(int rt, int ln, int rn) {
        if (target[rt].change) {
            target[target[rt].lc].change = true;
            target[target[rt].rc].change = true;
            target[target[rt].lc].update = target[rt].update;
            target[target[rt].rc].update = target[rt].update;
            target[target[rt].lc].sum = target[rt].update * ln;
            target[target[rt].rc].sum = target[rt].update * rn;
            target[rt].change = false;
        }
    }

    void pushUp(int rt) {
        target[rt].sum = target[target[rt].lc].sum + target[target[rt].rc].sum;
    }

    void update(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && r <= R) {
            target[rt].change = true;
            target[rt].update = C;
            target[rt].sum = C * (r - l + 1);
            return;
        }
        lazyCreate(rt);
        int mid = l + r >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            update(L, R, C, l, mid, target[rt].lc);
        }
        if (R > mid) {
            update(L, R, C, mid + 1, r, target[rt].rc);
        }
        pushUp(rt);
    }

    public CountIntervals() {
        lazyCreate(1);
    }

    int query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return target[rt].sum;
        }
        lazyCreate(rt);
        int mid = l + r >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        int sum = 0;
        if (L <= mid) {
            sum += query(L, R, l, mid, target[rt].lc);
        }
        if (R > mid) {
            sum += query(L, R, mid + 1, r, target[rt].rc);
        }
        return sum;
    }

    public void add(int left, int right) {
        update(left, right, 1, 1, N + 1, 1);
    }

    public int count() {
        return query(1, N + 1, 1, N + 1, 1);
    }
}

/**
 * Your CountIntervals object will be instantiated and called as such:
 * CountIntervals obj = new CountIntervals();
 * obj.add(left,right);
 * int param_2 = obj.count();
 */