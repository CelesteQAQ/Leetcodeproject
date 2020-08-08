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
}
