package cn.underdog.leetcode.MainClass;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 *
 * 注意:
 *
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 输入:
 * 26
 *
 * 输出:
 * "1a"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-a-number-to-hexadecimal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem19 {


   static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) {
        String s = toHex(26);
        System.out.println(s);
    }

    public static String toHex(int num) {
        String temp = Integer.toBinaryString(num);
        int length=temp.length();
        int total=temp.length()/4;
        int yushu=temp.length()%4;
        boolean flag= false;
        if(yushu!=0){
            total=total+1;
            flag=true;
        }
        for (int i = 0; i <total; i++) {
            if(flag){
                if(i==total-1)
                    getNum(temp, length, i,yushu);
                else
                    getNum(temp, length, i,4);
            }
            else
                getNum(temp, length, i,4);
        }
        return sb.reverse().toString();
    }

    private static void getNum(String temp, int length, int i,int jLength) {
        double result = 0.0;
        for (int j = 0; j < jLength; j++) {
            int position = (length - (i * 4 + j)) - 1;
            double zengliang = Math.pow(2, j);
            result += temp.charAt(position) == '0' ? 0.0 : zengliang;
        }
        getResult((int) result);
    }

    private static void getResult(int resultInt) {
        switch (resultInt){
            case 10:
                sb.append("a");
                break;
            case 11:
                sb.append("b");
                break;
            case 12:
                sb.append("c");
                break;
            case 13:
                sb.append("d");
                break;
            case 14:
                sb.append("e");
                break;
            case 15:
                sb.append("f");
                break;
            default:
                sb.append(resultInt);
        }
    }


}
