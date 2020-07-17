package leetcode0625;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/6/27 1:01
 * 描述：后序是左右根
 */
public class PostOrderTraversal {

    /**
     * 递归方法
     * 根右左顺序输出
     */
    public void postOrderTraversalWithRecursive(TreeNode node){
        if (node.LeftTreeNode != null){
        postOrderTraversalWithRecursive(node.LeftTreeNode);}
        if (node.RightTreeNode != null){
        postOrderTraversalWithRecursive(node.RightTreeNode);}
        if (node != null){
            visit(node);
        }
    }

    /**
     * 使用栈的迭代方法
     * 注意栈的进出顺序以及访问顺序
     * @param node
     */

    public void postOrderTraversalWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> resReverse = new LinkedList<>();
        if (node != null){
            stack.push(node);
        }
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            resReverse.add(cur);
            if (cur.LeftTreeNode != null){
                stack.push(cur.LeftTreeNode);
            }
            if (cur.RightTreeNode != null){
                stack.push(cur.RightTreeNode);
            }
        }
        ListIterator iterator = resReverse.listIterator();
        while (iterator.hasPrevious()){
            visit((TreeNode) iterator.previous());

        }
    }

    /**
     * 颜色标记法
     * 按照深度优先搜索顺序入栈，但是已经访问的节点标记为已经访问
     * @param node
     */

    public void postOrderTraversalWithColorMark(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        if (node != null){
            stack.push(node);
            map.put(node, false);
        }
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (!map.get(cur)) {
                stack.push(cur);
                map.put(cur, true);
                if (cur.RightTreeNode != null) {
                    stack.push(cur.RightTreeNode);
                    map.put(cur.RightTreeNode, false);
                }
                if (cur.LeftTreeNode != null) {
                    stack.push(cur.LeftTreeNode);
                    map.put(cur.LeftTreeNode, false);
                }
            } else {
                visit(cur);
            }

        }
    }



    private void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
