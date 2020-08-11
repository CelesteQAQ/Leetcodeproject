package leetcode0811;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-11 19:25
 * @description:
 * 题目：78. 子集
 * 描述：给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 **/
public class Subsets {
    /**
     * 可以遍历整个数组，将没有加入，1个加入，2个加入
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();


        helper(nums,0, list, result);
        return result;

    }

    /**
     *
     * @param nums : 需要从里面遍历
     * @param pos ：遍历到的位置
     * @param list ： 临时的列表
     * @param result ： 结果
     */
    private void helper(int[] nums, int pos, List<Integer> list, List<List<Integer>> result) {
        List<Integer> ans = new LinkedList<>();
        ans.addAll(list);//注意复制，不可以直接使用相等 ans = list，否则操作的就是同一个数组
        result.add(ans);
        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            helper(nums, i + 1, list, result);// 相当于，加了1进去，然后继续往里面添加2，3，等
            list = new LinkedList<>();//然后将1去掉，继续往下走
            list.addAll(ans);//注意复制的方式依旧是不可以使用等号来操作
        }
    }
}
