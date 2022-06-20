package cn.underdog.leetcode.competition;

class Bank {

     long[] longs = null;
    long length = 0;

    public Bank(long[] balance) {
        length = balance.length;
        longs = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
//        if (longs.length <= account1 || longs.length <= account2)
//            return false;
        if (account1 > length || account2 > length)
            return false;
        Long aLong = longs[account1 - 1];
        if (aLong >= money) {
            longs[account1 - 1] = aLong - money;
            Long aLong2 = longs[account2 - 1];
            longs[account2 - 1] = aLong2 + money;
    
            return true;
        } else
            return false;
    }

    public boolean deposit(int account, long money) {
//        if (longs.length <= account)
//            return false;
        if (account > length)
            return false;
        Long aLong = longs[account - 1];
        longs[account - 1] = aLong + money;
        return true;
    }

    public boolean withdraw(int account, long money) {
//        if (longs.length <= account)
//            return false;
        if (account > length)
            return false;
        Long aLong = longs[account - 1];
        if (aLong >= money) {
            longs[account - 1] = aLong - money;
            return true;
        } else
            return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */