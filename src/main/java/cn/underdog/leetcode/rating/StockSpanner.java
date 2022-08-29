package cn.underdog.leetcode.rating;

class StockSpanner {
    int[] targets = null;
    int index = 0;
    int[][] dp = null;

    public StockSpanner() {
        dp = new int[(int) 1e5][2];
        targets = new int[(int) 1e5];
    }

    public int next(int price) {
        int pre = index - 1;
        int tmp = index;
        targets[index++] = price;
        int count = 1;
        while (pre != -1 && targets[pre] <= price) {
            count += dp[pre][0];
            pre = dp[pre][1];
        }
        dp[tmp][0] = count;
        dp[tmp][1] = pre;
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */