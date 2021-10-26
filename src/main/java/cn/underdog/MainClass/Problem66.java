package cn.underdog.MainClass;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Problem66 {

    public static void main(String[] args) {
        searchMatrix(new int[][]{{-1,3}},-1);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length-1;
            if(right==0)
            {
                if(matrix[i][0]==target){
                    return true;
                }else {
                    continue;
                }
            }
            while (left < right) {
                int mid = left + (right - left + 1) / 2;
                if (matrix[i][mid] > target) {
                    right = mid - 1;
                } else if (matrix[i][mid] < target) {
                    left = mid;
                } else {
                    return true;
                }
            }

            if(matrix[i][left]==target){
                return true;
            }

        }
        return false;
    }

}
