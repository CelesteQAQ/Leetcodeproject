package leetcode0808;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: celeste
 * @create: 2020-08-08 19:50
 * @description:
 * 题目：76. 最小覆盖子串
 * 描述：给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，
 * 从字符串 S 里面找出：包含 T 所有字符的最小子串。
 **/
public class MinWindow {
    /**
     * 这个题需要考虑是否为T字符串的元素，以及匹配到一个字符，然后需要去掉这个字符然后查找剩下的
     * 如果是一样的字符，只需要判断是否是元素，但是现在需要判断是否是剩下的，以及左边窗移动需要更新匹配的字符串
     * 开始匹配，匹配到就加入匹配数组，然后等到匹配结束之后遇到谁就更新窗口
     * 可以使用一个map来存储
     */
    //因为需要check两个map是否一样
    Map<Character, Integer> need = new HashMap<>();//需要的匹配的，就是t
    Map<Character, Integer> have = new HashMap<>();//已经匹配到的
    public String minWindow(String s, String t){

        //将需要的map初始化
        for (int i = 0; i < t.length(); i++){
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;//遍历的位置，最后返回就是l到r
        int min = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen){
            ++r;
            //将所有匹配到的加入到已匹配的map
            if (r < sLen && need.containsKey(s.charAt(r))){
                have.put(s.charAt(r), have.getOrDefault(s.charAt(r), 0) + 1);
            }
            //判断是否已经匹配到完整的need，匹配到之后查看是否可以减去
            while (check() && l <= r){
                //如果现在的长度比最小的还要小，就可以更新最小的长度，以及最小的长度开始的位置
                if (r - l + 1 < min){//注意这个最小的长度是r - l + 1
                    min = r - l + 1;
                    ansL = l;
                    ansR = l + min;
                }
                //开始往前开始缩小窗口
                if (need.containsKey(s.charAt(l))){
                    have.put(s.charAt(l), have.getOrDefault(s.charAt(l), 0) - 1);
                }
                //右移指针
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    //这个check注意是使用迭代器，hasNext以及next，
    public boolean check(){
        Iterator item = need.entrySet().iterator();
        while (item.hasNext()){
            Map.Entry map = (Map.Entry) item.next();
            Character key = (Character) map.getKey();
            Integer value = (Integer) map.getValue();
            if (have.getOrDefault(key, 0) < value){
                return false;
            }
        }
        return true;
    }

    /**
     * 直接转换成快慢指针的问题
     * 建立一个数组，将t的字符串数量记录下来
     * 然后遍历整个s，遇到就减，当遇到减的数目刚刚好是t的长度（注意不能小于0）
     * 这样就可以看看是不是最短的长度，是就当成ans记录下来，下次遇到更小的就更换
     */
    public String minWindow_1(String s, String t){
        //mp记录t中字符出现的次数
        int[] mp = new int[256];
        for (char c : t.toCharArray()) mp[c] += 1;
        //快慢指针
        int start = 0, end = 0;
        int n = s.length(), m = t.length();
        int cnt = 0;
        int res = -1;
        String ans = "";
        while (end < n) {
            char c = s.charAt(end);
            mp[c] -= 1;
            //如果减去的数目大于0，就记下这个相减
            if (mp[c] >= 0) cnt += 1;
            //刚刚好就是t的长度
            while (cnt == m) {
                //如果这次的长度比最小的长度小就可以更新
                if (res == -1 || res > end - start + 1) {
                    ans = s.substring(start, end + 1);
                    res = end - start + 1;
                }
                //左边可以右移，因为前面的字符是已经减过的，一定是小于0的
                c = s.charAt(start);
                mp[c] += 1;
                //只有当加过的还是大于等于1是t里面的字符，只有每个字符还在才可以减去1继续判断长度是否最小
                if (mp[c] >= 1) cnt -= 1;
                start += 1;
            }
            //继续向右移动
            end += 1;
        }
        return ans;

    }
}
