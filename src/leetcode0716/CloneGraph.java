package leetcode0716;

import java.util.*;

/**
 * @author: celeste
 * @create: 2020-07-16 18:39
 * @description:
 * 题目：133. 克隆图
 * 描述：给你无向 连通 图中一个节点的引用，请你返回该图的 深拷贝（克隆）。
 * 图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 * 测试用例格式：
 * 简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），
 * 第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
 * 邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
 * 给定节点将始终是图中的第一个节点（值为 1）。你必须将 给定节点的拷贝 作为对克隆图的引用返回。
 **/
public class CloneGraph {
    /**
     * 对比之前的复制一个带下一位的链表，是先复制当前节点以及下一个，然后解决下一位的问题
     * 复制图更加麻烦，图包含当前节点值以及后面的节点，使用队列吧？
     * 还是递归？怎么使用 递归，最后一个被访问过就标记，如果所有邻居都被复制过来就复制自己
     */


    public Node cloneGraph(Node root){
        //判断有没有复制,是使用map将旧的跟新的匹配起来
        Map<Node, Node> map = new HashMap<>();
        return helper(root, map);

    }

    private Node helper(Node root, Map<Node, Node> map) {
        if (root == null){
            return null;
        }
        if(map.containsKey(root)){//之前访问过都放进去
            return map.get(root);
        }
        //开始访问邻居
        Node newNode = new Node(root.val, new ArrayList<Node>());
        map.put(root, newNode);
        for (int i = 0; i < root.neighbors.size();i++){
            newNode.neighbors.add(i, helper(root.neighbors.get(i), map));
        }
        return newNode;

    }

}
