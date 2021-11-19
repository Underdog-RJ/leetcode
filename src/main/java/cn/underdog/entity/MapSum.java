package cn.underdog.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSum {
    Map<String, Integer> map = null;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int count = 0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            if (key.startsWith(prefix)) {
                count += entry.getValue();
            }
        }
        return count;
    }
}
