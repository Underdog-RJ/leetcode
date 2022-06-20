package cn.underdog.leetcode.MainClass;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem7 {
    public static void main(String[] args) {

        System.out.println(isPowerOfThree(19684));
    }

    public static boolean isPowerOfThree(int n) {
        double num=Math.abs(n);
        if(n==1){
            return true;
        }if(n<=0){
            return false;
        }
        return isPowerOfThreeDG(num);
    }

    public static boolean isPowerOfThreeDG(double n) {
        double re = n/3.0;
        if(re==1){
            return true;
        }else if(re<1){
           return false;
        }
        return isPowerOfThreeDG(n/3);
    }


}
