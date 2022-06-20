package cn.underdog.leetcode.entity;

import java.util.*;

/**
 * TreeMap总结
 *      treeMap中的key 必须进行实现comparator接口所以是k是有序的。
 *      lastKey最后一个key,firstKey第一个key
 */
public class StockPrice {

    // k:时间戳，v:价格
    private TreeMap<Integer,Integer> map=null;
    // k:价格，v:时间戳集合
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
            // 上一次的已经存在获取上一次对应的price
            Integer lastPrice = map.get(timestamp);
            // 覆盖上次存在的。
            map.put(timestamp,price);
            // 获取上次key对应的集合
            Set<Integer> integerSet = prices.get(lastPrice);
            // 将本次的进行时间戳从集合总删除
            integerSet.remove(timestamp);
            // 如果集合的大小为0则从prices中删除本次对应的price
            if(integerSet.size()==0)
                prices.remove(lastPrice);
            /*
            找到本次对应的prices集合，在集合遍历时增加或者删除元素都会导致并发异常，需要转为迭代器进行操作
            Iterator<Map.Entry<Integer, Set<Integer>>> iterator = prices.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Set<Integer>> next = iterator.next();
                if (next.getValue().contains(timestamp)){
                    next.getValue().remove(timestamp);
                    if (next.getValue().size()==0)
                        iterator.remove();
                }
            }*/
            // 如果prices中不包含本次的price则添加。否则获取上次添加的。
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
        return  map.get(map.lastKey());
    }
    public int maximum() {
        return prices.lastKey();
    }
    public int minimum() {
        return prices.firstKey();
    }

}
