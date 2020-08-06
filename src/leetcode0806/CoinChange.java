package leetcode0806;

/**
 * @author: celeste
 * @create: 2020-08-06 16:06
 * @description:
 * 题目：322. 零钱兑换
 * 描述：给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 **/
public class CoinChange {
    /**
     * 动态规划方法
     * 当前位置的最少组合个数f(i) = f(i - 5)、f(i - 2)、f(i - 1)中最小值+1
     * 其中i要大于5；
     * 等等，零钱是给出的数组里的，
     * f（i) = f(i - a1),f(i - a2),....,f(i - an)中最小值
     */
    public int coinChange(int[] coins, int amount){
        int coinLen = coins.length;
        if (coinLen == 0){
            return -1;
        }
        int[] state = new int[amount + 1];
        state[0] = 0;
        for (int i = 1; i < amount + 1; i++){
            state[i] = amount + 1;
        }
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coinLen; j++){
                if (i >= coins[j]){//当前大于硬币的大小，那么当前就是银币的前面状态+1以及现在的最小
                    state[i] = Math.min(state[i - coins[j]] + 1, state[i]);
                }
            }
        }
        if (state[amount] == amount + 1){
            return -1;
        }
        return state[amount];
    }
}
