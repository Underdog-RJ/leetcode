package cn.underdog.leetcode.competition;

import java.util.*;

public class D_78 {
    public static void main(String[] args) {
        D_78 c_293 = new D_78();
//        c_293.divisorSubstrings(240, 2);
//        c_293.divisorSubstrings(430043, 2);
//        c_293.waysToSplitArray(new int[]{10, 4, -8, 7});
//        c_293.maximumWhiteTiles(new int[][]{{8051, 8057}, {8074, 8089}, {7994, 7995}, {7969, 7987}, {8013, 8020}, {8123, 8139}, {7930, 7950}, {8096, 8104}, {7917, 7925}, {8027, 8035}, {8003, 8011}}
//                , 9854);
        c_293.maximumWhiteTiles(new int[][]{{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}}, 10);
//        c_293.maximumWhiteTiles(new int[][]{{3745, 3757}, {3663, 3681}, {3593, 3605}, {3890, 3903}, {3529, 3539}, {3684, 3686}, {3023, 3026}, {2551, 2569}, {3776, 3789}, {3243, 3256}, {3477, 3497}, {2650, 2654}, {2264, 2266}, {2582, 2599}, {2846, 2863}, {2346, 2364}, {3839, 3842}, {3926, 3935}, {2995, 3012}, {3152, 3167}, {4133, 4134}, {4048, 4058}, {3719, 3730}, {2498, 2510}, {2277, 2295}, {4117, 4128}, {3043, 3054}, {3394, 3402}, {3921, 3924}, {3500, 3514}, {2789, 2808}, {3291, 3294}, {2873, 2881}, {2760, 2760}, {3349, 3362}, {2888, 2899}, {3802, 3822}, {3540, 3542}, {3128, 3142}, {2617, 2632}, {3979, 3994}, {2780, 2781}, {3213, 3233}, {3099, 3113}, {3646, 3651}, {3956, 3963}, {2674, 2691}, {3860, 3873}, {3363, 3370}, {2727, 2737}, {2453, 2471}, {4011, 4031}, {3566, 3577}, {2705, 2707}, {3560, 3565}, {3454, 3456}, {3655, 3660}, {4100, 4103}, {2382, 2382}, {4032, 4033}, {2518, 2531}, {2739, 2749}, {3067, 3079}, {4068, 4074}, {2297, 2312}, {2489, 2490}, {2954, 2974}, {2400, 2418}, {3271, 3272}, {3628, 3632}, {3372, 3377}, {2920, 2940}, {3315, 3330}, {3417, 3435}, {4146, 4156}, {2324, 2340}, {2426, 2435}, {2373, 2376}, {3621, 3626}, {2826, 2832}, {3937, 3949}, {3178, 3195}, {4081, 4082}, {4092, 4098}, {3688, 3698}}
//                , 1638);
    }

    public int divisorSubstrings(int num, int k) {
        String str = String.valueOf(num);
        int res = 0;
        for (int i = 0; i <= str.length() - k; i++) {
            int tmp = Integer.parseInt(str.substring(i, i + k));
            if (tmp == 0) {
                continue;
            }
            if (num % tmp == 0) {
                res++;
            }
        }
        return res;
    }


    public int waysToSplitArray(int[] nums) {
        int length = nums.length;
        long[] preSum = new long[length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        long res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            long left = preSum[i];
            long right = preSum[length - 1] - left;
            if (left >= right) {
                res++;
            }
        }
        return (int) res;
    }

    /*public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] tile : tiles) {
            for (int i = tile[0]; i <= tile[1]; i++) {
                set.add(i);
            }
        }
        int max = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            int left = i;
            int right = list.size() - 1;
            int target = list.get(i) + carpetLen - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                int num1 = list.get(mid);
                if (num1 > target) {
                    right = mid - 1;
                } else if (num1 < target) {
                    left = mid + 1;
                } else {
                    left = mid;
                    break;
                }
            }
            int tmp = left - i;
            if (target >= list.get(list.size() - 1)) {
                tmp++;
            }
            max = Math.max(max, tmp);
        }
        return max;
    }*/

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        int max = 0;
        Arrays.sort(tiles, ((o1, o2) -> o1[0] - o2[0]));
        int length = tiles.length;
        int[] preSum = new int[length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + tiles[i - 1][1] - tiles[i - 1][0] + 1;
        }
        for (int i = 0; i < tiles.length; i++) {
            int left = i;
            int right = length;
            int target = tiles[i][0] + carpetLen - 1;
            int index = binary_find(left, right, target, tiles);
            if (tiles[index][1] > target) {
                max = Math.max(max, preSum[index] - preSum[i] + target - tiles[index][0] + 1);
            } else {
                max = Math.max(max, preSum[index + 1] - preSum[i]);
            }
        }
        return max;
    }

    private int binary_find(int left, int right, int target, int[][] tiles) {
        while (left < right) {
            int mid = (left + right) >> 1;
            if (tiles[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left-1;
    }


}
