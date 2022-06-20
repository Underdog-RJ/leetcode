package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.MainClass.ListNode;

public class C_265 {
    public static void main(String[] args) {
        C_265 c_265 = new C_265();
//        c_265.smallestEqual(new int[]{4, 3, 2, 1});
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(1);
        ListNode l7 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        c_265.nodesBetweenCriticalPoints(l1);
    }

    public int smallestEqual(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i])
                min = Math.min(min, i);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1,-1};
        int gmax = Integer.MIN_VALUE;
        int gmin = Integer.MAX_VALUE;
        int preIndex = -1;
        int firstIndex = 0;
        boolean flag = false;
        ListNode p = head;
        int pre = p.val;
        p = p.next;
        int index = 1;
        while (p.next != null) {
            index++;
            int cntVal = p.val;
            int nextVal = p.next.val;
            if (cntVal > pre && cntVal > nextVal) {
                if (preIndex != -1) {
                    gmin = Math.min(gmin, index - preIndex);
                }
                if (flag) {
                    gmax = index - firstIndex;
                }
                preIndex = index;
                if (!flag) {
                    firstIndex = index;
                    flag = true;
                }
            }
            if (cntVal < pre && cntVal < nextVal) {
                if (preIndex != -1) {
                    gmin = Math.min(gmin, index - preIndex);
                }
                if (flag) {
                    gmax = index - firstIndex;
                }
                preIndex = index;
                if (!flag) {
                    firstIndex = index;
                    flag = true;
                }
            }
            pre = cntVal;
            p = p.next;

        }
        if (gmax != Integer.MIN_VALUE) {
            res[0] = gmin;
            res[1] = gmax;
        }

        return res;
    }


}
