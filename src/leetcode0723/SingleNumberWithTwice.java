package leetcode0723;

/**
 * @author: celeste
 * @create: 2020-07-23 14:30
 * @description:
 * 题目：260. 只出现一次的数字 III
 * 描述：给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。
 * 找出只出现一次的那两个元素。
 *
 **/
public class SingleNumberWithTwice {
    /**
     * 使用异或位操作
     * 这样剩下来的就是只出现1次的2个数字，问题变成了如何分辨2个只出现一次的数字
     * 可以求出2个数字差异的最后一位：减一之后与之前就可以得到
     * 然后再与每一个数字与操作，因为这一位出现1的都要异或，出现2次就会消去，剩下只出现1次的某一个
     */
    public int[] singleNumber(int[] nums){
        int bitMark = 0;
        for (int i = 0; i < nums.length; i++){
            bitMark ^= nums[i];
        }
        int result = 0;
        int diff = bitMark & (-bitMark);
        for (int j = 0; j < nums.length; j++){
            if ((diff & nums[j]) == 0){//注意&操作优先度比==要低
                result ^= nums[j];
            }
        }
        return new int[]{result, result ^ bitMark};
    }
}
