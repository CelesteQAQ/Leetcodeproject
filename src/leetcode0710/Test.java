package leetcode0710;



/**
 * author: Celeste
 * create time: 2020/7/10 0:40
 */
public class Test {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node;
//        node3.next = node4;
//        node4.next = node5;
        DetectCycle de = new DetectCycle();
        de.detectCycle(node);
    }
}
