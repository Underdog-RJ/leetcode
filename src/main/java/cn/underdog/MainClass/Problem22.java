package cn.underdog.MainClass;

/**
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 */
public class Problem22 {

    public static void main(String[] args) {

//        int result = countSegments("Hello, my name is John");
        int result = countSegments(", , , ,        a, eaefa");
        System.out.println(result);

    }

    public static int countSegments(String s) {

        if(s.equals(""))
            return 0;

        String[] s1 = s.split(" ");
        int length=0;
        for (String s2 : s1) {
            if(!s2.equals(""))
                length++;
        }

        return length;
    }


}
