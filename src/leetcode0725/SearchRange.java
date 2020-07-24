package leetcode0725;

/**
 * @author: celeste
 * @create: 2020-07-25 01:57
 * @description:
 * 题目：linkcode上面的题搜索区间
 * 描述：给定一个包含 n 个整数的排序数组，找出给定目标值 target 的起始和结束位置。
 * 如果目标值不在数组中，则返回[-1, -1]
 **/
public class SearchRange {
    /**
     * 就是找出target出现的位置
     * 理解错误，应该是第一次target出现的位置以及最后一次出现的位置
     */
    public int[] searchRange(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] == target){
                result[0] = mid - 1;
                result[1] = mid  == nums.length - 1 ? -1 : mid + 1;
            }else if (nums[mid] > target){
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }
        return result;
    }

    /**
     * 找到第一个出现的位置以及最后一个出现的位置
     * 使用模板3
     * start + 1 < end
     * 确定最后一定有3个以上
     */
    public int[] searchRange_1(int[] nums, int target){
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] == target){
            result[0] = start;
        }else if (nums[end] == target){
            result[0] = end;
        }else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        //检索最右边的数字
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid] > target){
                end = mid;
            }else if (nums[mid] < target){
                start = mid;
            }else {
                start = mid;
            }
        }
        if (nums[start] == target){
            result[1] = start;
        }else if (nums[end] == target){
            result[1] = end;
        }else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        return result;
    }
}
