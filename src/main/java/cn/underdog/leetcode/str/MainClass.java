package cn.underdog.leetcode.str;

public class MainClass {
    public static void main(String[] args) {

    }

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ('a' - 1 + Integer.parseInt(s.substring(i, i + 2))));
                i += 3;
            } else {
                sb.append((char) ('a' - 1 + s.charAt(i) - '0'));
                i++;
            }
        }
        return sb.toString();
    }

}
