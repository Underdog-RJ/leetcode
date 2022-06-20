package cn.underdog.leetcode.MainClass;

public class Problem92 {
    public static void main(String[] args) {
        maxPower("cc");
    }

    public static int maxPower(String s) {
        int res = 1;
        char last = s.charAt(0);
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == last) {
                res++;
            } else {
                if (max < res)
                    max = res;
                res = 1;
                last = s.charAt(i);
            }
        }
        if (max < res)
            max = res;
        return max;
    }
}
