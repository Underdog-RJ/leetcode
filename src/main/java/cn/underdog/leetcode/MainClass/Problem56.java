package cn.underdog.leetcode.MainClass;

import cn.underdog.leetcode.entity.Bank;

public class Problem56 {

    public static void main(String[] args) {
        Bank obj = new Bank(new long[]{10,100,20,50,30});
        obj.withdraw(3,10);
        obj.transfer(5, 1, 20); // 返回 true ，账户 5 的余额是 $30 ，所以可以转账 $20 。
        // 账户 5 的余额为 $30 - $20 = $10 ，账户 1 的余额为 $10 + $20 = $30 。
        obj.deposit(5, 20);     // 返回 true ，可以向账户 5 存款 $20 。
        // 账户 5 的余额为 $10 + $20 = $30 。
        obj.transfer(3, 4, 15); // 返回 false ，账户 3 的当前余额是 $10 。
        // 所以无法转账 $15 。
        obj.withdraw(10, 50);   // 返回 false ，交易无效，因为账户 10 并不存在。

    }

}
