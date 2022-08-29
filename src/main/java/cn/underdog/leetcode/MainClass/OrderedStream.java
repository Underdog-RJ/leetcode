package cn.underdog.leetcode.MainClass;

import java.util.*;

class OrderedStream {
    int ptr = 1;
    HashMap<Integer, String> map = new HashMap<>();

    public OrderedStream(int n) {

    }

    public List<String> insert(int idKey, String value) {
        map.put(idKey, value);
        if (idKey == ptr) {
            List<String> strings = new ArrayList<>();
            int tmp = ptr;
            while (!map.isEmpty() && map.containsKey(tmp)) {
                strings.add(map.remove(tmp++));
            }
            ptr = tmp;
            return strings;
        } else {
            return new ArrayList<>();
        }
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */