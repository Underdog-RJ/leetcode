package cn.underdog.leetcode.segmentTree;

import java.util.List;

public class MainClass {
    /**
     * ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
     * [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
     *
     * @param args //
     */
    public static void main(String[] args) {
//        NumArray numArray = new NumArray(new int[]{1, 3, 5});
//        numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//        numArray.update(1, 2);   // nums = [1,2,5]
//        numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
//        MyCalendar1 myCalendar = new MyCalendar1();
//        myCalendar.book(47, 50);
//        myCalendar.book(33, 41);
//        myCalendar.book(39, 45);
//        myCalendar.book(33, 42);
//        myCalendar.book(25, 32);
//        myCalendar.book(26, 35);
//        myCalendar.book(19, 25);//true
//        myCalendar.book(3, 8);
//        myCalendar.book(8, 13);
//        myCalendar.book(18, 27);
//        MyCalendarThree myCalendarThree = new MyCalendarThree();
//        myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//        myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//        myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
//        myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
//        myCalendarThree.book(5, 10); // 返回 3
//        myCalendarThree.book(25, 55); // 返回 3
        RangeFreqQuery rangeFreqQuery = new RangeFreqQuery(new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56});
        System.out.println(rangeFreqQuery.query(1, 2, 4));
        System.out.println(rangeFreqQuery.query(0, 11, 33));

    }


}
