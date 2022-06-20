package cn.underdog.leetcode.competition;

import java.util.Arrays;

/**
 * @author underdog_rj
 * @date2022/5/320:22
 */
public class C_285 {


    public static void main(String[] args) {
        C_285 c_285 = new C_285();
//        c_285.countCollisions_1("LLRR");
//        c_285.countCollisions_1("RLRSLL");
//        c_285.maximumBobPoints_1(9, new int[]{1, 1, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0});
//        c_285.maximumBobPoints_1(9, new int[]{0, 0, 0, 0, 0, 2, 0, 5, 1, 1, 0, 0});
        c_285.maximumBobPoints_1(729, new int[]{56, 81, 32, 233, 85, 39, 15, 7, 11, 106, 59, 5});
    }

    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int current = nums[i];
            int right = i + 1;
            int left = i - 1;
            // 计算右边不等于i
            while (right < nums.length && current == nums[right]) {
                right++;
                i = right - 1;
            }
            while (left >= 0 && current == nums[left]) {
                left--;
            }
            if (left < 0 || right >= nums.length)
                continue;
            if (nums[left] < current && current > nums[right])
                count++;
            if (nums[left] > current && nums[right] > current)
                count++;
        }

        return count;
    }

    public int countCollisions(String directions) {
        int res = 0;
        int length = directions.length();
        StringBuilder sb = new StringBuilder(directions);
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) == 'S')
                continue;
            else if (sb.charAt(i) == 'R') {
                if (i + 1 == length) {
                    continue;
                }
                if (sb.charAt(i + 1) == 'L') {
                    res += 2;
                    sb.setCharAt(i + 1, 'S');
                } else if (sb.charAt(i + 1) == 'S') {
                    res++;
                } else {
                    int next = i + 1;
                    int total = 1;
                    while (next < length && sb.charAt(next) == 'R') {
                        sb.setCharAt(next, 'S');
                        next++;
                        total++;
                    }
                    i += total;
                    if (next == length)
                        continue;
                    if ('L' == sb.charAt(next))
                        res += total + 1;
                    else
                        res += total;
                    sb.setCharAt(next, 'S');

                }
            } else {
                if (i == 0) {
                    continue;
                } else {
                    if (sb.charAt(i - 1) == 'S') {
                        res++;
                        sb.setCharAt(i, 'S');
                    }
                }
            }
        }

        return res;

    }

    int globalMax = 0;
    int[] res = new int[12];

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] currentNum = new int[12];
        dfs(numArrows, aliceArrows, 11, 0, currentNum);
        return res;
    }

    private void dfs(int numArrows, int[] aliceArrows, int index, int currentTotal, int[] currentNum) {
        // 递归出口，如果当前的箭全部射出，则循环结束
        if (numArrows == 0 || index == -1) {
            if (index == -1) {
                currentNum[0] += numArrows;
            }
            if (currentTotal > globalMax) {
                globalMax = currentTotal;
                System.arraycopy(currentNum, 0, res, 0, 12);
            }
            return;
        }
        for (int i = index; i >= 0; i--) {
            // 判断Bob想要赢下当前的靶
            int cntAlice = aliceArrows[i];
            // 能够赢下
            if (numArrows - 1 >= cntAlice) {
                currentTotal += i;
                numArrows -= (cntAlice + 1);
                currentNum[i] = cntAlice + 1;
                dfs(numArrows, aliceArrows, i - 1, currentTotal, currentNum);
                numArrows += (cntAlice + 1);
                currentNum[i] = 0;
                currentTotal -= i;
            }
        }
        if (index == 0) {
            currentNum[0] += numArrows;
        }
        if (currentTotal > globalMax) {
            globalMax = currentTotal;
            System.arraycopy(currentNum, 0, res, 0, 12);
        }
    }


    public int countCollisions_1(String directions) {
        long count = 0;
        int length = directions.length();
        char[] chars = directions.toCharArray();
        for (int i = 0; i < length; i++) {
            // 向右查找第一个为L/S的坐标
            if (chars[i] == 'R') {
                int start = i + 1;
                chars[i] = 'S';
                while (start < length && chars[start] == 'R') {
                    chars[start] = 'S';
                    start++;
                }
                if (start < length && chars[start] == 'L') {
                    count += (start - i + 1);
                    chars[start] = 'S';
                } else if (start < length && chars[start] == 'S') {
                    count += start - i;
                }
                i = start;
            } else if (chars[i] == 'L') {
                int start = i - 1;
                if (start >= 0 && chars[start] == 'S') {
                    count++;
                    chars[i] = 'S';
                }
            }
        }
        return (int) count;
    }

    private int[] resMaxmum;
    private int[] cntMaxmum;
    private int maxTotal = Integer.MIN_VALUE;

    /**
     * 暴力回溯，从右边开始，模拟每一种赢的情况，只有赢的时候才进行回溯。
     *
     * @param numArrows
     * @param aliceArrows
     * @return
     */
    public int[] maximumBobPoints_1(int numArrows, int[] aliceArrows) {
        resMaxmum = new int[12];
        cntMaxmum = new int[12];
        int cntTotal = 0;
        backtrackingMaximum(numArrows, aliceArrows, cntTotal, 11);
        return resMaxmum;
    }

    private void backtrackingMaximum(int numArrows, int[] aliceArrows, int cntTotal, int startIndex) {
        if (numArrows == 0 || startIndex <= 0) {
            if (numArrows != 0) {
                cntMaxmum[0] += numArrows;
            }
            if (maxTotal < cntTotal) {
                maxTotal = cntTotal;
                resMaxmum = Arrays.copyOf(cntMaxmum, 12);
            }
            return;
        }
        for (int i = startIndex; i >= 0; i--) {
            int cntAliceArrows = aliceArrows[i];
            // 如果bob想要获得当前的得分，必须要的数量
            int winCount = cntAliceArrows + 1;
            if (numArrows >= winCount) {
                numArrows -= winCount;
                cntMaxmum[i] = winCount;
                cntTotal += i;
                backtrackingMaximum(numArrows, aliceArrows, cntTotal, i - 1);
                numArrows += winCount;
                cntMaxmum[i] = 0;
                cntTotal -= i;
            }
        }
    }


}
