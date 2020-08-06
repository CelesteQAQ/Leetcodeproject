package leetcode0806;

/**
 * @author: celeste
 * @create: 2020-08-06 16:31
 * @description:
 * 题目：92 背包问题 lintcode
 * 描述：在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
 * 注意：这个是不是不可以重复取，取了需要去掉？
 * 样例 1:
 * 	输入:  [3,4,8,5], backpack size=10
 * 	输出:  9
 * 样例 2:
 * 	输入:  [2,3,5,7], backpack size=12
 * 	输出:  12
 **/
public class Backpack {
    public int backpack(int m, int[] A){
        int len_A = A.length;
        boolean[][] state = new boolean[len_A + 1][m + 1];
        state[0][0] = true;
        for (int i = 1; i <= len_A; i++){
            for (int j = 0; j <= m; j++){
                state[i][j] = state[i - 1][j];
                if (j >= A[i - 1] && state[i - 1][j - A[i - 1]]){
                    state[i][j] = true;
                }
            }
        }
        for (int i = m; i > 0; i--){
            if (state[len_A][i]){
                return i;
            }
        }
        return 0;
    }
}
