package cn.underdog.MainClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 */
public class Problem23 {

    public static void main(String[] args) {

//        int[] nums= new int[]{1,Integer.MIN_VALUE};
//        int[] nums= new int[]{Integer.MIN_VALUE,2,3,Integer.MIN_VALUE};
//        int[] nums= new int[]{3,3,3,3,4,3,2,3,3};
//        int[] nums= new int[]{Integer.MIN_VALUE,1,1};
        int[] nums= new int[]{1,2,2,5,3,5};
        int i = thirdMax(nums);
        System.out.println(i);

    }

    public static int thirdMax(int[] nums) {


        int length= nums.length;

        boolean flag = false;

        if(length>=3)
            flag=true;

        Long max = Long.MIN_VALUE;
        Long secMax = Long.MIN_VALUE;
        Long thirdMax =Long.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            if(nums[i]>thirdMax && nums[i]<secMax){
                thirdMax=new Long(nums[i]);
            }else if(nums[i]>secMax && nums[i]<max){
                thirdMax=secMax;
                secMax=new Long(nums[i]);

            }else if(nums[i]>max){
                thirdMax=secMax;
                secMax=max;
                max=new Long(nums[i]);
            }
        }

        if(flag&&thirdMax!=Long.MIN_VALUE){
            return thirdMax.intValue();
        }else {
            return max.intValue();
        }

    }


}
