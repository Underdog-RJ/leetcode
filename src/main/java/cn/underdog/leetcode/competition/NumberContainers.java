package cn.underdog.leetcode.competition;

import java.util.*;

class NumberContainers {

    /**
     * index-value
     */
    Map<Integer, Integer> map = new HashMap<>();
    /**
     * value-Set<Index></Index>
     */
    Map<Integer, TreeSet<Integer>> map1 = new HashMap<>();


    public NumberContainers() {

    }

    public void change(int index, int number) {
        if (map.containsKey(index)) {
            Integer preValue = map.get(index);
            TreeSet<Integer> set = map1.get(preValue);
            set.remove(index);
            map.put(index, number);
        } else {
            map.put(index, number);
        }
        TreeSet<Integer> orDefault = map1.getOrDefault(number, new TreeSet<>());
        orDefault.add(index);
        map1.put(number, orDefault);
    }

    public int find(int number) {
        TreeSet<Integer> orDefault = map1.getOrDefault(number, new TreeSet<>());
        if(orDefault.size()==0)
            return -1;
        Integer integer = orDefault.first();
        return integer;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */