package cn.underdog.MainClass;

import cn.underdog.entity.PeekingIterator;

import java.util.ArrayList;
import java.util.List;
public class Problem24 {

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(list.iterator());
        Integer next = peekingIterator.next();
        System.out.println(next);
        Integer peek = peekingIterator.peek();
        System.out.println(peek);
        Integer next1 = peekingIterator.next();
        System.out.println(next1);
        Integer next2 = peekingIterator.next();
        System.out.println(next2);
        boolean b = peekingIterator.hasNext();
        System.out.println(b);
    }

}
