package cn.underdog.primaryAlgorithm;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class day_04 {

    public static void main(String[] args) {
//        reverseString(new char[]{'h','e','l','l','o'});
        reverseWords("Let's take LeetCode contest");
    }

    public static String reverseString(char[] s) {
        int length = s.length/2;
        for (int i = 0; i < length; i++) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i]= temp;
        }
       return new String(s);
    }

    public static String reverseWords(String s) {

        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            String s2 = reverseString(s1[i].toCharArray());
            if(i==s1.length-1){
                sb.append(s2);
            }else {
                sb.append(s2+" ");
            }
        }
        return sb.toString();

    }




}
