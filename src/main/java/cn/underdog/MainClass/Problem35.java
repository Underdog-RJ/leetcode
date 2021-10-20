package cn.underdog.MainClass;

/**
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings({"all"})
public class Problem35 {
    public static void main(String[] args) {
//        int divide = divide(10, 3);
//        int divide = divide(-7, -3);
        int divide = divide(-2147483648, 2);
//        int divide = divide(12, 4);
//        int divide = divide(2147483647, 1);
//        int divide = divide(1, -1);
        System.out.println(divide);
    }
   /* public static int divide(int dividend, int divisor) {
        if(dividend==0)
            return 0;
        if(divisor==Integer.MIN_VALUE)
            return dividend==Integer.MIN_VALUE?1:0;
        if(dividend == Integer.MIN_VALUE&&divisor==1){
            return Integer.MIN_VALUE;
        }
        if(dividend == Integer.MAX_VALUE&&divisor==1){
            return Integer.MAX_VALUE;
        }
        if(dividend == Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        boolean flag = true;
        if(dividend<0)
        {
            flag=!flag;
            dividend=Math.abs(dividend);
        }
        if(divisor<0)
            flag=!flag;
        divisor=Math.abs(divisor);
        int sum = 0;
        int left =0;
        int right = dividend;
        for (;left<right;){
            if(right==Integer.MAX_VALUE)
                right=right-1;
            int mid = left+(right-left+1) / 2;;
            if((long)mid*divisor>dividend)
                right=mid-1;
            else {
                left = mid;
            }
        }
        if(!flag)
        {
            return -left;
        }
        return left;
    }*/

    /**
     * Integer.MIN_VALUE = -2147483648
     * Integer.MIN_VALUE = 2147483647
     * 注意会出现益处问题
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        // 如果被除数为0直接返回
        if(dividend==0)
            return 0;
        // 如果除数为最小值 如果被除数也为最小值，则返回1否则返回0
        if(divisor==Integer.MIN_VALUE)
            return dividend==Integer.MIN_VALUE ? 1 : 0;
        // 如果被除数为最小值除数为1则返回最小值
        if(dividend == Integer.MIN_VALUE&&divisor==1)
            return Integer.MIN_VALUE;
        // 如果被除数为最小值除数为1则返回最大值
        if(dividend == Integer.MIN_VALUE&&divisor==-1)
            return Integer.MAX_VALUE;
        // 如果被除数最大值，除数为一，则直接返回最大值
        if(dividend == Integer.MAX_VALUE&&divisor==1)
            return Integer.MAX_VALUE;
        /**
         * 把两个数都转为负数（如果都转为正数会出现溢出）
         *     无论那个大于0都转为相反的值
         */
        boolean flag = false;
        if(dividend>0) {
            flag = !flag;
            dividend = -dividend;
        }
        if(divisor>0) {
            flag = !flag;
            divisor = -divisor;
        }
        /**
         * 二分查找法
         *      第一次用被除数作为right,0为left。取中间值，如果mid * 除数小于dividend 则直接right = mid+1 否则 left = mid
         */
        long right = dividend;
        long left = 0;
        for (;left>right;){
            long mid = left+(right-left-1) / 2;
            if(-(long)mid*divisor<dividend)
                right=mid+1;
            else
                left =mid;
        }
        if(!flag)
            return -(int) left;
        return (int)left;
    }
}
