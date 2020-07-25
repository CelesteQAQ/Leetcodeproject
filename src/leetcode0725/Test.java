package leetcode0725;

import leetcode0724.Search;

/**
 * @author: celeste
 * @create: 2020-07-25 14:14
 * @description:
 **/
public class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1}};
        SearchMatrix se = new SearchMatrix();
        se.searchMatrix(matrix, 2);
    }
}
