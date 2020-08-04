package leetcode0804;

/**
 * @author: celeste
 * @create: 2020-08-04 12:49
 * @description:
 * 题目：45. 跳跃游戏 II
 * 描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 **/
public class Jump {
    /**
     * 2 3 1 1 4
     * 找到最小的跳跃长度
     * 将前面，每个可以跳到的位置为true改为可以跳到的大小，不可以跳到就是0
     * 可以跳到的最小数字，加一个最小值的判断
     * 1 1
     * 有一个测试用例太长（时间限制）
     */
    public int jump(int[] nums){
        int len = nums.length;
        if (len == 0){
            return 0;
        }
        int[] state = new int[len];
        state[0] = 0;
        for (int i = 1; i < len; i++){
            state[i] = i;
            for (int j = 0; j < i; j++){
                if (nums[j] + j >= i){
                    state[i] = Math.min(state[i], state[j] + 1);
                }
            }
        }
        return state[len - 1];
    }

    /**
     * 贪心优化算法
     * 首先可以到达的就是
     * 因为确保是可以到达，所以不需要考虑无法到达的情况，肯定都是覆盖的
     */
    public int jump_2(int[] nums){
        int len = nums.length;
        int[] state = new int[len];
        for (int i = 0; i < len; i++){
            int idx = 0;
            while (idx < len && idx + nums[idx] < i){
                idx++;
            }
            state[i] = state[idx] + 1;
        }
        return state[len - 1];
    }
}
