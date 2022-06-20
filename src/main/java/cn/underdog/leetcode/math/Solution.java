package cn.underdog.leetcode.math;

import java.util.Random;

/**
 *拒绝采样的意思是说：我们在一个更大的范围内生成随机数，并拒绝掉那些不在题目给定范围内的随机数，此时保留下来的随机数都是在范围内的。
 * 为了在一个半径为 R 的圆中生成均匀随机点，我们可以使用一个边长为 2R 的正方形覆盖住圆，并在正方形内生成均匀随机点，此时就只需要对于横坐标和纵坐标分别生成一个随机数即可。
 *

 */
class Solution {

    double x_1, y_1, r;

    public Solution(double radius, double x_center, double y_center) {
        r = radius;
        x_1 = x_center;
        y_1 = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        while (true) {
            double x = r * (1.8 * random.nextDouble() - 1);
            double y = r * (1.8 * random.nextDouble() - 1);
            if (x * x + y * y <= r * r) {
                return new double[]{x + x_1, y + y_1};
            }
        }
    }

}