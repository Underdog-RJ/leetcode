package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/321:06
 */
public class C_274 {
    public boolean checkString(String s) {
        int maxA = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                maxA = Math.max(maxA, i);
            } else {
                minB = Integer.min(minB, i);
            }
        }
        return maxA<minB;
    }
    public int numberOfBeams(String[] bank) {
        List<Integer> list = new ArrayList<>();
        for (String s : bank) {
            int tmp = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    tmp++;
            }
            if (tmp > 0) {
                list.add(tmp);
            }
        }
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += list.get(i) * list.get(i + 1);
        }

        return res;
    }
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long tmp = mass;
        for (int asteroid : asteroids) {
            if (tmp >= asteroid) {
                tmp += asteroid;
            } else {
                return false;
            }
        }
        return true;
    }


}
