package cn.underdog.MainClass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem3 {

    public static void main(String[] args) {
        int[] arr1={};
        int[] arr2={1};
        double restlt=findMedianSortedArrays(arr1,arr2);
        System.out.println(restlt);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] restlt=new int[nums1.length+nums2.length];
        int i=0;
        int j=0;
        int w=0;
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]<nums2[j]){
                restlt[w++]=nums1[i++];
            }else{
                restlt[w++]=nums2[j++];
            }
        }
        while (i<nums1.length){
            restlt[w++]=nums1[i++];
        }
        while (j<nums2.length){
            restlt[w++]=nums2[j++];
        }

       if (restlt.length!=0){
           double test=0;
          if(restlt.length%2==1){
               test = restlt[restlt.length/2];
          }else {
              double temp=restlt[restlt.length/2]+restlt[restlt.length/2-1];
               test = (temp)/2;
          }
            return  test;
       }else {
           return 0;
       }



    }
}
