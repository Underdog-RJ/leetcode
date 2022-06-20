package cn.underdog.leetcode.competition;

import java.util.*;
import java.util.PriorityQueue;

/**
 * @author underdog_rj
 * @date2022/5/320:59
 */
public class D_70 {
    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : cost) {
            priorityQueue.add(i);
        }
        int total = 0;
        while (priorityQueue.size() != 0) {
            if (priorityQueue.size() > 2) {
                total += priorityQueue.poll() + priorityQueue.poll();
                priorityQueue.poll();
            } else if (priorityQueue.size() == 2) {
                total += priorityQueue.poll() + priorityQueue.poll();
            } else {
                total += priorityQueue.poll();
            }
        }
        return total;
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int tmp = lower;
        int min = tmp;
        int max = tmp;
        for (int i = 0; i < differences.length; i++) {
            // 计算当前值
            tmp += differences[i];
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }
        if (min > upper)
            return 0;
        if (max < lower)
            return 0;
        if (max > upper)
            return 0;
        int num1 = lower - min;
        int num2 = max + num1;
        int num3 = upper - num2;
        return num3 + 1 > 0 ? num3 + 1 : 0;
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        // 使用优先队列判断 0为距离1为价格，2为x,3为y
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                if (o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
                if (o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
                return Integer.compare(o1[3], o2[3]);
            }
        });

        List<List<Integer>> res = new ArrayList<>();
        // bfs+小根堆
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        int rowLength = grid.length;
        int colLengh = grid[0].length;
        // 当前已经遍历遍历过的
        boolean[][] flag = new boolean[rowLength][colLengh];
        flag[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            // 判断当前的情况
            int cntRow = poll[0];
            int cntCol = poll[1];
            int cntCount = poll[2];
            int cntPrice = grid[cntRow][cntCol];
            // 当前感兴趣
            if (cntPrice >= pricing[0] && cntPrice <= pricing[1]) {
                priorityQueue.add(new int[]{cntCount, cntPrice, cntRow, cntCol});
            }
            // 计算四个点坐标
            int num1 = cntRow - 1;
            int num2 = cntRow + 1;
            int num3 = cntCol - 1;
            int num4 = cntCol + 1;
            // 上
            if (num1 >= 0 && !flag[num1][cntCol] && grid[num1][cntCol] != 0) {
                queue.add(new int[]{num1, cntCol, cntCount + 1});
                flag[num1][cntCol] = true;
            }
            // 下
            if (num2 < rowLength && !flag[num2][cntCol] && grid[num2][cntCol] != 0) {
                queue.add(new int[]{num2, cntCol, cntCount + 1});
                flag[num2][cntCol] = true;
            }
            // 左
            if (num3 >= 0 && !flag[cntRow][num3] && grid[cntRow][num3] != 0) {
                queue.add(new int[]{cntRow, num3, cntCount + 1});
                flag[cntRow][num3] = true;
            }
            // 右
            if (num4 < colLengh && !flag[cntRow][num4] && grid[cntRow][num4] != 0) {
                queue.add(new int[]{cntRow, num4, cntCount + 1});
                flag[cntRow][num4] = true;
            }
        }
        while (k != 0 && priorityQueue.size() != 0) {
            int[] poll = priorityQueue.poll();
            res.add(List.of(poll[2], poll[3]));
            k--;
        }
        return res;
    }
}
