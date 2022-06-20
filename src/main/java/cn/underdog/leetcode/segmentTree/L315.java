package cn.underdog.leetcode.segmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L315 {

    public static void main(String[] args) {
        L315 l315 = new L315();
//        l315.countSmaller(new int[]{5, 2, 6, 1});
        l315.countSmaller(new int[]{0, 1, 0});
    }

    class Node {
        int sum;
        int lazy;
        int l, r;
    }

    Node[] target = null;

    void pushUp(int rt) {
        target[rt].sum = target[rt << 1].sum + target[rt << 1 | 1].sum;
    }

    void pushDown(int rt, int ln, int rn) {
        if (target[rt].lazy != 0) {
            int tmp = target[rt].lazy;
            target[rt << 1].lazy += tmp;
            target[rt << 1].sum += tmp * ln;
            target[rt << 1 | 1].lazy += tmp;
            target[rt << 1 | 1].sum += tmp * rn;
            target[rt].lazy = 0;
        }
    }

    void build(int rt, int l, int r) {
        target[rt].l = l;
        target[rt].r = r;
        if (l != r) {
            int mid = l + r >> 1;
            build(rt << 1, l, mid);
            build(rt << 1 | 1, mid + 1, r);
        }

    }

    void add(int L, int R, int C, int l, int r, int rt) {
        if (L <= target[rt].l && target[rt].r <= R) {
            target[rt].sum += C * (target[rt].r - target[rt].l + 1);
            target[rt].lazy += C;
            return;
        }
        int mid = target[rt].l + target[rt].r >> 1;
        pushDown(rt, mid - target[rt].l + 1, target[rt].r - mid);
        if (L <= mid) {
            add(L, R, C, target[rt].l, mid, rt << 1);
        }
        if (R > mid) {
            add(L, R, C, mid + 1, target[rt].r, rt << 1 | 1);
        }
        pushUp(rt);
    }


    private int query(int L, int R, int l, int r, int rt) {
        if (L <= target[rt].l && target[rt].r <= R) {
            return target[rt].sum;
        }
        int mid = target[rt].l + target[rt].r >> 1;
        pushDown(rt, mid - target[rt].l + 1, target[rt].r - mid);
        int res = 0;
        if (L <= mid) {
            res += query(L, R, target[rt].l, mid, rt << 1);
        }
        if (R > mid) {
            res += query(L, R, mid + 1, target[rt].r, rt << 1 | 1);
        }
        return res;
    }

    public List<Integer> countSmaller(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int n = max - min;
        target = new Node[n + 1 << 2];
        for (int i = 0; i < target.length; i++) {
            target[i] = new Node();
        }
        build(1, min, max);
        int length = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = length - 1; i >= 0; i--) {
            int index = nums[i];
            add(index, index, 1, min, max, 1);
            int cnt = 0;
            if (index - 1 >= min) {
                cnt = query(min, index - 1, min, max, 1);
            }
            System.out.println(cnt);
            res.add(cnt);
        }
        Collections.reverse(res);
        return res;
    }


}
