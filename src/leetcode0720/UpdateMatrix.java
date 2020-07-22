package leetcode0720;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-07-20
 * 题目：542. 01 矩阵
 * 描述：给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 **/
public class UpdateMatrix {
    /**
     * 2个for循环找到不为0的元素，然后进入bfs
     * bfs中将邻居（上下左右）添加到队列中，如果出现0则返回队列的层数
     */
    public class State {//将位置设成一个类，可以存储在队列中
        int x;
        int y;

        State(int i, int j) {
            x = i;
            y = j;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        //建立结果以及队列,队列里应该是矩阵的位置
        //结果是原来的矩阵
        Queue<State> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = bfs(matrix, queue, i, j);
                }
            }
        }
        return matrix;
    }

    public int bfs(int[][] matrix, Queue<State> queue, int x, int y) {
        int result = 0;
        queue.add(new State(x, y));
        while (!queue.isEmpty()) {
            State s  = queue.remove();
            int i = s.x;
            int j = s.y;
            result++;
            if (i > 0){
                if (matrix[i - 1][j] > 0){
                    queue.add(new State(i - 1, j));
                } else {
                    queue.clear();
                    return result;
                }
            }
            if (i < matrix.length - 1){
                if (matrix[i + 1][j] > 0) {
                    queue.add(new State(i + 1, j));
                } else{
                    queue.clear();
                    return result;
                }
            }
            //上
            if (j > 0){
                if (matrix[i][j - 1] > 0){
                    queue.add(new State(i, j - 1));
                }else{
                    queue.clear();
                    return result;
                }
            }

            //下
            if (j < matrix[0].length - 1){
                if (matrix[i][j + 1] > 0){
                    queue.add(new State(i, j + 1));
                }else{
                    queue.clear();
                    return result;
                }
            }

        }
        return matrix[x][y];
    }


    /**
     * leetcode的方法
     * 将位置设为一个数组，当位置上的值是0时就入栈，为1就置为最大值，以便待会修改
     * 然后将位置取出，判断0位置的前后左右值是否大于现在的值+1，是就替换，并且入队列，因为修改的值会影响自己的邻居
     * 思路是从0到1，上面我的是从1到0，这样无法更新先更新的部分，更适合使用dfs
     */
    int[][] vector = new int[][]{{0, 1},{0, -1}, {1, 0}, {-1, 0}};
    public int[][] updateMatrix_bfs(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();//准确的说存储的是会影响其他位置的位置
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    queue.add(new int[]{i, j});//不需要使用独立一个类，可以建立一个数组
                }else {
                    matrix[i][j] = row + col;//不为0就置为大数值，以便修改
                }
            }
        }

        while (!queue.isEmpty()){
            int[] s = queue.poll();
            for (int[] v : vector){//前后左右
                int r = s[0] + v[0];
                int c = s[1] + v[1];
                if (r >= 0 && r < row
                && c >= 0 && c < col
                && matrix[r][c] > matrix[s[0]][s[1]] + 1){//前后左右的值大于当前值加1，那就修改并且入队列
                    matrix[r][c] = matrix[s[0]][s[1]] + 1;
                    queue.add(new int[]{r, c});
                }
            }
        }
        return matrix;
    }
}
