package cn.underdog.newcode.dp.tmp;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int left = 0, right = n - 1, index = 0;
        int[] res = new int[n];
        int count = 1;
        while (left <= right) {
            // 大
            if ((count & 1) == 1) {
                if (nums[left] >= nums[right]) {
                    res[index++] = nums[left++];
                } else {
                    res[index++] = nums[right--];
                }
            } else {
                if (nums[left] >= nums[right]) {
                    res[index++] = nums[right--];
                } else {
                    res[index++] = nums[left++];
                }
            }
            count++;
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
