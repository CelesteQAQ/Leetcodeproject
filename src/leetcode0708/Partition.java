package leetcode0708;

/**
 * author: Celeste
 * create time: 2020/7/8 1:42
 * 题目：86. 分隔链表
 * 描述：给定一个链表和一个特定值 x，对链表进行分隔，
 * 使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 * 其实就是快排的链表实现
 * 并且要求是稳定的
 */
public class Partition {
    /**
     * 参考数组版本的快排
     * 只将小于特定值的往前面移动，但是就是不稳定 1 4 3 2 5 2===》1 4 3
     * 1 2 4 3 5 2
     * 链表的稳定性好实现是因为不需要移动
     */
    public ListNode partition(ListNode head, int x){
        ListNode dummy = new ListNode(0);//记住最开始的链表头1
        dummy.next = head;
        ListNode BigDummy = dummy;//记住最开始第一个大于x前面的节点，可以方便插入
        if (head == null || head.next == null){
            return head;
        }
        while (BigDummy.next != null && BigDummy.next.val < x){
            BigDummy = BigDummy.next;
        }
        if (BigDummy.next == null){
            return dummy.next;
        }
        ListNode beforeBig = BigDummy;
        ListNode q = beforeBig;
        while (q.next != null){
            if (q.next.val < x){
                //遇到小于x的换到前面1 4 3 2 5 2===》1 4 3
                ListNode temp = beforeBig.next;//大于部分
                ListNode next = q.next.next;//后面部分
                beforeBig.next = q.next;//换到前面
                beforeBig = beforeBig.next;//最大往后一个
                beforeBig.next = temp;//将最大往前
                q.next = next;
            }else {
                //大于或者等于就跳过
                q = q.next;
            }

        }
        return dummy.next;

    }

    /**
     * 方法二：将大于x的节点，放在另外一个链表，最后链接两个表
     */
    public ListNode partition2(ListNode head, int x){
        if (head == null){
            return head;
        }

        ListNode headDummy = new ListNode(0);
        ListNode tailDummy = new ListNode(0);
        ListNode tail = tailDummy;
        headDummy.next = head;
        head = headDummy;
        while (head.next != null){
            if (head.next.val < x){
                head = head.next;
            }else {
                ListNode t = head.next;
                head.next = head.next.next;
                tail.next = t;
                tail = tail.next;
            }
        }
        tail.next = null;
        head.next = tailDummy.next;
        return headDummy.next;


    }

}
