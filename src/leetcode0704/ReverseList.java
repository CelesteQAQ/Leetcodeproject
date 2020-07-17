package leetcode0704;

import java.util.LinkedList;

/**
 * author: Celeste
 * create time: 2020/7/4 1:19
 * 题目:206. 反转链表
 * 描述：反转一个单链表，可以使用迭代或者递归的反转链表
 */
public class ReverseList {

    /**
     * 迭代法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode res;
        res = dummy;
        LinkedList<Integer> nodeList = new LinkedList<>();
        nodeList.addFirst(head.val);
        while (head.next != null){
            nodeList.addFirst(head.next.val);
            head = head.next;
        }
        while (!nodeList.isEmpty()){
            res.next = new ListNode(nodeList.remove());
            res = res.next;
        }
        return dummy.next;

    }

    /**
     * 更加简洁的迭代方法
     */

    public ListNode reverseListWithList(ListNode head){

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode tempNext = curr.next;
            //1 2 3 4 5
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
    }

    /**
     * 使用递归方法
     * 递归是当前节点的next的next是当前
     */

    public ListNode reverseListWithRecursive(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
       ListNode p = reverseListWithRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;

        //1 2 3 4 5
        //1 2 3 4 5
        // 4-->5-->null
        // 5-->4-->null
        //3 5-->4-->null 3-->4
        //5-->4-->3-->null

    }
}
