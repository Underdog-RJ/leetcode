package cn.underdog.MainClass;

import java.util.*;

/**
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * <p>
 * 美式键盘 中：
 * <p>
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * <p>
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * <p>
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keyboard-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem70 {

    public static void main(String[] args) {
        findWords(new String[]{"Hello","Alaska","Dad","Peace"});
        findWords(new String[]{"omk"});
    }

    public static String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        list.add("qwertyuiop");
        list.add("asdfghjkl");
        list.add("zxcvbnm");
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String tempWord = word.toLowerCase();
            for (String s : list) {
                char[] chars = tempWord.toCharArray();
                boolean flag = true;
                for (char aChar : chars) {
                    if(!s.contains(aChar+"")){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    res.add(word);
                }
            }

        }
        String[] ans = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i]=res.get(i);
        }

        return ans;

    }

}
