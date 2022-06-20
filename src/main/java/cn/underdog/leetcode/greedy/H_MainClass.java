package cn.underdog.leetcode.greedy;

import java.util.Arrays;

public class H_MainClass {

    public static void main(String[] args) {
        H_MainClass h_mainClass = new H_MainClass();
//        h_mainClass.candy(new int[]{1, 3, 2, 2, 1});
//        h_mainClass.candy(new int[]{1, 2, 87, 87, 87, 2, 1});
        System.out.println(h_mainClass.candy(new int[]{1, 6, 10, 8, 7, 3, 2}));

    }

    public int candy(int[] ratings) {
        int length = ratings.length;
        int[] res = new int[length];
        Arrays.fill(res, 1);
        // 正向遍历，从左到右考虑大小情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                res[i] = res[i - 1] + 1;
            }
        }
        // 逆向遍历，从右到左考虑大小情况
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                res[i] = Math.max(res[i + 1] + 1, res[i]);
            }
        }
        return Arrays.stream(res).sum();
    }
}
