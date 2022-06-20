package cn.underdog.leetcode.MainClass;

public class Problem95 {
    public static void main(String[] args) {

    }

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.split(" ");
        for (int i = 0; i < k; i++) {
            if (i + 1 != k)
                sb.append(strings[i] + " ");
            else
                sb.append(strings[i]);
        }
        return sb.toString();
    }
}
