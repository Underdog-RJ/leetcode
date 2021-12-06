package cn.underdog.competition;


import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.util.Set;

public class ddd {
    public static void main(String[] args) {
//        System.out.println(minimumBuckets("HH......."));
//        System.out.println(minimumBuckets(".HH.HH.HH.HH..H"));
        System.out.println(minimumBuckets(".HH.H.H.H.."));
//        System.out.println(minimumBuckets(".H.H"));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words1.length; i++)
            map1.put(words1[i], map1.getOrDefault(words1[i], 0) + 1);
        for (int i = 0; i < words2.length; i++)
            map2.put(words2[i], map2.getOrDefault(words2[i], 0) + 1);
        int res = 0;
        Set<Map.Entry<String, Integer>> entries = map1.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(1)) {
                String key = entry.getKey();
                if (map2.containsKey(key)&&map2.get(key)==1)
                    res++;
            }
        }
        return res;

    }

    public static int minimumBuckets(String street) {
        if (street.contains("HHH"))
            return -1;
        if (street.length() == 1)
            return street.charAt(0) == 'H' ? -1 : 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) == 'H') {
                list.add(i);
            }
        }
        int res = 0;
        if (list.size() == 2) {
            if (list.get(1) - list.get(0) == 1)
                return -1;
        }
        for (int i = 0; i < list.size() ; i+=2) {
            int t1 = list.get(i);
            int t2 = list.get(i + 1);
            if (t2 - t1 == 1) {
                if(t1==1)
                    res++;
            }
            if (t2 - t1 == 2) {
                res++;
            }
            if (t2 - t1 >= 3) {
                res += 2;
            }
        }
        return res;
    }

}
