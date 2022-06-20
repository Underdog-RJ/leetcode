package cn.underdog.leetcode.design;

import cn.underdog.leetcode.entity.Bank;

public class MainClass {

    public static void main(String[] args) {
//        Bank bank = new Bank(new long[]{0});
//        bank.deposit(1,2);
//        bank.transfer(1,1,1);
//        bank.transfer(1,1,3);
        Solution solution = new Solution(new int[][]{{-2, -2, 1, 1}, {2, 2, 4, 6}});
        solution.pick();
        solution.pick();
        solution.pick();
        solution.pick();
    }


}
