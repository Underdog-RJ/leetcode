package cn.underdog.leetcode.competition;

import java.util.*;

public class C_303 {

    public static void main(String[] args) {
        C_303 c_303 = new C_303();
//        c_303.equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}});
//        c_303.equalPairs(new int[][]{{13, 13}, {13, 13}});
//        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
//        foodRatings.highestRated("korean"); // 返回 "kimchi"
//        // "kimchi" 是分数最高的韩式料理，评分为 9 。
//        foodRatings.highestRated("japanese"); // 返回 "ramen"
//        // "ramen" 是分数最高的日式料理，评分为 14 。
//        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
//        foodRatings.highestRated("japanese"); // 返回 "sushi"
//        // "sushi" 是分数最高的日式料理，评分为 16 。
//        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
//        foodRatings.highestRated("japanese"); // 返回 "ramen"
//        // "sushi" 和 "ramen" 的评分都是 16 。
//        // 但是，"ramen" 的字典序比 "sushi" 更小。
        FoodRatings foodRatings = new FoodRatings(new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"}, new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"}, new int[]{2, 6, 18, 6, 5});
        foodRatings.changeRating("qnvseohnoe", 11);
        foodRatings.highestRated("fajbervsj");
        foodRatings.changeRating("emgqdbo", 3);
        foodRatings.changeRating("jmvfxjohq", 9);
        foodRatings.changeRating("emgqdbo", 14);
        foodRatings.highestRated("fajbervsj");
        foodRatings.highestRated("snaxol");


    }


    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                return c;
            set.add(c);
        }
        return '0';
    }

    public int equalPairs(int[][] grid) {
        Map<String, Integer> row = new HashMap<>();
        Map<String, Integer> col = new HashMap<>();
        for (int[] ints : grid) {
            StringBuilder sb = new StringBuilder();
            for (int anInt : ints) {
                sb.append(anInt + "-");
            }
            String cntK = sb.toString();
            row.put(cntK, row.getOrDefault(cntK, 0) + 1);
        }
        for (int i = 0; i < grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                sb.append(grid[j][i] + "-");
            }
            String cntK = sb.toString();
            col.put(cntK, col.getOrDefault(cntK, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<String, Integer> entry : row.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (col.containsKey(key)) {
                Integer integer = col.get(key);
                res += integer * value;
            }
        }
        return res;

    }


}
