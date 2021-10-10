package cn.underdog.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {

    private int index;
    private Iterator<Integer> iterator;
    private List<Integer> list;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator=iterator;
        this.list=new ArrayList<>();
        iterator.forEachRemaining(item->this.list.add(item));
        this.index=0;
    }

    @Override
    public boolean hasNext() {
        return index<list.size();
    }

    @Override
    public Integer next() {
        return this.list.get(this.index++);
    }

    public Integer peek() {
        return this.list.get(this.index);
    }
}
