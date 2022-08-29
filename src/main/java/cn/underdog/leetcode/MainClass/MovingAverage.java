package cn.underdog.leetcode.MainClass;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class MovingAverage {
    int size = 0;
    int sum = 0;
    Deque<Integer> deque = new LinkedList<>();
    ;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        sum += val;
        deque.addLast(val);
        if (deque.size() <= size) {
            return (double) sum / deque.size();
        } else {
            sum -= deque.pollFirst();
            return (double) sum / deque.size();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */