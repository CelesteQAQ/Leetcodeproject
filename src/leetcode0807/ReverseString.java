package leetcode0807;

/**
 * @author: celeste
 * @create: 2020-08-07 17:06
 * @description:
 * 题目：344. 反转字符串
 * 描述：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 **/
public class ReverseString {
    /**
     * 使用递归就是先打印后面然后再打印自己
     * 需要原地修改自己然后输出
     * 那就是从中间开始往外面交换
     */
    public void reverseString(char[] s){
        if (s.length == 0 || s.length == 1){
            return;
        }
        for (int i = 0; i < s.length / 2; i++){
            if (i < s.length - i - 1){
                char temp = s[i];
                s[i] = s[s.length - i - 1];
                s[s.length - i - 1] = temp;
            }
        }
    }

    /**
     * 递归的方法
     * 但是空间复杂度没有上面的方法好，因为递归需要耗费一个栈的空间
     */
    public void reverseString_2(char[] s){
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int left, int right) {
        if (left < right){
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
            helper(s, left, right);
        }
    }

}
