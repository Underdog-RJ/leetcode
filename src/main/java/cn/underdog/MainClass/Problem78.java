package cn.underdog.MainClass;

/**
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 * <p>
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 * <p>
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem78 {

    public static void main(String[] args) {
//        maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"});
//        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(maxProduct(new String[]{"a","aa","aaa","aaaa"}));

    }

    public static int maxProduct(String[] words) {
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            int currentLength = words[i].length();
            String currentWord = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String nextWord = words[j];
                int nextLength = words[j].length();
                boolean flag = false;
                for (int u = 0; u < nextWord.length(); u++) {
                    if (currentWord.indexOf(nextWord.charAt(u)) != -1) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    if (res < currentLength * nextLength) {
                        res = currentLength * nextLength;
                    }
                }
            }
        }
        return res;
    }
}
