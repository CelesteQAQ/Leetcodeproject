package leetcode0729;

/**
 * @author: celeste
 * @create: 2020-07-29 01:34
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 10, 3, 5, 1};
        HeapSort he = new HeapSort();
        he.heapSort(nums);
        System.out.println(nums);
    }
}
