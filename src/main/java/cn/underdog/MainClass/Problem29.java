package cn.underdog.MainClass;

/**
 * 你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。
 *
 * 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。
 *
 * 输入：n = 5
 * 输出：2
 * 解释：因为第三行不完整，所以返回 2 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem29 {

    public static void main(String[] args) {
        int i = arrangeCoins(3);
        System.out.println(i);
    }

    /**
     * 暴力解除
     * @param n
     * @return
     */
   /* public static int arrangeCoins(int n) {
        int count=0;
        int sum = 1;
        while (n>0){
            n-=sum++;
            count++;
        }
        if(n<0)
            return count-1;
        else
            return count;
    }*/

    /**
     * 二分查找
     *    前k个需要的硬币为:   k*(k+1)/2  =====>>>(long)mid*(mid+1)<=(long)n*2
     *    如果k大于right=mid-1
     *    否则left=mid
     *
     * @param n
     * @return
     */
    public static int arrangeCoins(int n) {
       int left=1;
       int right=n;
       while (left<right){
           int mid = (right-left+1)/2+left;
           if((long)mid*(mid+1)<=(long)n*2)
               left=mid;
           else
               right=mid-1;
       }
       return left;
    }





}
