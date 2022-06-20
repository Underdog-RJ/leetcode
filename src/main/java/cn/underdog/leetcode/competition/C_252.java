package cn.underdog.leetcode.competition;

import java.util.PriorityQueue;

public class C_252 {

    public static void main(String[] args) {
        C_252 c_252 = new C_252();
//        c_252.numberOfWeeks(new int[]{5, 7, 5, 7, 9, 7});
        c_252.minimumPerimeter1(1000);
    }

    public long numberOfWeeks(int[] milestones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int milestone : milestones) {
            priorityQueue.add(milestone);
        }
        long res = 0;
        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.size() == 1) {
                priorityQueue.poll();
                res++;
            } else {
                Integer num1 = priorityQueue.poll();
                Integer num2 = priorityQueue.poll();
                if (num1 != num2) {
                    priorityQueue.add(num1 - num2);
                }
                res += num2 * 2;
            }
        }
        return res;
    }

    public long minimumPerimeter(long neededApples) {
        if (neededApples <= 12)
            return 8;
        long count = 2;
        long start = 0;
        while (count < neededApples) {
            // 计算本层
            long half = start / 2;
            long half1 = half / 2;
//            count += 2l * ((2l * half + half) * (half + 1) - half) + 2l * ((2l * half1 + half1) * (half1 + 1) - half1);
            long num1 = 2l * ((2l * half + half) * (half + 1) - half);
            long num2 = 2l * ((2l * half1 + half1) * (half1 + 1) - half1);
            count += num1 + num2;
            System.out.println(count);
            start += 2;
        }
        return (start - 2) * 4;
    }

    public long minimumPerimeter1(long neededApples) {
        for (long i = 1;; i++) {
            System.out.println(2 * i * (i + 1) * (2 * i + 1));
            if (2 * i * (i + 1) * (2 * i + 1) >= neededApples) {
                System.out.println(2 * i * (i + 1) * (2 * i + 1));
                return 8 * i;
            }
        }
    }
    /**
     * 12
     * 60
     * 168
     * 360
     * 660
     * 1092
     * 1092
     *
     * 2
     * 12
     * 54
     * 130
     * 274
     * 476
     * 782
     * 1170
     * Process finished with exit code 0
     */
}
