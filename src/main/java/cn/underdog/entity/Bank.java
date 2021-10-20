package cn.underdog.entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Bank {

//    LinkedList<Long> list =new LinkedList<>();
    long[] longs=null;

    public Bank(long[] balance) {
        longs=balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(longs.length<account1||longs.length<account2)
            return false;
        Long aLong = longs[account1-1];
        if(aLong>=money){
            Long aLong2 = longs[account2-1];
            longs[account1-1] = aLong-money;;
            longs[account2-1] = aLong2+money;;
            return true;
        }else
            return false;
    }

    public boolean deposit(int account, long money) {
        if(longs.length<account)
            return false;
        Long aLong = longs[account-1];
        longs[account-1] = aLong+money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(longs.length<account)
            return false;
        Long aLong = longs[account-1];
        if(aLong>=money)
        {
            longs[account-1] = aLong-money;
            return true;
        }
        else
            return false;
    }

}
