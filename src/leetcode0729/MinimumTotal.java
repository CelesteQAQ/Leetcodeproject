package leetcode0729;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-07-29 01:50
 * @description:
 * 题目：120. 三角形最小路径和
 * 描述：给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 思路：每个数的最小路径和都是前一个的最小路径和+自己
 * 等式：f（i, j) = Min(f(i -1,j - 1),f(i-1,j)) + a[i,j]
 * 其中边界问题：如i = 0， 就是自己；左边第一个j = 0就是上面一个的j = 0；右边最后一个j就是上面j - 1，没有j
 **/
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle){
        //存放每个数字的最小路径和
        int row = triangle.size();
        int[][] total = new int[row][row];

        total[0][0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < row; i++){
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {//左边第一个
                    total[i][j] = total[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    total[i][j] = total[i - 1][i - 1] + triangle.get(i).get(j);
                } else {
                    total[i][j] = Math.min(total[i - 1][j - 1], total[i - 1][j])
                            + triangle.get(i).get(j);
                }

            }

        }
        for (int i = 0; i < row; i++){
            min = Math.min(total[row - 1][i], min);
        }
        return min;


    }

}
