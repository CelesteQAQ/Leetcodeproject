package leetcode0625;

import java.util.HashMap;
import java.util.Stack;

/**
 * author: Celeste
 * create time: 2020/6/25 1:44
 * 描述：中序遍历二叉树
 */
public class InorderTraversal {

    /**
     * 中序遍历二叉树的递归方法
     * @param node
     */
    public void inorder(TreeNode node){
        if (node.LeftTreeNode != null){
            inorder(node.LeftTreeNode);
        }
        visit(node);
        if (node.RightTreeNode != null){
            inorder(node.RightTreeNode);
        }
    }

    /**
     * 中序遍历二叉树的非递归方法
     * 颜色标记法，已访问的标记为真，未访问的标记为假
     *
     * @param node
     */
    public void inorderTraversal(TreeNode node){
        HashMap<TreeNode, Boolean> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        if (node != null){
            stack.push(node);
            map.put(node, false);
        }
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            if (!map.get(curNode)){
                if (curNode.RightTreeNode != null){
                stack.push(node.RightTreeNode);
                map.put(curNode.RightTreeNode, false);}
                stack.push(curNode);
                map.put(curNode, true);
                if (curNode.LeftTreeNode != null){
                stack.push(node.LeftTreeNode);
                map.put(curNode.LeftTreeNode, false);}
            }else {
                visit(curNode);
            }
        }
    }


    /**
     * 使用栈的迭代方法
     * 注意入栈的只有左子树，右子树是访问完根节点后跳转
     * 中序遍历是在出栈的时候添加值
     * 根节点入栈，左子树入栈，直到没有左子树，访问根节点，当前节点跳转到根节点的右子树继续根左入栈
     * 注意判断非空
     * @param node
     */
    public void inorderTraversalWithStack(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.LeftTreeNode;
            }
            cur = stack.pop();
            visit(cur);
            cur = cur.RightTreeNode;
        }

    }

    private void visit(TreeNode node) {
        System.out.println(node.val);
    }
}
