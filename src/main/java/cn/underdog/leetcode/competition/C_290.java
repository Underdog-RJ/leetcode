package cn.underdog.leetcode.competition;

import java.util.*;

/**
 * @author underdog_rj
 * @date2022/5/319:56
 */
public class C_290 {
    public static void main(String[] args) {

    }

    /**
     * 用TreeSet进行排序加去重
     * set.retainAll去重操作
     * @param nums
     * @return
     */
    public List<Integer> intersection(int[][] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int[] tmp = nums[0];
        for (int i : tmp) {
            set.add(i);
        }
        for (int i = 1; i < nums.length; i++) {
            int[] num = nums[i];
            Set<Integer> integers = new HashSet<>();
            for (int j : num) {
                integers.add(j);
            }
            set.retainAll(integers);
        }
        return new ArrayList<>(set);
    }


    /**
     *
     * @param circles
     * @return
     */
    public int countLatticePoints(int[][] circles) {
        int count = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] circle : circles) {
                    if ((circle[0] - i) * (circle[0] - i) + (circle[1] - j) * (circle[1] - j) <= (circle[2] * circle[2])) {
                        count++;
                    }
                }

            }
        }
        return count;
    }


    /*   public int[] countRectangles(int[][] rectangles, int[][] points) {
        int length = points.length;
        int[] res = new int[length];
        for (int i = 0; i < points.length; i++) {
            int n = 0;
            int[] point = points[i];
            for (int[] rectangle : rectangles) {
                if (rectangle[0] >= point[0] && rectangle[1] >= point[1]) {
                    n++;
                }
            }
            res[i] = n;
        }
        return res;
    }*/

    // TODO 超时
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = points.length;
        int length = rectangles.length;
        int[] res = new int[n];
        String[] strings1 = new String[length];
        String[] strings2 = new String[length];
        for (int i = 0; i < rectangles.length; i++) {
            int[] rectangle = rectangles[i];
            strings1[i] = rectangle[0] + "-" + rectangle[1];
            strings2[i] = rectangle[0] + "-" + rectangle[1];
        }
        Arrays.sort(strings1, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("-");
                String[] split2 = o2.split("-");
                return Integer.compare(Integer.parseInt(split1[0]), Integer.parseInt(split2[0]));
            }
        });
        Arrays.sort(strings2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("-");
                String[] split2 = o2.split("-");
                return Integer.compare(Integer.parseInt(split1[1]), Integer.parseInt(split2[1]));
            }
        });

        for (int i = 0; i < points.length; i++) {
            // x1
            int left = 0;
            int right = length - 1;
            int num1 = points[i][0];
            while (left <= right) {
                int mid = (left + right) / 2;
                int target = Integer.parseInt(strings1[mid].split("-")[0]);
                if (target > left) {
                    right = mid - 1;
                } else if (target < num1) {
                    left = mid + 1;
                } else {
                    left = mid;
                    if (left > 0) {
                        left--;
                        while (left > 0 && left == Integer.parseInt(strings1[left].split("-")[0])) {
                            left--;
                        }
                        if (left != 0 && left != Integer.parseInt(strings1[left].split("-")[0])) {
                            left++;
                        }
                    }

                    break;
                }
            }
            Set<String> set = new HashSet<>();
            for (int j = left; j < length; j++) {
                set.add(strings1[j]);
            }

            // x1
            int left1 = 0;
            int right1 = length - 1;
            int num2 = points[i][1];
            while (left1 <= right1) {
                int mid = (left1 + right1) / 2;
                int target = Integer.parseInt(strings2[mid].split("-")[1]);
                if (target > num2) {
                    right1 = mid - 1;
                } else if (target < num2) {
                    left1 = mid + 1;
                } else {
                    left1 = mid;
                    if (left1 > 0) {
                        left1--;
                        while (left1 > 0 && num2 == Integer.parseInt(strings2[left1].split("-")[1])) {
                            left1--;
                        }
                        if (left1 != 0 && num2 != Integer.parseInt(strings2[left1].split("-")[1])) {
                            left1++;
                        }
                    }

                    break;
                }
            }
            Set<String> set1 = new HashSet<>();
            for (int j = left1; j < length; j++) {
                set1.add(strings2[j]);
            }
            set.retainAll(set1);
            int size = set.size();
            res[i] = size;
        }
        return res;

    }



}
