package cn.underdog.leetcode.competition;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class C_268 {

    public static void main(String[] args) {

    }

    /**
     * 街上有 n 栋房子整齐地排成一列，每栋房子都粉刷上了漂亮的颜色。给你一个下标从 0 开始且长度为 n 的整数数组 colors ，其中 colors[i] 表示第  i 栋房子的颜色。
     *
     * 返回 两栋 颜色 不同 房子之间的 最大 距离。
     *
     * 第 i 栋房子和第 j 栋房子之间的距离是 abs(i - j) ，其中 abs(x) 是 x 的绝对值。
     *
     *  
     *
     * 示例 1：
     *
     *
     *
     * 输入：colors = [1,1,1,6,1,1,1]
     * 输出：3
     * 解释：上图中，颜色 1 标识成蓝色，颜色 6 标识成红色。
     * 两栋颜色不同且距离最远的房子是房子 0 和房子 3 。
     * 房子 0 的颜色是颜色 1 ，房子 3 的颜色是颜色 6 。两栋房子之间的距离是 abs(0 - 3) = 3 。
     * 注意，房子 3 和房子 6 也可以产生最佳答案。
     * 示例 2：
     *
     *
     *
     * 输入：colors = [1,8,3,8,3]
     * 输出：4
     * 解释：上图中，颜色 1 标识成蓝色，颜色 8 标识成黄色，颜色 3 标识成绿色。
     * 两栋颜色不同且距离最远的房子是房子 0 和房子 4 。
     * 房子 0 的颜色是颜色 1 ，房子 4 的颜色是颜色 3 。两栋房子之间的距离是 abs(0 - 4) = 4 。
     * 示例 3：
     *
     * 输入：colors = [0,1]
     * 输出：1
     * 解释：两栋颜色不同且距离最远的房子是房子 0 和房子 1 。
     * 房子 0 的颜色是颜色 0 ，房子 1 的颜色是颜色 1 。两栋房子之间的距离是 abs(0 - 1) = 1 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/two-furthest-houses-with-different-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param colors
     * @return
     */
    public int maxDistance(int[] colors) {
        List<Integer>[] lists = new List[101];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < colors.length; i++) {
            int color = colors[i];
            lists[color].add(i);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lists.length; i++) {
            List<Integer> list1 = lists[i];
            for (int j = i + 1; j < lists.length; j++) {
                List<Integer> list2 = lists[j];
                for (Integer integer : list1) {
                    for (Integer integer1 : list2) {
                        max = Math.max(max, Math.abs(integer - integer1));
                    }
                }
            }
        }
        return max;
    }

    /**
     * 你打算用一个水罐给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，第 i 株植物的位置是 x = i 。x = -1 处有一条河，你可以在那里重新灌满你的水罐。
     *
     * 每一株植物都需要浇特定量的水。你将会按下面描述的方式完成浇水：
     *
     * 按从左到右的顺序给植物浇水。
     * 在给当前植物浇完水之后，如果你没有足够的水 完全 浇灌下一株植物，那么你就需要返回河边重新装满水罐。
     * 你 不能 提前重新灌满水罐。
     * 最初，你在河边（也就是，x = -1），在 x 轴上每移动 一个单位 都需要 一步 。
     *
     * 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。另有一个整数 capacity 表示水罐的容量，返回浇灌所有植物需要的 步数 。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：plants = [2,2,3,3], capacity = 5
     * 输出：14
     * 解释：从河边开始，此时水罐是装满的：
     * - 走到植物 0 (1 步) ，浇水。水罐中还有 3 单位的水。
     * - 走到植物 1 (1 步) ，浇水。水罐中还有 1 单位的水。
     * - 由于不能完全浇灌植物 2 ，回到河边取水 (2 步)。
     * - 走到植物 2 (3 步) ，浇水。水罐中还有 2 单位的水。
     * - 由于不能完全浇灌植物 3 ，回到河边取水 (3 步)。
     * - 走到植物 3 (4 步) ，浇水。
     * 需要的步数是 = 1 + 1 + 2 + 3 + 3 + 4 = 14 。
     * 示例 2：
     *
     * 输入：plants = [1,1,1,4,2,3], capacity = 4
     * 输出：30
     * 解释：从河边开始，此时水罐是装满的：
     * - 走到植物 0，1，2 (3 步) ，浇水。回到河边取水 (3 步)。
     * - 走到植物 3 (4 步) ，浇水。回到河边取水 (4 步)。
     * - 走到植物 4 (5 步) ，浇水。回到河边取水 (5 步)。
     * - 走到植物 5 (6 步) ，浇水。
     * 需要的步数是 = 3 + 3 + 4 + 4 + 5 + 5 + 6 = 30 。
     * 示例 3：
     *
     * 输入：plants = [7,7,7,7,7,7,7], capacity = 8
     * 输出：49
     * 解释：每次浇水都需要重新灌满水罐。
     * 需要的步数是 = 1 + 1 + 2 + 2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 = 49 。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/watering-plants
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param plants
     * @param capacity
     * @return
     */
    public int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int init = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (capacity >= plants[i]) {
                res++;
                capacity -= plants[i];
            } else {
                capacity = init;
                res += i + i + 1;
                capacity -= plants[i];
            }
        }

        return res;
    }
}
