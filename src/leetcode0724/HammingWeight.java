package leetcode0724;

/**
 * @author: celeste
 * @create: 2020-07-24 01:14
 * @description:
 * 题目：191. 位1的个数
 * 描述：编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 **/
public class HammingWeight {
    /**
     * 直接每位判断是否为1，为1就加一
     */
    public int hammingWeightWithBit(int n){
        int result = 0;
        int mark = 1;
        for (int i = 0; i < 32; i++){
            if ((n & mark) != 0){
                result++;
            }
            mark = mark << 1;
        }
        return result;
    }

    /**
     * 使用a&(a-1)可以得到最后一个1转成0
     * 1出现的次数就是可以a&(a-1)的次数
     */
    public int hammingWeightWithAnd(int n){
        int result = 0;
        while (n != 0){
            n = n & (n - 1);
            result++;

        }
        return result;
    }



}
