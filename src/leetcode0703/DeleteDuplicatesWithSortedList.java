package leetcode0703;

/**
 * author: Celeste
 * create time: 2020/7/3 2:19
 * 题目：82. 删除排序链表中的重复元素 II
 * 描述：给定一个排序链表，删除所有含有重复数字的节点，
 * 只保留原始链表中 没有重复出现 的数字。
 */
public class DeleteDuplicatesWithSortedList {
    /**
     * 与删除重复节点相比，是将所有重复节点删除，不能留下当前节点
     */
    Integer previous = null;

    public ListNode deleteDuplicatesWithSortedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
//        if (head.val == head.next.val){
//            while (head.next != null && head.val == head.next.val){
//                head = head.next;
//            }
//        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        //1 1 2 2 4 4 5
        //0 1 1 2 2 4 4 5
        while (p.next != null && p.next.next != null){
            if (p.next.val == p.next.next.val){
                p.next = p.next.next;
                while (p.next.next != null && p.next.val == p.next.next.val){
                    p.next = p.next.next;
                }
                p.next = p.next.next;
            }else {
                p = p.next;
            }

        }
        return dummy.next;
//        head.next = deleteDuplicatesWithSortedList(head.next);
//        if (head.next != null && (head.val == head.next.val || head.next.val == previous)){
//            head = head.next.next;
//        }else {
//            previous = head.val;
//        }
//        return head;

//        ListNode curNode = head;
//        ListNode preNode = new ListNode(0);
//
//        if (curNode.next != null && curNode.val == curNode.next.val){
//        while (curNode.next != null && curNode.val == curNode.next.val){
//            curNode = curNode.next;
//        }
//        head = curNode.next;
//        preNode.next = head;
//        curNode = curNode.next;}
//        else {
//            preNode.next = head;
//
//        }
//
//        while (curNode != null && curNode.next != null){
//            if (curNode.val == curNode.next.val){
//                while (curNode.next != null && curNode.val == curNode.next.val){
//                    curNode = curNode.next;
//                }
//                preNode.next = curNode.next;
//                curNode = curNode.next;
//            }else{
//                curNode = curNode.next;
//                preNode = preNode.next;
//            }
//        }
//        return head;
    }

    /**
     * 使用递归的方法
     * 如果是重复的跳过直到删完，返回下一个元素的删除重复值
     * 如果是不重复的下一元素是下一元素的删除重复值的返回值
     */

    public ListNode deleteDuplicatesWithRecursive(ListNode head){
        if (head == null){
            return head;
        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode p = dummy;
        if (head.next != null && head.val == head.next.val){
            if (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicatesWithRecursive(head.next);
            }
        else {
                head.next = deleteDuplicatesWithRecursive(head.next);
            }
        return head;
    }
}
