package cn.underdog.primaryAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    int[] res = null;

    public Solution(int[] nums) {
        res = nums;
    }
    public int[] reset() {
        return res;
    }

    public int[] shuffle() {
        int[] clone = res.clone();
        int half = res.length / 2;
        int index1 = (int) (Math.random() * half);
        int index2 = (int) (Math.random() * half) + half;
        int temp = clone[index1];
        clone[index1] = clone[index2];
        clone[index2] = temp;
        return clone;
    }
}
