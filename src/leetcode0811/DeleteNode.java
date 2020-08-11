package leetcode0811;

import leetcode0810.TreeNode;

import javax.swing.*;

/**
 * @author: celeste
 * @create: 2020-08-11 15:34
 * @description:
 * 题目：450. 删除二叉搜索树中的节点
 * 描述：给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 **/
public class DeleteNode {
    /**
     * 删除某一个节点
     * 就是当遇到这个节点之后，删掉然后将左子树的最大值或者右子树的最小值放上来
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        //找到之后怎么删
        if (key == root.val) {
            //将左子树的最大值放上来,直接改值，不要改，如果是null怎么办
            if (root.left == null) {
                root = root.right;
                return root;
            } else if (root.right == null) {
                root = root.left;
                return root;
            }
            //左子树和右子树都不为null，将左子树提上来
            TreeNode temp = root.left;
            while(temp.right != null && temp.right.right != null){
                temp = temp.right;
            }
            if (temp.right == null){//就是第一个
                root.val = root.left.val;
                root.left = root.left.left;
            }else{//往下走的
                root.val = temp.right.val;//复制节点的值
                temp.right = temp.right.left;//更新提上来的节点的位置
            }
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    /**
     * 从右子树换到根节点
     */
    public TreeNode deleteNode_1(TreeNode root, int key){
        if (root == null){
            return null;
        }
        if (key < root.val){
            root.left = deleteNode_1(root.left, key);
        }else if (key > root.val){
            root.right = deleteNode_1(root.right, key);
        }else if (key == root.val){
            if (root.left == null){
                return root.right;
            }else if (root.right == null){
                return root.left;
            }
            //左右子树都不是null
            TreeNode cur = root.right;
            while (cur.left != null){
                cur = cur.left;
            }
            //cur现在是右边最小的值作为跟节点，左子树是根的左子树。返回右子树即可
            cur.left = root.left;
            return root.right;
        }
        return root;
    }
}
