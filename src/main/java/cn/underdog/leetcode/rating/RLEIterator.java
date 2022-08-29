package cn.underdog.leetcode.rating;

class RLEIterator {

    int[] target = null;
    int left = 0;
    int length = 0;

    public RLEIterator(int[] encoding) {
        target = encoding;
        length = encoding.length;
    }

    public int next(int n) {
        int res = -1;
        while (n >= 0 && left < length) {
            if (target[left] >= n) {
                target[left] -= n;
                res = target[left + 1];
                break;
            } else {
                n -= target[left];
                left += 2;
            }
        }
        return res;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */