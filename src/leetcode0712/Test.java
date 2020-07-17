package leetcode0712;

/**
 * author: Celeste
 * create time: 2020/7/12 1:02
 */
public class Test {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        IsPalindrome isP = new IsPalindrome();
        isP.isPalindrome(node);
    }
}
