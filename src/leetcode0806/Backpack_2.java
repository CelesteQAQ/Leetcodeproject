package leetcode0806;

/**
 * @author: celeste
 * @create: 2020-08-06 16:56
 * @description:
 * 题目：125 背包问题2
 * 描述：有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
 * 问最多能装入背包的总价值是多大?
 * 这次的物品是有价值，前面是无价值，可以随便装
 * 有价值的物品是不是应该选择最有价值的放进去，但是这是贪心做法
 * 动态规划，可以将每种放置情况的价值标出来，前面是标可不可行，这里可以换成价值存储
 * 然后遍历最后一行，找出最大价值的位置
 **/
public class Backpack_2 {
    public int backpack_2(int m, int[] A, int[] V){
        int len_A = A.length;
        int[][] state = new int[len_A + 1][m + 1];
        state[0][0] = 0;
        for (int i = 1; i <= len_A; i++){
            for (int j = 0; j <= m; j++){
                state[i][j] = state[i - 1][j];
                if (j >= A[i - 1] && state[i - 1][j - A[i - 1]] > 0){
                    state[i][j] = state[i - 1][j - A[i - 1]] + V[i - 1];
                }
            }
        }
        int result = 0;
        for (int i = m; i > 0; i--){
            result = Math.max(result, state[len_A][i]);
        }
        return result;
        //可以将最大价值并入到状态里面，上面的处理是将每个加法的价值和计算出来，然后选择最大的
        //也可以选择状态保存的就是最大价值，这样可以不用在遍历一遍
//        for (int i = 1; i <= len_A; i++){
//            for (int j = 0; j <= m; j++){
//                state[i][j] = state[i - 1][j];
//                if (j >= A[i - 1]){
//                    state[i][j] = Math.max(state[i - 1][j - A[i - 1]] + V[i - 1], state[i - 1][j]);
//                }
//            }
//        }
//        return state[len_A][m];

    }
}
