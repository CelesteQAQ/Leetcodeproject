package leetcode0709;

/**
 * author: Celeste
 * create time: 2020/7/9 2:09
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        SortedList so = new SortedList();
        so.mergeSort(node1);
    }
}
