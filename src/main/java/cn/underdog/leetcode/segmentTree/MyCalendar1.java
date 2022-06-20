package cn.underdog.leetcode.segmentTree;


public class MyCalendar1 {

    class Node {
        // ls,rs分别代表当前节点的左右子节点在tr的下标
        // sum代表当前节点有多少数
        // lazy为懒标记
        int lc, rc, lazy, sum;
    }

    // cnt 在tr数组中的下标
    int N = (int) 1e9, M = 120010, cnt = 1;
    Node[] target = new Node[M];

    void add(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && r <= R) {
            target[rt].sum += (r - l + 1) * C;
            target[rt].lazy += C;
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
            return target[rt].sum;
        }
        lazyCreate(rt);
        int mid = l + r >> 1;
        pushDown(rt, mid - l + 1, r - mid);
        int res = 0;
        if (L <= mid) {
            res += query(L, R, l, mid, target[rt].lc);
        }
        if (R > mid) {
            res += query(L, R, mid + 1, r, target[rt].rc);
        }
        return res;
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

    // 把当前任务下发
    void pushDown(int rt, int ln, int rn) {
        if (target[rt].lazy != 0) {
            int tmp = target[rt].lazy;
            target[target[rt].lc].lazy += tmp;
            target[target[rt].lc].sum += tmp * ln;
            target[target[rt].rc].lazy += tmp;
            target[target[rt].rc].sum += tmp * rn;
            target[rt].lazy = 0;
        }
    }

    void pushUp(int rt) {
        target[rt].sum = target[target[rt].lc].sum + target[target[rt].rc].sum;
    }

    public boolean book(int start, int end) {
        if (query(start + 1, end, 1, N + 1, 1) > 0) return false;
        add(start + 1, end, 1, 1, N + 1, 1);
        return true;
    }

}
