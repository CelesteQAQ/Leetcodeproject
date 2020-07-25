package leetcode0725;

import java.util.Arrays;

/**
 * @author: celeste
 * @create: 2020-07-25 20:33
 * @description:
 * 题目：33. 搜索旋转排序数组
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 **/
public class SearchTarget {
    /**
     * 与前面的寻找最小值相比，最小值位置可以变化（确切的知道最小值的位置，
     * 但是寻找指定的值的位置，找不到返回-1，与中间值比较，如果目标值大于当前位置，存在2种可能
     * 第一就是切下去，左边有序，右边无序（如果目标值大于第一位，则往右边寻找），4 5 6      7 0 1 2
     * 第二就是左边无序，右边有序   4 5 6 7 0      1 2
     * 那么第一步判断哪边是有序的，如果有序中没有，循环无序查找
     */

    public int search(int[] nums, int target) {
        int len = nums.length;
        return searchTarget(nums, 0, len - 1, target);
    }
    public int searchTarget(int[] nums, int start, int end, int target){
        if (start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[start] <= nums[mid]){//左边有序,注意这个小于等于号
            if (target <= nums[mid] && target >= nums[start]){//在左边有序数组中
                return binarySearch_1(nums, start, mid, target);
            }else {//其他情况都是递归
                return searchTarget(nums,mid + 1, end, target);
            }
        }else {//右边有序
            if (target <= nums[end] && target >= nums[mid]) {//在右边有序里面
                return binarySearch_1(nums, mid, end, target);
            } else {//其他情况
                return searchTarget(nums, start, mid - 1, target);
            }
        }
    }

    public int binarySearch_1(int[] nums, int start, int end, int target){
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
