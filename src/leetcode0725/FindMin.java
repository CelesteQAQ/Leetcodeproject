package leetcode0725;

/**
 * @author: celeste
 * @create: 2020-07-25 14:39
 * @description:
 * 题目：153. 寻找旋转排序数组中的最小值
 * 描述：假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 请找出其中最小的元素。
 * 你可以假设数组中不存在重复元素。
 **/
public class FindMin {
    /**
     * 经典查找题，旋转的数组，不是完全有序
     * 处理时小于向哪走，大于向哪走？
     */
    public int findMin(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int min = nums[start];
        while (start <= end){
            int mid = start + (end - start) / 2;
            if (nums[mid] < min){//当前值小于最小值，最小值设为当前值，并且查找范围变为前半部分
                min = nums[mid];
                end = mid - 1;
            }else {//当前值大于最小值，最小值依旧是最小值，范围变为查找后半部分
                start = mid + 1;
            }
        }
        return min;
    }

}
