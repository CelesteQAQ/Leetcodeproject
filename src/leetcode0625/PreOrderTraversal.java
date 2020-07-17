package leetcode0625;

import java.util.HashMap;
import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/6/25 1:20
 * 描述：前序遍历二叉树
 */
public class PreOrderTraversal {

    /*
    前序遍历的递归方法
     */

    public void preOrder(TreeNode node){
        visit(node);
        if (node.LeftTreeNode != null){
        preOrder(node.LeftTreeNode);}
        if (node.RightTreeNode != null){
        preOrder(node.RightTreeNode);}

    }

    /*
    前序遍历的非递归方法
     */

    public void preOrderTraversal(TreeNode node){

        Stack<TreeNode> stack = new Stack<>();
        if (node != null){
            stack.push(node);
        }
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            visit(curNode);
            if (curNode.RightTreeNode != null){
                stack.push(curNode.RightTreeNode);
            }
            if (curNode.LeftTreeNode != null){
                stack.push(curNode.LeftTreeNode);
            }

        }

    }

    /**
     * 颜色标记法
     * 其实就是按照递归的方法设计的进出栈
     * @param node
     */

    public void preOrderTraversalWithColorMark(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        if (node != null){
            stack.push(node);
            map.put(node, false);
        }
        while (!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if (!map.get(cur)){
                if (cur.RightTreeNode != null){
                    stack.push(cur.RightTreeNode);
                    map.put(cur.RightTreeNode, false);
                }
                if (cur.LeftTreeNode != null){
                    stack.push(cur.LeftTreeNode);
                    map.put(cur.LeftTreeNode, false);
                }
                stack.push(cur);
                map.put(cur, true);
            } else {
                visit(cur);
            }
        }
    }


    private void visit(TreeNode node) {
        System.out.println(node.val);
    }

}
