package cn.underdog.leetcode.rating;

import java.util.Arrays;
import java.util.Scanner;

public class Problem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        double hat = max * ((double) q / 100);
        int tmp = Math.min((int) ((100 - hat) / ((double) p / 100)), 100);
        int res = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            double cnt = (double) nums[i] * ((double) q / 100) + tmp * ((double) p / 100);
            if (cnt >= 60) {
                res++;
            }
            tmp--;
        }
        System.out.println(res);
    }



}
