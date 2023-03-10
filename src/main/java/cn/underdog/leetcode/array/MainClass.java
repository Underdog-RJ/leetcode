package cn.underdog.leetcode.array;

import java.util.Arrays;
import java.util.*;

public class MainClass {

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4);
//        mainClass.maximumProduct(new int[]{1, 12, -5, -6, 50, 3});
//        mainClass.maximumProduct(new int[]{1, 12, -5, -6, 50, 3});
//        mainClass.nextPermutation(new int[]{6, 5, 4});

//        mainClass.nextPermutation(new int[]{8, 3, 9, 6, 4, 7, 5, 2, 1});
//        mainClass.nextPermutation(new int[]{5, 3, 2});
//        System.out.println(mainClass.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
//        System.out.println(mainClass.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
//        System.out.println(mainClass.merge(new int[][]{{1, 3}, {2, 6}, {15, 18}, {8, 10}}));
//        System.out.println(mainClass.merge(new int[][]{{1, 4}, {4, 5}}));
//        System.out.println(mainClass.merge(new int[][]{{2, 3}, {4, 5}, {4, 7}, {8, 9}, {1, 10}}));
//        System.out.println(mainClass.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}));
//        System.out.println(mainClass.merge(new int[][]{{1, 4}, {2, 3}}));
//        System.out.println(mainClass.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
//        System.out.println(mainClass.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
//        mainClass.sortColors(new int[]{0, 1, 2, 0, 2, 1});
        mainClass.imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}});
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;

            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public double findMaxAverage(int[] nums, int k) {
        int temp = 0;
        double res = 0.0;
        for (int i = 0; i < k; i++) {
            temp += nums[i];
        }
        res = (double) temp / k;
        double max = res;

        for (int i = 1; i <= nums.length - k; i++) {
            temp -= nums[i - 1];
            temp += nums[i + k - 1];
            res = (double) temp / k;
            if (max < res) {
                max = res;
            }
        }

        return max;
    }

    public int maximumProduct(int[] nums) {
       /* int max = Integer.MIN_VALUE;
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int u = j + 1; u < nums.length; u++) {
                    temp = nums[i] * nums[j] * nums[u];
                    if (temp > max) {
                        max = temp;
                    }
                }
            }
        }*/
        int l = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[l - 1] * nums[l - 2] * nums[l - 3], nums[0] * nums[1] * nums[l - 1]);
    }


    public void nextPermutation(int[] nums) {
        int length = nums.length - 1;
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = length; i > 0; i--) {
            // ?????????????????????
            if (nums[i] <= nums[i - 1]) {
                list.add(nums[i]);
            } else {
                flag = true;
                int current = nums[i - 1];
                list.add(nums[i]);
                int value = 0;
                int index = 0;
                for (int u = 0; u < list.size(); u++) {
                    if (list.get(u) > current) {
                        value = list.get(u);
                        index = u;
                        break;
                    }
                }
                list.remove(index);
                list.add(index, current);
                nums[i - 1] = value;
                int temp = i;
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    nums[temp++] = iterator.next();
                }
                break;
            }
        }
        if (!flag) {
            list.add(nums[0]);
            int index = 0;
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                nums[index++] = iterator.next();
            }
        }
    }

    /**
     * ?????????????????? nums ????????? k???????????????????????? k ?????????????????????
     * <p>
     * ??????????????????????????????????????????????????? k ????????????????????????????????? k ?????????????????????
     * <p>
     * ??
     * <p>
     * ?????? 1:
     * <p>
     * ??????: [3,2,1,5,6,4] ??? k = 2
     * ??????: 5
     * ????????2:
     * <p>
     * ??????: [3,2,3,1,2,4,5,5,6] ??? k = 4
     * ??????: 4
     * ??
     * <p>
     * ??????????????????LeetCode???
     * ?????????https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * ??????????????????????????????????????????????????????????????????????????????????????????????????????
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int index = nums.length - k;
        return nums[index];
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    int t1 = o1[0] + o1[1];
                    int t2 = o2[0] + o2[1];
                    int temp = t1 - t2;
                    if (temp > 0)
                        return 1;
                    else if (temp < 0)
                        return -1;
                    else if (temp == 0)
                        return 0;
                }
                return 0;
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] last = list.get(list.size() - 1);
            // ?????????????????????????????????????????????
            if (last[1] >= current[0]) {
                if (current[1] < last[1])
                    continue;
                last[1] = current[1];
            }
            // ?????????????????????????????????????????????
            else if (last[1] < current[0]) {
                list.add(current);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] ints = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            System.arraycopy(intervals[i], 0, ints[i], 0, intervals[i].length);
        }
        ints[intervals.length] = newInterval;
        return merge(intervals);
    }


    /**
     * ???????????????????????N????????????????????????????i?????????????????????????gas[i]????????
     * <p>
     * ??????????????????????????????????????????????????? i ????????????????????? i+1??????????????????????????????????cost[i]???????????????????????????????????????????????????????????????????????
     * <p>
     * ?????????????????????????????????????????????????????????????????????????????????????????? -1???
     * <p>
     * ??????:??
     * <p>
     * ???????????????????????????????????????????????????
     * ???????????????????????????????????????????????????
     * ??????????????????????????????????????????
     * ????????1:
     * <p>
     * ??????:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * <p>
     * ??????: 3
     * <p>
     * ??????:
     * ??? 3 ????????????(????????? 3 ???)?????????????????? 4 ??????????????????????????? = 0 + 4 = 4 ?????????
     * ?????? 4 ?????????????????????????????? 4 - 1 + 5 = 8 ?????????
     * ?????? 0 ?????????????????????????????? 8 - 2 + 1 = 7 ?????????
     * ?????? 1 ?????????????????????????????? 7 - 3 + 2 = 6 ?????????
     * ?????? 2 ?????????????????????????????? 6 - 4 + 3 = 5 ?????????
     * ?????? 3 ?????????????????????????????? 5 ???????????????????????????????????? 3 ???????????????
     * ?????????3 ?????????????????????
     * ?????? 2:
     * <p>
     * ??????:
     * gas  = [2,3,4]
     * cost = [3,4,3]
     * <p>
     * ??????: -1
     * <p>
     * ??????:
     * ???????????? 0 ?????? 1 ??????????????????????????????????????????????????????????????????????????????????????????
     * ????????? 2 ????????????????????????????????? 4 ???????????? ??????????????? = 0 + 4 = 4 ?????????
     * ?????? 0 ?????????????????????????????? 4 - 3 + 2 = 3 ?????????
     * ?????? 1 ?????????????????????????????? 3 - 3 + 3 = 3 ?????????
     * ??????????????? 2 ??????????????????????????????????????? 4 ???????????????????????????????????? 3 ????????????
     * ????????????????????????????????????????????????????????????
     * <p>
     * ??????????????????LeetCode???
     * ?????????https://leetcode-cn.com/problems/gas-station
     * ??????????????????????????????????????????????????????????????????????????????????????????????????????
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        System.out.println();
        int length = gas.length;
        // ????????????????????????
        int i = 0;
        while (i < length) {
            int totalGasNum = 1;
            int totalGas = gas[i];
            int next = i;
            // ????????????????????????????????????
            while (next < length) {
                // ?????????????????????????????????????????????Loop
                if (cost[next] > totalGas)
                    break;
                // ??????????????????????????????????????????????????????????????????????????????????????????
                totalGasNum++;
                if (totalGasNum == length + 1)
                    return i;

                // ????????????????????????????????????
                // ?????????????????????
                totalGas -= cost[next];
                // ?????????????????????
                next = (next + 1) % length;
                // ???????????????????????????gas
                totalGas += gas[next];
            }
            // ????????????i?????????????????????
            i += totalGasNum;
        }
        return -1;
    }

    /**
     * ?????????????????????????????????????????????????????n ???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * <p>
     * ?????????????????????????????? 0?????1 ??? 2 ???????????????????????????????????????
     * <p>
     * ??
     * <p>
     * ?????? 1???
     * <p>
     * ?????????nums = [2,0,2,1,1,0]
     * ?????????[0,0,1,1,2,2]
     * ?????? 2???
     * <p>
     * ?????????nums = [2,0,1]
     * ?????????[0,1,2]
     * ?????? 3???
     * <p>
     * ?????????nums = [0]
     * ?????????[0]
     * ?????? 4???
     * <p>
     * ?????????nums = [1]
     * ?????????[1]
     * ??
     * <p>
     * ??????????????????LeetCode???
     * ?????????https://leetcode-cn.com/problems/sort-colors
     * ??????????????????????????????????????????????????????????????????????????????????????????????????????
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        for (int j = index; j < length; j++) {
            if (nums[j] == 1) {
                int temp = nums[index];
                nums[index] = nums[j];
                nums[j] = temp;
                index++;
            }
        }
    }

    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];
                res++;
            }
        }
        return res;
    }

    /**
     * ??????????????? ??????????????3 x 3 ??????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
     * <p>
     * ???????????????????? ???????????? ????????????????????????????????????????????? 8 ?????????????????????????????????????????????????????????????????????????????????????????? 9 ??????????????????????????????
     * <p>
     * ?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????? 4 ??????????????????????????????
     * <p>
     * <p>
     * <p>
     * ????????????????????????????????? m x n ???????????? img ?????????????????????????????????????????????????????????????????
     * <p>
     * ??
     * <p>
     * ?????? 1:
     * <p>
     * <p>
     * <p>
     * ??????:img = [[1,1,1],[1,0,1],[1,1,1]]
     * ??????:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
     * ??????:
     * ????????? (0,0), (0,2), (2,0), (2,2): ??????(3/4) = ??????(0.75) = 0
     * ????????? (0,1), (1,0), (1,2), (2,1): ??????(5/6) = ??????(0.83333333) = 0
     * ????????? (1,1): ??????(8/9) = ??????(0.88888889) = 0
     * ?????? 2:
     * <p>
     * <p>
     * ??????: img = [[100,200,100],[200,50,200],[100,200,100]]
     * ??????: [[137,141,137],[141,138,141],[137,141,137]]
     * ??????:
     * ????????? (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
     * ????????? (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
     * ????????? (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
     * <p>
     * ??????????????????LeetCode???
     * ?????????https://leetcode-cn.com/problems/image-smoother
     * ??????????????????????????????????????????????????????????????????????????????????????????????????????
     *
     * @param img
     * @return
     */
   /* public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][];
        for (int i = 0; i < img.length; i++) {
            int[] ints = img[i];
            res[i] = new int[ints.length];
            for (int j = 0; j < ints.length; j++) {
                // ?????????????????????0
                if (i == 0) {
                    if (j == 0) {
                        int count = img[i][j] + img[i][j + 1] + img[i + 1][j] + img[i + 1][j + 1];
                        res[i][j] = count / 4;
                    } else if (j == ints.length - 1) {
                        int count = img[i][j] + img[i][j - 1] + img[i + 1][j - 1] + img[i + 1][j];
                        res[i][j] = count / 4;
                    } else {
                        int count = img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i + 1][j - 1] + img[i + 1][j] + img[i + 1][j + 1];
                        res[i][j] = count / 6;
                    }
                } else if (i == img.length - 1) {
                    if (j == 0) {
                        int count = img[i][j] + img[i][j + 1] + img[i - 1][j] + img[i - 1][j + 1];
                        res[i][j] = count / 4;
                    } else if (j == ints.length - 1) {
                        int count = img[i][j] + img[i][j - 1] + img[i - 1][j - 1] + img[i - 1][j];
                        res[i][j] = count / 4;
                    } else {
                        int count = img[i][j] + img[i][j - 1] + img[i][j + 1] + img[i - 1][j - 1] + img[i - 1][j] + img[i - 1][j + 1];
                        res[i][j] = count / 6;
                    }
                } else if (j == 0) {
                    int count = img[i][j] + img[i - 1][j] + img[i - 1][j + 1] + img[i][j + 1] + img[i + 1][j] + img[i + 1][j + 1];
                    res[i][j] = count / 6;
                } else if (j == ints.length - 1) {
                    int count = img[i][j] + img[i][j - 1] + img[i - 1][j - 1] + img[i - 1][j] + img[i + 1][j - 1] + img[i + 1][j];
                    res[i][j] = count / 6;
                } else {
                    int count = img[i][j] + img[i][j + 1] + img[i][j - 1] + img[i - 1][j] + img[i - 1][j - 1] + img[i - 1][j + 1] + img[i + 1][j] + img[i + 1][j - 1] + img[i + 1][j + 1];
                    res[i][j] = count / 9;
                }
            }
        }

        return res;
    }*/
    public int[][] imageSmoother(int[][] img) {
        int[][] res = new int[img.length][img[0].length];
        int row = img.length;
        int col = img[0].length;
        int[][] dirs = new int[][]{{0, 0}, {0, 1}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 0}, {1, 1}};
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int total = 0;
                int cnt = 0;
                for (int[] dir : dirs) {
                    int cntI = i + dir[0];
                    int cntJ = j + dir[1];
                    if (cntJ < 0 || cntI < 0 || cntI >= row || cntJ >= col)
                        continue;
                    cnt++;
                    total += img[cntI][cntJ];
                }
                res[i][j] = total / cnt;
            }
        }
        return res;
    }
}
