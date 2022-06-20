package cn.underdog.leetcode.MainClass;

import java.util.Arrays;

public class Problem50 {
    public static void main(String[] args) {

    }

    public static int minMovesToSeat(int[] seats, int[] students) {

        Arrays.sort(seats);
        Arrays.sort(students);

        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count+=Math.abs(seats[i]-students[i]);
        }

        return count;
    }

}
