package cn.underdog.entity;

import java.util.*;

public class WordDictionary {

     Set<String> set;

//    private WordDictionary[] children;
//    private boolean isEnd;

    public WordDictionary() {
         set = new HashSet<>();
//        children = new WordDictionary[26];
//        isEnd = false;
    }

    public void addWord(String word) {
         set.add(word);
      /*  WordDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null)
                node.children[index] = new WordDictionary();
            node = node.children[index];
        }
        node.isEnd = true;*/
    }

    // 使用 递归解决当前为 . 如果当前为. 则查找儿子，如果儿子存在  切割字符串，换位root结点，如果不存在直接返回
//    public boolean searchDG(String word,WordDictionary root) {
//        WordDictionary node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char ch = word.charAt(i);
//            int index = ch - 'a';
//            if(".".equals(ch+"")){
//                for (int j = 0; j < 26; j++) {
//                    if(node.children[j]!=null){
//                      boolean result =  searchDG(word.substring(i+1,word.length()),node.children[j]);
//                      if(result)
//                          return true;
//                    }
//                }
//                return false;
//            }
//            if(node.children[index]==null)
//                return false;
//            node = node.children[index];
//        }
//        return node!=null && node.isEnd;
//    }

    public boolean search(String word) {
//      return  searchDG(word,this);
        /**
         * 暴力搜索。
         */
        boolean flag = false;
        int wLength = word.length();
        List<String> list =new ArrayList<>(set);
        for (String s : list) {
            // 如果当前字符串长度不等于word的length 进行下一个
            if(s.length()!=wLength)
                continue;
            // 遍历当前字符串
            for(int i=0;i<s.length();i++){
                if(".".equals(word.charAt(i)+"")){
                    // 如果当前是. 并且.为最后一个则之间返回true
                    if(i==s.length()-1){
                        return true;
                    }
                    continue;
                }
                // 如果当前不相等跳过本次循环
                if(!Objects.equals(s.charAt(i)+"",word.charAt(i)+"")){
                    break;
                }else {
                    if(i==s.length()-1){
                        return true;
                    }
                }
            }
        }
        return flag;
    }


}
