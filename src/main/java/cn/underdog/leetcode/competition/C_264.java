package cn.underdog.leetcode.competition;

import java.util.*;

public class C_264 {

    public static void main(String[] args) {
//        int i = countValidWords("!this  1-s b8d!");
//        int i = countValidWords("alice and  bob are playing stone-game10");
//        int i = countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener.");
//        int i = countHighestScoreNodes(new int[]{-1, 0});
        int i = countHighestScoreNodes(new int[]{-1, 3, 3, 5, 7, 6, 0, 0});
//        int i = countHighestScoreNodes(new int[]{-1,2,0,2,0});
//        int i = countHighestScoreNodes(new int[]{-1, 9, 3, 0, 13, 2, 10, 2, 18, 16, 18, 5, 9, 3, 4, 13, 0, 12, 16});
        System.out.println(i);
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
        int max_count = 1;
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
        for (int i = 0; i < parents.length; i++) {
            // 创建长度位parents 的数组表示当前节点知否已经访问，如果已经访问置为1
            int[] flag = new int[length];
            flag[i] = 1;
            List<Integer> list = map.get(i);
            if (list != null && list.size() != 0) {
                for (Integer integer : list) {
                    count = 1;
                    flag[integer] = 1;
                    int sum = dfs(map, integer, flag);
                    sums.add(sum);
                }
            }
            for (int j = 0; j < flag.length; j++) {
                if (flag[j] == 0) {
                    count = 1;
                    flag[j] = 1;
                    int dfs = dfs(map, j, flag);
                    sums.add(dfs);
                }
            }
            int temp = 1;
            for (Integer sum1 : sums) {
                temp *= sum1;
            }
            if (temp == max) {
                max_count++;
            }
            if (temp > max) {
                max = temp;
                max_count = 1;
            }
            sums.clear();
        }
        return max_count;
    }

    static int count = 0;
    static List<Integer> sums = new ArrayList<>();

    /**
     * 深度优先
     */
    public static int dfs(Map<Integer, List<Integer>> map, int index, int[] flag) {
        List<Integer> list = map.get(index);
        if (list == null || list.size() == 0)
            return 1;
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


  /*
    public static int countHighestScoreNodes(int[] parents) {
        Map<Integer, List<Integer>> map = new HashMap();
        int[] count = new int[parents.length];
        for(int i = 1; i < parents.length; i++){
            List<Integer> list = new ArrayList(map.getOrDefault( parents[i], new ArrayList()));
            list.add(i);
            map.put(parents[i], list);
        }
        DFS(0, map, count);
        long scoreMax = Integer.MIN_VALUE;
        int nodes = 0;
        for(int i = 0; i < parents.length; i++){
            long score = 1;
            if(parents[i] == -1){
                List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
                for(int num : list)
                    score *= count[num];
            }else{
                score = count[0] - count[i];
                List<Integer> list = new ArrayList( map.getOrDefault( i, new ArrayList() ) );
                for(int num : list)
                    score *= count[num];
            }
            if(scoreMax < score){
                scoreMax = score;
                nodes = 1;
            }else if(score == scoreMax) ++nodes;
            System.out.println(score);
        }
        return nodes;
    }*/

   /* public static void DFS(int index,  Map<Integer, List<Integer>> map, int[] count){
        List<Integer> list = new ArrayList( map.getOrDefault( index, new ArrayList() ) );
        if(list.size() == 0){
            count[index] = 1;
            return;
        }
        for(int num : list){
            DFS(num, map, count);
            count[index] += count[num];
        }
        ++count[index];
    }
*/

}
