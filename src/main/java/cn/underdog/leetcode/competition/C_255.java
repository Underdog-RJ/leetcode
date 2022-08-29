package cn.underdog.leetcode.competition;

import java.util.*;

public class C_255 {
    public static void main(String[] args) {
//        System.out.println(Math.pow(2, 16));
        C_255 c_255 = new C_255();
//        c_255.findDifferentBinaryString(new String[]{"10", "01"});
//        c_255.findDifferentBinaryString(new String[]{"00", "01", "10"});
//        System.out.println(c_255.minimizeTheDifference(new int[][]{{3, 5}, {5, 10}}, 47));
        System.out.println(c_255.minimizeTheDifference(new int[][]{{1, 2, 30}, {4, 6, 50}, {7, 8, 90}}, 13));
    }

    public int findGCD(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int gcd = getGCD(max, min);
        return gcd;
    }

    private int getGCD(int max, int min) {
        while (min != 0) {
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;
    }

    public String findDifferentBinaryString(String[] nums) {
        Set<String> strings = new HashSet<>();
        for (String num : nums) {
            strings.add(num);
        }
        int length = nums[0].length();
        StringBuilder sb = new StringBuilder();
        return backtrackingFindDiff(strings, length, sb);
    }

    private String backtrackingFindDiff(Set<String> strings, int length, StringBuilder sb) {
        if (sb.length() == length) {
            if (strings.contains(sb.toString())) {
                return "";
            } else {
                return sb.toString();
            }
        }
        for (int i = 0; i < 2; i++) {
            if ((i & 1) == 0)
                sb.append("0");
            else
                sb.append("1");
            String res = backtrackingFindDiff(strings, length, sb);
            if (!res.equals(""))
                return sb.toString();
            sb.deleteCharAt(sb.length() - 1);
        }
        return "";
    }

    private Integer min = Integer.MAX_VALUE;
    private int m = 0;
    private int n = 0;
    private boolean[][] memo = new boolean[71][5000];

    /**
     * 直接回溯，从每一行中选择一个数字，添加到最后一行，选择出最小值，但是此方法必然超时
     * 1.进行剪枝操作：对二维数组进行排序，在遍历每一列的操作的时候，当当前值已经大于目标值并且两者之差已经超过最小值了，就不需要进行当前层后续的遍历了，直接break，仍然超时
     * 举个例子new int[][]{{1, 2, 30}, {4, 6, 50}, {7, 8, 90}}, 13)  选择出1+6+8=15因为前面已经进行了排序的操作，所以后面的元素肯定都大于15，所以直接结束当前层
     * 2.记忆化搜索：最大行70行，目标值最大为4900（一行70个数字最大值70 ==4900）记录每一行出现的可能的值，如果当前行已经出现过了，就不需要重复操作了，仅需要一个就行
     *
     * @param mat
     * @param target
     * @return
     */
    public int minimizeTheDifference(int[][] mat, int target) {
        m = mat.length;
        n = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            Arrays.sort(mat[i]);
        }
        backtrackingMinimize(mat, target, 0, 0);
        return min;
    }

    private void backtrackingMinimize(int[][] mat, int target, int startIndex, int cnt) {
        if (startIndex == m) {
            min = Math.min(min, Math.abs(target - cnt));
            return;
        }
        if (memo[startIndex][cnt])
            return;
        memo[startIndex][cnt] = true;
        for (int i = 0; i < n; i++) {
            cnt += mat[startIndex][i];
            if (cnt - target > 0 && cnt - target > min)
                break;
            backtrackingMinimize(mat, target, startIndex + 1, cnt);
            cnt -= mat[startIndex][i];
        }
    }

    // TODO 完成分组背包模板

    /**
     * 1.全部都映射为0-4900的和，
     * 上次的全部情况为true的加上本次的可能的值，都进行映射。
     * @param mat
     * @param target
     * @return
     */
    public int minimizeTheDifference1(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;
        boolean[] flag = new boolean[4900];
        for (int i = 0; i < n; i++) {
            flag[mat[0][i]] = true;
        }
        for (int i = 1; i < m; i++) {
            boolean[] cnt = new boolean[4900];
            for (int j = 0; j < flag.length; j++) {
                if (flag[j]) {
                    for (int u = 0; u < n; u++) {
                        if (j + mat[i][u] < 4900) {
                            cnt[j + mat[i][u]] = true;
                        }
                    }
                }
            }
            flag = cnt;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) {
                min = Math.min(min, Math.abs(i - target));
            }
        }
        return min;


    }
}
