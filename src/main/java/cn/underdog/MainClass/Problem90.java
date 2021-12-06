package cn.underdog.MainClass;

import cn.underdog.entity.Solution;

public class Problem90 {
    public static void main(String[] args) {
        Solution solution =new Solution(3,1);
        int[] flip = solution.flip();
        System.out.println(flip[0]+":"+flip[1]);
        int[] flip1 = solution.flip();
        System.out.println(flip1[0]+":"+flip1[1]);
        int[] flip2 = solution.flip();
        System.out.println(flip2[0]+":"+flip2[1]);
        solution.reset();
        int[] flip3 = solution.flip();
        System.out.println(flip3[0]+":"+flip3[1]);

    }
}
