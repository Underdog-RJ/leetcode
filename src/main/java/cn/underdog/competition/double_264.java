package cn.underdog.competition;

import java.util.*;

public class double_264 {

    public static void main(String[] args) {
//        int i = countValidWords("!this  1-s b8d!");
//        int i = countValidWords("alice and  bob are playing stone-game10");
//        int i = countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.");
        countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
    }

    public static int countValidWords(String sentence) {
        String[] s = sentence.split(" ");
        int count = 0;
        for (String s1 : s) {
            if (!s1.equals("") && s1 != null) {
                boolean valid = isValid(s1);
                if (valid) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isValid(String sentence) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < sentence.length(); i++) {
            if (Character.isDigit(sentence.charAt(i))) {
                return false;
            }
            if (!Character.isLetter(sentence.charAt(i))) {
                if (sentence.charAt(i) == '-') {
                    count1++;
                }
                if (sentence.charAt(i) != '-' && !Character.isLetter(sentence.charAt(i))) {
                    if (i + 1 != sentence.length()) {
                        return false;
                    }
                    count2++;
                }
                if (count1 > 1) {
                    return false;
                }
                if (count2 > 1) {
                    return false;
                }
                if (sentence.charAt(i) == '-') {
                    if (i + 1 >= sentence.length()) {
                        return false;
                    }
                    if (i - 1 < 0) {
                        return false;
                    } else {
                        if (Character.isLetter(sentence.charAt(i - 1)) && Character.isLetter(sentence.charAt(i + 1))) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }



    public static int countHighestScoreNodes(int[] parents) {

        /**
         * 拓扑排序
         */
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i < parents.length; i++) {
            if (map.containsKey(parents[i])) {
                List<Integer> list = map.get(parents[i]);
                list.add(i);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(parents[i], temp);
            }
        }
        int length = parents.length;
        int max = Integer.MIN_VALUE;
        /**
         * 求最大值
         */
        for (int i = 0; i < parents.length; i++) {
            // 创建长度位parents 的数组表示当前节点知否已经访问，如果已经访问置为1
            int[] flag = new int[length];
            flag[i] = 1;
            dfs(map, i, flag);
            for (int j = 0; j < flag.length; j++) {
                if (flag[j] == 0) {
                   dfs(map, j, flag);
                }
                int temp = 1;
                for (Integer sum : sums) {
                    temp *= sum;
                }
                max = Math.max(temp,max);
                sums.clear();
            }
            int temp = 1;
            for (Integer sum : sums) {
                temp *= sum;
            }
            max = Math.max(temp,max);
            sums.clear();
        }
        return max;
    }
    static int count = 0;
    static List<Integer> sums = new ArrayList<>();
    /**
     * 深度优先
     */
    public static int dfs(Map<Integer, List<Integer>> map, int index, int[] flag) {
        List<Integer> list = map.get(index);
        if (list == null || list.size() == 0)
            return 0;

        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (flag[integer] == 0) {
                flag[integer] = 1;
                count++;
                dfs(map, integer, flag);
            }
        }
        return count;
    }


}
