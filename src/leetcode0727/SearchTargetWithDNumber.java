package leetcode0727;

/**
 * @author: celeste
 * @create: 2020-07-27 16:18
 * @description:
 * 题目：81. 搜索旋转排序数组 II
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 本题中的 nums 可能包含重复元素。
 **/
public class SearchTargetWithDNumber {
    /**
     * 跟前面说的一样，有重复值，去掉重复值套用无重复值的方法
     */
    public boolean search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            while (start + 1 < end && nums[start] == nums[start + 1]){
                start++;
            }
            while (start + 1 < end && nums[end] == nums[end - 1]){
                end--;
            }
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[mid] >= nums[start]){//当前值大于第一个值，证明是左边有序
                if (target >= nums[start] && target < nums[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {//右边有序，mid+ 1-----end
                if (target >= nums[mid + 1] && target <= nums[end]){//在右边区域
                    start = mid + 1;
                }else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target || nums[end] == target){
            return true;
        }
        return false;
    }
}
