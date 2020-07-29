package leetcode0730;

import leetcode0725.SearchTarget;
import leetcode0728.MergeSort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: celeste
 * @create: 2020-07-30 00:39
 * @description:
 * 题目：128. 最长连续序列
 * 描述：给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 思路：首先是想对他进行排序，排序之后就可以判断最长连续序列的长度，更新
 * 允许重复值吗？
 * 排序的时间复杂度为O(n)的排序算法选什么？
 **/
public class LongestConsecutive {
    public int longestConsecutive(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        //排序
        MergeSort me = new MergeSort();
        nums = me.mergeSort(nums);
        //排序完之后对nums判断是否为连续
        int[] longest = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            if(i == 0){
                longest[i] = 1;
            }else if (nums[i] == nums[i - 1] + 1){//连续则最长为前一个位置的值加一
                longest[i] = longest[i - 1] + 1;
            }else if(nums[i] == nums[i - 1]){//否则则为1
                longest[i] = longest[i - 1];
            }else{
                longest[i] = 1;
            }
            max = Math.max(max, longest[i]);
        }
        return max;
    }


    /**
     * 使用一个set将数字都保存起来，再遍历
     * 如果当前数字的前一个数字存在，则跳过，因为后面也会遍历到
     * 然后往后+1判断是否存在，存在就+1
     * 选择最大值返回
     * @param nums
     * @return
     */
    public int longestConsecutiveWithLeetCode(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i : nums){
            set.add(i);
        }
        int result = 0;
        for (int num : set){
            if (!set.contains(num - 1)){
                int CurrentNum = num;
                int longestCur = 1;
                while (set.contains(CurrentNum + 1)){
                    CurrentNum++;
                    longestCur++;
                }
                result = Math.max(result, longestCur);
            }
        }
        return result;
    }
}
