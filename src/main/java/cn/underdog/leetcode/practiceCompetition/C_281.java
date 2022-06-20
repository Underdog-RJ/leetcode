package cn.underdog.leetcode.practiceCompetition;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class C_281 {
    public static void main(String[] args) {
        C_281 c_281 = new C_281();
        c_281.repeatLimitedString("cczazcc", 3);
    }


    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        char pre = '0';
        while (map.size() != 0) {
            Map.Entry<Character, Integer> entry = map.pollFirstEntry();
            Character cnt = entry.getKey();
            Integer cntValue = entry.getValue();
            if (cnt == pre) {
                if (map.size() == 0)
                    return sb.toString();
                Map.Entry<Character, Integer> next = map.pollFirstEntry();
                map.put(cnt, cntValue);
                Character nextKey = next.getKey();
                Integer nextValue = next.getValue();
                if (nextValue > 1) {
                    map.put(nextKey, nextValue - 1);
                }
                sb.append(nextKey);
                pre = nextKey;
            } else {
                Integer value = entry.getValue();
                if (value <= repeatLimit) {
                    for (Integer i = 0; i < value; i++) {
                        sb.append(cnt);
                    }
                    pre = cnt;
                } else {
                    for (int i = 0; i < repeatLimit; i++) {
                        sb.append(cnt);
                    }
                    pre = cnt;
                    map.put(cnt, value - repeatLimit);
                }
            }
        }
        return sb.toString();
    }
}
