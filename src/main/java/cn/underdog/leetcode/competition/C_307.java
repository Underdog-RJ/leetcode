package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.math.BigInteger;
import java.util.*;

public class C_307 {

    public static void main(String[] args) {
        C_307 c_307 = new C_307();
//        c_307.minNumberOfHours(5, 3, new int[]{1, 4, 3, 2}, new int[]{2, 6, 3, 1});
//        System.out.println(c_307.largestPalindromic("5736732"));
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(10);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(2);
        treeNode.left = treeNode1;

//        c_307.amountOfTime(treeNode, 1);
//        long lcm = c_307.lcm(50, 70);
//        System.out.println(lcm);
//        c_307.minOperations(new int[]{50, 75, 100});
        c_307.minOperations(new int[]{1, 1});
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sum = Arrays.stream(energy).sum();
        int res = 0;
        res += Math.max(0, sum - initialEnergy + 1);
        int[] target = new int[energy.length];
        target[0] = initialExperience;
        int max = 0;
        for (int i = 1; i < target.length; i++) {
            target[i] = target[i - 1] + experience[i - 1];
        }
        for (int i = 0; i < target.length; i++) {
            if (target[i] <= experience[i]) {
                max = Math.max(max, experience[i] - target[i] + 1);
            }
        }
        res += max;
        return res;
    }

    public String largestPalindromic(String num) {
        long[] ints = new long[10];
        for (int i = 0; i < num.length(); i++) {
            ints[num.charAt(i) - '0']++;
        }
        TreeMap<Integer, Long> even = new TreeMap<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                even.put(i, ints[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        int max = -1;
        while (!even.isEmpty()) {
            Map.Entry<Integer, Long> entry = even.pollLastEntry();
            Long value = entry.getValue();
            if (!flag && (value & 1) == 1) {
                max = entry.getKey();
                flag = true;
            }
            for (long i = 0; i < value / 2; i++) {
                sb.append(entry.getKey());
            }
        }
        int start = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                start++;
            } else {
                break;
            }
        }
        sb.delete(0, start);
        String s = sb.toString();
        if (s.equals("") && max == -1) return "0";
        String s1 = sb.reverse().toString();
        if (max == -1) {
            return s + s1;
        } else {
            return s + max + s1;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        List<Integer>[] edges = new List[110000];
        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<>();
        }
        build(root, edges);
        int res = 0;
        boolean[] visited = new boolean[110000];
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> edge = edges[start];
        visited[start] = true;
        for (Integer integer : edge) {
            visited[integer] = true;
            queue.add(new int[]{integer, 1});
        }
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            res = Math.max(res, poll[1]);
            List<Integer> edge1 = edges[poll[0]];
            for (Integer integer : edge1) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.add(new int[]{integer, poll[1] + 1});
                }
            }
        }
        return res;
    }


    private void build(TreeNode root, List<Integer>[] edges) {
        if (root != null) {
            int rootVal = root.val;
            if (root.left != null) {
                edges[rootVal].add(root.left.val);
                edges[root.left.val].add(rootVal);
            }
            if (root.right != null) {
                edges[rootVal].add(root.right.val);
                edges[root.right.val].add(rootVal);
            }
            build(root.left, edges);
            build(root.right, edges);
        }
    }

    /**
     * 校运动会上，所有参赛同学身上都贴有他的参赛号码。某班参赛同学的号码记于数组 nums 中。假定反转后的号码称为原数字的「镜像号码」。如果 两位同学 满足条件：镜像号码 A + 原号码 B = 镜像号码 B + 原号码 A，则这两位同学可以到广播站兑换一次读通讯稿的机会，为同班同学加油助威。请返回所有参赛同学可以组成的可以读通讯稿的组数，并将结果对10^9+7取余。
     *
     * 注意：
     *
     * 镜像号码中如存在前置零，则忽略前置零。
     * 同一位同学可有多次兑换机会。
     * 示例 1：
     *
     * 输入：nums = [17,28,39,71]
     *
     * 输出：3
     *
     * 解释：
     * 共有三对同学，分别为 [17,28]、[17,39]、[28,39]。其中：
     * 第一对同学：17 + 82 = 71 + 28；
     * 第二对同学：17 + 93 = 71 + 39；
     * 第三对同学：28 + 93 = 82 + 39。
     *
     * 示例 2：
     *
     * 输入：nums = [71, 60]
     *
     * 输出：1
     *
     * 解释：
     * 共有一对同学，为 [71, 60]。
     * 因为 71 + 6 = 17 + 60，此处 60 的镜像号码为 6，前导零被忽略。
     *
     * 提示：
     *
     * 0 <= nums.length <= 10^6
     * 0 <= nums[i] <= 10^9
     * @param nums
     * @return
     */
   public int numberOfPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i] - Integer.parseInt(new StringBuilder(nums[i] + "").reverse().toString());
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        long res = 0;
        int mod = 1000000007;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value >= 2) {
                res += (long) value * (value - 1) / 2;
                res %= mod;
            }
        }
        return (int) res;
    }

    /**
     * 最近的降雨，使田地中的一些地方出现了积水，field[i][j] 表示田地第 i 行 j 列的位置有：
     *
     * 若为 W, 表示该位置为积水；
     * 若为 ., 表示该位置为旱地。
     * 已知一些相邻的积水形成了若干个池塘，若以 W 为中心的八个方向相邻积水视为同一片池塘。
     *
     * 请返回田地中池塘的数量。
     *
     * 示例 1：
     *
     * 输入: field = [".....W",".W..W.","....W.",".W....","W.WWW.",".W...."]
     *
     * 输出：3
     *
     * 解释：如下图所示，共有 3 个池塘：
     * image.png
     *
     * 示例 2：
     *
     * 输入: field = ["W....W",".W..W.","..W.W.","W..W..","W.W...",".W...."]
     *
     * 输出：1
     *
     * 解释：如下图所示，共有 1 个池塘：
     * image.png
     *
     * 提示：
     *
     * 1 <= field.length, field[i].length <= 100
     * field 中仅包含 W 和 .
     * @param field
     * @return
     */
    public int lakeCount(String[] field) {
        int res = 0;
        int m = field.length, n = field[0].length();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (field[i].charAt(j) == 'W' && !visited[i][j]) {
                    res++;
                    dfsLC(field, i, j, visited);
                }
            }
        }
        return res;
    }

    private void dfsLC(String[] field, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= field.length || j >= field[0].length()) return;
        if (visited[i][j]) return;
        if (field[i].charAt(j) == 'W') {
            visited[i][j] = true;
            dfsLC(field, i - 1, j - 1, visited);
            dfsLC(field, i - 1, j, visited);
            dfsLC(field, i - 1, j + 1, visited);
            dfsLC(field, i, j - 1, visited);
            dfsLC(field, i, j + 1, visited);
            dfsLC(field, i + 1, j - 1, visited);
            dfsLC(field, i + 1, j, visited);
            dfsLC(field, i + 1, j + 1, visited);
        }
    }

    public int minOperations1(int[] numbers) {
        BigInteger lcm = BigInteger.ONE;
        for (int number : numbers) {
            lcm = lcm.multiply(BigInteger.valueOf(number)).divide(lcm.gcd(BigInteger.valueOf(number)));
        }
        int count = 0;
        for (long number : numbers) {
            BigInteger x = lcm.divide(BigInteger.valueOf(number));
            while (x.compareTo(BigInteger.valueOf(0)) > 0 && x.mod(BigInteger.valueOf(3)).equals(BigInteger.ZERO)) {
                x = x.divide(BigInteger.valueOf(3));
                count++;
            }
            while (x.compareTo(BigInteger.valueOf(0)) > 0 && x.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                x = x.divide(BigInteger.valueOf(2));
                count++;
            }
            if (!x.equals(BigInteger.ONE)) {
                return -1;
            }
        }
        return count;
    }

    /**
     * 九坤-04. 筹码游戏
     * 通过的用户数18
     * 尝试过的用户数39
     * 用户总通过次数21
     * 用户总提交次数152
     * 题目难度Hard
     * 九坤很喜欢玩德州扑克，但是有一个神奇的周五，大家都去加班了，于是九坤只能研究起了桌上的筹码。
     *
     * 他把所有的筹码都放入了一个纸箱中，并按以下规则向外抽取筹码：
     *
     * 每次抽取仅取出 1 个筹码
     * 如果对本次取出的筹码不满意，会将该筹码放回并重新抽取，直到确定想要这个筹码。
     * 对于取出的筹码，他会将相同面值的筹码放在一堆
     * 例如：抽取了 6 个筹码，3 个 10，2 个 5，1个 1，那么他就会把这些筹码放成三堆，数量分别是3、2、1。
     *
     * 纸箱中共有 kind 种面值的筹码。现给定九坤取出筹码的最终目标为 nums， nums[i] 表示第 i 堆筹码的数量。
     * 假设每种面值的筹码都有无限多个，且九坤总是遵循最优策略，使得他达成目标的操作次数最小化。
     * 请返回九坤达成目标的情况下，需要取出筹码次数的期望值。
     *
     * 注意：
     *
     * 最终取出的筹码中，对于任意两堆筹码的面值都是不同的。
     * 不需要考虑筹码堆的顺序（例如，[3,1,1]、[1,1,3] 这两个筹码堆是相同的）
     * 示例 1:
     *
     * 输入：
     * nums = [1,1]
     * kind = 2
     * 输出：3.00000
     *
     * 解释：共有 2 种筹码，初始取出的数量为 [0,0]
     * 第一次取出筹码后，筹码数量为 [1,0]，此时取了 1 次
     * 第二次取出筹码后，筹码数量为 [2,0] 和 [1,1] 的概率均为 0.5
     * 因此，在 [1,0] 的基础上取出 [1,1] 的次数期望值为 2
     * 总期望值为 1+2=3
     *
     * 示例 2:
     *
     * 输入：
     * nums = [1,2]
     * kind = 4
     * 输出：3.833333
     *
     * 解释：1 + 1 + 1/4 * 4/3 + 3/4 * 4/2 = 23 / 6
     *
     * 提示：
     *
     * 1 <= kind <= 50
     * 1 <= nums.length <= kind
     * sum(nums[0],nums[1],...,nums[n]) <= 50
     * @param numbers
     * @return
     */
    public int minOperations(int[] numbers) {
        Arrays.sort(numbers);
        long maxLcm = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (maxLcm > numbers[i]) {
                maxLcm = lcm(numbers[i], maxLcm);
            } else {
                maxLcm = lcm(maxLcm, numbers[i]);
            }
        }
        int max = (int) maxLcm / numbers[0];
        long[] dp = new long[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i <= max; i++) {
            if ((i % 2) == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if ((i % 3) == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < numbers.length; i++) {
            int cntK = (int) (maxLcm / numbers[i]);
            if (dp[cntK] == Integer.MAX_VALUE) return -1;
            res += dp[cntK];
        }
        return res;
    }

    public long lcm(long x, long y) {
        long gcd = gcd1(x, y);
        return (x / gcd) * (y / gcd) * gcd;
    }

    public long gcd1(long a, long b) {
        return (b == 0 ? a : gcd1(b, a % b));
    }


}
