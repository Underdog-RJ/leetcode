package cn.underdog.leetcode.diffArray;

/**
 * 差分数组：
 * 主要解决的问题：给出一个原数组，后面n个操作，对原数组的区间进行修改，最后返回原数组。
 */
public class Main {

    /**
     * ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]
     * [[],
     *
     * @param args
     */
    public static void main(String[] args) {
//        MyCalendarThree myCalendarThree = new MyCalendarThree();
//        myCalendarThree.book(10, 20); // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//        myCalendarThree.book(50, 60); // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
//        myCalendarThree.book(10, 40); // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
//        myCalendarThree.book(5, 15); // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
//        myCalendarThree.book(5, 10); // 返回 3
//        myCalendarThree.book(25, 55); // 返回 3
        //[24,40],[43,50],[27,43],[5,21],[30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(24, 40);
        myCalendarTwo.book(43, 50);
        myCalendarTwo.book(27, 43);
        myCalendarTwo.book(5, 21);
        myCalendarTwo.book(30, 40);
        myCalendarTwo.book(14, 29);
        myCalendarTwo.book(3, 19);
        myCalendarTwo.book(3, 14);
        myCalendarTwo.book(25, 39);
        myCalendarTwo.book(6, 19);

    }

    /**
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * <p>
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * <p>
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     * 示例 2：
     * <p>
     * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
     * 输出：[10,25]
     * 解释：
     * 航班编号        1   2
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       15
     * 总座位数：      10  25
     * 因此，answer = [10,25]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 2 * 104
     * 1 <= bookings.length <= 2 * 104
     * bookings[i].length == 3
     * 1 <= firsti <= lasti <= n
     * 1 <= seatsi <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/corporate-flight-bookings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int[] booking : bookings) {
            diff[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                diff[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        return diff;
    }


    /**
     * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
     * <p>
     * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
     * <p>
     * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
     * 输出：false
     * 示例 2：
     * <p>
     * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
     * 输出：true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/car-pooling
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1000];
        for (int[] trip : trips) {
            diff[trip[1]] += trip[0];
            if (trip[2] < 1000) {
                diff[trip[2]] -= trip[0];
            }
        }
        for (int i = 1; i < diff.length; i++) {
            diff[i] += diff[i - 1];
        }
        for (int i : diff) {
            if (i > capacity)
                return false;
        }
        return true;
    }

}
