package leetcode0722;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: celeste
 * @create: 2020-07-22 21:45
 * @description:
 * 题目：136. 只出现一次的数字
 * 描述：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 **/
public class SingleNumber {
    /**
     * 不考虑附加条件线性时间复杂度，不能用额外空间等
     * 可以直接使用set，如果已存在删除，最后剩下的就是只出现一次的数字
     */
    public int singleNumber(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!set.add(nums[i])){
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    /**
     * 使用位操作的异或，这样只有那个只出现一次的数字会被找出来，其他异或都是0
     */
    public int singleNumberWithBit(int[] nums){
        int result = 0;
        for (int i = 0; i < nums.length; i++){
            result = result ^ nums[i];
        }
        return result;
    }

}
