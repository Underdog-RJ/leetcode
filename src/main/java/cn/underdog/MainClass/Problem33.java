package cn.underdog.MainClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;

/**
 * 给你一个长度为 2 * n 的整数数组。你需要将 nums 分成 两个 长度为 n 的数组，分别求出两个数组的和，并 最小化 两个数组和之 差的绝对值 。nums 中每个元素都需要放入两个数组之一。
 *
 * 请你返回 最小 的数组和之差。
 *
 * 输入：nums = [3,9,7,3]
 * 输出：2
 * 解释：最优分组方案是分成 [3,9] 和 [7,3] 。
 * 数组和之差的绝对值为 abs((3 + 9) - (7 + 3)) = 2 。
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@SuppressWarnings({"all"})
public class Problem33 {
    public static void main(String[] args) {
//        int[] nums = new int[]{2,-1,0,4,-2,-9};
//        int[] nums = new int[]{-36,36};
//        int[] nums = new int[]{3,9,7,3};
        int[] nums = new int[]{42,41,59,43,69,67};
//        int[] nums = new int[]{0,6,11,17,18,24};
        int i = minimumDifference(nums);
        System.out.println(i);
    }


    // TODO 思路错误
    public static int minimumDifference(int[] nums) {
//        TreeMap<Integer,Integer> map =new TreeMap<>();
//        for (int num : nums) {
//            map.put(num,0);
//        }
//        Set<Integer> integers = map.keySet();

        if(nums.length ==2)
            return Math.abs(nums[1]-nums[0]);
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int average =0;
        if(sum%2==0){
            average = sum / 2;
        }else {
            average = sum/2 +1;
        }


        int[] tempNums= new int[nums.length];
        int mid = nums.length / 2;
        int count=1;
        int tempTotal = nums[nums.length-1] + nums[0];
        tempNums[0]=1;
        tempNums[nums.length-1]= 1;
        while (mid>count+1){
            mid--;
            if(tempTotal<average){
                int index = 0;
                int min=Integer.MAX_VALUE;
                int distance = average-tempTotal;
                for ( int i =1; i < tempNums.length; i++) {
                    if(tempNums[i]==0){
                        int temp = Math.abs(distance-nums[i]);
                        if(temp<min){
                            min =temp;
                            index=i;
                        }
                    }
                }
                tempTotal+=nums[index];
                tempNums[index]=1;
            }else {
                int index = 0;
                int min=Integer.MAX_VALUE;
                int distance = average-tempTotal;
                for ( int i =1; i < tempNums.length; i++) {
                    if(tempNums[i]==0){
                        int temp = Math.abs(distance-nums[i]);
                        if(temp<min){
                            min=temp;
                            index=i;
                        }
                    }
                }
                tempTotal+=nums[index];
                tempNums[index]=1;
            }
        }

        int tempTotal1=0;
        for (int i = 0; i < tempNums.length; i++) {
            if(tempNums[i]==0){
                tempTotal1+=nums[i];
            }
        }

        return Math.min(Math.abs(tempTotal-tempTotal1),Math.abs(tempTotal1-tempTotal));
    }
}
