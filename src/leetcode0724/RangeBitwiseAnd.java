package leetcode0724;

/**
 * @author: celeste
 * @create: 2020-07-24 02:47
 * @description:
 * 题目：201. 数字范围按位与
 * 描述：给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 **/
public class RangeBitwiseAnd {
    /**
     * 数字范围按位与不就是每个数字与操作吗？
     * 但是会超出时间限制
     */

    public int rangeBitwiseAnd(int m, int n){
        int result = m;
        for (int i = m + 1; i <= n; i++){
            result &= i;
        }
        return result;
    }

    /**
     * 数字范围按位与是求的最前面的前缀，后面都是与0
     */
    public int rangeBitwiseAnd_2(int m, int n){
        int count = 0;
        while (m < n){
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}
