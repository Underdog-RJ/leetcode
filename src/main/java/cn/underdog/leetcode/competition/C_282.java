package cn.underdog.leetcode.competition;

import java.util.*;

public class C_282 {

    public static void main(String[] args) {
        C_282 c_282 = new C_282();

//        int i = c_282.minSteps_1("leetcode", "coats");
//        int i = c_282.minSteps_1("cotxazilut", "nahrrmcchxwrieqqdwdpneitkxgnt");
        long l = c_282.minimumTime_1(new int[]{1, 2, 3}, 5);
//        long l = c_282.minimumTime(new int[]{2}, 1);
//        System.out.println(l);
    }

    public int prefixCount(String[] words, String pref) {
        int res = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                res++;
            }
        }
        return res;
    }

    public int minSteps(String s, String t) {
        int res = 0;
        Map<Character, Integer> mapS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        // s - t
        Set<Map.Entry<Character, Integer>> entries = mapS.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            Integer orDefault = mapT.getOrDefault(key, 0);
            if (value > orDefault) {
                res += value - orDefault;
            }
        }
        Set<Map.Entry<Character, Integer>> entries1 = mapT.entrySet();
        for (Map.Entry<Character, Integer> characterIntegerEntry : entries1) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
            Integer orDefault = mapS.getOrDefault(key, 0);
            if (value > orDefault) {
                res += value - orDefault;
            }
        }

        return res;

    }

    // 暴力解决 超时
//    public long minimumTime(int[] time, int totalTrips) {
//        long current = 1;
//        while (true) {
//            long currentTimeTotal = 0;
//            // 判断当前时间是否满足
//            for (int i = 0; i < time.length; i++) {
//                currentTimeTotal += current / time[i];
//                if (currentTimeTotal >= totalTrips) {
//                    return current;
//                }
//            }
//            current++;
//        }
//    }

    public long minimumTime(int[] time, int totalTrips) {
        long left = 1, right = 100000000000000L;
        while (left < right) {
            long mid = (right + left) / 2;
            long count = 0;
            for (int i : time) {
                count += mid / i;
            }
            if (count < totalTrips) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int minSteps_1(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Character, Integer> entry : mapS.entrySet()) {
            Character key = entry.getKey();
            Integer valueS = entry.getValue();
            if (mapT.containsKey(key)) {
                Integer integerT = mapT.get(key);
                if (valueS > integerT) {
                    res += valueS - integerT;
                }
            } else {
                res += entry.getValue();
            }
        }
        for (Map.Entry<Character, Integer> entry : mapT.entrySet()) {
            Character key = entry.getKey();
            Integer valueT = entry.getValue();
            if (mapS.containsKey(key)) {
                Integer integerS = mapS.get(key);
                if (valueT > integerS) {
                    res += valueT - integerS;
                }
            } else {
                res += valueT;
            }
        }
        return (int) res;

    }


    public long minimumTime_1(int[] time, int totalTrips) {
        long left = 0;
        long right = 100000000000000L;
        while (left < right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int t : time) {
                count += mid / t;
            }
            if (totalTrips > count) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
