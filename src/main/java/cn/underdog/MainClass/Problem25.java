package cn.underdog.MainClass;

import java.util.Locale;

/**
 * 有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。
 *
 * 给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，并且将所有的小写字母转换为大写字母。
 *
 * 给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。
 * 输入：S = "5F3Z-2e-9-w", K = 4
 * 输出："5F3Z-2E9W"
 * 解释：字符串 S 被分成了两个部分，每部分 4 个字符；
 *      注意，两个额外的破折号需要删掉。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/license-key-formatting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Problem25 {
    public static void main(String[] args) {
//        String ss = licenseKeyFormatting("5F3Z-2e-9-w", 4);
        String ss = licenseKeyFormatting("----------kmhvVuPIyobPjThzMdhzvBWqNwfDajFiWUQvSUfrQsTuHorFisEjIbHtNEPrLbHJFnDNWFijctwBskljKratHqSOWBOgDnaQodjo" ,99);
        System.out.println(ss);
    }

    public static String licenseKeyFormatting(String s, int k) {
        String[] split = s.split("-");
        String temp="";
        for (String s1 : split) {
            temp+=s1;
        }
//        temp=temp.toUpperCase(Locale.ROOT);
        temp = temp.toUpperCase();
        int length = temp.length();
        int chuyu=length / k;
        int yushu=length % k;
        String result="";
        if(chuyu==0){
            return temp;
        }else if(chuyu==1&&yushu==0){
            return temp;
        }else if(chuyu==1&&yushu!=0){
            result= temp.substring(0,yushu)+"-"+temp.substring(yushu,length);
            return result;
        }else {
            if(yushu!=0){
                result+=temp.substring(0,yushu)+"-";
            }
            for (int i =0;i<chuyu;i++){
                int buchang=yushu+i*k;
                if(i+1!=chuyu){
                    result+=temp.substring(buchang,buchang+k)+"-";
                }else {
                    result+=temp.substring(buchang,buchang+k);
                }
            }
            return result;
        }


    }

}
