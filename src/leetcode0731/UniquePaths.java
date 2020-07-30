package leetcode0731;

/**
 * @author: celeste
 * @create: 2020-07-31 01:24
 * @description:
 * 题目：62. 不同路径
 * 描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 **/
public class UniquePaths {
    /**
     * 直接将每个路径点初始化为1，然后每个位置的点等于上面的点+左边的点
     */
    public int uniquePaths(int m, int n){
        int[][] state = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                state[i][j] = 1;
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                state[i][j] = state[i - 1][j] + state[i][j - 1];
            }
        }
        return state[m - 1][n - 1];
    }

}
