package cn.underdog.leetcode.segmentTree;

class MyCalendarThree {


    class Node {
        int lc, rc, lazy, max;
    }

    int N = (int) 1e9, M = 120010, cnt = 1;
    Node[] target = new Node[M];


    void add(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && r <= R) {
            target[rt].lazy += C;
            target[rt].max += C;
            return;
        }
        lazyCreate(rt);
        int mid = l + r >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        if (L <= mid) {
            add(L, R, C, l, mid, target[rt].lc);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, r, target[rt].rc);
        }
        pushUp(rt);
    }

    int query(int L, int R, int l, int r, int rt) {
        if (L <= l && r <= R) {
            return target[rt].max;
        }
        lazyCreate(rt);
        int mid = l + r >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        int max = Integer.MIN_VALUE;
        if (L <= mid) {
            max = Math.max(max, query(L, R, l, mid, target[rt].lc));
        }
        if (R > mid) {
            max = Math.max(max, query(L, R, mid + 1, r, target[rt].rc));
        }
        return max;
    }

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
        if (target[rt].lazy != 0) {
            int tmp = target[rt].lazy;
            target[target[rt].lc].lazy += tmp;
            target[target[rt].lc].max += tmp;
            target[target[rt].rc].lazy += tmp;
            target[target[rt].rc].max += tmp;
            target[rt].lazy = 0;
        }
    }


    void pushUp(int rt) {
        target[rt].max = Math.max(target[target[rt].lc].max, target[target[rt].rc].max);
    }


    public int book(int start, int end) {
        add(start + 1, end, 1, 1, N + 1, 1);
        return query(1, N + 1, 1, N + 1, 1);
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */