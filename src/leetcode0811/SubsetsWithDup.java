package leetcode0811;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-11 20:57
 * @description:
 * 题目：90. 子集 II
 * 描述：给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 **/
public class SubsetsWithDup {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums,0, list, result);
        //在这里需要对result中出现的重复的list去掉
        //也可以对nums排序之后决定要不要
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
            if (i != pos && nums[i] == nums[i - 1]){//确保是从第二个数字开始，如果与前一个数字相同就跳
                continue;
            }
            list.add(nums[i]);
            helper(nums, i + 1, list, result);// 相当于，加了1进去，然后继续往里面添加2，3，等
            list = new LinkedList<>();//然后将1去掉，继续往下走
            list.addAll(ans);//注意复制的方式依旧是不可以使用等号来操作
        }
    }
}
