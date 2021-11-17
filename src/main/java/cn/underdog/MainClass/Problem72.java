package cn.underdog.MainClass;

/**
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如  sqrt 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem72 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(5));
    }

    public static boolean isPerfectSquare(int num) {
      /*  double sqrt = Math.sqrt(num);
        int temp = (int) ((int) sqrt * sqrt);
        return temp == num ? true : false;*/
        if(num==Integer.MAX_VALUE)
            return false;
        int left = 0;
        int right = num;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > (double) num / mid) {
                right = mid - 1;
            } else if (mid < (double) num / mid) {
                left = mid;
            } else {
                return true;
            }
        }
        return false;

    }
}
