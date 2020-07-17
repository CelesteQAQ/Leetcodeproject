package leetcode0713;

import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/7/13 1:07
 * 题目：155.最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 */
public class MinStack {

    /**
     * 怎么建立？使用链表还是数组？
     * 常数时间内检索到最小元素的栈是将最小值添加到链表当中
     * 那么是链表里面的元素如何初始化？
     * 方法是使用2个栈来实现，一个最小栈始终保持最小值在顶部
     */
    private Stack<Integer> data;
    private Stack<Integer> helper;
    public MinStack(){
        data = new Stack<>();
        helper = new Stack<>();
    }
    public void push(int x) {
        data.add(x);
        if (helper.isEmpty() || helper.peek() >= x){
            helper.add(x);
        }else {
            helper.add(helper.peek());
        }
    }

    public void pop() {
        if (!data.isEmpty()){
            helper.pop();
            data.pop();
        }
    }

    public int top() {
        if (!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈元素为空，此操作非法");
    }

    public int getMin() {
        if (!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈元素为空，此操作非法");
    }
}
