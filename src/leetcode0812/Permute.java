package leetcode0812;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-12 16:34
 * @description:
 * 题目：46. 全排列
 * 描述：给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 **/
public class Permute {
    /**
     * 根前面的子集区别在于这个是全排列，固定大小，但是谁前谁后没有关系
     * 所以可以每次选完之后复制剩下的数字，继续循环
     */
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
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
        result.add(list);
    }

    /**
     * 另一种做法，将已经访问过的加标注为true
     * 下次遇到不会将其加入
     * 但是时间却没有复制剩余部分的数组要好
     * @param nums
     * @return
     */

    public List<List<Integer>> permute_1(int[] nums){
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, list, result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> result) {
        List<Integer> ans = new LinkedList<>();
        ans.addAll(list);//注意复制，不可以直接使用相等 ans = list，否则操作的就是同一个数组
        if (list.size() == nums.length){
            result.add(list);
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited, list, result);
            visited[i] = false;
            list = new LinkedList<>();//然后将1去掉，继续往下走
            list.addAll(ans);//注意复制的方式依旧是不可以使用等号来操作
        }
    }


}
