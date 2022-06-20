package cn.underdog.leetcode.competition;

import java.util.*;

public class D_59 {

    public static void main(String[] args) {
        D_59 d_59 = new D_59();
        d_59.minTimeToType("bza");
    }

    public int minTimeToType(String word) {
        int cntPointer = 0;
        int count = 0;
        for (char c : word.toCharArray()) {
            int tmp = c - 'a';
            if (tmp < cntPointer) {
                // 顺时针
                int num1 = 26 - cntPointer + tmp;
                int num2 = cntPointer - tmp;
                count += Math.min(num1, num2) + 1;
            } else if (tmp > cntPointer) {
                //
                int num1 = tmp - cntPointer;
                int num2 = cntPointer + (26 - tmp);
                count += Math.min(num1, num2) + 1;
            } else {
                count++;
            }
            cntPointer = tmp;
        }
        return count;
    }
}
