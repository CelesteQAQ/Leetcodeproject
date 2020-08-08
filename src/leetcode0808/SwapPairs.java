package leetcode0808;

import java.util.List;

/**
 * @author: celeste
 * @create: 2020-08-08 14:48
 * @description:
 * 题目：24. 两两交换链表中的节点
 * 描述：给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 **/
public class SwapPairs {
    /**
     * 为什么是递归？
     * 不是直接每2个交换就可以了吗？
     * 1 -> 2 -> 3 -> 4
     * 2 -> 1 -> 3 -> 4
     */
    public ListNode swapPairs_1(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode dummy_1 = dummy;
        while (dummy.next != null && dummy.next.next != null){
            ListNode temp = dummy.next.next;//2
            dummy.next.next = dummy.next.next.next;
            temp.next = dummy.next;
            dummy.next = temp;
            dummy = dummy.next.next;
        }
        return dummy_1.next;
    }

    /**
     * 递归方法，就是默认后面已经排序好（递归的位置）
     * 然后将位置转换
     */
    public ListNode swapPairs(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //选出需要变换位置的第一个位置以及第二个位置
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        //后面位置的节点默认已经变换完，然后交换
        firstNode.next = swapPairs(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }

}
