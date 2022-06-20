package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/321:11
 */
public class D_68 {
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        for (String sentence : sentences) {
            max = Math.max(max, sentence.split(" ").length);
        }

        return max;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>(List.of(supplies));
        while (!queue.isEmpty()) {
            String cntItem = queue.poll();
            for (int i = 0; i < ingredients.size(); i++) {
                List<String> stringList = ingredients.get(i);
                if (stringList.size() == 0)
                    continue;
                stringList.remove(cntItem);
                if (stringList.size() == 0) {
                    queue.offer(recipes[i]);
                    list.add(recipes[i]);
                }
            }
        }
        return list;
    }

    private boolean backTrackAllRecipes(boolean[] flags, String recipe, List<List<String>> ingredients, Set<String> set, Set<String> res, Map<String, Integer> map) {
        if (res.contains(recipe))
            return true;
        Integer index = map.get(recipe);
        if (!flags[index]) {
            flags[index] = true;
            List<String> list = ingredients.get(index);
            for (int i = 0; i < list.size(); i++) {
                String cnt = list.get(i);
                if (!set.contains(cnt)) {
                    // 如果原料表不包含，这接返回
                    if (!map.containsKey(cnt))
                        return false;
                    boolean flag = backTrackAllRecipes(flags, cnt, ingredients, set, res, map);
                    if (!flag) {
                        return false;
                    } else {
                        res.add(cnt);
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    //TODO 不会
    public boolean canBeValid(String s, String locked) {
        int valid1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (valid1 > 0) {
                    valid1--;
                } else {
                    if (locked.charAt(i) == '0') {
                        valid1++;
                    } else {
                        return false;
                    }
                }
            } else {
                valid1++;
            }
        }

        return valid1 == 0;
    }
}
