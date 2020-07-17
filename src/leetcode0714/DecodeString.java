package leetcode0714;

import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/7/14 0:41
 * 题目：394. 字符串解码
 * 描述：给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string
 * 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，
 * 且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，
 * 例如不会出现像 3a 或 2[4] 的输入。
 */
public class DecodeString {
    /**
     * "3[a]2[bc]"   3 [ a ] 弹出 辅助栈存放[] 3
     * [ a ]
     * aaa
     * 主栈aaa
     * 2
     * 辅助栈 [bc]
     * bcbc
     * 主栈aaabcbc
     * 主栈保存什么？
     * 辅助栈保存什么？
     * abc3[cd]xyz    a b c 3
     * 3[a2[c]]  3 入栈 3 [ a 2 [c] 出栈  cc入下一个辅助栈  3 [ a ]出栈
     * a+cc 3次
     * 辅助栈是放已经弄好的字符串
     */
    public String decodeString(String s) {
        if (s.length() == 0){
            return "";
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case ']':
                    String temp = "";
                    while (!stack.isEmpty() && !stack.peek().equals("[")){
                        String v = stack.pop();
                        temp = v + temp;//将中间部分组合
                    }
                    stack.pop();
                    int idx = 0;
                    int j = 1;
                    while (!stack.isEmpty() && stack.peek().charAt(0) >= '0' && stack.peek().charAt(0) <= '9'){
                        idx = Integer.parseInt(stack.pop()) * j + idx;
                        j *= 10;
                    }
                    for (int k = 0; k < idx; k++){
                        stack.push(temp);
                    }
                default:
                    if (s.charAt(i) != ']'){
                        stack.push(String.valueOf(s.charAt(i)));
                    }
            }
        }
        String result = "";
        while (!stack.isEmpty()){
            result = stack.pop() + result;
        }
        return result;
//        char[] chars = s.toCharArray();
//        Stack<String> stack = new Stack<>();
//        Stack<String> helper = new Stack<>();
//        for (int i = 0; i < chars.length; i++) {
//
//            //遇到 ],把前面直到数字都弹出来
//            if (chars[i] == '[') {
//                helper.push(String.valueOf(chars[i++]));
//                while (chars[i] != ']') {
//                    //数字都需要进主站
//                    if (Character.isDigit(chars[i])){
//                        String digit = String.valueOf(chars[i]);
//                        while (Character.isDigit(chars[i])){
//                            digit = String.valueOf(chars[i++]) + digit;
//                        }
//                        stack.push(digit);
//                    }else {
//                        helper.push(String.valueOf(chars[i++]));
//                    }
//                }
//            }
//            //遇到了]
//            if (chars[i] == ']') {
//                String main = "";
//                //把辅助栈道[为止的元素弹出来
//                String temp = helper.pop();
//                while (!temp.equals("[")) {
//                    main = temp + main;
//                    temp = helper.pop();
//                }
//                String n = stack.peek();
//                int num = 1;
//                if (Character.isDigit(n.charAt(0))){
//                    num = Integer.parseInt(stack.pop());
//                }
//                String helperTemp = "";//数字+[]
//                while (num != 0) {
//                    helperTemp = main + helperTemp;
//                    num--;
//                }
//                //判断是否可以放进主栈，看辅助栈是否为空
//                if (helper.isEmpty()) {
//                    stack.push(helperTemp);
//                } else {
//                    helper.push(helperTemp);
//                }
//            }
//            //数字入主栈
//            else if (Character.isDigit(chars[i])) {
//                stack.push(String.valueOf(chars[i]));
//            }
//            else {
//                stack.push(String.valueOf(chars[i]));
//            }
//        }
//        String result = "";
//        while (!stack.isEmpty()){
//            result = stack.pop() + result;
//        }
//        return result;

//                String temp = "";//helper里装的字符串
//                char ch = stack.pop();
//                while (ch != '['){
//                    temp = ch + temp;
//                    ch = stack.pop();
//                }
//                int num = Integer.parseInt(String.valueOf(stack.pop()));
//
//                String helperTemp = helper.isEmpty() ? "" : helper.pop();
//                while (num != 0){
//                    helperTemp = temp + helperTemp;
//                    num--;
//                }
//                helper.push(temp);
//            }
//        }
//        String he = helper.pop();
//        while (!stack.isEmpty()){
//            he = stack.pop() + he;
//        }
//        return he;
    }
}
