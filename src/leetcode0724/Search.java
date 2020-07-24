package leetcode0724;

/**
 * @author: celeste
 * @create: 2020-07-24 13:21
 * @description:
 * 题目：704. 二分查找
 * 描述：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 **/
public class Search {
    /**
     * 就是二分查找，四点要素，start、end、退出条件、比较返回
     */
    public int search(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
