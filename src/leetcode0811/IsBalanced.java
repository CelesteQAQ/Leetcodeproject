package leetcode0811;

import leetcode0810.TreeNode;

/**
 * @author: celeste
 * @create: 2020-08-11 17:12
 * @description:
 * 题目：110. 平衡二叉树
 * 描述：给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 **/
public class IsBalanced {
    /**
     * 判断一个节点是否是高度平衡，首先他的左子树是高度平衡的，右子树是高度平衡的
     * 然后左子树的高度与右子树的高度差的绝对值不超过1
     */

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1){

            return true;
        }
        return false;

    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null){
            return 1;
        }else{
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
