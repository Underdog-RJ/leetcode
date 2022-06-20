package cn.underdog.leetcode.competition;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class C_295 {


    public static void main(String[] args) {
        C_295 c_295 = new C_295();
//        c_295.discountPrices("there are $1 $2 and 5$ candies in the shop", 50);
//        c_295.discountPrices("$76111 ab $6 $", 48);
        c_295.totalSteps(new int[]{10, 1, 2, 3, 4, 5, 6, 1, 2, 3});
    }

    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> windows = new HashMap<>();
        for (char c : target.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        int left = 0, right = 0;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (needs.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (needs.get(c).equals(windows.get(c))) {
                    valid++;
                }
            }
            while (valid == needs.size()) {
                char cnt = s.charAt(left);
                left++;
                if (needs.containsKey(cnt)) {
                    res++;
                    if (needs.get(cnt).equals(windows.get(cnt))) {
                        valid--;
                    }
                    windows.put(cnt, windows.getOrDefault(cnt, 0) - 1);
                }
            }
        }
        return res;

    }

    public int rearrangeCharacters1(String s, String target) {
        int[] alp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alp[s.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : target.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            int total = alp[key - 'a'];
            res = Math.min(res, total / value);
        }

        return res;

    }

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        BigDecimal has = new BigDecimal(100 - discount).divide(new BigDecimal(100)).setScale(2);
        String[] split = sentence.split(" ");
        Out:
        for (String s : split) {
            if (s.startsWith("$")) {
                String substring = s.substring(1);
                for (int i = 0; i < substring.length(); i++) {
                    if (!Character.isDigit(substring.charAt(i))) {
                        sb.append(s);
                        continue Out;
                    }
                }
                if (substring.equals("")) {
                    sb.append(s + " ");
                    continue;
                }
                Long i = Long.parseLong(substring);
                String cntD = new BigDecimal(i).multiply(has).setScale(2).toString();
                sb.append("$" + cntD + " ");
            } else {
                sb.append(s + " ");
            }
        }
        return sb.toString().trim();
    }

    public String discountPrices1(String sentence, int discount) {
        return Stream.of(sentence.split(" ")).map(t -> !t.matches("\\$\\d+") ? t : String.format("$%.2f", Long.parseLong(t.substring(1)) * (1 - discount / 100.))).collect(Collectors.joining(" "));
    }

    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxT = 0;
            while (!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                maxT = Math.max(maxT, stack.pop()[1]);
            }
            maxT = stack.isEmpty() ? 0 : maxT + 1;
            max = Math.max(max, maxT);
            stack.push(new int[]{nums[i], maxT});
        }
        return max;
    }
}
