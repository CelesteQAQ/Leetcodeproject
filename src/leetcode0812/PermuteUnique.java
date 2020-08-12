package leetcode0812;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-12 20:04
 * @description:
 * 题目：47. 全排列 II
 * 描述：
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 **/
public class PermuteUnique {
    /**
     * 跟前面一样，遇到下一个一样的是会跳过
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        Arrays.sort(nums);
        helper(nums, list, result);
        return result;
    }

    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result) {
//        if (pos == nums.length){
//            List<Integer> ans = new LinkedList<>();
////            ans.addAll(list);//注意复制，不可以直接使用相等 ans = list，否则操作的就是同一个数组
//            result.add(ans);
//        }
        int num_len = nums.length;
        if(num_len == 0) result.add(list);//添加完之后就可以添加这个结果到result中

        List<Integer> ans = new LinkedList<>();
        ans.addAll(list);//注意复制，不可以直接使用相等 ans = list，否则操作的就是同一个数组
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1]){//确保是从第二个数字开始，如果与前一个数字相同就跳
                continue;
            }
            list.add(nums[i]);
            int[] next = new int[nums.length - 1];
            for (int j = 0; j < nums.length; j++){
                if (j < i){
                    next[j] = nums[j];
                }else if (j == i){
                    continue;
                }else {
                    next[j - 1] = nums[j];
                }

            }
//            int[] next = new int[nums.length - 1];
//            int[] next = Arrays.copyOfRange(nums, 1, nums.length - 1);
            helper(next, list, result);// 相当于，加了1进去，然后继续往里面添加2，3，等
            list = new LinkedList<>();//然后将1去掉，继续往下走
            list.addAll(ans);//注意复制的方式依旧是不可以使用等号来操作
        }
    }

    public List<List<Integer>> permuteUnique_1(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, visited, list, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        List<Integer> ans = new LinkedList<>();
        ans.addAll(list);//注意复制，不可以直接使用相等 ans = list，否则操作的就是同一个数组
        //可以合成一句：result.add(new ArrayList<Integer>(list);
        if (list.size() == nums.length){
            result.add(list);
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i]) continue;
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i-1]){//确保是从第二个数字开始，如果与前一个数字相同就跳
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, list, result);
            visited[i] = false;
            list = new LinkedList<>();//然后将1去掉，继续往下走
            list.addAll(ans);//注意复制的方式依旧是不可以使用等号来操作
        }
    }
}
