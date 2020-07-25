package leetcode0725;

/**
 * @author: celeste
 * @create: 2020-07-25 13:15
 * @description:
 * 题目：35. 搜索插入位置
 * 描述：给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 **/
public class SearchInsert {
    /**
     * 如果没有就返回按顺序插入的位置，就是需要start以及end的信息，选择模板1
     * 后处理一个数，不等于就返回当前数字，等于也是返回当前数字
     */
    public int searchInsert(int[] nums, int target){
            if (nums == null || nums.length == 0){
                return 0;
            }
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {//当前值小于目标值，返回应该是start
                    start = mid + 1;
                } else {//当前值大于目标值，start还是那个start，返回应该是end
                    end = mid - 1;
                }
            }

            if (nums[start] >= target){//最后一个大于等于target都是返回这个
                return start;
            }else {//否则就返回start+1
                return start + 1;
            }
    }

    /**
     * 二叉查找模板2
     * 直接可以返回
     */
    public int searchInsert_2(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (target > nums[mid]){//目标值大于当前值，则start从当前的下一个开始，返回也是当前的下一个
                start = mid + 1;
            }else {//目标值小于或者等于当前值，则从当前的前一个结束，并且当start与end指的是同一个时，start没有变，返回依旧是start
                end = mid - 1;
            }
        }
        return start;
    }
}
