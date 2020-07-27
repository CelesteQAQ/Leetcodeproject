package leetcode0727;

/**
 * @author: celeste
 * @create: 2020-07-27 17:06
 * @description:
 * 经典排序算法：快速排序
 * 快排分为几步：
 * 首先选择一个比较值
 * 然后partition将大于和小于等于分开
 * 然后各自循环下去继续下去
 **/
public class QuickSort {
    public int[] quickSort(int[] nums){
        return qSort(nums, 0, nums.length - 1);
    }
    public int[] qSort(int[] nums, int start, int end){
        if (start >= end){
            return nums;
        }
        int mid = partition(nums, start, end);
        qSort(nums, start, mid);
        qSort(nums, mid + 1, end);
        return nums;
    }

    private int partition(int[] nums, int start, int end) {
        int cursor = nums[end];
        int i = start;
        /**
         * 将小于等于cursor的往前面交换     4 5 1 3 2 8
         * 前面大于的跟后面大于的值交换
         */
        for (int j = start; j < end; j++){
            if (nums[j] < cursor){
                swap(nums, i ,j);
                i++;
            }
        }
        swap(nums, i, end);
        return i;

    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
