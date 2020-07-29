package leetcode0730;

/**
 * @author: celeste
 * @create: 2020-07-30 00:54
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        LongestConsecutive lo = new LongestConsecutive();
        int a = lo.longestConsecutive(nums);
        System.out.println(a);
    }
}
