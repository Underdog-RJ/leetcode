package cn.underdog.leetcode.competition;

/**
 * @author underdog_rj
 * @date2022/5/321:02
 */
public class C_276 {

    public String[] divideString(String s, int k, char fill) {

        int tmp = s.length() % k;
        StringBuilder sb = new StringBuilder(s);
        if (tmp != 0) {
            tmp = k - tmp;
            for (int i = 0; i < tmp; i++) {
                sb.append(fill);
            }
        }
        s = sb.toString();
        int total = s.length() / k;
        String[] strings = new String[total];
        int j = 0;
        for (int i = 0; i < s.length(); i += k) {
            strings[j++] = s.substring(i, i + k);
        }
        return strings;
    }

    public int minMoves(int target, int maxDoubles) {
        int res = 0;
        while (target != 1) {
            if (maxDoubles == 0)
                return res + target - 1;
            if (maxDoubles != 0 && target % 2 == 0) {
                target /= 2;
                maxDoubles--;
            } else {
                target--;
            }
            res++;
        }
        return res;
    }

    public long mostPoints(int[][] questions) {
        int length = questions.length;
        // dp定义为当前节点的分数指，因为前面的值，取决后面的，所以反向dp
        long[] dp = new long[length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            // 当前节点有两种状态，做和不做
            if (i + questions[i][1] + 1 >= dp.length) {
                // 做 （本身的值） + 上次做的值
                long num1 = questions[i][0];
                // 不做 和前一个相同
                long num2 = dp[i + 1];
                dp[i] = Math.max(num1, num2);
            } else {
                // 做 （本身的值） + 上次做的值
                long num1 = questions[i][0] + dp[i + questions[i][1] + 1];
                // 不做 和前一个相同
                long num2 = dp[i + 1];
                dp[i] = Math.max(num1, num2);
            }
        }
        return dp[0];
    }
}
