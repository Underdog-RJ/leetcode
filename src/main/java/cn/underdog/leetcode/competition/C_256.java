package cn.underdog.leetcode.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C_256 {

    public static void main(String[] args) {
        C_256 c_256 = new C_256();
//        c_256.kthLargestNumber(new String[]{"3", "6", "7", "10"}, 4);
        c_256.minSessions(new int[]{1, 2, 3, 4, 5}, 5);
    }

    /**
     * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
     * <p>
     * 返回 nums 中表示第 k 大整数的字符串。
     * <p>
     * 注意：重复的数字在统计时会视为不同元素考虑。例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = ["3","6","7","10"], k = 4
     * 输出："3"
     * 解释：
     * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
     * 其中第 4 大整数是 "3"
     * 示例 2：
     * <p>
     * 输入：nums = ["2","21","12","1"], k = 3
     * 输出："2"
     * 解释：
     * nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
     * 其中第 3 大整数是 "2"
     * 示例 3：
     * <p>
     * 输入：nums = ["0","0"], k = 2
     * 输出："0"
     * 解释：
     * nums 中的数字按非递减顺序排列为 ["0","0"]
     * 其中第 2 大整数是 "0"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-the-kth-largest-integer-in-the-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length1 = o1.length();
                int length2 = o2.length();
                if (length1 > length2)
                    return -1;
                else if (length1 < length2)
                    return 1;
                else {
                    for (int i = 0; i < length1; i++) {
                        if (o1.charAt(i) > o2.charAt(i))
                            return -1;
                        else if (o1.charAt(i) < o2.charAt(i))
                            return 1;
                    }
                    return 0;
                }
            }
        });
        return nums[k - 1];
    }

   /* List<Integer> cntPath = new ArrayList<>();
    Integer min = Integer.MAX_VALUE;

    public int minSessions(int[] tasks, int sessionTime) {
        boolean[] booleans = new boolean[tasks.length];
        backtrackingMin(tasks, booleans, sessionTime);
        System.out.println(min);
        return min;
    }

    private void backtrackingMin(int[] tasks, boolean[] booleans, int sessionTime) {
        if (cntPath.size() == tasks.length) {
            int tmp = 1;
            int count = sessionTime;
            for (int i = 0; i < cntPath.size(); i++) {
                if (count >= cntPath.get(i)) {
                    count -= cntPath.get(i);
                } else {
                    tmp++;
                    count = sessionTime - cntPath.get(i);
                }
            }
            min = Integer.min(tmp, min);
            return;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (booleans[i])
                continue;
            booleans[i] = true;
            cntPath.add(tasks[i]);
            backtrackingMin(tasks, booleans, sessionTime);
            booleans[i] = false;
            cntPath.remove(cntPath.size() - 1);
        }
    }*/


    /**
     * 根据698分割k个等和的子集
     * 从最小的开始模拟，从sum/sessionTime开始模拟到task.length 的长度是否可以村的下
     *
     * @param tasks
     * @param sessionTime
     * @return
     */
    public int minSessions(int[] tasks, int sessionTime) {
        int sum = Arrays.stream(tasks).sum();
        int start = sum / sessionTime > 0 ? sum / sessionTime : 1;
        Arrays.sort(tasks);
        for (int i = 0; i < tasks.length/2; i++) {
            int tmp = tasks[i];
            tasks[i] = tasks[tasks.length - i - 1];
            tasks[tasks.length - i - 1] = tmp;
        }
        for (int i = start; i < tasks.length; i++) {
            int[] edges = new int[i];
            boolean flag = backTrackingMinSession(tasks, sessionTime, edges, 0);
            if (flag)
                return i;
        }
        return -1;
    }

    private boolean backTrackingMinSession(int[] tasks, int sessionTime, int[] edges, int index) {
        if (index == tasks.length)
            return true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] + tasks[index] > sessionTime)
                continue;
            if (i > 0 && edges[i] == edges[i - 1])
                continue;
            edges[i] += tasks[index];
            if (backTrackingMinSession(tasks, sessionTime, edges, index + 1)) return true;
            edges[i] -= tasks[index];
        }
        return false;
    }

}
