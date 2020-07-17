package leetcode0713;

import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/7/13 1:43
 * 题目:150. 逆波兰表达式求值
 * 描述：根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，
 * 也可以是另一个逆波兰表达式。
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，
 * 表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvalRPN {
    /**
     * 其实就是一个栈将数字入栈，遇到运算符就弹出进行运算
     */
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        if (len == 0) {
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a - b);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a / b);
            } else {
                String s = tokens[i];
                int foo = Integer.parseInt(s);

                stack.push(foo);
            }

        }
        return stack.pop();
    }
}
