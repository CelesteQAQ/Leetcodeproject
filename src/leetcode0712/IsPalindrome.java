package leetcode0712;

/**
 * author: Celeste
 * create time: 2020/7/12 0:53
 * 题目：234. 回文链表
 * 描述：请判断一个链表是否为回文链表。
 */
public class IsPalindrome {
    /**
     * 方法：跟前面插入很像
     * 先找到中间元素，然后判断是否一样
     */
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null){
            return true;
        }
        //先找到中间元素的前一个
        ListNode fast = head.next;//2 4 null 1 2    2 4
        ListNode slow = head;
        ListNode next;
        ListNode temp = null;
        while (fast != null && fast.next != null){//0 0
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast == null){//1 2 2 1
            //奇数 slow 0 1 2  1 2 3 4 5   3
            next = slow.next;
            temp.next = null;


        }else {//1 2 3 4
            //偶数
            next = slow.next;
            slow.next = null;
        }
        //反转next链表
        //ListNode tempNext = next.next;
        ListNode prev = null;
        while (next != null){
            ListNode tempNext = next.next;
            next.next = prev;
            prev = next;
            next = tempNext;
        }


        if (equal(prev,head)){
            return true;
        }else {
            return false;
        }


    }

    private boolean equal(ListNode head, ListNode next) {
        while (head != null && next != null){
            if (head.val != next.val){
                return false;
            }
            head = head.next;
            next = next.next;
        }
        if (head != null || next != null){
            return false;
        }else {
            return true;
        }
    }
}
