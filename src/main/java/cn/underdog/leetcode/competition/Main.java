package cn.underdog.leetcode.competition;

import cn.underdog.leetcode.entity.TreeNode;

import java.io.*;

/**
 * @author underdog_rj
 * @date2022/4/229:08
 */
public class Main {


    public static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

   /* public static void main(String[] args) throws IOException {
        long n = Long.parseLong(sc.readLine().replace(" ", ""));
        long target = n + 2;
        long next = n;
        while (n != 1) {
            // 奇数
            if ((n & 1) == 1) {
                next = next % target;
                n--;
            }
            next = next * next % target;
            n >>= 1;
        }
        System.out.println(next);

    }*/

//    public static void main(String[] args) throws IOException {
//        String s = sc.readLine();
//        int n = Integer.parseInt(sc.readLine().replace(" ", ""));
//        String[] query = new String[n];
//        for (int i = 0; i < n; i++) {
//            query[i] = sc.readLine();
//        }
//        String[] strings = s.split(" ");
//        HashMap<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < strings.length; i += 2) {
//            map.put(strings[i], map.getOrDefault(strings[i], 0) + Integer.parseInt(strings[i + 1]));
//        }
//        for (String key : query) {
//            Integer orDefault = map.getOrDefault(key, 0);
//            System.out.println(orDefault);
//        }
//
//    }

    /*public static void main(String[] args) throws IOException {
        int totalNum = Integer.parseInt(sc.readLine());
        for (int i = 0; i < totalNum; i++) {
            long res = 0;

            int totalPerNum = Integer.parseInt(sc.readLine());
            String[] attackstr = sc.readLine().split(" ");
            String[] magicstr = sc.readLine().split(" ");
            List<Integer> attacks = new ArrayList<>();
            List<Integer> magics = new ArrayList<>();
            for (int j = 0; j < totalPerNum; j++) {
                attacks.add(Integer.parseInt(attackstr[j]));
                magics.add(Integer.parseInt(magicstr[j]));
            }
            Collections.sort(attacks, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return Integer.compare(o1, o2);
                }
            });
            Collections.sort(magics, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return -Integer.compare(o1, o2);
                }
            });

            // 计算本次
            for (int j = 0; j < totalPerNum; j++) {
                res += attacks.get(j) * magics.get(j);
            }
            System.out.println(res);

        }
    }*/


    public static void main(String[] args) throws IOException {
      /*  String[] s = sc.readLine().split(" ");
        int length = Integer.parseInt(s[0]);
        int need1 = Integer.parseInt(s[1]);
        int need0 = Integer.parseInt(s[2]);
        String target = sc.readLine();
        if (need0 + need1 > length) {
            System.out.println(0);
            return;
        } else if (need0 == 0 && need1 == 0) {
            System.out.println((long) length * (length + 1) / 2 + 1);
        }

        int[] num0 = new int[length + 1];
        int[] num1 = new int[length + 1];
        num0[1] = target.charAt(0) == '0' ? 1 : 0;
        num1[1] = target.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) == '0') {
                num0[i + 1] = num0[i] + 1;
                num1[i + 1] = num1[i];
            } else {
                num0[i + 1] = num0[i];
                num1[i + 1] = num1[i] + 1;
            }
        }
        // 计算符合的数量
        int res = 0;
        for (int i = 1; i <= length; i++) {
            int left = i;
            int right = length;
            while (left < right) {
                int mid = (left + right) / 2;
                int n1 = num1[mid] - num1[i - 1];
                int n0 = num0[mid] - num0[i - 1];
                if (n0 >= need0 && n1 >= need1) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res += length - left + 1;
        }
        System.out.println(res);*/

        Main main = new Main();
//        main.largestGoodInteger("6777133339");
//        TreeNode treeNode = new TreeNode(4);
//        TreeNode treeNode1 = new TreeNode(8);
//        TreeNode treeNode2 = new TreeNode(5);
//        TreeNode treeNode3 = new TreeNode(0);
//        TreeNode treeNode4 = new TreeNode(1);
//        TreeNode treeNode5 = new TreeNode(6);
//        treeNode.left = treeNode1;
//        treeNode.right = treeNode2;
//        treeNode1.left = treeNode3;
//        treeNode1.right = treeNode4;
//        treeNode2.right = treeNode5;
//        main.averageOfSubtree(treeNode);
        main.countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"
        );
//        main.countTexts("22233");
    }

   /* public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int need1 = sc.nextInt();
        int need0 = sc.nextInt();
        String target = sc.next();
        if (need0 + need1 > length) {
            System.out.println(0);
            return;
        } else if (need0 == 0 && need1 == 0) {
            System.out.println((long) length * (length + 1) / 2 + 1);
        }
        int sum0 = 0;
        int sum1 = 0;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (target.charAt(i) == '0') {
                sum0++;
            } else {
                sum1++;
            }
            while (sum0 >= need0 && sum1 >= need1 && left <= i) {
                if (target.charAt(left) == '0') {
                    sum0--;
                } else {
                    sum1--;
                }
                left++;
            }
            sum += left;
        }
        System.out.println(sum);
    }*/

    public String largestGoodInteger(String num) {
        String res = "";
        Out:
        for (int i = 0; i <= num.length() - 3; i++) {
            String str = num.substring(i, i + 3);
            for (int j = 0; j < str.length() - 1; j++) {
                if (str.charAt(j) != str.charAt(j + 1)) {
                    continue Out;
                }
            }
            int tmp = res.compareTo(str);
            if (tmp < 0) {
                res = str;
            }
        }
        return res;
    }

    int totalAvg = 0;
    public int averageOfSubtree(TreeNode root) {
        // 1.先统计当前节点的节点个数
        dfsAvg(root);
        return totalAvg;
    }

    private int[] dfsAvg(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            int count = 0;
            int sum = 0;
            int[] ints = dfsAvg(root.left);
            int[] ints1 = dfsAvg(root.right);
            sum += ints[0];
            sum += ints1[0];
            count += ints[1];
            count += ints1[1];
            sum += root.val;
            count++;
            if (root.val == sum / count) {
                totalAvg++;
            }
            return new int[]{sum, count};
        }
    }

    public int countTexts(String pressedKeys) {
        long res = 1;
        int mod = 1000000007;
        int[] coings1 = new int[]{1, 2, 3};
        int[] coings2 = new int[]{1, 2, 3, 4};
        int preIndex = 0;
        char preChar = pressedKeys.charAt(0);
        for (int i = 1; i < pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i) != preChar) {
                int total = i - preIndex;
                char tmp = preChar;
                preChar = pressedKeys.charAt(i);
                preIndex = i;
                res *= change((tmp == '7' || tmp == '9') ? coings2 : coings1, total);
                res %= mod;
            }
        }
        // 计算最后一次
        int total = pressedKeys.length() - preIndex;
        char tmp = pressedKeys.charAt(pressedKeys.length() - 1);
        res *= change((tmp == '7' || tmp == '9') ? coings2 : coings1, total) % mod;
        res %= mod;
        return (int) res;
    }

    public int change(int[] nums, int target) {
        int mod = 1000000007;
        // 定义dp[i]为容量为i 的背包有多少种排列方式
        long[] dp = new long[target + 1];
        // 初始化dp
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                    dp[i] %= mod;
                }
            }
        }
        return (int) dp[target];
    }


}
