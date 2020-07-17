package leetcode0705;

/**
 * author: Celeste
 * create time: 2020/7/5 2:55
 * 题目：92. 反转链表 II
 * 描述：反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 */
public class ReverseBetween {
    /**
     *在中间反转使用前面反转的prev，curr以及next节点
     * 即
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null){
            return head;}
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode prev = null;
        int len = n - m + 1;
        while (m != 0){
            // 0-->1-->2-->3-->4-->5
            prev = head;
            head = head.next;
            m--;
        }
        //2-->3-->4-->5
        ListNode next = null;
        ListNode mid = head;

        while (head != null && len != 0){
            // 1-->2-->3-->4-->5
            // 1-->4-->3-->4-->5
            ListNode tempNext = head.next;//3-->4-->5
            head.next = next;//null
            next = head;//
            head = tempNext;
            len--;
        }
        prev.next = next;
        mid.next = head;

        return dummy.next;
    }
    }
