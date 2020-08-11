package leetcode0811;

import leetcode0810.TreeNode;

/**
 * @author: celeste
 * @create: 2020-08-11 14:35
 * @description:
 * 题目：701. 二叉搜索树中的插入操作
 * 描述：给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 **/
public class InsertIntoBST {
    /**
     * 第一种方法：就是一直比较下去，选择到叶子的位置，然后插入，不需要对二叉树进行其他操作
     */
    public TreeNode insertIntoBST(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode curNode = root;
        while (curNode != null){
            //如果比root的值要小就向左边，如果比root的值要大就向右边
            if (val < curNode.val && curNode.left != null){
                curNode = curNode.left;
            }
            else if (val < curNode.val && curNode.left == null){
                curNode.left = new TreeNode(val);
            }
            else if (val > curNode.val && curNode.right != null){
                curNode = curNode.right;
            }
            else if (val > curNode.val && curNode.right != null){
                curNode.right = new TreeNode(val);
            }
            if (curNode.val == val){
                break;
            }
        }
        return root;
    }

    /**
     * 可以使用递归的方法
     * 如果小于就插入到左子树，如果大于就插入到右子树
     */
    public TreeNode insertIntoBST_1(TreeNode root, int val){
        if (root == null){
            return new TreeNode(val);
        }
        if (val < root.val) root.left = insertIntoBST_1(root.left, val);
        if (val > root.val) root.right = insertIntoBST_1(root.right, val);
        return root;
    }


}
