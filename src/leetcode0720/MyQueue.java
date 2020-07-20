package leetcode0720;

import java.util.Stack;

/**
 * @author: celeste
 * @create: 2020-07-20 11:20
 * @description:
 * 题目：232. 用栈实现队列
 * 描述：使用栈实现队列的下列操作：
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 **/
public class MyQueue {


    Stack<Integer> stack = new Stack<>();//入队列就入栈
    Stack<Integer> helper = new Stack<>();//出队列，则出栈，如果为空则stack入栈再出栈
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!helper.isEmpty()){
            return helper.pop();
        }else {
            while (!stack.isEmpty()){
                helper.push(stack.pop());
            }
            return helper.pop();
        }

    }

    /** Get the front element. */
    public int peek() {
        if (!helper.isEmpty()){
            return helper.peek();
        }else {
            while (!stack.isEmpty()){
                helper.push(stack.pop());
            }
            return helper.peek();
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack.isEmpty() && helper.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

}
