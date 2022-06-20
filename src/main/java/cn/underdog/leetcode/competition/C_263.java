package cn.underdog.leetcode.competition;

import java.util.*;

public class C_263 {
    public static void main(String[] args) {

    }


    public boolean areNumbersAscending(String s) {
        String[] s1 = s.split(" ");

        LinkedList<Integer> list = new LinkedList<>();
        for (String s2 : s1) {
            boolean numeric = isNumeric(s2);
            if (numeric) {
                int currentNum = Integer.parseInt(s2);
                if (list != null && list.size() > 0) {
                    Integer last = list.getLast();
                    if (last >= currentNum)
                        return false;
                }
                list.add(currentNum);
            }
        }
        return true;
    }

    public boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public int countMaxOrSubsets(int[] nums) {
        int res = 0;
        // 查找子集
        List<List<Integer>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());
        for (int num : nums) {
            List<List<Integer>> currentSet = new ArrayList<>();
            List<Integer> temp = null;
            for (List<Integer> list : subset) {
                temp = new ArrayList<>();
                temp.addAll(list);
                temp.add(num);
                currentSet.add(temp);
            }
            subset.addAll(currentSet);
        }
        int max = Integer.MIN_VALUE;
        for (List<Integer> list : subset) {
            if (list.isEmpty())
                continue;
            int temp = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                temp |= list.get(i);
            }
            if (temp == max) {
                res++;
            } else if (temp > max) {
                max = temp;
                res = 1;
            }
        }
        return res;
    }
}
