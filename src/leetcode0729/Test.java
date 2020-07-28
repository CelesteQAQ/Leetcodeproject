package leetcode0729;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: celeste
 * @create: 2020-07-29 01:34
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
//        int[] nums = new int[]{4, 10, 3, 5, 1};
//        HeapSort he = new HeapSort();
//        he.heapSort(nums);
//        System.out.println(nums);

        //120. 三角形最小路径和
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(2);
        lists.add(temp);
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(3);
        temp1.add(4);
        lists.add(temp1);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(6);
        temp2.add(5);
        temp2.add(7);
        lists.add(temp2);
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(4);
        temp3.add(1);
        temp3.add(8);
        temp3.add(3);
        lists.add(temp3);
        MinimumTotal mi = new MinimumTotal();
        mi.minimumTotal(lists);
    }
}
