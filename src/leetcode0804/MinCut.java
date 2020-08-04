package leetcode0804;

/**
 * @author: celeste
 * @create: 2020-08-04 13:38
 * @description:
 * 题目：132. 分割回文串 II
 * 描述：给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 **/
public class MinCut {
    /**
     * 分割字符串，aab
     * 回文字符串可以把字符串都切开
     * 然后比较？
     * 每个字符串最大切割刀数是字符串长度-1、判断前面是否为字符串，
     * 判断是否为回文字，是看先后面看，先判断大部分是不是回文，不是就继续分，越到后面，都是已经处理过的
     */
    public int minCut(String s){
        if (s.length() == 0 || s.length() == 1){
            return 0;
        }
        int len = s.length();
        int[] cut = new int[len + 1];
        cut[0] = -1;
        cut[1] = 0;
        for (int i = 1; i < len + 1; i++){
            cut[i] = i - 1;
            for (int j = 0; j < i; j++){
                if (isPar(s, i - 1, j)){//判断前面是否是回文字符串，是就选择最小的部分，不是，继续选小范围
                    //因为前面已经判断过了，所以不要先从第一个开始，而是从最后往前
                    cut[i] = Math.min(cut[j] + 1, cut[i]);
                }
            }
        }
        return cut[len];

    }

    private boolean isPar(String s, int i, int j) {
        while (i > j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

}
