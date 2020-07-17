package leetcode0701;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * author: Celeste
 * create time: 2020/7/1 1:44
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }else {
            queue.add(root);}
        while (!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> temp = new LinkedList<>();
            for (int i = 0; i < levelNum; i++){
                TreeNode curNode = queue.poll();
                temp.add(curNode.val);
                if (curNode.left != null){
                    queue.add(curNode.left);
                }
                if (curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            res.addFirst(temp);
        }
        return res;
    }
}
