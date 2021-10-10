package cn.underdog.MainClass;

import java.math.BigDecimal;

/**
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 *
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 *
 * 如果存在多个答案，只需返回 任意一个 。
 *
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem26 {
    public static void main(String[] args) {

        fractionToDecimal(2,3);


    }

    //TODO 长除法，不会
    public static String fractionToDecimal(int numerator, int denominator) {


        BigDecimal bdFZ=new BigDecimal( numerator);
        BigDecimal bdFM=new BigDecimal( denominator);

        BigDecimal divide = bdFZ.divide(bdFM,10000,BigDecimal.ROUND_HALF_UP);
        String chushu  = divide.toString().split("\\.")[0];
        String yushu  = divide.toString().split("\\.")[1];



        return ";";
    }

}
