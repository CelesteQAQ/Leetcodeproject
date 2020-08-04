package leetcode0805;

import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-05 02:16
 * @description:
 * 题目：139. 单词拆分
 * 描述：给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * s = "leetcode", wordDict = ["leet", "code"]
 * 是先判断是否存在，然后判断后半部分是否存在？？
 * 依旧是使用一个状态数组存储是否可以切割
 * 然后从前面开始判断是否可以切割以及后面是否存在，是就是可以切割
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict){
        int len = s.length();
        if (len == 0){
            return true;
        }
        boolean[] state = new boolean[len + 1];
        state[0] = true;
        for (int i = 1; i < len + 1; i++){
            for (int j = 0; j < i; j++){
                if (state[j] && wordDict.contains(s.substring(j, i))){
                    state[i] = true;
                }
            }
        }
        return state[len];
    }
}
