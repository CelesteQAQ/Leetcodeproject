package leetcode0728;

import java.util.Arrays;

/**
 * @author: celeste
 * @create: 2020-07-28 00:25
 * @description:
 * 经典排序算法：归并排序
 * 描述：之前看到说归并排序是从下往上的，快速排序是从上往下
 * 归并先切成2份，排序后合并
 * divide and conquer
 **/
public class MergeSort {
    public int[] mergeSort(int[] nums){
        return mSort(nums);
    }
    public int[] mSort(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        if (nums == null || nums.length == 1){//最小的板块就是一个元素
            return nums;
        }
        int mid = start + (end - start) / 2;
        //divide
        int[] left = mSort(Arrays.copyOfRange(nums, start, mid + 1));
        int[] right = mSort(Arrays.copyOfRange(nums, mid + 1, end + 1));
        int[] result = merge(left, right);
        return result;
    }

    private int[] merge(int[] left, int[] right) {
        int l = 0;
        int r = 0;
        int i = 0;
        int[] result = new int[left.length + right.length];
        while (l < left.length && r < right.length){
            if (left[l] <= right[r]){
                result[i++] = left[l++];
            }else {
                result[i++] = right[r++];
            }
        }
        while (l != left.length){
            result[i++] = left[l++];
        }
        while (r != right.length){
            result[i++] = right[r++];
        }
        return result;
//        int len = end - start + 1;
//        int[] tempNums = new int[len];
//        int start_2 = mid + 1;
//        //注意已经越界了
//        for (int i = 0; i < len; i++){
//            if (nums[start] <= nums[start_2]){
//                tempNums[i] = nums[start];
//                start++;
//            }else {
//                tempNums[i] = nums[start_2];
//                start_2++;
//            }
//        }
//        nums = Arrays.copyOf(tempNums, len);
//        return;return
    }

}
