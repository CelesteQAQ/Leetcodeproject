package leetcode0724;

/**
 * @author: celeste
 * @create: 2020-07-24 01:40
 * @description:
 * 题目：338. 比特位计数
 * 描述：给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 **/
public class CountBits {
    /**
     * 可以一直调用汉明重量函数
     */

    public int[] countsBits(int num){
        int[] result = new int[num + 1];
        HammingWeight ha = new HammingWeight();
        for (int i = 0; i <= num; i++){
            result[i] = ha.hammingWeightWithAnd(i);
        }
        return result;
    }

    /**
     * 动态规划+当前数字的1出现次数是由之前出现的数字+1
     * 如 0 1
     * 10 11
     * 100 101 110 111
     * 都是由0 - b决定的
     */
    public int[] countBitsWithDP (int num){
        int[] result = new int[num + 1];
        int i = 0;
        int  b = 1;
        while (b <= num){
            while (i < b && i + b <= num){
                result[i + b] = result[i] + 1;
                i++;
            }
            i = 0;
            b <<= 1;
        }
        return result;
    }

    /**
     * 动态规划+最后一位1是当前数字除以2得到的数字个数+最后一位是否为1
     * 如100 10 111 11 1000 100
     */
    public int[] countBitsWithLastBit(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num;  i++){
            result[i] = result[i / 2] + (i & 1);//注意&操作符是比其他运算符优先度要低
        }
        return result;
    }

    /**
     * 前面一直使用的a&（a-1)相当于是当前数字去掉最后一位1
     * 所以当前数字的1出现的次数=a&(a-1)出现的次数+1
     */
    public int[] countBitsWithAnd(int num){
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++){
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

}
