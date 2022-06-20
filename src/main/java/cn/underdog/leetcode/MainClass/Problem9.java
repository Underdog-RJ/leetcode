package cn.underdog.leetcode.MainClass;

import java.util.*;

/**
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 * 示例：
 *
 "abcdxabcde"
 "abcdeabcdx"
 * 输入: "sea", "eat"
 * 输出: 2
 * 解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 */

//TODO 未做完
public class Problem9 {

    public static void main(String[] args) {
        String word1="abcdxabcde";
        String word2="abcdeabcdx";
        int result = minDistance1(word1, word2);
        System.out.println(result);
    }

    public static int minDistance(String word1, String word2) {
        HashMap<Integer,Character> wordMap1=new LinkedHashMap<>();
        HashMap<Integer,Character> wordMap2=new LinkedHashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(Objects.equals(word1.charAt(i),word2.charAt(j))){
                    wordMap1.put(i,word1.charAt(i));
                    wordMap2.put(j,word1.charAt(i));
                }
            }
        }
        System.out.println("=============map1==================");
        wordMap1.forEach((k,v)->
            System.out.println("k \t"+k+" \t"+"v \t"+v)
        );
        System.out.println("=============map2==================");

        wordMap2.forEach((k,v)->
            System.out.println("k \t"+k +"\t"+"v \t"+v)
        );
        return 0;

    }

    public static int minDistance1(String word1, String word2) {

        int i=0;
        int result=0;
        for ( i = 0; i < word1.length(); i++) {
            int j=0;
            int total=0;
            int temp=i;
            int tempJ=0;
            while (temp<word1.length()){
                while (j<word2.length()&&temp < word1.length()){
                    if(Objects.equals(word1.charAt(temp),word2.charAt(j))){
                        System.out.print(word1.charAt(temp));
                        total++;
                        temp++;
                        j++;
                        if(tempJ==0){
                            tempJ=j;

                        }
                    }else {
                        j++;
                    }
                }
                j=tempJ;
                temp++;
            }
            if(total>result){
                result=total;
            }
            System.out.println("-------------------");
        }

        return word1.length()-result+word2.length()-result;
    }


}
