package cn.underdog.leetcode.MainClass;


/**
 * 线段数：主要解决数组中更新问题，然后求区间和，max/min等等,主要提供三个方法
 *      query(left,right)区间和
 *      add(left,right,C)left,right区间内都加C
 *      update(left,right,C)left,right区间都更新为C
 *      所以此题主要用update方法addRange都更新为1，removeRange都更新为0.最后用query统计区间和，简单明了。
 *      但是线段数为满二叉树，此题的数据范围为1-1e9，如果直接开辟4*1e9超出范围，所以采用动态开点的方式，就是用一个cnt表示当前下标索引值，当用到时去创建节点
 */
class RangeModule {

    /**
     * 构造节点，lc,左孩子下标，rc右孩子下标
     * chage时当前节点的更新值，和update搭配使用，
     * sum时当前节点表示的范围和
     */
    class Node {
        int lc, rc, change, sum;
        boolean update;
    }

    int N = (int) 1e9, M = 1000000, cnt = 1;
    Node[] target = new Node[M];

    void pushUp(int rt) {
        target[rt].sum = target[target[rt].lc].sum + target[target[rt].rc].sum;
    }

    void pushDown(int rt, int ln, int rn) {
        if (target[rt].update) {
            target[target[rt].lc].update = true;
            target[target[rt].rc].update = true;
            target[target[rt].lc].change = target[rt].change;
            target[target[rt].rc].change = target[rt].change;
            target[target[rt].lc].sum = target[rt].change * ln;
            target[target[rt].rc].sum = target[rt].change * rn;
            target[rt].update = false;
        }
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

    void update(int L, int R, int C, int l, int r, int rt) {
        if (L <= l && r <= R) {
            target[rt].update = true;
            target[rt].change = C;
            target[rt].sum = (r - l + 1) * C;
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

    public RangeModule() {

    }

    public void addRange(int left, int right) {
        update(left + 1, right, 1, 1, N + 1, 1);
    }

    public boolean queryRange(int left, int right) {
        int total = right - left;
        int query = query(left + 1, right, 1, N + 1, 1);
        return query == total;
    }

    public void removeRange(int left, int right) {
        update(left + 1, right, 0, 1, N + 1, 1);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */