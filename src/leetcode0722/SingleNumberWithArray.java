package leetcode0722;

/**
 * @author: celeste
 * @create: 2020-07-22 22:09
 * @description:
 * 题目：137. 只出现一次的数字 II
 * 描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 **/
public class SingleNumberWithArray {
    /**
     * 参考上一题出现2次但是只有一个出现1次可以使用异或，但是这个是出现3次
     * 假设使用异或的话，3个异或出来是自己？
     * 使用将每个1位置上的数目加起来，然后除以3余数就是只出现一次的数字
     */
    public int singleNumber(int[] nums){
        int result = 0;
        for (int i = 0; i < 64; i++){
            int sum = 0;
            for (int j = 0; j < nums.length; j++){
                sum += (nums[j] >> i) & 1;
            }
            result = result | ((sum % 3) << i);
        }
        return result;
    }
}
