package cn.underdog.MainClass;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Problem2 {


    public static void main(String[] args) {
//        int length=lengthOfLongestSubstring(UUID.randomUUID().toString().replaceAll("-",""));
        int length=lengthOfLongestSubstringB("dvdf");
        System.out.println(length);
    }

    /**
     *
     * @param replaceAll
     * @return
     */
    private static int lengthOfLongestSubstring(String replaceAll) {
        char[] chars = replaceAll.toCharArray();
        int max=0;
        for (int i = 0; i < chars.length; i++) {

            Set<String> small=new LinkedHashSet<>();

            for (int j = i; j<chars.length; j++) {

                if(small.contains(chars[j]+""))
                {
                    break;
                }else {
                    small.add(chars[j]+"");
                }

            }

            if(max<small.size()){
                max=small.size();
            }

            System.out.println(small.toString());
        }

        return max;
    }

    private static int lengthOfLongestSubstringF(String s) {
       if(s!=""){
            int start=0,end=s.length();
            int max=0;
           Map<Character,Integer> map=new HashMap<>();
           while (start<end){
               if(map.containsKey(s.charAt(start))){
                   start=map.get(s.charAt(start));
                   map=new HashMap<>();
               }else {
                   map.put(s.charAt(start),++start);
               }
               if(max<map.size()){
                   max= map.size();
               }
           }
           return max;
       }else {
           return 0;
       }
    }

    private static int lengthOfLongestSubstringB(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }


}
