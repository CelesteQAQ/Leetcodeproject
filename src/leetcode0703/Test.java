package leetcode0703;

/**
 * author: Celeste
 * create time: 2020/7/3 1:28
 */
public class Test {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
//        ListNode listNode5 = new ListNode(4);
//        ListNode listNode6 = new ListNode(4);
//        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
//        listNode6.next = listNode7;
        DeleteDuplicatesWithSortedList de = new DeleteDuplicatesWithSortedList();
        de.deleteDuplicatesWithRecursive(listNode1);



    }
}
