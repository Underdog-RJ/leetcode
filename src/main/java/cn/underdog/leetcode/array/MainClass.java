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
            // 找到第一个数字
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
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,1,5,6,4] 和 k = 2
     * 输出: 5
     * 示例 2:
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
     * 输出: 4
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
            // 如果当前左边界和上次有边界相等
            if (last[1] >= current[0]) {
                if (current[1] < last[1])
                    continue;
                last[1] = current[1];
            }
            // 如果当前左边界大于上次的有边界
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
     * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * <p>
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * <p>
     * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
     * <p>
     * 说明: 
     * <p>
     * 如果题目有解，该答案即为唯一答案。
     * 输入数组均为非空数组，且长度相同。
     * 输入数组中的元素均为非负数。
     * 示例 1:
     * <p>
     * 输入:
     * gas  = [1,2,3,4,5]
     * cost = [3,4,5,1,2]
     * <p>
     * 输出: 3
     * <p>
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     * 示例 2:
     * <p>
     * 输入:
     * gas  = [2,3,4]
     * cost = [3,4,3]
     * <p>
     * 输出: -1
     * <p>
     * 解释:
     * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
     * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
     * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
     * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
     * 因此，无论怎样，你都不可能绕环路行驶一周
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/gas-station
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        System.out.println();
        int length = gas.length;
        // 从哪个加油站出发
        int i = 0;
        while (i < length) {
            int totalGasNum = 1;
            int totalGas = gas[i];
            int next = i;
            // 判断当前能到达的最远距离
            while (next < length) {
                // 如果下一个大于当前的总和则跳出Loop
                if (cost[next] > totalGas)
                    break;
                // 如果可以到达下一个并且当前达到的加油站数量达到最大则直接返回
                totalGasNum++;
                if (totalGasNum == length + 1)
                    return i;

                // 如果可以到达下一个加油站
                // 减去当前消耗的
                totalGas -= cost[next];
                // 计算下一个索引
                next = (next + 1) % length;
                // 加上下一个加油站的gas
                totalGas += gas[next];
            }
            // 添加本次i走过的最远距离
            i += totalGasNum;
        }
        return -1;
    }

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[0]
     * 示例 4：
     * <p>
     * 输入：nums = [1]
     * 输出：[1]
     *  
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
     * 图像平滑器 是大小为 3 x 3 的过滤器，用于对图像的每个单元格平滑处理，平滑处理后单元格的值为该单元格的平均灰度。
     * <p>
     * 每个单元格的  平均灰度 定义为：该单元格自身及其周围的 8 个单元格的平均值，结果需向下取整。（即，需要计算蓝色平滑器中 9 个单元格的平均值）。
     * <p>
     * 如果一个单元格周围存在单元格缺失的情况，则计算平均灰度时不考虑缺失的单元格（即，需要计算红色平滑器中 4 个单元格的平均值）。
     * <p>
     * <p>
     * <p>
     * 给你一个表示图像灰度的 m x n 整数矩阵 img ，返回对图像的每个单元格平滑处理后的图像 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * <p>
     * <p>
     * 输入:img = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出:[[0, 0, 0],[0, 0, 0], [0, 0, 0]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
     * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
     * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
     * 示例 2:
     * <p>
     * <p>
     * 输入: img = [[100,200,100],[200,50,200],[100,200,100]]
     * 输出: [[137,141,137],[141,138,141],[137,141,137]]
     * 解释:
     * 对于点 (0,0), (0,2), (2,0), (2,2): floor((100+200+200+50)/4) = floor(137.5) = 137
     * 对于点 (0,1), (1,0), (1,2), (2,1): floor((200+200+50+200+100+100)/6) = floor(141.666667) = 141
     * 对于点 (1,1): floor((50+200+200+200+200+100+100+100+100)/9) = floor(138.888889) = 138
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/image-smoother
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
                // 处理左上边界值0
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
