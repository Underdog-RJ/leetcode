package cn.underdog.MainClass;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem83 {
    public static void main(String[] args) {
        System.out.println(detectCapitalUse("EEJIHEHEFIEFBBBBaefanfnawjfbawebf"));
//        System.out.println(detectCapitalUse("FFFFFFFFFe"));
//        System.out.println(detectCapitalUse("Leetcode"));
    }

    public static boolean detectCapitalUse(String word) {
        boolean flag = 'A' <= word.charAt(0) && word.charAt(0) <= 'Z' ? true : false;
        // 如果首字母是小写，如果出现大写直接返回false
        if (!flag) {
            for (int i = 1; i < word.length(); i++) {
                if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                    return false;
                }
            }
            return true;
        }
        // 如果首字母是大写
        else {
            boolean flagL = false;
            for (int i = 1; i < word.length(); i++) {
                if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                    if (i > 1 && !flagL)
                        return false;
                    flagL = true;
                } else {
                    if (flagL) {
                        return false;
                    }
                }
            }
            return true;
        }

    }
}
