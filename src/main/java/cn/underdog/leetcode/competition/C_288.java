package cn.underdog.leetcode.competition;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author underdog_rj
 * @date2022/5/320:11
 */
public class C_288 {

    public static void main(String[] args) {
        C_288 c_288 = new C_288();
//        c_288.minimizeResult_1("247+38");
        c_288.maximumProduct_1(new int[]{24, 5, 64, 53, 26, 38}, 54);
    }

    public int largestInteger(int num) {
        PriorityQueue<Integer> odd = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        PriorityQueue<Integer> even = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int tmp = Integer.parseInt(str.charAt(i) + "");
            if ((tmp & 1) == 0) {
                even.add(tmp);
            } else {
                odd.add(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int tmp = Integer.parseInt(str.charAt(i) + "");
            if ((tmp & 1) == 0) {
                sb.append(even.poll());
            } else {
                sb.append(odd.poll());
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public String minimizeResult(String expression) {
        String[] split = expression.split("\\+");
        String str0 = split[0];
        String str1 = split[1];
        int min = Integer.MAX_VALUE;
        int indexI = -1;
        int indexJ = -1;
        for (int i = 0; i < str0.length(); i++) {
            String tmp1 = str0.substring(0, i);
            String tmp2 = str0.substring(i);
            for (int j = 0; j < str1.length(); j++) {
                String tmp3 = str1.substring(0, j + 1);
                String tmp4 = str1.substring(j + 1);
                int tmpSum = Integer.parseInt(tmp2) + Integer.parseInt(tmp3);
                int finalTmp = (Objects.equals("", tmp1) ? 1 : Integer.parseInt(tmp1)) * tmpSum * (Objects.equals("", tmp4) ? 1 : Integer.parseInt(tmp4));
                if (finalTmp < min) {
                    min = finalTmp;
                    indexI = i;
                    indexJ = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(indexI, "(");

        sb.insert(str0.length() + 3 + indexJ, ")");

        return sb.toString();
    }

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }
        while (k != 0) {
            Integer poll = priorityQueue.poll();
            poll++;
            priorityQueue.add(poll);
            k--;
        }
        long res = 1;
        long mod = 1000000007;
        Iterator<Integer> iterator = priorityQueue.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            res = (res * next) % mod;
        }

        return (int) res;
    }


    //            ============== 1=================
    public int largestInteger_1(int num) {
        String str = String.valueOf(num);
        PriorityQueue<Integer> priorityQueue1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> priorityQueue2 = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i) - '0';
            if ((tmp & 1) == 0) {
                priorityQueue1.add(tmp);
            } else {
                priorityQueue2.add(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i) - '0';
            if ((tmp & 1) == 0) {
                sb.append(priorityQueue1.poll());
            } else {
                sb.append(priorityQueue2.poll());
            }
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * 简单模拟：因为长度10，但是注意
     * @param expression
     * @return
     */
    public String minimizeResult_1(String expression) {
        String[] split = expression.split("\\+");
        String num1 = split[0];
        String num2 = split[1];
        int min = Integer.MAX_VALUE;
        int indexI = -1;
        int indexJ = -1;
        for (int i = 0; i < num1.length(); i++) {
            String str1 = num1.substring(0, i);
            String str2 = num1.substring(i);
            for (int j = 0; j < num2.length(); j++) {
                String str3 = num2.substring(0, j + 1);
                String str4 = num2.substring(j + 1);
                int t1 = 0;
                int t2 = 0;
                int t3 = 0;
                int t4 = 0;
                if (str1 == null || str1.equals("")) {
                    t1 = 1;
                } else {
                    t1 = Integer.parseInt(str1);
                }
                t2 = Integer.parseInt(str2);
                t3 = Integer.parseInt(str3);
                if (str4 == null || str4.equals("")) {
                    t4 = 1;
                } else {
                    t4 = Integer.parseInt(str4);
                }
                int tmp = t1 * (t2 + t3) * t4;
                if (tmp < min) {
                    indexI = i;
                    indexJ = j;
                    min = tmp;
                }
            }


        }
        StringBuilder sb = new StringBuilder(expression);
        sb.insert(indexI, "(");
        sb.insert(num1.length() + 3 + indexJ, ")");
        return sb.toString();
    }


    /**
     * 基本贪心：为了使多个数字成绩总和最大，===》》分布尽可能的平均
     *          利用小根堆特性，每次获取最小的值
     *大数问题：记得用Long,每次结束之后mod 1000000007
     * @param nums
     * @param k
     * @return
     */
    public int maximumProduct_1(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.add(num);
        }

        while (k != 0) {
            Integer poll = priorityQueue.poll();
            poll++;
            k--;
            priorityQueue.add(poll);
        }
        long res = 1;
        while (priorityQueue.size() != 0) {
            res *= priorityQueue.poll();
            res %= 1000000007;
        }

        return (int) res;
    }


}
