package leetcode0728;

/**
 * @author: celeste
 * @create: 2020-07-28 01:18
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 1, 3, 2, 8};
        MergeSort me = new MergeSort();
        me.mergeSort(nums);
        System.out.println(nums);
    }
}
