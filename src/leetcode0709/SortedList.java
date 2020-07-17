package leetcode0709;

/**
 * author: Celeste
 * create time: 2020/7/9 1:54
 * 题目：148. 排序链表
 * 描述：在 O(n log n) 时间复杂度和常数级空间复杂度下，
 * 对链表进行排序。
 */
public class SortedList {
    /**
     * 归并排序，找中点和合并操作
     */
    public ListNode mergeSort(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //找到中心点
        ListNode middle = findMiddle(head);
        ListNode tail = middle.next;
        middle.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(tail);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (left != null && right != null){
            if (left.val < right.val){
                head.next = left;
                left = left.next;
            }else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }
        if (left != null){
            head.next = left;
        }else head.next = right;

        return dummy.next;

    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }



}
