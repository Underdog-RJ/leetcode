package cn.underdog.newcode;

import java.util.*;

public class Main {

    private long cntValue = 0;
    private long maxValue = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value = sc.nextInt();
        int[][] bags = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                bags[i][j] = sc.nextInt();
            }
        }
        Main main = new Main();
        main.backtracking(value, n, bags, 0);
        System.out.println(main.maxValue == 0 ? -1 : main.maxValue);
    }

    private void backtracking(int value, int n, int[][] bags, int startIndex) {
        if (value == 0) {
            maxValue = Math.max(maxValue, cntValue);
            return;
        }
        if (startIndex >= n)
            return;
        for (int i = startIndex; i < n; i++) {
            int[] bag = bags[i];
            if (value >= bag[0]) {
                cntValue += bag[1];
                backtracking(value - bag[0], n, bags, i + 1);
                cntValue -= bag[1];
            }
            if (value >= bag[2]) {
                cntValue += bag[3];
                backtracking(value - bag[2], n, bags, i + 1);
                cntValue -= bag[3];
            }
        }
    }
}
