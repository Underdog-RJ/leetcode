package cn.underdog.leetcode.competition;

import java.util.*;

class RangeFreqQuery {

  /*  Map<Integer, TreeMap<Integer, Integer>> map = new HashMap<>();

    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            TreeMap<Integer, Integer> orDefault = map.getOrDefault(arr[i], new TreeMap<>());
            Map.Entry<Integer, Integer> integerIntegerEntry = orDefault.lastEntry();
            if (integerIntegerEntry != null) {
                Integer value = integerIntegerEntry.getValue();
                orDefault.put(i, value + 1);
            } else {
                orDefault.put(i, 1);
            }
            map.put(arr[i], orDefault);
        }

    }

    */
    /**
     * floorEntry向下去整找到第一个小于等于的值
     * lowerEntry向下取整找到第一个小于的值
     * ceilingEntry向上取整找到一个大于等于的值
     * higherEntry向上取整找到第一个大于的值。
     *
     * @param left
     * @param right
     * @param value
     * @return
     *//*
    public int query(int left, int right, int value) {
        TreeMap<Integer, Integer> integerIntegerTreeMap = map.get(value);
        if (integerIntegerTreeMap == null)
            return 0;
        Map.Entry<Integer, Integer> entry1 = integerIntegerTreeMap.lowerEntry(left);
        int v1 = 0;
        int v2 = 0;
        if (entry1 != null)
            v1 = entry1.getValue();
        Map.Entry<Integer, Integer> entry2 = integerIntegerTreeMap.floorEntry(right);
        if (entry2 != null)
            v2 = entry2.getValue();
        return v2 - v1;

    }*/
    Map<Integer, List<Integer>> map = new HashMap<>();

    /**
     * 二分查找
     * @param arr
     */
    public RangeFreqQuery(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            List<Integer> orDefault = map.getOrDefault(arr[i], new ArrayList<>());
            orDefault.add(i);
            map.put(arr[i], orDefault);
        }
    }

    public int query(int left, int right, int value) {
        List<Integer> orDefault = map.getOrDefault(value, new ArrayList<>());
        if (orDefault.size() == 0)
            return 0;
        int l = 0;
        int r = orDefault.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (orDefault.get(mid) >= left) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int n1 = l;
        l = 0;
        r = orDefault.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (orDefault.get(mid) <= right) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int n2 = l;
        return n2 - n1;
    }
}