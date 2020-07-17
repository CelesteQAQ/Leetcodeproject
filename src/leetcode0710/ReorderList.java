package leetcode0710;

/**
 * author: Celeste
 * create time: 2020/7/10 0:28
 * 题目：143. 重排链表
 * 描述：给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {
    /**
     * 先找到中间节点，然后反转后面的链表
     * 再将后面部分的节点按顺序插入到链表
     */
    public void reorderList(ListNode head){
        //先找到中间节点
        ListNode dummySlow = head;
        ListNode dummyFast = head.next;
        if (dummySlow == null || dummyFast == null){
            return;
        }
        //1 2 3 4
        //1 2 3 4    2    2 4      1 2 ----> 1 2
        //1 2 3 4 5   3      null    1 2 3 ----> 1 2 4 3
        while (dummyFast != null && dummyFast.next != null){
            dummySlow = dummySlow.next;
            dummyFast = dummyFast.next.next;
        }
        ListNode tailDummy = dummySlow.next;//后面部分链表 3 4 或者 4 5
        dummySlow.next = null;

        //反转后面部分的链表,头插法
        //翻转tail 4 5
        //返回prev
        ListNode prev = null;

        while (tailDummy != null){
            ListNode next = tailDummy.next;
            tailDummy.next = prev;
            prev = tailDummy;
            tailDummy = next;
        }

        //按顺序插入
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (prev != null){
            ListNode temp = head.next;
            head.next = new ListNode(prev.val, temp);
            head = head.next;
            head = head.next;
            prev = prev.next;
        }



    }
}
