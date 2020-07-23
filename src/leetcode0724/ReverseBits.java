package leetcode0724;

/**
 * @author: celeste
 * @create: 2020-07-24 02:28
 * @description:
 * 题目：190. 颠倒二进制位
 * 描述：颠倒给定的 32 位无符号整数的二进制位。
 **/
public class ReverseBits {
    /**
     * 直接倒插
     */
    public int reverseBits(int n){
        int result = 0;
        int bit = 32;
        while (bit != 0){
            result += (n & 1) << bit;
            n >>= 1;
            bit--;
        }
        result += (n & 1);
        return result;
    }
}
