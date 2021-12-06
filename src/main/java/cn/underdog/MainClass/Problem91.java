package cn.underdog.MainClass;

public class Problem91 {
    public static void main(String[] args) {
        System.out.println(findNthDigit(999));
    }

    /**
     * 暴力求解超时
     * @param n
     * @return
     */
    /*public static int findNthDigit(int n) {
        if (n <= 9)
            return n;
        if (n == 10)
            return 1;
        int count = 9;
        int temp = 9;
        int res = 0;
        for (int i = 10; i < n; i++) {
            String current = String.valueOf(i);
            int length = current.length();
            temp += length;
            if (temp < n) {
                count += length;
            } else {
                int index = n - count;
                char c = current.charAt(index - 1);
                res = Integer.parseInt(c + "");
                break;
            }

        }
        return res;
    }*/

    /**
     * 找规律
     * 一位数字有9
     * 二位数字有90
     * 三位数字有900
     * 四位数字有9000
     * 五位数字有90000
     * 先找到是几位数字
     *
     * @param n
     * @return
     */
    public static int findNthDigit(int n) {
        int d = 1; //对应位数
        int count = 9; // 第一次的个数
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }


}
