package cn.underdog.competition;

import java.beans.Transient;
import java.util.Arrays;
import java.util.StringJoiner;
public class C_272 {
    public static void main(String[] args) {
        C_272 c_272 = new C_272();
//        System.out.println(c_272.isPalindrome("aba"));
//        c_272.addSpaces("EnjoyYourCoffee", new int[]{5, 9});
//        c_272.getDescentPeriods(new int[]{3,2,1,4});
//        c_272.getDescentPeriods(new int[]{8, 6, 7, 7,});
//        System.out.println(c_272.getDescentPeriods(new int[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 4, 3, 10, 9, 8, 7}));
//        System.out.println(c_272.kIncreasing(new int[]{5, 4, 3, 2, 1}, 1));
//        System.out.println(c_272.kIncreasing(new int[]{4,1,5,2,6,2}, 2));
//        System.out.println(c_272.kIncreasing(new int[]{4,1,5,2,6,2}, 3));
        System.out.println(c_272.kIncreasing(new int[]{12, 6, 12, 6, 14, 2, 13, 17, 3, 8, 11, 7, 4, 11, 18, 8, 8, 3}, 1));

    }

    public String firstPalindrome(String[] words) {
        for (int i = 0; i < words.length; i++) {
            boolean palindrome = isPalindrome(words[i]);
            if (palindrome) {
                return words[i];
            }
        }
        return "";
    }

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for (int i = 0; i < spaces.length; i++) {
            int space = spaces[i];
            sb.insert(space + count++, " ");
        }
        return sb.toString();
    }

    public long getDescentPeriods(int[] prices) {
        long res = prices.length;
        int slow = 0;
        int quick = 1;
        int length = prices.length;
        while (quick < length) {
            if (prices[quick - 1] - prices[quick] == 1)
                res += quick - slow;
            else
                slow = quick;
            quick++;
        }
        return res;
    }

    public int kIncreasing(int[] arr, int k) {
        int res = 0;
        int length = arr.length;
        for (int i = k; i < length; i++) {
            int temp = arr[i] - arr[i - k];
            if (temp < 0) {
                arr[i] = arr[i - 1];
                res++;
            }
        }
        return res;
    }


}
