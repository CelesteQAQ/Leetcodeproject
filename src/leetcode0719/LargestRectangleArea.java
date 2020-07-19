package leetcode0719;

import java.sql.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-07-19 21:07
 * @description:
 * 题目：84. 柱状图中最大的矩形
 * 描述：给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 **/
public class LargestRectangleArea {
    /**
     * 最大面积是区间最小高度*区间宽度
     * 首先使用2个for循环一直找最大值
     * 注意循环的起点以及终点，以及可以是单一个，这样面积就是本身的高度
     */
    public int largestRectangleArea(int[] heights){
        if (heights.length == 0){
            return 0;
        }
        int result = 0;
        for (int i = 0; i < heights.length; i++){
            int minHeight = heights[i];
            for (int j = i; j < heights.length; j++){
                //找到最小高度
                minHeight = Math.min(minHeight, heights[j]);
                //找到最大面积
                result = Math.max(minHeight * (j - i + 1), result);
            }
        }
        return result;
    }

    /**
     * 使用栈来存储左边最小的高度的位置
     * 然后，记录当前作为柱子高度的左边起点，右边终点，计算最大宽度
     */
    public int largestRectangleAreaWithStack(int[] heights){
        int len = heights.length;
        if (len == 0){
            return 0;
        }
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++){
            //左边有最小高度，并且本身小于左边最小，则出栈，且栈顶位置的右边界限是当前位置
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                right[stack.pop()] = i;
            }
            //否则，入站，当前节点的左边边界是栈顶位置
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
       int ans = 0;
        for (int j = 0; j < heights.length; j++){
            ans = Math.max(ans, (right[j] - left[j] - 1) * heights[j]);
        }
        return ans;

    }

}
