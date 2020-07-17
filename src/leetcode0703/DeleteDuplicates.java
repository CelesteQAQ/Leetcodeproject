package leetcode0703;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Celeste
 * create time: 2020/7/3 1:43
 * 题目：83. 删除排序链表中的重复元素
 * 描述：给定一个排序列表，删除所有重复的元素，使得每个元素只出现一次
 */
public class DeleteDuplicates {

    /**
     * 借助set集合，如果在set中出现就删除，注意add方法插入失败会返回false
     */
    public ListNode deleteDuplicatesWithSet(ListNode head){
        Set<Integer> set = new HashSet<>();
        if (head == null || head.next == null){
            return head;
        }
        ListNode curNode = head;
        set.add(curNode.val);
        while (curNode.next != null){
            if (!set.add(curNode.next.val)){
                curNode.next = curNode.next.next;
            }else{
                curNode = curNode.next;
            }
        }
        return head;
    }
}
