package cn.underdog.leetcode.MainClass;

import java.util.LinkedList;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * <p>
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。、
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem46 {

    public static void main(String[] args) {
        String s = countAndSay(5);
        System.out.println(s);
    }

    /**
     * 求n的描述，需要第N-1项，由此可得，需要进行递归求出前一个的。
     * 递归出口条件  n==1 return 1
     *
     * @param n
     * @return
     */
    public static String countAndSay(int n) {
        // 递归出口条件  n==1 直接返回
        if (n == 1)
            return 1 + "";
        // 返回前一项的结果。
        String s = countAndSay(n - 1);
        String result = "";
        // list 存放对前一项遍历的结果，其中每个元素的格式为: X_X 第一个为  次数，第二个为 出现的数字 （ex: 1_2:一个2）
        LinkedList<String> list = new LinkedList<>();
        // 遍历前一次结果，加入到list中
        for (int i = 0; i < s.length(); i++) {
            // 如果数组不为null
            if (list != null && list.size() != 0) {
                // 获取最后一个
                String last = list.getLast();
                String num = last.split("_")[1];
                String total = last.split("_")[0];
                // 如果本次循环的i和list中的最后一个为同一个元素次数+1
                if (num.equals(s.charAt(i) + "")) {
                    total = Integer.parseInt(total) + 1 + "";
                    String re = total + "_" + num;
                    list.removeLast();
                    list.addLast(re);
                }
                // 否则为新出现的，直接将本次数字置为1
                else {
                    list.addLast(1 + "_" + s.charAt(i));
                }
            }
            // 如果数组为null则直接返回，直接讲本次数字置为1
            else {
                list.add(1 + "_" + s.charAt(i));
            }
        }
        // 将本次结果遍历，返回
        StringBuilder sb = new StringBuilder();
        for (String s1 : list) {
            String[] s2 = s1.split("_");
            for (String s3 : s2) {
                sb.append(s3);
            }
        }
        result = sb.toString();
        return result;
    }


}
