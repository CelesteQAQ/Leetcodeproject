package leetcode0806;

/**
 * @author: celeste
 * @create: 2020-08-06 02:22
 * @description:
 * 题目：72. 编辑距离
 * 描述：给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 **/
public class MinDistance {
    /**
     * 可不可以使用前面最长公共子序列？？
     * 但是似乎长度一样的时候不能这样处理
     * 这个方法不可行是因为长度一样的时候，不清楚最长公共子序列的间隔是怎么样的
     * 如sea与eat需要2次
     * intention与execution需要5次
     * 无法保证一样
     * 相同长度似乎更加看重相同的公共子序列是连续的，不一定
     */
    public int minDistance(String word1, String word2){
        LongestCommonSubsequence lo = new LongestCommonSubsequence();
        if (word1.length() != word2.length()){
            return Math.max(word1.length(), word2.length()) - lo.longestCommonSubsequence(word1, word2);
        }else {
            int common = 0;
            for (int i = 0; i < word1.length(); i++){
                if (word1.charAt(i) == word2.charAt(i)){
                    common++;
                }
            }
            return word1.length() - common;

        }
    }

    /**
     * 直接使用动态规划计算需要修改次数，而不是看相同的部分
     *     h o r s e
     *     1 2 3 4 5
     * r 1 1 2 2 3 4
     * o 2 2 1 2 3 4
     * s 3 3 2 3 2 3
     * 状态方程为
     * f(i, j) = f(i - 1, j - 1) ,相等情况
     * f(i, j) = f(i, j - 1), f(i - 1, j)中最小值 + 1，不相等情况
     * 考虑少了一种情况，可以是替换，所以应该是三个的最小值+1
     * f(i, j) = f(i, j - 1), f(i - 1, j), f(i - 1, j - 1)中最小值 + 1，不相等情况
     */
    public int minDistance_2(String word1, String word2){
        int len_1 = word1.length(), len_2 = word2.length();
        int[][] state = new int[len_2 + 1][len_1 + 1];
        //初始化边界
        for (int i = 1; i < len_2 + 1; i++){
            state[i][0] = i;
        }
        for (int i = 1; i < len_1 + 1; i++){
            state[0][i] = i;
        }
        for (int i = 1; i < len_2 + 1; i++){
            for (int j = 1; j < len_1 + 1; j++){
                if (word1.charAt(j - 1) == word2.charAt(i - 1)){
                    state[i][j] = state[i - 1][j - 1];
                }else {
                    state[i][j] = Math.min(state[i][j - 1], state[i - 1][j]);
                    state[i][j] = Math.min(state[i - 1][j - 1], state[i][j]) + 1;
                 }
            }
        }
        return state[len_2][len_1];
    }
}
