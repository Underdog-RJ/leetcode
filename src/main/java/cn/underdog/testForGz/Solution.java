package cn.underdog.testForGz;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getHint("1807","7810"));
    }
    public String getHint(String secret, String guess) {
        StringBuilder sb1 = new StringBuilder(secret);
        StringBuilder sb2 = new StringBuilder(guess);
        int c1 = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < sb1.length(); i++) {
            if (sb1.charAt(i) == sb2.charAt(i)) {
                c1++;
                sb1.replace(i, i + 1, "");
                sb2.replace(i, i + 1, "");
                i--;
            } else {
                if (map1.get(sb1.charAt(i)) == null) {
                    map1.put(sb1.charAt(i), 1);
                } else if (map1.get(sb1.charAt(i)) != null) {
                    map1.put(sb1.charAt(i), map1.get(sb1.charAt(i)) + 1);
                }
                if (map2.get(sb2.charAt(i)) == null) {
                    map2.put(sb2.charAt(i), 1);
                } else if (map2.get(sb2.charAt(i)) != null) {
                    map2.put(sb2.charAt(i), map2.get(sb2.charAt(i)) + 1);
                }
            }
        }
        int c2 = 0;
        char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for (char c : arr) {
            c2 += Math.min(map1.get(c) == null ? 0 : map1.get(c), map2.get(c) == null ? 0 : map2.get(c));
        }

        return c1 + "A" + c2 + "B";
    }
}