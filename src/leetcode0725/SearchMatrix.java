package leetcode0725;

/**
 * @author: celeste
 * @create: 2020-07-25 13:52
 * @description:
 * 题目：74. 搜索二维矩阵
 * 描述：编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 **/
public class SearchMatrix {
    /**
     * 这个矩阵是每一行都比前一行要大，所以可以直接使用二叉查找，相当于一个有序数组切分成好几份
     * 0 - (n + m)
     */
    public boolean searchMatrix(int[][] matrix, int target){
        if (matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            int midRow = mid / col;
            int midCol = mid % col;
            if (matrix[midRow][midCol] == target){
                return true;
            }else if (matrix[midRow][midCol] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return false;
    }
}
