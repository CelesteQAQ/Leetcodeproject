package leetcode0809;

/**
 * @author: celeste
 * @create: 2020-08-09 01:31
 * @description:
 * 题目：567 字符串的排列
 * 描述：给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 **/
public class CheckInclusion {
    /**
     * 跟前面一题判断是否存在最小窗口的一样，可以判断是否在s2中
     * 然后这个是要连续的s2
     */
    public boolean checkInclusion(String s1, String s2){
        int[] mp = new int[256];
        for (char c : s1.toCharArray()) mp[c]++;
        int start = 0, end = 0;
        int cnt = 0;
        int s1_len = s1.length(), s2_len = s2.length();
        if (s1_len > s2_len){
            return false;
        }
        while (end < s2_len){
            char c = s2.charAt(end);
            mp[c]--;
            if (mp[c] >= 0) {//匹配到s1的元素就加一，往前匹配
                cnt++;
                end++;
            }else {//没有匹配到s1的元素就将窗口往前匹配，缩短窗口
                //减当前的位置的值加回去，避免直接end++无法判断当前是否为s1元素
                mp[c]++;
                //将窗口前面的元素去掉，更新mp值以及长度
                c = s2.charAt(start);
                mp[c] += 1;
                start++;
                cnt--;
            }
            //判断是否匹配到s1的组合，因为end在匹配到就+1了，注意长度刚刚好是s1
            if (cnt == s1_len && end - start == s1_len){
                return true;
            }
        }
        return false;
    }
}
