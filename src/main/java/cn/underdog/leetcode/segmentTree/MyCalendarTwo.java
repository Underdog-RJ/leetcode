package cn.underdog.leetcode.segmentTree;

/**
 * 实现一个 MyCalendar 类来存放你的日程安排。如果要添加的时间内不会导致三重预订时，则可以存储这个新的日程安排。
 * <p>
 * MyCalendar 有一个 book(int start, int end)方法。它意味着在 start 到 end 时间内增加一个日程安排，注意，这里的时间是半开区间，即 [start, end), 实数 x 的范围为，  start <= x < end。
 * <p>
 * 当三个日程安排有一些时间上的交叉时（例如三个日程安排都在同一时间内），就会产生三重预订。
 * <p>
 * 每次调用 MyCalendar.book方法时，如果可以将日程安排成功添加到日历中而不会导致三重预订，返回 true。否则，返回 false 并且不要将该日程安排添加到日历中。
 * <p>
 * 请按照以下步骤调用MyCalendar 类: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyCalendar();
 * MyCalendar.book(10, 20); // returns true
 * MyCalendar.book(50, 60); // returns true
 * MyCalendar.book(10, 40); // returns true
 * MyCalendar.book(5, 15); // returns false
 * MyCalendar.book(5, 10); // returns true
 * MyCalendar.book(25, 55); // returns true
 * 解释：
 * 前两个日程安排可以添加至日历中。 第三个日程安排会导致双重预订，但可以添加至日历中。
 * 第四个日程安排活动（5,15）不能添加至日历中，因为它会导致三重预订。
 * 第五个日程安排（5,10）可以添加至日历中，因为它未使用已经双重预订的时间10。
 * 第六个日程安排（25,55）可以添加至日历中，因为时间 [25,40] 将和第三个日程安排双重预订；
 * 时间 [40,50] 将单独预订，时间 [50,55）将和第二个日程安排双重预订。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个测试用例，调用 MyCalendar.book 函数最多不超过 1000次。
 * 调用函数 MyCalendar.book(start, end)时， start 和 end 的取值范围为 [0, 10^9]。
 */
class MyCalendarTwo {

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

    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {
        if (query(start + 1, end, 1, N + 1, 1) >= 2) return false;
        add(start + 1, end, 1, 1, N + 1, 1);
        return true;
    }
}