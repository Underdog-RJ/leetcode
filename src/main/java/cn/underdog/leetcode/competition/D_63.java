package cn.underdog.leetcode.competition;

import java.util.*;

public class D_63 {
    public static void main(String[] args) {

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int count = 0;
        for (int i = 0; i < seats.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }

        return count;
    }

    public boolean winnerOfGame(String colors) {
        int length = colors.length();
        if (length <= 2)
            return false;
        int count = 0;
        for (int i = 1; i < length - 1; i++) {
            if (colors.charAt(i) == 'A' && colors.charAt(i - 1) == 'A' && colors.charAt(i + 1) == 'A') {
                count++;
            } else if (colors.charAt(i) == 'B' && colors.charAt(i - 1) == 'B' && colors.charAt(i + 1) == 'B') {
                count--;
            }
        }
        return count > 0;
    }

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int length = patience.length;
        int[] dist = new int[length];
        // 用-1来标记全部为没有访问过
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        // 先遍历为0的节点
        queue.offer(0);
        // 标记0为已经访问过
        dist[0] = 0;
        // 建图
        List<Integer>[] graphs = new List[length];
        for (int i = 0; i < length; i++) {
            graphs[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graphs[edge[0]].add(edge[1]);
            graphs[edge[1]].add(edge[0]);
        }
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer integer : graphs[u]) {
                // 如果当前节点没访问过
                if (dist[integer] == -1) {
                    dist[integer] = dist[u] + 1;
                    // 当前访问节点加入
                    queue.offer(integer);
                }
            }
        }
        int max = 0;
        // 从第一个开始
        for (int i = 1; i < length; i++) {
            int ans = 0;
            // 当前节点的
            int pat = patience[i];
            int current = dist[i];
            if (current * 2 <= pat) {
                ans = current * 2 + 1;
            } else {
                ans = ((current * 2 - 1) / pat) * pat + 2 * current + 1;
            }
            max = Math.max(max, ans);

        }

        return max;
    }
}
