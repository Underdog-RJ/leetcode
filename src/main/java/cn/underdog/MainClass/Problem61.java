package cn.underdog.MainClass;

import cn.underdog.entity.WordDictionary;

public class Problem61 {
    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));
//        wordDictionary.addWord("a");
//        wordDictionary.addWord("a");
//        System.out.println(wordDictionary.search("."));
//        System.out.println(wordDictionary.search("aa"));
//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search(".a"));
//        System.out.println(wordDictionary.search("a."));

    }
}
