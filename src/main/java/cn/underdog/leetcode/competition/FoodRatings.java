package cn.underdog.leetcode.competition;

import java.util.*;

class FoodRatings {

    Map<String, TreeMap<String, Integer>> map1 = new TreeMap<>();
    Map<String, String> map2 = new TreeMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        for (int i = 0; i < n; i++) {
            String cuisine = cuisines[i];
            TreeMap<String, Integer> orDefault = map1.getOrDefault(cuisine, new TreeMap<>((o1, o2) -> {
                String[] split1 = o1.split("-");
                String[] split2 = o2.split("-");
                int num1 = Integer.parseInt(split1[1]);
                int num2 = Integer.parseInt(split2[1]);
                String str1 = split1[0];
                String str2 = split2[0];
                if (num1 != num2) return num2 - num1;
                else return str1.compareTo(str2);
            }));
            String foodName = foods[i];
            String key = foodName + "-" + ratings[i];
            orDefault.put(key, 1);
            map1.put(cuisine, orDefault);
            map2.put(foodName, cuisine + "-" + ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String tmp = map2.get(food);
        String cuisine = tmp.split("-")[0];
        TreeMap<String, Integer> nodeIntegerTreeMap = map1.get(cuisine);
        String preK = food + "-" + tmp.split("-")[1];
        nodeIntegerTreeMap.remove(preK);
        String cntK = food + "-" + newRating;
        nodeIntegerTreeMap.put(cntK, 1);
        String pre = cuisine + "-" + newRating;
        map2.put(food, pre);
    }

    public String highestRated(String cuisine) {
        TreeMap<String, Integer> nodes = map1.get(cuisine);
        String s = nodes.firstEntry().getKey().split("-")[0];
        return s;
    }
}

class Node implements Comparable<Node> {
    String foodName;
    int rating;

    @Override
    public boolean equals(Object obj) {
        if (foodName.equals(((Node) obj).foodName)) return false;
        else return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int compareTo(Node o) {
        if (o.rating != this.rating) return o.rating - this.rating;
        else return this.foodName.compareTo(o.foodName);
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */