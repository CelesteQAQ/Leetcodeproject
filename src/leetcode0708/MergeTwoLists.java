package leetcode0708;

/**
 * author: Celeste
 * create time: 2020/7/8 0:37
 * 题目：21. 合并两个有序链表
 * 描述：将两个升序链表合并为一个新的 升序 链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists  {
    /**
     * 两个链表都是升序，直接比较
     * 剩下的直接加
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0);
        ListNode head = new ListNode(0);
        head.next = result;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                result.next = l1;
                result = result.next;
                l1 = l1.next;

            }else {
                result.next = l2;
                result = result.next;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            result.next = l2;
        }else {
            result.next = l1;
        }
        return head.next.next;

    }

    /**
     * 使用递归的方法
     * 如果l1是null，返回l2
     * 如果l2是null，返回l1
     * 如果l1.val 大于 l2.val，返回l1与l2.next的合并
     * 否则返回l1.next与l2的合并
     */

    public ListNode mergeTwoListsWithRecursive(ListNode l1, ListNode l2){
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        if (l1.val > l2.val){
            l2.next = mergeTwoListsWithRecursive(l1, l2.next);
            return l2;
        }else {
            l1.next = mergeTwoListsWithRecursive(l1.next, l2);
            return l1;
        }
    }
}
