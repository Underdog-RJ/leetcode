package cn.underdog.MainClass;


import java.math.BigInteger;

public class Problem94 {
    public static void main(String[] args) {
        superPow(Integer.MAX_VALUE, new int[]{2, 0, 0});
    }

   /* public static int superPow(int a, int[] b) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            sb.append(b[i]);
        }
        BigInteger bigA= new BigInteger(String.valueOf(a));
        BigInteger bigB = new BigInteger(sb.toString());
        BigInteger pow = bigA.modPow(bigB,new BigInteger("1337"));
        return pow.intValue();
    }*/

    public static int superPow(int a, int[] b) {
        if (a == 0)
            return 0;
        if (a == 1)
            return 1;
        a = a % 1337;
        int length = b.length;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (length <= 30) {
            int start = length - 1 - count * 30;
            for (int i = start; i >= 0; i--) {
                sb.append(b[i]);
            }
            int mi = Integer.parseInt(sb.toString());
        }
        return 0;
    }

    public static int supperPowDG(int a, int b) {
        if (b == 1)
            return 1;
        else if (b % 2 == 1) {
            return supperPowDG(a, b - 1) * a;
        } else {
            int temp = supperPowDG(a, b / 2);
            return temp * temp;
        }
    }
}
