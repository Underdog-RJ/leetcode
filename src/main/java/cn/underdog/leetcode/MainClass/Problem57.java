package cn.underdog.leetcode.MainClass;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 *
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-complement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem57 {

    public static void main(String[] args) {

    }

    public int findComplement(int num) {

        String binaryString = Integer.toBinaryString(num);
        int count = 0;
        int j= 0;
        for (int i = binaryString.length()-1;i>=0;i--){
            if("0".equals(binaryString.charAt(i)+"")){
              count+=(int)  Math.pow(2,j);
            }
            j++;
        }
        return count;
    }
}
