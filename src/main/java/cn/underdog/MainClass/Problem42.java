package cn.underdog.MainClass;

/**
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *输入：arr = [0,1,0]
 * 输出：1
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/B1IidL
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem42 {
    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{0,1,0});
    }

    public static int peakIndexInMountainArray(int[] arr) {

        int index=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                index=i;
            }
        }
        return index;
    }


}
