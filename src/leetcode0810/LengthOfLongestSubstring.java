package leetcode0810;

import java.util.Map;

/**
 * @author: celeste
 * @create: 2020-08-10 17:03
 * @description:
 * 题目：3. 无重复字符的最长子串
 * 描述：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 **/
public class LengthOfLongestSubstring {
    /**
     * 跟前面求匹配的刚刚好相反，是遇到相同的字符就马上减
     * 窗口右指针是向右扩展，然后判断是否已经访问过
     * 窗口左指针收紧，将当前重复的字符去掉
     */
    public int lengthOfLongestSubstring(String s){
        int ansMax = 0;
        int start = 0, end = 0;
        int[] map = new int[256];
        while (end < s.length()){
            char c = s.charAt(end);
            map[c]++;
            end++;
            //遇到重复的字符，记下大小，然后需要窗口收紧
            if (map[c] > 1){
                ansMax = Math.max(ansMax, end - start - 1);

                //没找到当前重复字符，继续循环
                while (map[s.charAt(start)] != 2){
                    map[s.charAt(start)]--;
                    start++;
                }
                map[s.charAt(start)]--;
                start++;

            }
            //没有遇到重复字符就是继续扩张
        }
        //注意有可能是没有遇到重复字符就结束了循环或者最后一次遍历没有遇到重复字符就结束了，
        //所以需要判断是当前的最小还是最后的长度大
        return Math.max(ansMax, end - start);
    }
}
