package cn.underdog.competition;

import cn.underdog.MainClass.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class pr_265 {
    public static void main(String[] args) {
        /*ListNode l2 = new ListNode(5, new ListNode(8, new ListNode(1)));
        deleteListNode(l2);*/
//[6,16,0,11,8,2,3,0,5,14,1,18,14,9,10,12,4,2,0,13,9,5]
        int[] n = new int[]{2, 0, 4, 7, 7, 4, 7, 1, 6, 5};
        int[] subsets = subsets1(n, 5);
        for (int subset : subsets) {
            System.out.println(subset);
        }

    }

    public static ListNode deleteListNode(ListNode head) {
        if (head == null)
            return head;
        ListNode p = head;
        ListNode r = p;
        while (p != null) {
            ListNode temp = p.next;
            if (temp != null) {
                p.next = temp.next;
                temp.next = null;
                p = p.next;
            } else {
                p = p.next;
            }
        }
        return head;

    }


    public static int[] subsets(int[] heights, int cnt) {
        if (heights == null)
            return new int[]{0};
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(heights);
        for (int i = 0; i <= heights.length - cnt; i++) {
            List<Integer> temp = new ArrayList<>();
            int leng = i + cnt;
            for (int j = i; j < leng; j++) {
                temp.add(heights[j]);
            }
            res.add(temp);
        }
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < res.size(); i++) {
            int currentMin = res.get(i).stream().min(Comparator.comparing(item -> item.intValue())).get();
            int currentMax = res.get(i).stream().max(Comparator.comparing(item -> item.intValue())).get();
            int temp = currentMax - currentMin;
            if (temp < min) {
                min = temp;
                index = i;
            }
        }
        List<Integer> list = res.get(index);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static int[] subsets1(int[] heights, int cnt) {
        if (heights == null)
            return new int[]{0};
        Arrays.sort(heights);
        int min = Integer.MAX_VALUE;
        int[] res = new int[cnt];
        int index = 0;
        for (int i = 0; i <= heights.length - cnt; i++) {
            if(heights[cnt+i-1]-heights[i]<min){
                min=heights[cnt+i-1]-heights[i];
                index = i;
            }
        }
        for (int i = 0; i < cnt; i++) {
            res[i]=heights[i+index];
        }
        return res;
    }

    public static void dfs(List<List<Integer>> res, int[] nums, int k, List<Integer> currentSet, int start) {
        if (k == 0) {
            if (!res.contains(currentSet)) {
                res.add(new ArrayList<>(currentSet));
            }
            return;
        }
        for (int i = start; i < nums.length; i++) {
            currentSet.add(nums[i]);
            dfs(res, nums, k - 1, currentSet, i + 1);
            currentSet.remove(currentSet.size() - 1);
        }
    }
}
