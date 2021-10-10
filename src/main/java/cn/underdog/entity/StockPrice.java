package cn.underdog.entity;

import java.util.*;

public class StockPrice {

    private TreeMap<Integer,Integer> map=null;

    private TreeMap<Integer,Set<Integer>> prices=null;


    public StockPrice() {
        map = new TreeMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        // 判断在map中是否存在当前时间戳
        if(!map.containsKey(timestamp)){
            map.put(timestamp,price);
            // 判断价格Map是否存在当前价格，如果不存在创建一个新的set集合否则取出之前的set添加本次timestamp
            if(!prices.containsKey(price)){
                Set<Integer> set =new HashSet<>();
                set.add(timestamp);
                prices.put(price,set);
            }else {
                Set<Integer> integers = prices.get(price);
                integers.add(timestamp);
                prices.put(price,integers);
            }
        }else {
            Integer lastPrice = map.get(timestamp);
            map.put(timestamp,price);
            Set<Integer> integerSet = prices.get(lastPrice);
            integerSet.remove(timestamp);
            if(integerSet.size()==0)
                prices.remove(lastPrice);
            /*Iterator<Map.Entry<Integer, Set<Integer>>> iterator = prices.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Set<Integer>> next = iterator.next();
                if (next.getValue().contains(timestamp)){
                    next.getValue().remove(timestamp);
                    if (next.getValue().size()==0)
                        iterator.remove();
                }
            }*/
            if(!prices.containsKey(price)){
                Set<Integer> integers=new HashSet<>();
                integers.add(timestamp);
                prices.put(price,integers);
            }else {
                Set<Integer> integers = prices.get(price);
                integers.add(timestamp);
                prices.put(price,integers);
            }
        }
    }

    public int current() {
        Integer integer = map.get(map.lastKey());
        System.out.println(integer);
        return integer;
    }
    public int maximum() {
        Integer integer = prices.lastKey();
        System.out.println(integer);
        return integer;
    }
    public int minimum() {
        Integer integer = prices.firstKey();
        System.out.println(integer);
        return integer;
    }

}
