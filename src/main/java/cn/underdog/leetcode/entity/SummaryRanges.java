package cn.underdog.leetcode.entity;
import java.util.ArrayList;
import java.util.List;
public class SummaryRanges {

    private List<Integer> list;

    public SummaryRanges() {
        this.list=new ArrayList<>();
    }

    public void addNum(int val) {
        this.list.add(val);
    }

    public int[][] getIntervals() {
        return null;
    }
}
