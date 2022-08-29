package cn.underdog.leetcode.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D_60 {

    public static void main(String[] args) {
        D_60 d_60 = new D_60();
//        d_60.findFarmland(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}});
//        d_60.findFarmland(new int[][]{{1, 1, 0, 0, 0, 1}, {1, 1, 0, 0, 0, 0}});
        LockingTree lockingTree = new LockingTree(new int[]{-1, 0, 0, 1, 1, 2, 2});
        lockingTree.lock(2, 2);    // 返回 true ，因为节点 2 未上锁。
        // 节点 2 被用户 2 上锁。
        lockingTree.unlock(2, 3);  // 返回 false ，因为用户 3 无法解锁被用户 2 上锁的节点。
        lockingTree.unlock(2, 2);  // 返回 true ，因为节点 2 之前被用户 2 上锁。
        // 节点 2 现在变为未上锁状态。
        lockingTree.lock(4, 5);    // 返回 true ，因为节点 4 未上锁。
        // 节点 4 被用户 5 上锁。
        lockingTree.upgrade(0, 1); // 返回 true ，因为节点 0 未上锁且至少有一个被上锁的子孙节点（节点 4）。
        // 节点 0 被用户 1 上锁，节点 4 变为未上锁。
        lockingTree.lock(0, 1);    // 返回 false ，因为节点 0 已经被上锁了。
    }

    public int findMiddleIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int sum = Arrays.stream(nums).sum();
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int tail = sum - cnt - nums[i];
            if (cnt == tail) return i;
            cnt += nums[i];
        }
        return -1;
    }

    public int[][] findFarmland(int[][] land) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] ints = dfsFindFramland(land, i, j);
                    list.add(new int[]{i, j, ints[0], ints[1]});
                }
            }
        }
        int[][] res = new int[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int[] dfsFindFramland(int[][] land, int i, int j) {
        if (i >= land.length || j >= land[0].length) return new int[0];
        if (land[i][j] != 1) return new int[0];
        land[i][j] = -1;
        int maxi = i;
        int maxj = j;
        int[] behind = dfsFindFramland(land, i + 1, j);
        if (behind != null && maxi + maxj < Arrays.stream(behind).sum()) {
            maxi = behind[0];
            maxj = behind[1];
        }
        int[] right = dfsFindFramland(land, i, j + 1);
        if (right != null && maxi + maxj < Arrays.stream(right).sum()) {
            maxi = right[0];
            maxj = right[1];
        }
        return new int[]{maxi, maxj};
    }

}
