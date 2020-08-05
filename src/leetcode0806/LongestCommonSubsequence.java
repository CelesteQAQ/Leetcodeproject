package leetcode0806;

/**
 * @author: celeste
 * @create: 2020-08-06 01:37
 * @description:
 * 题目：1143. 最长公共子序列
 * 描述：给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（
 * 也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 若这两个字符串没有公共子序列，则返回 0。
 **/
public class LongestCommonSubsequence {
    /**
     * 是不是两个序列可以看成是矩阵的形式
     *
     */
    public int longestCommonSubsequence(String text1, String text2){
        int len_1 = text1.length(), len_2 = text2.length();
        int[][] state = new int[len_1 + 1][len_2 + 1];
        for (int i = 0; i < len_1; i++){
            for (int j = 0; j < len_2; j++){
                if (text1.charAt(i) == text2.charAt(j)){//如果相等，则最长子序列是前面+1
                    state[i + 1][j + 1] = state[i][j] + 1;
                }else {//不等就看text1少一个，以及text2少一个的最大值
                    state[i + 1][j + 1] = Math.max(state[i][j + 1], state[i + 1][j]);
                }
            }
        }
        return state[len_1][len_2];
    }
}
