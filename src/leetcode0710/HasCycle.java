package leetcode0710;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Celeste
 * create time: 2020/7/10 1:32
 * 题目：141. 环形链表
 * 描述：给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置
 * （索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class HasCycle {
    /**
     * 第一想法就是使用hashSet判断set中是否已经存在这个节点
     */
    public boolean hasCycleWithHashSet(ListNode head){
        Set<ListNode> set = new HashSet<>();
//        if (head == null || head.next == null){
//            return false;
//        }
        while (head != null){
            if (set.add(head)){
                head = head.next;
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 快慢指针
     * 有环一定会相遇
     */

    public boolean hasCycle(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast != slow){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null || fast.next == null){
            return false;
        }else {
            return true;
        }
    }
}
