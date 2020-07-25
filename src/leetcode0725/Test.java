package leetcode0725;

import leetcode0724.Search;

/**
 * @author: celeste
 * @create: 2020-07-25 14:14
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        SearchTarget se = new SearchTarget();
        int x = se.search(nums, 3);
        System.out.println(x);
    }
}
