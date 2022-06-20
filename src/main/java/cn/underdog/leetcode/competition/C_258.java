package cn.underdog.leetcode.competition;

import java.util.*;

public class C_258 {

    public static void main(String[] args) {
        C_258 c_258 = new C_258();
        c_258.interchangeableRectangles(new int[][]{{4, 5}, {7, 8}});
    }

    public String reversePrefix(String word, char ch) {

        int i = word.indexOf(ch);
        if (i == -1)
            return word;
        char[] chars = word.substring(0, i + 1).toCharArray();
        for (int j = 0; j < chars.length / 2; j++) {
            char tmp = chars[j];
            chars[j] = chars[chars.length - 1 - j];
            chars[chars.length - 1 - j] = tmp;
        }
        return new String(chars) + word.substring(i + 1);
    }

    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        long count = 0;
        for (int[] rectangle : rectangles) {
            double tmp = (double) rectangle[0] / rectangle[1];
            Integer orDefault = map.getOrDefault(tmp, 0);
            count += orDefault;
            map.put(tmp, orDefault + 1);
        }
        return count;
    }

    // TODO 状态压缩
    public int maxProduct(String s) {
        return 0;
    }

}


