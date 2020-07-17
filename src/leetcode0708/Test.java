package leetcode0708;



/**
 * author: Celeste
 * create time: 2020/7/8 1:07
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        Partition pa = new Partition();
        pa.partition2(node1, 3);

    }
}
