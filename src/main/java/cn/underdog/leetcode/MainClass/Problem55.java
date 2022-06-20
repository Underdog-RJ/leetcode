package cn.underdog.leetcode.MainClass;


import java.util.LinkedList;

public class Problem55 {
    public static void main(String[] args) {
//        boolean b = areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles");
//        boolean b = areNumbersAscending("sunset isFull at 7 51 pm overnight lows will be in the low 50 and 60 s");
//        boolean b = areNumbersAscending("4 5 11 26");
        boolean b = areNumbersAscending("hello world 5 x 5");
        System.out.println(b);
    }

    public static boolean areNumbersAscending(String s) {

        String[] s1 = s.split(" ");

        LinkedList<Integer> list = new LinkedList<>();
        for (String s2 : s1) {
            boolean numeric = isNumeric(s2);
            if(numeric){
                int currentNum = Integer.parseInt(s2);
                if (list != null && list.size() > 0) {
                    Integer last = list.getLast();
                    if(last>=currentNum)
                        return false;
                }
                list.add(currentNum);
            }
        }
        return true;
    }

    /**
     * 判断当前字符串是否为数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
}
