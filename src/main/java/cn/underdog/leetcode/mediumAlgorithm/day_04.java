package cn.underdog.leetcode.mediumAlgorithm;



import java.util.ArrayList;
import java.util.Stack;
import java.util.List;


public class day_04 {

    public static void main(String[] args) {
//        intervalIntersection(new int[][]{{0,2},{5,10},{13,23},{24,25}},new int[][]{{1,5},{8,12},{15,24},{25,26}});
        intervalIntersection(new int[][]{{3,5},{9,20}},new int[][]{{4,5},{7,10},{11,12},{14,15},{16,20}});
//        intervalIntersection(new int[][]{{4,6},{7,8},{10,17}},new int[][]{{5,10}});
    }

    /**
     * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，请你判断二者是否相等。# 代表退格字符。
     * <p>
     * 如果相等，返回 true ；否则，返回 false 。
     * <p>
     * 注意：如果对空文本输入退格字符，文本继续为空。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ab#c", t = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     * <p>
     * 输入：s = "ab##", t = "c#d#"
     * 输出：true
     * 解释：s 和 t 都会变成 “”。
     * 示例 3：
     * <p>
     * 输入：s = "a##c", t = "#a#c"
     * 输出：true
     * 解释：s 和 t 都会变成 “c”。
     * 示例 4：
     * <p>
     * 输入：s = "a#c", t = "b"
     * 输出：false
     * 解释：s 会变成 “c”，但 t 仍然是 “b”。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack1.push(s.charAt(i));
            } else {
                if (stack1.size() != 0) {
                    stack1.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stack2.push(t.charAt(i));
            } else {
                if (stack2.size() != 0) {
                    stack2.pop();
                }
            }
        }
        return stack1.equals(stack2);
    }


    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * <p>
     * 输入：height = [1,1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     * 示例 4：
     * <p>
     * 输入：height = [1,2,1]
     * 输出：2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            int width = right - left;
            int high = height[left] > height[right] ? height[right] : height[left];
            if (max < width * high) {
                max = width * high;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    /**
     * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
     * <p>
     * 返回这 两个区间列表的交集 。
     * <p>
     * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
     * <p>
     * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
     * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     * 示例 2：
     * <p>
     * 输入：firstList = [[1,3],[5,9]], secondList = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：firstList = [], secondList = [[4,8],[10,12]]
     * 输出：[]
     * 示例 4：
     * <p>
     * 输入：firstList = [[1,7]], secondList = [[3,10]]
     * 输出：[[3,7]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interval-list-intersections
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> tempRes = new ArrayList<>();
        for (int i = 0; i < firstList.length; i++) {
            for (int j = 0; j < secondList.length; j++) {
                if(firstList[i][0] >= secondList[j][0]&&firstList[i][1] <= secondList[j][1]){
                    tempRes.add(new int[]{firstList[i][0], firstList[i][1]});
                }
                else if (firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) {
                    tempRes.add(new int[]{firstList[i][0], secondList[j][1]});
                }
                else if (firstList[i][1] >= secondList[j][0] && firstList[i][1] <= secondList[j][1]) {
                    tempRes.add(new int[]{secondList[j][0],firstList[i][1]});
                }
                if(firstList[i][0] < secondList[j][0]&&firstList[i][1] > secondList[j][1]){
                    tempRes.add(new int[]{secondList[j][0],secondList[j][1]});
                }
            }
        }
        int[] res[] =new int[tempRes.size()][];
        for (int i = 0; i < tempRes.size(); i++) {
            res[i]=tempRes.get(i);
        }

        return res;
    }
}
