package cn.underdog.leetcode.MainClass;

/**
 * 一条包含字母 A-Z 的消息通过以下的方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 一条已编码的消息，所有的数字都必须分组，然后按原来的编码方案反向映射回字母（可能存在多种方式）。例如，"11106" 可以映射为：
 *
 * "AAJF" 对应分组 (1 1 10 6)
 * "KJF" 对应分组 (11 10 6)
 * 注意，像 (1 11 06) 这样的分组是无效的，因为 "06" 不可以映射为 'F' ，因为 "6" 与 "06" 不同。
 *
 * 除了 上面描述的数字字母映射方案，编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一数字（不包括 '0'）。例如，编码字符串 "1*" 可以表示 "11"、"12"、"13"、"14"、"15"、"16"、"17"、"18" 或 "19" 中的任意一条消息。对 "1*" 进行解码，相当于解码该字符串可以表示的任何编码消息。
 *
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。
 *
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。
 *输入：s = "*"
 * 输出：9
 * 解释：这一条编码消息可以表示 "1"、"2"、"3"、"4"、"5"、"6"、"7"、"8" 或 "9" 中的任意一条。
 * 可以分别解码成字符串 "A"、"B"、"C"、"D"、"E"、"F"、"G"、"H" 和 "I" 。
 * 因此，"*" 总共有 9 种解码方法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem12 {
    public static void main(String[] args) {
        int res = numDecodings("*");
        System.out.println(res);
    }

    /**
     *总体分为三种情况
     *  1.当前位置为0，返回-1，代表上一步的是一个错误的决定
     *  2.当前位置为*
     *      2.1 当前位置有9种情况
     *      2.下一个位置不越界
     *          2.2.1 下一个位置为* 15 种情况  （第一个取1，第二位取1-9。第二个取2，第二个取1-6）
     *          2.2.2  下一个位置不为*
     *              2.2.2.1 下一个是1-6 之间 有2种情况（*取1或者取2）
     *              2.2.2.2  下一个是7-9之间  有一种情况
     * 3.当前位置不是*,也不是0
     *  3.1 当前位置单独面对，1种情况
     *  3.2 下一个位置不越界
     *      3.2.1 当前为1 后面字符为* 9种情况
     *      3.2.2 当前位2，子厚字符为*,6种情况
     *      3.2.3 后面字符不为 * ，并且两个位置字符组合在1-26之间
     *
     */
    public static int numDecodings(String s) {
        char[] array = s.toCharArray();
        int rs = process(0, array);
        return rs == -1 ? 0 : rs;
    }

    /**
     * 代表从0到index范围上有多少种情况
     * @param index
     * @param array
     * @return
     */
    public static int process(int index, char[] array) {


        // 递归出口
        if(index==array.length){
            return 1;
        }

        int rs = 0;

        // 当array[index]为*的时候
        if(array[index]=='*'){
            // 第一种情况，一个*单独面对
           int p1 = 0;
           int ans = process(index+1,array);
           p1 = ans == -1 ? p1 : (ans*9);

           // 第二种情况，*和index+1一起面对
           int p2=0;
           if(index+1<array.length){
               // 下一个情况为 *
               if(array[index+1]=='*'){
                  ans = process(index+2,array);
                  p2 = ans == -1 ? p2 : (ans*15);
               }else {
                   // 下一个情况不为 *
                   if(array[index+1] >=  '0' && array[index+1]<='6'){
                       ans = process(index+2,array);
                       p2 = ans == -1 ? p2 : (ans * 2);
                   }else {
                       ans = process(index+2,array);
                       p2 = ans == -1 ? p2 : ans ;
                   }
               }
           }
            rs = p1+p2;
        } else if(array[index] != '0'){
            int p1=0;
            int ans = process(index+1,array);
            p1 = ans == -1? p1:ans;

            // 两个字符一起面对

            int p2= 0;
            if(index+1<array.length){
                if(array[index]=='1' && array[index+1] == '*'){
                    ans =   process(index+2,array);
                    p2 = ans ==-1 ? p2 : (ans*9);
                }  else if(array[index]=='2' && array[index+1] == '*'){
                    ans = process(index+2,array);
                    p2 = ans == -1 ? p2 :(ans*6);
                } else if(array[index+1] != '*'  && ((array[index] - '0') * 10 + (array[index + 1] - '0')) > 0 && ((array[index] - '0') * 10 + (array[index + 1] - '0')) <= 26){
                    // 当前位置可以和下一个位置一起执行
                    ans = process(index+2,array);
                    p2 = ans == -1 ? p2 :ans;
                }

            }
            rs = p1 +p2;
        }else {
            // 当前字符为0
            rs =-1;
        }


        return rs;

    }
}
