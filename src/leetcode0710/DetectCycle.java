package leetcode0710;

/**
 * author: Celeste
 * create time: 2020/7/10 1:58
 * 题目：142. 环形链表 II
 * 描述：给定一个链表，返回链表开始入环的第一个节点。 
 * 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置
 * （索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 */
public class DetectCycle {
    /**
     * 找链表有环情况下的入口
     * 使用快慢指针
     * 快慢指针相遇之后，慢指针再从起点开始，快指针继续走
     * 等到再次相遇就是环的入口
     */
    public ListNode detectCycle(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        //相遇之后，slow回到最开始的起点
        //并且fast是从下一个节点开始与slow节点的步伐一致往前移动，相遇就是入口
        slow = head;
        fast = fast.next;//因为开始是从head-->next开始的
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
