package leetcode0726;

import java.util.EmptyStackException;

/**
 * @author: celeste
 * @create: 2020-07-26 00:35
 * @description:
 * 题目：154. 寻找旋转排序数组中的最小值 II
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 注意数组中可能存在重复的元素。
 **/
public class FindMinWithDNumber {
    /**
     * 与前面对比，这次的数组是有序并且有重复的
     * 区别在哪，有序不能简单的大于小于直接判断在什么位置
     * 2 2 2 0 1
     */
    public int findMinWithDNumber(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int min = nums[start];
        // 10 1 10 10 10
        while (start + 1 <= end){
            while (start + 1 < end && nums[start] == nums[start + 1]){
                start++;
            }
            while (start + 1 < end && nums[end] == nums[end - 1]){
                end--;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] <= nums[end]){//右边是递增的
                end = mid;
            }else {//左边是递增的
                start = mid;
            }
        }
        if (nums[start] > nums[end]){
            return nums[end];
        }

        return nums[start];
    }

}
