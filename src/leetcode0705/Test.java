package leetcode0705;


/**
 * author: Celeste
 * create time: 2020/7/5 3:41
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ReverseBetween re = new ReverseBetween();
        re.reverseBetween(node1, 2, 4);
    }
}
