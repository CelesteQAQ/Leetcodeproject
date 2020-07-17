package leetcode0712;

/**
 * author: Celeste
 * create time: 2020/7/12 1:52
 * 题目：138. 复制带随机指针的链表
 * 描述：给定一个链表，每个节点包含一个额外增加的随机指针，
 * 该指针可以指向链表中的任何节点或空节点。
 * 要求返回这个链表的 深拷贝。 
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。
 * 每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；
 * 如果不指向任何节点，则为  null 。
 */
public class CopyRandomList {
    /**
     * 先复制每个节点到自己节点后面
     * 然后处理随机节点
     * 最后将原来的节点与后面的节点分离
     * @param head
     * @return
     */
    public Node copyRandomList(Node head){
        //首先复制节点到目前节点后面
        if (head == null){
            return null;
        }
        Node curr = head;
        while (curr != null){
            Node next = curr.next;
            Node tempNext = new Node(curr.val);
            tempNext.next = next;
            curr.next = tempNext;
            curr = curr.next.next;
        }
        //处理随机节点
        Node cur = head;
        while (cur != null){
            if (cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //分离
        cur = head;
        Node cloneHead = cur.next;
        while (cur != null && cur.next != null){
            Node temp = cur.next;
            cur.next = cur.next.next;
            cur = temp;
        }
        return cloneHead;
    }

}
