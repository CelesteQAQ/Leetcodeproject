package leetcode0802;

/**
 * @author: celeste
 * @create: 2020-08-02 17:03
 * @description:
 * 题目：55. 跳跃游戏
 * 描述：给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 **/
public class CanJump {
    /**
     * 可以去到最后一个位置，也可以通过建立一个数组，将每个位置可以去到的位置更新
     * （注意是可以去到的最大的跳跃步伐）
     * 2 3 1 1 4
     * 速度太慢，但是空间复杂度还好
     */
    public boolean canJump(int[] nums) {
        boolean[] state = new boolean[nums.length];
        state[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (state[i]) {//将当前位置可以去到的地方全部置为真
                int step = nums[i];
                int j = 1;
                while (step != 0 && i + j < nums.length) {
                    state[i + j] = true;
                    j++;
                    step--;
                }
            }
            if (state[nums.length - 1]) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump_2(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        boolean[] state = new boolean[nums.length];
        state[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (state[j] && nums[j] + j >= i) {
                    state[i] = true;
                }
            }
        }
        return state[nums.length - 1];

    }
}
