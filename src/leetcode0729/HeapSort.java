package leetcode0729;

/**
 * @author: celeste
 * @create: 2020-07-29 01:11
 * @description:
 * 描述：经典排序算法：堆排序
 * 首先是建堆
 * 然后在n/2位置开始堆调整
 * 最后取出第一个数字。将最后一个数字放在第一位继续堆调整
 * （可以直接在数组处理，因为建堆不是使用的链表）
 **/
public class HeapSort {
    public int[] heapSort(int[] nums){
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--){
            headify(nums, i, len);//平衡
        }
        for (int i = len - 1; i >= 1; i--){
            //得到大根堆后，交换最后一个与第一个
            swap(nums, 0, i);
            //继续对后面的堆进行平衡，但是数组的长度变为len-1
            headify(nums, 0, i);
        }
        return nums;
    }

    private void headify(int[] nums, int i, int len) {
        //平衡一个二叉树如何平衡？i：根节点；len是平衡的最后一个节点
        while (i < len){
            int l = i * 2 + 1;
            int r = i * 2 + 2;
            int maxIndex = i;
            if (l < len && nums[l] > nums[maxIndex]){
                maxIndex = l;
            }
            if (r < len && nums[r] > nums[maxIndex]){
                maxIndex = r;
            }
            if (maxIndex != i){
                swap(nums, i, maxIndex);
                i = maxIndex;
            }else {
                return;
            }
        }



    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
