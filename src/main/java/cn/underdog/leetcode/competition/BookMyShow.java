package cn.underdog.leetcode.competition;

public class BookMyShow {

    int[] dis = null;
    int maxValue = 0;

    public BookMyShow(int n, int m) {
        dis = new int[n];
        maxValue = m - 1;
    }

    public int[] gather(int k, int maxRow) {
        int[] tmp = new int[dis.length];
        System.arraycopy(dis, 0, tmp, 0, dis.length);
        for (int i = 0; i <= maxRow; i++) {
            int endIndex = tmp[i];
            int cntTotal = maxValue - endIndex + 1;
            if (cntTotal >= k) {
                tmp[i] = endIndex + k;
                dis = tmp;
                return new int[]{i, endIndex};
            }
        }
        return new int[0];
    }

    public boolean scatter(int k, int maxRow) {
        int[] tmp = new int[dis.length];
        System.arraycopy(dis, 0, tmp, 0, dis.length);
        for (int i = 0; i <= maxRow && k > 0; i++) {
            int endIndex = tmp[i];
            int cntTotal = maxValue - endIndex + 1;
            if (cntTotal < k) {
                k -= cntTotal;
                tmp[i] = endIndex + cntTotal;
            } else {
                tmp[i] = endIndex + k;
                k = 0;
            }
        }
        if (k > 0) {
            return false;
        } else {
            dis = tmp;
            return true;
        }
    }

}
