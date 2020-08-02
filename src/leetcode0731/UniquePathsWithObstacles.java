package leetcode0731;

/**
 * @author: celeste
 * @create: 2020-07-31 01:38
 * @description:
 * 题目：63. 不同路径 II
 * 描述：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 **/
public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        //一开始就是障碍就是0
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] state = new int[m][n];
        //对所有格子进行初始化为1
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                state[i][j] = 1;
            }
        }
        //第一列初始化，遇到障碍就为0
        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0] == 1 || state[i - 1][0] == 0){
                state[i][0] = 0;
            }
        }
        //第一行初始化，遇到障碍就为0
        for (int j = 1; j < n; j++){
            if (obstacleGrid[0][j] == 1 || state[0][j - 1] == 0){
                state[0][j] = 0;
            }
        }
        //状态变换有2种方式，一种没有遇到障碍物，是上面以及左边的和；另一种就是遇到障碍物，为0；
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    state[i][j] = 0;
                }else {
                    state[i][j] = state[i - 1][j] + state[i][j - 1];
                }
            }
        }
        return state[m - 1][n - 1];
    }
    /**
     * 可以使用滚动数组的方式来实现节省空间
     * 滚动数组主要需要知道是由前面几个状态推导到当前状态，前面的都可以删掉
     * 在这里只需要保存一个数组的大小就可以。
     * 后面的值都是由前一个状态加上当前状态就可以了
     */
    public int uniquePathsWithRollingArray(int[][] obstacleGrid){
        if (obstacleGrid[0][0] == 1){
            return 0;
        }
        //数组选择大一个是因为有边界问题，直接选多一个可以不讨论边界问题，直接加
        int[] state = new int[obstacleGrid[0].length + 1];
        //对第一个进行初始化
        if (obstacleGrid[0][0] == 0){
            state[1] = 1;
        }
        //对第一行进行初始化，需要吗？默认是0,不需要，直接开始
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){
                if (obstacleGrid[i][j] == 1){
                    state[j + 1] = 0;
                }else {
                    state[j + 1] = state[j + 1] + state[j];
                }
            }
        }
        return state[obstacleGrid[0].length];
    }

}
