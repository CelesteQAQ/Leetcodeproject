package leetcode0802;

/**
 * @author: celeste
 * @create: 2020-08-02 16:23
 * @description:
 * 题目：70. 爬楼梯
 * 描述：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 **/
public class ClimbStairs {
    /**
     * 经典动态规划的题目爬楼梯
     * 当前爬楼梯的方法数目是前一个楼梯的方法数目+前2个跑楼梯的方法数目
     * 其实就是斐波那契数组
     */
    public int climbStairs(int n){
        if (n <= 1){
            return 1;
        }
        int[] state = new int[n + 1];

        if (n >= 2){
            state[1] = 1;
            state[2] = 2;
            for (int i = 2; i < n +1; i++){
                    state[i] = state[i - 2] + state[i - 1];
            }
        }
        return state[n];
    }
    /**
     * 数组滚动方法
     * 只需要三个数字,不需要建立一个n大小的数组
     */
    public int climbStairsWithRollingArray(int n){
        if (n <= 1){
            return 1;
        }
        int a0 = 1;
        int a1 = 1;
        int a2 = 1;
        for (int i = 2; i < n + 1; i++){
            a0 = a1;
            a1 = a2;
            a2 = a0 + a1;
        }
        return a2;
    }
}
