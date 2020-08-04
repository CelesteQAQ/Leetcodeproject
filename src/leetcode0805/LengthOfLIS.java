package leetcode0805;

import java.awt.event.MouseAdapter;

/**
 * @author: celeste
 * @create: 2020-08-05 01:37
 * @description:
 * 题目：300. 最长上升子序列
 * 描述：给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 最长上升可以看遇到比现在的数字大的最小的值加入，可以求到当前最长的长度
 * 从最后面往前移动？
 **/
public class LengthOfLIS {
    /**
     * 跟前面那道很像，从前面开始遍历，然后与前面的值开始对比，是否大于前面的值，大于就是排在前面的值后面
     * 所以当前的最长序列长度就是前面小于他的数字+1
     */
    public int lengthOfLIS(int[] nums){
        int len = nums.length;
        if (len == 0 || len == 1){
            return len;
        }
        int[] length = new int[len];
        length[0] = 1;//忘记初始化第一个的长度了
        for (int i = 1; i < len; i++){
            length[i] = 1;//每个位置最小的长度就是1，跟前面切的数目一样切最多是
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){//前面的比当前数字小的，当前长度是前面的数字的长度+1中最大的
                    length[i] = Math.max(length[i], length[j] + 1);
                }
            }
        }
        //选出最大的长度
        int result = 0;
        for (int i = 0; i < len; i++){
            result = Math.max(result, length[i]);
        }
        return result;
    }
}
