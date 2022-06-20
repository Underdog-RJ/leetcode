package cn.underdog.leetcode.hashtable;

import java.util.Arrays;

class Bitset {

    char[] chars = null;
    char[] reverse = null;
    int cnt = 0;

    public Bitset(int size) {
        chars = new char[size];
        reverse = new char[size];
        Arrays.fill(chars, '0');
        Arrays.fill(reverse, '1');
    }

    public void fix(int idx) {
        if (chars[idx] == '0') {
            chars[idx] = '1';
            cnt++;
        }
        reverse[idx] = '0';
    }

    public void unfix(int idx) {
        if (chars[idx] == '1') {
            chars[idx] = '0';
            cnt--;
        }
        reverse[idx] = '1';
    }

    public void flip() {
        char[] tmp = chars;
        chars = reverse;
        reverse = tmp;
        cnt = chars.length - cnt;
    }

    public boolean all() {
        return cnt == chars.length;
    }

    public boolean one() {
       return cnt>0;
    }

    public int count() {
        return cnt;
    }

    public String toString() {
        return new String(chars);
    }
}
