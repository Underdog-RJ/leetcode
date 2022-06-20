package cn.underdog.leetcode.MainClass;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem10 {
    public static void main(String[] args) {
        int[] h={4,3,2,1,4};
        System.out.println(maxArea(h));
    }


    /**
     * 暴力破解
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxArea=0;
        for (int i = 0; i < height.length; i++) {
            for(int j=i+1;j<height.length;j++){
                int width= j-i;
                int heith = height[i]>height[j] ? height[j]:height[i];
                int Area = width*heith;
                if(maxArea<Area) maxArea=Area;
            }
        }
        return maxArea;
    }


    /**
     * 双指针
     * @param height
     * @return
     */
    public static int maxAreaT(int[] height) {
        int maxArea=0;
        int left=0;
        int right=height.length-1;
        while (left<right){
            int width = right-left;
            int heigh = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea,width*heigh);
            if(height[left]>=height[right])
                right--;
            else
                left++;
        }
        return maxArea;
    }
}
