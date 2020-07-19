package leetcode0719;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: celeste
 * @create: 2020-07-19 16:15
 * @description:
 * 题目：200岛屿数量
 * 描述：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 **/
public class NumIslands {
    /**
     * 定义一个set放置已经访问过的元素点
     * 2个for循环，从第一个元素开始判断是否为1，是否已经访问过，已经访问过跳过
     * 没有访问过，数量加1，调用dfs，为1往set中添加
     */

    public int numIslands(char[][] grid){
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //建立结果以及set
        int result = 0;
        Set<String> set = new HashSet<>();
        int xLen = grid.length;
        int yLen = grid[0].length;

        //开始for循环访问元素
        for (int i = 0; i < xLen; i++){
            for (int j = 0; j < yLen; j++){
                if (grid[i][j] == '1'){
                    String state = "" + i + " " + j;
                    if (!set.contains(state)){
                        ++result;
                        dfs(i, j, grid, set);
                    }
                }
            }
        }
        return result;
    }

    private void dfs(int x, int y, char[][] grid, Set<String> set) {
        if (grid[x][y] == '1') {
            String state = "" + x + " " + y;
            if (set.add(state)) {

                if (x > 0) {
                    //上
                    dfs(x - 1, y , grid, set);
                }
                if (x < grid.length - 1) {
                    //下
                    dfs(x + 1, y, grid, set);
                }
                if (y > 0) {
                    //左
                    dfs(x, y - 1, grid, set);
                }
                if (y < grid[0].length - 1) {
                    //右
                    dfs(x, y + 1, grid, set);
                }
            } else {
                return;
            }
        }else {
                return;
            }
        }

    /**
     * leetcode官方答案
     * 直接将已访问元素置为0，不需要一个额外的内存来保存已经访问元素
     * @param grid
     * @return
     */
    public int numIslandsWithLeetCodeSolution(char[][] grid){
        if (grid == null || grid.length == 0){
            return 0;
        }
        int result = 0;
        int xLen = grid.length;
        int yLen = grid[0].length;
        for (int i = 0; i < xLen; i++){
            for (int j = 0; j < yLen; j++){
                if (grid[i][j] == '1'){
                    ++result;
                    dfs1(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dfs1(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        dfs1(grid, i - 1, j);
        dfs1(grid, i + 1, j);
        dfs1(grid, i, j - 1);
        dfs1(grid, i, j + 1);
    }


}
