package leetcode0730;

/**
 * @author: celeste
 * @create: 2020-07-30 01:46
 * @description:
 * 题目：64. 最小路径和
 * 描述：给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，
 * 使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 **/
public class MinPathSum {
    /**
     * 这种矩阵的状态很好找，就是每一个格子
     * 状态转换就是向下或者向右移动
     * 起点是0，0
     * 终点是n-1，n-1
     */
    public int minPathSum(int[][] grid){
        if (grid.length == 0){
            return 0;
        }
        for (int j = 1; j < grid[0].length; j++){
            grid[0][j] = grid[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++){
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++){
            for (int j = 1; j < grid[0].length; j++){
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
