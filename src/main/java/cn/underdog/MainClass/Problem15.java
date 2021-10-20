package cn.underdog.MainClass;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。

 每个矩形由其 左下 顶点和 右上 顶点坐标表示：

 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义
 输入：ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 输出：45

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/rectangle-area
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。。
 */
public class Problem15 {
    public static void main(String[] args) {
//        int ax1= 0;
//        int ay1= 0;
//        int ax2= 0;
//        int ay2= 0;
//        int bx1= -1;
//        int by1= -1;
//        int bx2= 1;
//        int by2= 1;
        int ax1= -2;
        int ay1= -2;
        int ax2= 2;
        int ay2= 2;
        int bx1= 2;
        int by1= -2;
        int bx2= 4;
        int by2= 2;

        int result = computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        System.out.println(result);

    }

    public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        List<Integer> listX1=new ArrayList<>();
        listX1.add(ax1);
        listX1.add(ax2);
        List<Integer> listX2=new ArrayList<>();
        listX2.add(bx1);
        listX2.add(bx2);
        List<Integer> listY1=new ArrayList<>();
        listY1.add(ay1);
        listY1.add(ay2);
        List<Integer> listY2=new ArrayList<>();
        listY2.add(by1);
        listY2.add(by2);

        // 计算两个的公共面积
        int rs1= (listX1.get(0)-listX1.get(1))*(listY1.get(0)-listY1.get(1));
        int rs2= (listX2.get(0)-listX2.get(1))*(listY2.get(0)-listY2.get(1));

        int total = rs1 + rs2;
        List<Integer> listX=new ArrayList<>();
        List<Integer> listY=new ArrayList<>();
        isContain(listX1.get(0),listX2,listX);
        isContain(listX1.get(1),listX2,listX);
        isContain(listX2.get(0),listX1,listX);
        isContain(listX2.get(1),listX1,listX);
        isContain(listY1.get(0),listY2,listY);
        isContain(listY1.get(1),listY2,listY);
        isContain(listY2.get(0),listY1,listY);
        isContain(listY2.get(1),listY1,listY);
        List<Integer> listXF = new ArrayList<>(new LinkedHashSet<>(listX));
        List<Integer> listYF = new ArrayList<>(new LinkedHashSet<>(listY));
        if(listXF!=null&&listXF.size()==2&&listYF!=null&&listYF.size()==2){
            int temp =Math.abs(listXF.get(1)-listXF.get(0))*Math.abs(listYF.get(1)-listYF.get(0));
            total-=temp;
        }
        return total;
    }

    private static void isContain(Integer integer, List<Integer> listX2,List<Integer> list) {
        if(integer>=listX2.get(0)&&integer<=listX2.get(1)){
            list.add(integer);
        }
    }


}
