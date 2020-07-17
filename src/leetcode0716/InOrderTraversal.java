package leetcode0716;

import javax.management.ListenerNotFoundException;
import javax.swing.tree.TreeCellRenderer;
import java.util.*;

/**
 * @author: celeste
 * @create: 2020-07-16 01:25
 * @description:
 * 题目：94. 二叉树的中序遍历
 * 描述：给定一个二叉树，返回它的中序 遍历。
 **/
public class InOrderTraversal {
    /**
     * 中序遍历-递归方法，左根右
     */
    public List<Integer> inorderTraversalWithRecursive(TreeNode root){
        List<Integer> result = new LinkedList<>();
        dfs(root, result);
        return result;
    }

    public void dfs(TreeNode root, List<Integer> result){
        //左根右
        if (root == null){
            return;
        }
        dfs(root.left, result);
        result.add(root.val);
        dfs(root.right, result);
    }


    /**
     * 非递归的方法
     * 迭代 左根右 左边访问完再添加根
     * 需要一个栈来保存
     */
    public List<Integer> InorderTraversalWithoutRecursive(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();//建立一个栈，先放右，根，左
        if (root == null){
            return result;
        }
        // 1
        //  2
        //3
        //先从左边开始遍历，当左边为空是加入root，然后开始走右边
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){//3
                stack.add(curr);//2 3
                curr = curr.left;
            }//加入左边，左边为空，加入root
            curr = stack.pop();
            result.add(curr.val);//添加1 3
            curr = curr.right;//2

        }
        return result;

//        while ()
//        if (root == null){
//            return result;
//        }
//        if (root.right != null){
//            stack.add(root.right);
//        }
//        stack.add(root);
//        if (root.left != null){
//            stack.add(root.left);
//        }
        //按出栈顺序继续入栈

    }

    /**
     * 遍历的通用迭代的方法，颜色标记法
     * 访问过的部分将颜色标记
     */

    public List<Integer> InOrderTraversalWithColorMark(TreeNode root){
        //建立放置标记的map
        Map<TreeNode, Boolean> map = new HashMap<>();
        //建立result
        List<Integer> result = new LinkedList<>();
        //建立存放节点的stack
        Stack<TreeNode> stack = new Stack<>();
        //如果root不是null，添加到栈中并且map中设为false，第一次加入；如果是null返回空列表
        if (root != null){
            stack.add(root);
            map.put(root, false);
        }
        //只要stack不为空
        while (!stack.isEmpty()){
            //弹出栈的最后一个元素
            TreeNode cur = stack.pop();
            //当当前节点是第一次访问，按右根左顺序加入
            if(!map.get(cur)){
                if (cur.right != null){
                    stack.add(cur.right);
                    map.put(cur.right, false);
                }
                stack.add(cur);
                map.put(cur, true);
                if (cur.left != null){
                    stack.add(cur.left);
                    map.put(cur.left, false);
                }
            } else {
                result.add(cur.val);
            }
        }
        return result;//如果root是null，stack是空的，直接返回空列表

    }




}
