package cn.underdog.leetcode.math;

import java.util.Random;

public class MainClass {


    public static void main(String[] args) {


    }

    /**
     * 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
     *
     * 示例:
     * 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
     * 输出: 2
     * 解释:
     * 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
     *
     *
     * 注意:
     *
     * 3 <= points.length <= 50.
     * 不存在重复的点。
     *  -50 <= points[i][j] <= 50.
     * 结果误差值在 10^-6 以内都认为是正确答案。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/largest-triangle-area
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param points
     * @return
     */
    /**
     * 思路：海伦公式
     * 定义三角形的三边为a,b,c
     * p = (a+b+c)/2
     * s = sqrt(p*(p-a)*(p-b)*(p-c))
     *
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length - 2; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length - 1; j++) {
                int[] point2 = points[j];
                for (int t = j + 1; t < points.length; t++) {
                    // 获取三个点
                    int[] point3 = points[t];
                    // 求出三个点之间的长度
                    // point1 2
                    double a = Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
                    // point1 3
                    double b = Math.sqrt(Math.pow(point1[0] - point3[0], 2) + Math.pow(point1[1] - point3[1], 2));
                    // point2 3
                    double c = Math.sqrt(Math.pow(point3[0] - point2[0], 2) + Math.pow(point3[1] - point2[1], 2));

                    double p = (a + b + c) / 2.0;
                    double s = Math.sqrt(p * Math.abs(p - a) * Math.abs(p - b) * Math.abs(p - c));
                    max = Math.max(max, s);
                }
            }
        }
        return max;
    }

    /**
     * 三角形面积公式
     *       ||x1 y1 1||
     * s =   ||x2 y2 1||  = 0.5*|x1*y2+x2*y3+x3*y1-x1*y3-x2*y1-x3*y2|
     *       ||x3 y3 1||
     *
     * @param points
     * @return
     */
    public double largestTriangleArea_1(int[][] points) {
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < points.length - 2; i++) {
            int[] point1 = points[i];
            for (int j = i + 1; j < points.length - 1; j++) {
                int[] point2 = points[j];
                for (int t = j + 1; t < points.length; t++) {
                    int[] point3 = points[t];
                    max = Math.max(max, calc(point1, point2, point3));
                }
            }
        }
        return max;
    }

    private double calc(int[] point1, int[] point2, int[] point3) {
        int x1 = point1[0];
        int x2 = point2[0];
        int x3 = point3[0];
        int y1 = point1[1];
        int y2 = point2[1];
        int y3 = point3[1];
        return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
    }


}
