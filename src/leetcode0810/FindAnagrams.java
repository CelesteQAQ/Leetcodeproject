package leetcode0810;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-10 15:42
 * @description:
 * 题目：438. 找到字符串中所有字母异位词
 * 描述：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * 说明：
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 **/
public class FindAnagrams {
    /**
     * 考虑前面找到就返回true，没找到就返回false的做法
     * 在这一题就是将true返回改成下标，然后继续运行下去
     * 输入:
     * s: "cba eba bac d" p: "abc"
     * 输出:
     * [0, 6]
     */
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new LinkedList<>();
        int start = 0; int end = 0;
        int s_len = s.length(), p_len = p.length();
        int[] mp = new int[256];
        int cnt = 0;
        //初始化需要匹配的数组
        for (char c : p.toCharArray()) mp[c]++;
        while (end < s_len){
            char c  = s.charAt(end);
            mp[c]--;
            //记下在p中出现在s中的个数，不在p中的不会记下数目
            if (mp[c] >= 0) {
                cnt++;
                end++;
            }else {//包含不存在p的元素以及超出了p的次数
                //减当前的位置的值加回去，避免直接end++无法判断当前是否为s1元素
                mp[c]++;
                //将窗口前面的元素去掉，更新mp值以及长度
                c = s.charAt(start);
                mp[c] += 1;
                start++;
                cnt--;
            }
            //刚刚好数目等于p的数目，怎么处理？记下start然后，开始start向右移动
            if (cnt == p_len && end - start == p_len){
                result.add(start);
                mp[s.charAt(start)]++;
                start++;
                cnt--;
            }
        }
        return result;

    }
}
